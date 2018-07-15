package br.com.simplustec.application.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.simplustec.application.exception.CsvGeneratorException;
import br.com.simplustec.application.exception.DateNotProvidedException;
import br.com.simplustec.application.exception.InvalidDateFormatException;
import br.com.simplustec.application.exception.MyFileNotFoundException;
import br.com.simplustec.application.exception.ZipFileException;
import br.com.simplustec.application.exception.responseerror.ApplicationErrorResponse;


@ControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(InvalidDateFormatException.class)
	public ResponseEntity<?> handleInvalidDateFormatException(InvalidDateFormatException e) {
		
    	ApplicationErrorResponse error = ApplicationErrorResponse.builder()
            	.error(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Ocorreu um erro no parseador de data")
                .build();

    	return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MyFileNotFoundException.class)
	public ResponseEntity<?> handleMyFileNotFoundException(InvalidDateFormatException e) {
    	ApplicationErrorResponse error = ApplicationErrorResponse.builder()
            	.error(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Ocorreu um erro ao localizar o arquivo de relatório")
                .build();

    	return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ZipFileException.class)
	public ResponseEntity<?> handleZipFileException(ZipFileException e) {
    	ApplicationErrorResponse error = ApplicationErrorResponse.builder()
            	.error(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Ocorreu um erro ao gerar o arquivo zipado para os relatórios")
                .build();

    	return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CsvGeneratorException.class)
	public ResponseEntity<?> handleCsvGeneratorException(CsvGeneratorException e) {
    	ApplicationErrorResponse error = ApplicationErrorResponse.builder()
            	.error(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Ocorreu um erro ao gerar o CSV do relatório")
                .build();

    	return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(DateNotProvidedException.class)
	public ResponseEntity<?> handleDateNotProvidedException(DateNotProvidedException e) {
    	ApplicationErrorResponse error = ApplicationErrorResponse.builder()
            	.error(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Ocorreu um erro no conversor de data")
                .build();

    	return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
