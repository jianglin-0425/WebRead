package com.jl.repository;

import com.jl.bean.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IInformationDAO {

	/**
	 * 查询所有
	 * @return
	 * @throws Exception
	 */
	public List<Information> findByiID(Information i) throws Exception;

	public List<InformationVO> findVOByPage(@Param( value = "info")Information info, @Param( value = "count") Integer count) throws Exception;
}
