package br.com.simplustec.application.exception.responseerror;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
public class ApplicationErrorResponse {

	private Integer status;
    private String error;
    private String message;
}
