package br.com.simplustec.application.service.implementation;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import br.com.simplustec.application.constants.ReportNamesConstants;
import br.com.simplustec.application.datatransferobject.CsvDTO;
import br.com.simplustec.application.datatransferobject.ReportFilterDTO;
import br.com.simplustec.application.domain.Company;
import br.com.simplustec.application.exception.ZipFileException;
import br.com.simplustec.application.mapper.ProductMapper;
import br.com.simplustec.application.service.CompanyService;
import br.com.simplustec.application.service.FileStorageService;
import br.com.simplustec.application.service.ProductService;
import br.com.simplustec.application.service.ReportService;
import br.com.simplustec.application.utils.CsvGenerator;
import br.com.simplustec.application.utils.ZipFileUtils;

@Service
public class DefaultReportService implements ReportService {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private FileStorageService fileStorageService;

	@Override
	public Resource generateDefaultReport() {
		try {
			List<CsvDTO> csvList = this.createCsvsReports(companyService.findAll());
			String location = ZipFileUtils.execute(csvList);
			Resource resource = fileStorageService.loadFileAsResource(location);
			return resource;			
		} catch (IOException e) {
			throw new ZipFileException("Erro ao gerar o arquivo zipado para o relatório");
		}
	}

	@Override
	public byte[] generateDefaultReportInMemory() {
		try {
			List<CsvDTO> csvList = this.createCsvsReports(companyService.findAll());
			return ZipFileUtils.createByteArrayZip(csvList);
		} catch (IOException e) {
			throw new ZipFileException("Erro ao gerar o arquivo zipado para o relatório");
		}
	}
	
	@Override
	public byte[] generateReportInMemory(ReportFilterDTO reportFilterDTO) {
		try {
			List<CsvDTO> csvList = this.createCsvsReports(companyService.findAllByCompanyNameLike(reportFilterDTO.getCompanyName()));
			return ZipFileUtils.createByteArrayZip(csvList);
		} catch (IOException e) {
			throw new ZipFileException("Erro ao gerar o arquivo zipado para o relatório");
		}
	}
	
	private List<CsvDTO> createCsvsReports(List<Company> companyList) {
		List<CsvDTO> csvList = new ArrayList<>();
		companyList.forEach(company -> {
			csvList.add(CsvGenerator.toCSV(ProductMapper.makeProductDTOList(productService.findAllProductsWithoutBoxes(company.getName())), MessageFormat.format(ReportNamesConstants.PRODUCTS_REPORT, company.getName())));
			csvList.add(CsvGenerator.toCSV(ProductMapper.makeProductDTOList(productService.findAllProductsBoxes(company.getName())), MessageFormat.format(ReportNamesConstants.BOXES_REPORT, company.getName())));
		});
		return csvList;
	}
	
}
