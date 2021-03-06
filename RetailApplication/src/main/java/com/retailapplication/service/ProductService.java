package com.retailapplication.service;

import java.io.IOException;

import org.springframework.web.client.HttpClientErrorException;

import com.mongodb.MongoException;
import com.retailapplication.model.PriceInfo;
import com.retailapplication.model.Product;
import com.retailapplication.model.ProductInfo;

public interface ProductService {
  public PriceInfo getPriceDetails(int id) throws MongoException,IOException;
 
  public Product getProductData(int id) throws MongoException,IOException;
  
  public ProductInfo getProductInfo(int id) throws MongoException, IOException;
  
  public Product updateProductPrice(int id, Product prod) throws Exception;

}

