package com.jl.biz.impl;

import com.jl.bean.Admin;
import com.jl.bean.MessageVO;
import com.jl.biz.IMessageService;
import com.jl.repository.IMessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements IMessageService {

	@Autowired
	IMessageDAO dao ;

	@Override
	public List<MessageVO> findMessage(MessageVO m) throws Exception {
		return dao.findMessage(m);
	}

	@Override
	public MessageVO findContent(MessageVO m) throws Exception {
		
		List<MessageVO> list=dao.findContent(m);
		if (list!=null) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<MessageVO> findAdminMessage(Admin admin, String pageIndex, String PageSize) {
		//TODO:
		return null;
	}
}
