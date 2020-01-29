package com.webencyclop.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webencyclop.demo.model.Product;
import com.webencyclop.demo.repository.ProductRepository;

@Service
public class ProductService
{
	@Autowired
	private ProductRepository productrepo;
		 
	public List<Product> listAllProducts()
	{
		return productrepo.findAll();
	}
	
	public Product getProductById(Integer id)
	{
		Product product=productrepo.findById(id).orElse(null);
	    return product;
	}

    public Product saveProduct(Product product) 
    {
    	product = productrepo.save(product); 
    	return product;
    }
  
	public void deleteProduct(Integer id) 
	{		
		productrepo.deleteById(id);
    }

}
