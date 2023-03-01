package com.ayeon.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SampleDTOList {

	
	private List<SampleDTO> list;

	public SampleDTOList(List<SampleDTO> list) {
		list = new ArrayList<SampleDTO>();
	}
	
	
	
}
