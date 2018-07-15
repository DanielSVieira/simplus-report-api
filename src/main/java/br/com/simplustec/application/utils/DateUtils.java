package br.com.simplustec.application.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.simplustec.application.exception.DateNotProvidedException;

public class DateUtils {
	
	public static String getDateWithoutTime(Date date) throws ParseException {
		if(date == null) {
			throw new DateNotProvidedException("Data não informada");
		}
		DateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy");
		return outputFormatter.format(date);
	}

}
