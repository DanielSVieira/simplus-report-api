package br.com.simplustec.application.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import br.com.simplustec.application.datatransferobject.CsvDTO;

public class ZipFileUtils {
	public static String execute(List<CsvDTO> csvList) throws IOException {
		int compression = 3;
		File tempZipFile = File.createTempFile("simplus-report", ".zip");
		tempZipFile.deleteOnExit();

		try (FileOutputStream fos = new FileOutputStream(tempZipFile); ZipOutputStream zos = new ZipOutputStream(fos)) {
			zos.setLevel(compression);
			for (CsvDTO csvDTO : csvList) {
				writeZipFile(zos, csvDTO);
			}
		}

		return tempZipFile.getAbsolutePath();
	}

	public static byte[] createByteArrayZip(List<CsvDTO> csvList) throws IOException {
		int compression = 3;
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ZipOutputStream zos = new ZipOutputStream(baos)) {

			zos.setLevel(compression);
			for (CsvDTO csvDTO : csvList) {
				writeZipFile(zos, csvDTO);
			}
			return baos.toByteArray();
		}
	}

	private static void writeZipFile(ZipOutputStream zos, CsvDTO csvDTO) throws IOException {
		ZipEntry entry = new ZipEntry(csvDTO.getFileName());
		zos.putNextEntry(entry);
		try {
			zos.write(csvDTO.getCsvContent().getBytes(), 0, csvDTO.getCsvContent().length());
		} finally {
			zos.closeEntry();
		}
	}

}
