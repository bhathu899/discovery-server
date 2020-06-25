package com.demo.order.model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class DateHandler extends StdDeserializer<LocalDate> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1839116906609620495L;

	public DateHandler() {
		this(null);
	}
	public DateHandler(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		String date=p.getText();
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			return sdf.parse(date).toInstant()
				      .atZone(ZoneId.systemDefault())
				      .toLocalDate();
		}
		catch(Exception ex) {
			return null;
		}
				
	}

}
