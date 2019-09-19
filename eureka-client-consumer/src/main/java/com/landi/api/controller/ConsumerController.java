package com.landi.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by cbb on 2019/9/19.
 */
@RestController
public class ConsumerController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/test")
	public String test(){
		String result = restTemplate.getForObject("http://eureka-client-provider/getPort",String.class);
		return result;
	}
}
