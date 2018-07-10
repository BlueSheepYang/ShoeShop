package com.shoes.service;

import java.util.List;

import com.shoes.entity.Commodity;

public interface CommodityService {
	
	public List<Commodity> getCommodity();
	
	public Commodity getCommodity(String id);

	void saveCommodity(Commodity commodity);
	
	public List<Commodity> getCommodityByPeople(String sex, String people);
	
	public List<Commodity> getCommodityBySeason(String season);
	
	public List<Commodity> getCommodityByKinds(String sex, String Kind);

}
