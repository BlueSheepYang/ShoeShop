package com.shoes.service;

import java.util.List;

import com.shoes.entity.Suggestion;

public interface SuggestionService {
	
	public List<Suggestion> getAllSuggestions();
	
	public List<Suggestion> getUnfinshedSuggestions();
	
	public List<Suggestion> getfinshedSuggestions();
	
	public Suggestion getSuggestion(int Id);
	
	public List<Suggestion> getCustomerSuggestion(String name);
	
	void saveSuggestion(Suggestion suggestion);
	
	void handleSuggestion(int Id);
	
	void deleteSuggestion(int Id);

}
