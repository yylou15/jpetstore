package org.csu.mypetstore.dao.impl;

import org.csu.mypetstore.dao.DBUtil;
import org.csu.mypetstore.dao.ProductDAO;
import org.csu.mypetstore.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private static final String GET_PRODUCT_LIST_BY_CATEGORY="SELECT PRODUCTID,NAME,DESCN as description,CATEGORY as categoryId FROM PRODUCT WHERE CATEGORY = ?";
    private static final String GET_PRODUCT="SELECT PRODUCTID,NAME,DESCN as description,CATEGORY as categoryID FROM PRODUCT WHERE PRODUCTID=?";
    private static final String SEARCH_PRODUCT_LIST="SELECT PRODUCTID,NAME,DESCN as description,CATEGORY as categoryID FROM PRODUCT WHERE lower(name) like ?";
    @Override
    public List<Product> getProductListByCategory(String categoryId) {
        List<Product> products=new ArrayList<Product>();
        try {
            Connection connection= DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(GET_PRODUCT_LIST_BY_CATEGORY);
            preparedStatement.setString(1,categoryId);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Product product=new Product();
                product.setProductId(resultSet.getString(1));
                product.setName(resultSet.getString(2));
                product.setDescription(resultSet.getString(3));
                product.setCategoryId(resultSet.getString(4));
                products.add(product);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getProduct(String productId) {
        Product product=null;
        try{
            Connection connection= DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(GET_PRODUCT);
            preparedStatement.setString(1,productId);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                product=new Product();
                product.setProductId(resultSet.getString(1));
                product.setName(resultSet.getString(2));
                product.setDescription(resultSet.getString(3));
                product.setCategoryId(resultSet.getString(4));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> searchProductList(String keywords) {
        List<Product> products=new ArrayList<Product>();
        try {
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(SEARCH_PRODUCT_LIST);
            preparedStatement.setString(1,keywords);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Product product=new Product();
                product.setProductId(resultSet.getString(1));
                product.setName(resultSet.getString(2));
                product.setDescription(resultSet.getString(3));
                product.setCategoryId(resultSet.getString(4));
                products.add(product);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }
}
