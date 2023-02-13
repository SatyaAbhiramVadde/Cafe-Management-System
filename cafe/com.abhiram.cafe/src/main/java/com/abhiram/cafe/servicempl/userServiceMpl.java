package com.abhiram.cafe.servicempl;

import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abhiram.cafe.POJO.User;
import com.abhiram.cafe.constants.cafeConstants;
import com.abhiram.cafe.dao.userDao;
import com.abhiram.cafe.service.userService;
import com.abhiram.cafe.utils.cafeUtils;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class userServiceMpl implements userService {
	Logger log;

@Autowired  
userDao userdao;
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) { 
      log.info("Inside Signup {}",requestMap);
      if(validateSignUpMap(requestMap))
      {
    	  User user= userdao.findByEmailId(requestMap.get("email"));

	}
      else {
    	  return cafeUtils.getResponeEntity(cafeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
      }
    	  return null;
	}
	
	
	private boolean validateSignUpMap(Map<String, String> requestMap)
	{
     if(requestMap.containsKey("name") && requestMap.containsKey("contactNumber") && requestMap.containsKey("email")
      && requestMap.containsKey("password"))
     {
       return true;	 
     }
     else
    	 return false;
    }
}