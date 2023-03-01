package com.ayeon.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

import java.lang.invoke.CallSite;
import java.net.http.HttpHeaders;
import java.rmi.activation.ActivationGroup_Stub;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ayeon.domain.SampleDTO;
import com.ayeon.domain.SampleDTOList;
import com.ayeon.domain.TodoDTO;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/sample/*")
public class SampleController {

//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}

	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
			log.info("todo----------: " +todo);
			return "ex03";
	}
	
	@RequestMapping("")
	public void basic() {

		log.info("Basic...................");
	}

	@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST })
	public void basicGet() {
		log.info("basic get............");
	}

	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get..........");
	}

	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {

		log.info("sampledto ======= " + dto);
		return "ex01";
	}

	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {

		log.info("---name---" + name);
		log.info("----age----" + age);

		return "ex02";
	}

	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {

		log.info("ids : " + ids);
		return "ex02list";

	}

	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("ids" + Arrays.toString(ids));
		return "ex02Array";
	}

	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {

		log.info("list dtos" + list);
		return "ex02Bean";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto: " + dto );
		log.info("page:" + page);
		return "/sample/ex04";
	}
	
	@GetMapping("/ex05")
	public String ex05( RedirectAttributes rttr, SampleDTO dto) {
		rttr.addFlashAttribute("name","aaa");
		rttr.addFlashAttribute("age",10);
		return "redirect:/";
	}
	
	
	//void타입
	@GetMapping("/ex06")
	public void ex06() {
		log.info("----- ex06 ----");
	}
	
	@GetMapping("/ex07")
	public @ResponseBody SampleDTO ex07(){
		log.info("/ex07-------:" );
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("namAyeon");
		return dto;
	}
	
	@GetMapping("/ex08")
	public ResponseEntity<String> ex08(){
		log.info("ex08.............");
		//{"name":"namAyeon","age":10}
		String message = "{\"name\": \"홍길동\"}";
		
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<String>(message, headers, HttpStatus.OK);
		
		
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload..........");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file->{
			log.info("---------------------------");
			log.info("name:" + file.getOriginalFilename());
			log.info("size" + file.getSize());
		});
	}
	

}
