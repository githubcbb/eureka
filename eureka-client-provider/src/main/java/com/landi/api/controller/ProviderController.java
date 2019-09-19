package com.landi.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cbb on 2019/9/19.
 */
@RestController
public class ProviderController {

	@Value("${server.port}")
	private String prot;

	@RequestMapping("/getPort")
	public String getProt(){
		return "provider项目被访问，provider端口是："+prot;
	}
}
