package br.com.simplustec.application.utils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Logger;

import br.com.simplustec.application.datatransferobject.CsvDTO;
import br.com.simplustec.application.exception.CsvGeneratorException;

public class CsvGenerator {

	private static final Logger LOGGER = Logger.getLogger(CsvGenerator.class.getName());
	private static final char separator = ';';

	public static CsvDTO toCSV(List<?> objectList, String fileName) {

		StringBuilder result = new StringBuilder();

		result.append(getHeaders(objectList.get(0), separator));
		result.append("\n");

		for (Object obj : objectList) {
			result.append(addObjectRow(obj, separator)).append("\n");
		}

		return new CsvDTO(fileName, result.toString());
	}

	private static String getHeaders(Object obj, char separator) {
		StringBuilder resultHeader = new StringBuilder();
		boolean firstField = true;
		Field fields[] = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String value;
			try {
				value = field.getName();

				if (firstField) {
					resultHeader.append(value);
					firstField = false;
				} else {
					resultHeader.append(separator).append(value);
				}
				field.setAccessible(false);
			} catch (IllegalArgumentException e) {
				LOGGER.severe(e.toString());
				throw new CsvGeneratorException("Erro ao adicionar header no CSV: " + e.getCause());
			}
		}
		return resultHeader.toString();

	}

	private static String addObjectRow(Object obj, char separator) {
		StringBuilder csvRow = new StringBuilder();
		Field fields[] = obj.getClass().getDeclaredFields();
		boolean firstField = true;
		for (Field field : fields) {
			field.setAccessible(true);
			Object value;
			try {
				value = field.get(obj);
				if (value == null)
					value = "";
				if (firstField) {
					csvRow.append(value);
					firstField = false;
				} else {
					csvRow.append(separator).append(value);
				}
				field.setAccessible(false);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				LOGGER.severe(e.toString());
				throw new CsvGeneratorException("Erro ao adicionar linha no CSV: " + e.getCause());
			}
		}
		return csvRow.toString();
	}

}
