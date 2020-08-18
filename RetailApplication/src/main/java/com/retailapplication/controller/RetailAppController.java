package com.retailapplication.controller;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.MongoException;
import com.retailapplication.model.PriceInfo;
import com.retailapplication.model.Product;
import com.retailapplication.model.ProductInfo;
import com.retailapplication.service.ProductService;

@RestController
@RequestMapping("/")
public class RetailAppController {
	private final Logger logger=LogManager.getLogger(RetailAppController.class.getName());
    @Autowired
    @Qualifier(value="productService")
    ProductService prodService;
    
	@RequestMapping(value = "/products/{id}")
	   public Product getProduct(@PathVariable int id) throws MongoException, IOException {
		logger.info("Working on the GET request, fetching the product details ");
		Product prod= prodService.getProductData(id);
		logger.info("Returning  the product details ");
	     return prod;
	   }
	
	@RequestMapping(value = "/products/fetch/{id}")
	   public ProductInfo getProductName(@PathVariable int id) throws MongoException, IOException {
	    
	     ProductInfo prodInfo=prodService.getProductInfo(id);
	     return prodInfo;
		
	   }
	
	
	@RequestMapping(value = "/products/{id}",method=RequestMethod.PUT)
	   public Product getProductName(@PathVariable int id,@RequestBody Product prod) throws Exception {
		 logger.info("Working on the PUT request, updating the product details ");
		 Product prodInfo=prodService.updateProductPrice(id, prod);
		 logger.info("Updated the product details ");
		 return prodInfo;
		
	   }
}

