package br.com.simplustec.application.service.implementation;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import br.com.simplustec.application.exception.MyFileNotFoundException;
import br.com.simplustec.application.service.FileStorageService;


@Service
public class DefaultFileStorageService implements FileStorageService {
	

    @Override
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = Paths.get(fileName)
                    .toAbsolutePath().normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("Arquivo não encontrado " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("Arquivo não encontrado " + fileName, ex);
        }
    }

}
