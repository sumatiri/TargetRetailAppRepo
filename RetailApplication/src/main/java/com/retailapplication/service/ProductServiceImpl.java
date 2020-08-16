package com.retailapplication.service;


import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mongodb.MongoException;
import com.retailapplication.model.PriceInfo;
import com.retailapplication.model.Product;
import com.retailapplication.model.ProductInfo;
import com.retailapplication.repository.PriceInfoRepository;
import com.retailapplication.repository.ProductInfoRepository;
@Service(value="productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
    private ProductInfoRepository prodInfoRepo;
    
    @Autowired
    private PriceInfoRepository priceInfoRepo;
    
    @Autowired
	private Environment env;
	@Override
	/* Function to fetch the price Information
	 * 
	 */
	public PriceInfo getPriceDetails(int id) {
		 
	 
		 PriceInfo priceInfo=priceInfoRepo.findById(id);
	  
	  
		return priceInfo;
	}
/* Function to get the product name from external API. Currently the provided API is not working
 * so taking this value from dummy API
 * 
 */

	public String getProductName(int id) throws Exception {
     try {
		String url = env.getProperty("target.restUrl1") + id;
		RestTemplate restTemplate = new RestTemplate();
		String resp = restTemplate.getForObject(url, String.class);

		String name = null;
		JsonParser springParser = JsonParserFactory.getJsonParser();
		Map<String, Object> map = springParser.parseMap(resp);

		if (map != null) {
			name = (String) map.get("name");
			return name;
		}else {
			throw new Exception("Product Name not found from external API");
		}
     }catch(Exception e) {
    	 throw new Exception("Product Name not found from external API");
     }

		
	}
/* Function to combine the data read fom external API with the price details found from database and 
 * showing the json result
 * 
 */
	@Override
	public Product getProductData(int id) throws MongoException, IOException {
	 try {	
		String productName=getProductName(id);
		Product pd=null;
		if(productName!=null) {
			PriceInfo pinfo=getPriceDetails(id);
			if(pinfo!=null) {
				pd=new Product();
				pd.setId(id);
				pd.setName(productName);
				pd.setcurrentPrice(pinfo);
				return pd;
			} else {
				throw new MongoException("Product details not found");
				
			}
			
		}else {
			throw new MongoException("Product details not found");
		}
	 }catch(Exception e){
		 throw new MongoException("Invalid Product ID provided in the URL. Product Information not found");
	 }
		
	}
	

	@Override
	public ProductInfo getProductInfo(int id) {
		ProductInfo pInfo=prodInfoRepo.findById(id);
		return pInfo;
	}

	@Override
	public Product updateProductPrice(int id, Product prod) throws Exception {
		try {
			 if(prod.getId()!=id) {
		         	throw new Exception("Product ID provided in request body doesnt match with Product ID in URL");
		     }
			String productName = getProductName(id);
			PriceInfo pInfoUserInput = prod.getcurrentPrice();
			Product prodToReturn = new Product();

			if (productName != null && pInfoUserInput != null) {

				// newProd = new Product(id, productName, pInfo);
				PriceInfo existingPrInfo = priceInfoRepo.findById(id);
				if (existingPrInfo != null) {
					existingPrInfo.setCurrencyCode(pInfoUserInput.getCurrencycode());
					existingPrInfo.setValue(pInfoUserInput.getValue());
					priceInfoRepo.save(existingPrInfo);
					prodToReturn.setcurrentPrice(existingPrInfo);
					prodToReturn.setName(productName);
					prodToReturn.setId(id);
					return prodToReturn;
				} else {

					throw new MongoException("Product Information is not Present for Updating");

				}
			} else {
				throw new MongoException("Product Information is not Present for Updating");
			}
		} catch (Exception e) {
			throw new MongoException(
					"Error occured while fetching Product Information. Please check the Product ID provided either in body or in URL");
		}

	}

	
}
