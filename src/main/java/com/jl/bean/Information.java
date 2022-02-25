package com.jl.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Information {

	Integer iId;
	String iType;
	String content;
	String vid;
	String publichTime;
}
