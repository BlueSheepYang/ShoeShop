package com.shoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoes.dao.CommodityDAO;
import com.shoes.entity.Commodity;


@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityDAO commodityDAO;
	
	@Override
	@Transactional
	public List<Commodity> getCommodity() {
		
		return commodityDAO.getCommodity();
	}

	@Override
	public Commodity getCommodity(String id) {
		
		return commodityDAO.getCommodity(id);
	}
	
	@Override
	public void saveCommodity(Commodity commodity) {
		commodityDAO.saveCommodity(commodity);
	}

	@Override
	public List<Commodity> getCommodityByPeople(String sex, String people) {

		return commodityDAO.getCommodityByPeople(sex, people);
	}

	@Override
	public List<Commodity> getCommodityBySeason(String season) {
		
		return commodityDAO.getCommodityBySeason(season);
	}

	@Override
	public List<Commodity> getCommodityByKinds(String sex, String Kind) {
		
		return commodityDAO.getCommodityByKinds(sex, Kind);
	}

}
