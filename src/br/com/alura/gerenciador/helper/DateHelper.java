package br.com.alura.gerenciador.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
	
	public static Date stringToDate(String data) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(data);
		} catch (ParseException e) {
			System.out.println("Deu ruim!");
		}
		return null;
	}
	
}
