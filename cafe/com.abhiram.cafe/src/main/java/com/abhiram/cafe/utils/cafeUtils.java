package com.abhiram.cafe.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class cafeUtils {
	
	private cafeUtils()
	{
		
	}
public static ResponseEntity<String> getResponeEntity(String responseMessage, HttpStatus httpStatus)
{
	return new ResponseEntity<String>("{\"message\":\"+ responseMessage +\"}",HttpStatus.INTERNAL_SERVER_ERROR);

}
}
