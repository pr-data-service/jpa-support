package com.jpasupport.test;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jpasupport.annotations.EntityMapping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@EntityMapping(entity = CustomTable1Entity.class)
public class CustomTable1DTO {

	public Long id;
	private String field1;
	private String field2;
	
}
