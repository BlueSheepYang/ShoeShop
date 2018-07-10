package com.shoes.dao;

import java.util.List;

import com.shoes.entity.Suggestion;

public interface SuggestionDAO {
	
	List<Suggestion> getAllSuggestions();
	
	List<Suggestion> getUnfinshedSuggestions();
	
	List<Suggestion> getfinshedSuggestions();
	
	Suggestion getSuggestion(int Id);

	List<Suggestion> getCustomerSuggestion(String name);
	
	void saveSuggestion(Suggestion suggestion);
	
	void handleSuggestion(int Id);
	
	void deleteSuggestion(int Id);

}
