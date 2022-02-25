package com.jl.biz.impl;

import com.jl.bean.Information;
import com.jl.bean.InformationVO;
import com.jl.biz.IInformationServer;
import com.jl.repository.IInformationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements IInformationServer {


	@Autowired
	IInformationDAO dao;
	@Override
	public List<Information> findByiID(Information i) throws Exception {
		return dao.findByiID(i);
	}

	@Override
	public List<InformationVO> findVOByPage(Information info, String count) throws Exception {
		List<InformationVO> list=null;
		list=dao.findVOByPage(info,Integer.parseInt(count));
		System.out.println(list);
		//TODO:處理時間
		return list;
	}
}
