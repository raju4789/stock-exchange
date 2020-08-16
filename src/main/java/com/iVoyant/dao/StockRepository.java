package com.iVoyant.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iVoyant.beans.InpStock;

@Repository
public interface StockRepository extends CrudRepository<InpStock, String> {

}
