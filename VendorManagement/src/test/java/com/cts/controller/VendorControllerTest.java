package com.cts.controller;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.entity.Vendor;
import com.cts.service.VendorService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = VendorController.class)
public class VendorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private VendorService venService;
	
	@Test
	public void getAllTest() throws Exception {

		when(venService.getAll()).thenReturn(
						Arrays.asList(new Vendor(1,"sweetyhari","hyd","789654123","nikki@gmail.com")));

		RequestBuilder req=MockMvcRequestBuilders.get("/getAll").accept(MediaType.APPLICATION_JSON);
		MvcResult res=mockMvc.perform(req).andExpect(status().isOk())
		.andExpect(content().json("[{vendorId:1,vendorName:nikhiladamaraju,city:hyd,mobileNo:\"9493720887\",emailId:nikki@gmail.com}]"))
		.andReturn();
	}

	
}
