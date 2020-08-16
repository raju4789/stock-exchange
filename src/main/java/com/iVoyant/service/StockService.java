package com.iVoyant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iVoyant.beans.InpStock;
import com.iVoyant.beans.OutStock;
import com.iVoyant.constants.ApplicationConstants;
import com.iVoyant.dao.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;

	public void saveAllStocks(List<InpStock> stocks) {
		stockRepository.saveAll(stocks);
	}

	public void deleteStock(String id) {
		stockRepository.deleteById(id);
	}
	
	// can implement observer design pattern whenever 
	// there is an update operation and send appropriate notifications to the buyer/seller
	public void addOrUpdate(InpStock stock) {
		stockRepository.save(stock);
	}

	public OutStock getStock(String id) {
		InpStock inpStock =  stockRepository.findById(id).orElse(null);
		OutStock outStock = null;
		if(inpStock != null) {
			outStock = formOutputStock(inpStock);
		}
		return outStock;
	}

	public List<OutStock> getAllStocks() {
		List<OutStock> stocks = new ArrayList<OutStock>();

		Iterable<InpStock> itr = stockRepository.findAll();

		itr.forEach(s -> {
			OutStock stock =  formOutputStock(s);
			stocks.add(stock);
		});
		return stocks;
	}
	
	

	
	private OutStock formOutputStock(InpStock s) {
		OutStock stock = new OutStock();
		if (ApplicationConstants.SELL.equals(s.getType().toUpperCase())) {
			stock.setSell_id(s.getOrder_id());
		} else {
			stock.setBuy_id(s.getOrder_id());
		}

		stock.setPrice(s.getPrice());
		stock.setQuantity(s.getQuantity());
		return stock;
	}
}
