package com.abhiram.cafe.restmpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.abhiram.cafe.constants.cafeConstants;
import com.abhiram.cafe.rest.userRest;
import com.abhiram.cafe.service.userService;
import com.abhiram.cafe.utils.cafeUtils;

import java.util.Map;

@RestController
public class userRestMpl implements userRest {
@Autowired
userService userService;
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		try
		{
			return userService.signUp(requestMap);
		}catch(Exception ex)
		{
		ex.printStackTrace();
	}
		return cafeUtils.getResponeEntity(cafeConstants.SOMETHING_WENT_WRONG , HttpStatus.INTERNAL_SERVER_ERROR);
		
}
}