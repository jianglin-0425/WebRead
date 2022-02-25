package com.jl.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
		String vName;
		Integer vID;
		String vPwd;
		String img;
		String intro;
}
