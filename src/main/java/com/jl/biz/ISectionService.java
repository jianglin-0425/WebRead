package com.jl.biz;

import com.jl.bean.SectionInfo;

public interface ISectionService {
	public SectionInfo getContent(SectionInfo info)  throws Exception ;
	public Integer getLength(SectionInfo info)  throws Exception ;
}
