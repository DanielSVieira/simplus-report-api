package br.com.simplustec.application.service;

import org.springframework.core.io.Resource;

public interface FileStorageService {
	
	public Resource loadFileAsResource(String fileName);

}
