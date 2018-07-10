package com.shoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoes.dao.ReplyDAO;
import com.shoes.dao.ShoppingCarDAO;
import com.shoes.entity.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO replyDAO;
	
	@Override
	public void saveReply(Reply reply) {
		
		replyDAO.saveReply(reply);

	}

	@Override
	public Reply getReply(int suggestionId) {
		
		return replyDAO.getReply(suggestionId);
	}

	@Override
	public List<Reply> getCustomerReply(String name) {
		// TODO Auto-generated method stub
		return replyDAO.getCustomerReply(name);
	}

}
