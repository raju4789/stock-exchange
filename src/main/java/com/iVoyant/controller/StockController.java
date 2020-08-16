package com.iVoyant.controller;

import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iVoyant.beans.InpStock;
import com.iVoyant.beans.OutStock;

import com.iVoyant.service.StockService;

@RestController
@RequestMapping("/stockexchange")
public class StockController {
	private static Logger log = Logger.getLogger(StockController.class);

	@Autowired
	private StockService stockService;

	@RequestMapping(value = "/stock", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> createStock(InpStock stock) {
		stockService.addOrUpdate(stock);

		return new ResponseEntity<String>("Stock added successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/stocks", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> createAllStocks(List<InpStock> stocks) {
		stockService.saveAllStocks(stocks);

		return new ResponseEntity<String>("Stocks added successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/stock", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<String> updateStock(InpStock stock) {
		stockService.addOrUpdate(stock);
		return new ResponseEntity<String>("Stock updated successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/stock/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteStock(@PathVariable String id) {
		stockService.deleteStock(id);
		return new ResponseEntity<String>("Stock deleted successfully", HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/stock/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<OutStock> getStock(@PathVariable String id) {
		OutStock stock = stockService.getStock(id);
		return new ResponseEntity<OutStock>(stock, HttpStatus.OK);
	}

	@RequestMapping(value = "/stocks", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<OutStock>> getStock() {
		log.info("Fetching all stocks ... ");
		List<OutStock> stocks = stockService.getAllStocks();
		log.info("Fetching of stocks complete");
		return new ResponseEntity<List<OutStock>>(stocks, HttpStatus.OK);
	}
}
