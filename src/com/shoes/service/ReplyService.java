package com.shoes.service;

import java.util.List;

import com.shoes.entity.Reply;

public interface ReplyService {
	
	void saveReply(Reply reply);
	
	Reply getReply(int suggestionId);

	List<Reply> getCustomerReply(String name);
}
