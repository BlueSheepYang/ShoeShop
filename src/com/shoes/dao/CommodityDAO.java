package com.shoes.dao;

import java.util.List;

import com.shoes.entity.Commodity;

public interface CommodityDAO {
	
	public List<Commodity> getCommodity();
	
	public List<Commodity> getCommodityByPeople(String sex, String people);
	
	public List<Commodity> getCommodityBySeason(String season);
	
	public List<Commodity> getCommodityByKinds(String sex, String Kind);
	
	public Commodity getCommodity(String id);

	void saveCommodity(Commodity commdity);
	
	

}
