package org.csu.mypetstore.service;

import org.csu.mypetstore.dao.CategoryDAO;
import org.csu.mypetstore.dao.ItemDAO;
import org.csu.mypetstore.dao.ProductDAO;
import org.csu.mypetstore.dao.impl.CategoryDAOImpl;
import org.csu.mypetstore.dao.impl.ItemDAOImpl;
import org.csu.mypetstore.dao.impl.ProductDAOImpl;
import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;

import java.util.List;

public class CatalogService {
    private CategoryDAO categoryDAO;
    private ProductDAO productDAO;
    private ItemDAO itemDAO;
    public  CatalogService(){
        categoryDAO=new CategoryDAOImpl();
        productDAO=new ProductDAOImpl();
        itemDAO=new ItemDAOImpl();
    }
    public List<Category> getCategoryList() {
        return categoryDAO.getCategoryList();
    }

    public Category getCategory(String categoryId) {
        return categoryDAO.getCategory(categoryId);
    }

    public Product getProduct(String productId) {
        return productDAO.getProduct(productId);
    }

    public List<Product> getProductListByCategory(String categoryId) {
        return productDAO.getProductListByCategory(categoryId);
    }

    public List<Product> searchProductList(String keyword) {
        return productDAO.searchProductList("%" + keyword.toLowerCase() + "%");
    }

    public List<Item> getItemListByProduct(String productId) {
        return itemDAO.getItemListByProduct(productId);
    }

    public Item getItem(String itemId) {
        return itemDAO.getItem(itemId);
    }

    public boolean isItemInStock(String itemId) {
        return itemDAO.getInventoryQuantity(itemId) > 0;
    }
}
