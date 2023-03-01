package com.ayeon.domain;

import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {

	private String title;
	
	@DateTimeFormat(pattern ="yyyy/MM/dd")
	private Date dueDate;
}
