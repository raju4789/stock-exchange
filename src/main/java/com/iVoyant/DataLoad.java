package com.iVoyant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.iVoyant.beans.InpStock;
import com.iVoyant.service.StockService;

@Component
class DataLoadListener implements ApplicationListener<ApplicationReadyEvent> {

	private static Logger log = Logger.getLogger(DataLoadListener.class);

	@Autowired
	private StockService stockService;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		log.info("Loading initial stocks data...");
		try {
			String line = "";
			String splitBy = ",";

			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader("./data/iVoyant_Stack_Data.csv"));

			List<InpStock> stocks = new ArrayList<InpStock>();

			while ((line = br.readLine()) != null) {
				try {
					String[] stockInfo = line.split(splitBy);
					InpStock stock = new InpStock(stockInfo[0], stockInfo[1], stockInfo[2],
							Integer.parseInt(stockInfo[3]), Integer.parseInt(stockInfo[4]), stockInfo[5]);
					stocks.add(stock);
				} catch (NumberFormatException e) {
					continue;
				}
			}

			stockService.saveAllStocks(stocks);

			log.info("Loading of initial stocks data complete.");
		} catch (IOException e) {
			log.error("IO Exception loading initial stocks data...", e);
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Exception loading initial stocks data...", e);
			e.printStackTrace();
		}
	}

}
