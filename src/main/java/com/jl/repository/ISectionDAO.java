package com.jl.repository;


import com.jl.bean.SectionInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ISectionDAO {

	public SectionInfo getContent(SectionInfo info)throws Exception ;
	
	public Integer getLength(SectionInfo info)throws Exception ;

	

	
}
