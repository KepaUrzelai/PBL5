package product.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import clases.Product;

public class ProductItemFacade {
	
	@Autowired
	private DaoProductItem productDao;
	
	@Transactional
	public boolean add(Product product) {
	    return productDao.add(product);
   }

}
