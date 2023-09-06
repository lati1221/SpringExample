package com.dlqudwp.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NewUserController {

	// 이메일 중복 여부를 알려주는 기능
	@GetMapping("/duplicate-email")
	@ResponseBody
	public String isDuplicateEmail(
			@RequestParam("email") String email) {
	
		boolean isDuplicate = userService.isDuplicateEmail(email);
		
		// 중복됨 : {"isDuplicate": true}
		// 중복안됨 : {"isDuplicate": false}
		
		Map<String, Boolean> resultMap = new HashMap<>();
		
		if(isDuplicate) {
			// 중복됨
			resultMap.put("isDuplicate", true);
		} else {
			// 중복안됨
			resultMap.put("isDuplicate", false);
		}
	}
	
}
