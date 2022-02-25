package com.jl.biz;

import com.jl.bean.Admin;
import com.jl.bean.MessageVO;

import java.util.List;


public interface IMessageService {
	/**
	 * 通过message表查询mID
	 * @param m
	 * @return
	 * @throws Exception
	 */
	public List<MessageVO> findMessage(MessageVO m) throws Exception;
	
	/**
	 * 通过message表查询mID
	 * @param m
	 * @return
	 * @throws Exception
	 */
	public MessageVO findContent(MessageVO m) throws Exception;

	public List<MessageVO> findAdminMessage(Admin admin,String pageIndex,String PageSize);
}
