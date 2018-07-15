package br.com.simplustec.application.utils;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import br.com.simplustec.application.exception.DateNotProvidedException;

public class DateUtilsTest {
	
	@Test
	public void testDataConverter() throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 0, 1);
		Date date = calendar.getTime();
		String convertedDate = DateUtils.getDateWithoutTime(date);
		
		assertEquals("01/01/2018", convertedDate);
	}
	
	@Test
	public void testDataConverterExceptionCase() throws ParseException {
		try {
			DateUtils.getDateWithoutTime(null);
		} catch(DateNotProvidedException e) {
			assertEquals(e.getMessage(), "Data não informada");
		}
	}

}
