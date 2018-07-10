package com.shoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoes.dao.SuggestionDAO;
import com.shoes.entity.Suggestion;

@Service
public class SuggestionServiceImpl implements SuggestionService {

	@Autowired
	private SuggestionDAO suggestionDAO;
	
	@Override
	@Transactional
	public List<Suggestion> getAllSuggestions() {
		
		return suggestionDAO.getAllSuggestions();
	}

	@Override
	@Transactional
	public List<Suggestion> getUnfinshedSuggestions() {
		
		return suggestionDAO.getUnfinshedSuggestions();
	}

	@Override
	@Transactional
	public List<Suggestion> getfinshedSuggestions() {
		
		return suggestionDAO.getfinshedSuggestions();
	}

	@Override
	@Transactional
	public Suggestion getSuggestion(int Id) {
		
		return suggestionDAO.getSuggestion(Id);
	}

	@Override
	@Transactional
	public List<Suggestion> getCustomerSuggestion(String name) {
		
		return suggestionDAO.getCustomerSuggestion(name);
	}

	@Override
	public void saveSuggestion(Suggestion suggestion) {

		suggestionDAO.saveSuggestion(suggestion);
		
	}

	@Override
	public void handleSuggestion(int Id) {
		
		suggestionDAO.handleSuggestion(Id);
		
	}

	@Override
	public void deleteSuggestion(int Id) {
		
		suggestionDAO.deleteSuggestion(Id);
		
	}

}
