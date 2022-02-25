package com.jl.repository;


import com.jl.bean.MessageVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMessageDAO {
	/**
	 * 查询所有
	 * @return
	 * @throws Exception
	 */
	public List<MessageVO> findMessage(MessageVO m) throws Exception;

	public List<MessageVO> findContent (MessageVO m) throws Exception;

}
