package com.jl.biz;


import com.jl.bean.Information;
import com.jl.bean.InformationVO;

import java.util.List;

public interface IInformationServer {

	/**
	 * 通过information表查询iID
	 * @param i
	 * @return
	 * @throws Exception
	 */
	public List<Information> findByiID(Information i) throws Exception;

	public List<InformationVO> findVOByPage(Information info,String count) throws Exception;


}
