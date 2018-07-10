package com.shoes.dao;

import java.util.List;

import com.shoes.entity.Reply;

public interface ReplyDAO {
	
	void saveReply(Reply reply);
	
	Reply getReply(int suggestionId);

	List<Reply> getCustomerReply(String name);

}
