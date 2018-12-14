package org.csu.mypetstore.dao.impl;

import com.sun.org.apache.regexp.internal.RE;
import org.csu.mypetstore.dao.DBUtil;
import org.csu.mypetstore.dao.OrderDAO;
import org.csu.mypetstore.domain.Order;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private static final String GET_ORDER="select BILLADDR1 AS billAddress1,BILLADDR2 AS billAddress2, BILLCITY,BILLCOUNTRY,BILLSTATE,BILLTOFIRSTNAME,BILLTOLASTNAME,BILLZIP,SHIPADDR1 AS shipAddress1,SHIPADDR2 AS shipAddress2,SHIPCITY,SHIPCOUNTRY,SHIPSTATE,SHIPTOFIRSTNAME,SHIPTOLASTNAME,SHIPZIP,CARDTYPE, COURIER,CREDITCARD,EXPRDATE AS expiryDate,LOCALE,ORDERDATE,ORDERS.ORDERID,TOTALPRICE,USERID AS username,STATUS FROM ORDERS, ORDERSTATUS WHERE ORDERS.ORDERID =? AND ORDERS.ORDERID = ORDERSTATUS.ORDERID";
    private static final String INSERT_ORDER_STATUS="INSERT INTO ORDERSTATUS (ORDERID, LINENUM, TIMESTAMP, STATUS) VALUES (?, ?, ?, ?)";
    private static final String INSERT_ORDER="INSERT INTO ORDERS (ORDERID, USERID, ORDERDATE, SHIPADDR1, SHIPADDR2, SHIPCITY, SHIPSTATE,SHIPZIP, SHIPCOUNTRY, BILLADDR1, BILLADDR2, BILLCITY, BILLSTATE, BILLZIP, BILLCOUNTRY,COURIER, TOTALPRICE, BILLTOFIRSTNAME, BILLTOLASTNAME, SHIPTOFIRSTNAME, SHIPTOLASTNAME,CREDITCARD, EXPRDATE, CARDTYPE, LOCALE) VALUES(?, ?, ?, ?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?)";
    private static final String GET_ORDERS_BY_USERNAME=" SELECT BILLADDR1 AS billAddress1,BILLADDR2 AS billAddress2,BILLCITY,BILLCOUNTRY,BILLSTATE,BILLTOFIRSTNAME,BILLTOLASTNAME,BILLZIP,SHIPADDR1 AS shipAddress1,SHIPADDR2 AS shipAddress2,SHIPCITY,SHIPCOUNTRY,SHIPSTATE,SHIPTOFIRSTNAME,SHIPTOLASTNAME,SHIPZIP,CARDTYPE,COURIER, CREDITCARD, EXPRDATE AS expiryDate,LOCALE,ORDERDATE,ORDERS.ORDERID,TOTALPRICE,USERID AS username FROM ORDERS WHERE ORDERS.USERID = ?  ORDER BY ORDERDATE";

    @Override
    public List<Order> getOrdersByUsername(String username) {
        List<Order> orderList=new ArrayList<Order>();
        try {
            Connection connection= DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(GET_ORDERS_BY_USERNAME);
            preparedStatement.setString(1,username);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setBillAddress1(resultSet.getString(1));
                order.setBillAddress2(resultSet.getString(2));
                order.setBillCity(resultSet.getString(3));
                order.setBillCountry(resultSet.getString(4));
                order.setBillState(resultSet.getString(5));
                order.setBillToFirstName(resultSet.getString(6));
                order.setBillToLastName(resultSet.getString(7));
                order.setBillZip(resultSet.getString(8));
                order.setShipAddress1(resultSet.getString(9));
                order.setShipAddress2(resultSet.getString(10));
                order.setShipCity(resultSet.getString(11));
                order.setShipCountry(resultSet.getString(12));
                order.setShipState(resultSet.getString(13));
                order.setShipToFirstName(resultSet.getString(14));
                order.setShipToLastName(resultSet.getString(15));
                order.setShipZip(resultSet.getString(16));
                order.setCardType(resultSet.getString(17));
                order.setCourier(resultSet.getString(18));
                order.setCreditCard(resultSet.getString(19));
                order.setExpiryDate(resultSet.getString(20));
                order.setLocale(resultSet.getString(21));
                order.setOrderDate(resultSet.getDate(22));
                order.setOrderId(resultSet.getInt(23));
                order.setTotalPrice(resultSet.getBigDecimal(24));
                order.setUsername(resultSet.getString(25));
                orderList.add(order);

            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderList;
    }


    @Override
    public Order getOrder(int orderId) {
        Order order=new Order();
        try{
            Connection connection= DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(GET_ORDER);
            preparedStatement.setString(1,String.valueOf(orderId));
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                order.setBillAddress1(resultSet.getString(1));
                order.setBillAddress2(resultSet.getString(2));
                order.setBillCity(resultSet.getString(3));
                order.setBillCountry(resultSet.getString(4));
                order.setBillState(resultSet.getString(5));
                order.setBillToFirstName(resultSet.getString(6));
                order.setBillToLastName(resultSet.getString(7));
                order.setBillZip(resultSet.getString(8));
                order.setShipAddress1(resultSet.getString(9));
                order.setShipAddress2(resultSet.getString(10));
                order.setShipCity(resultSet.getString(11));
                order.setShipCountry(resultSet.getString(12));
                order.setShipState(resultSet.getString(13));
                order.setShipToFirstName(resultSet.getString(14));
                order.setShipToLastName(resultSet.getString(15));
                order.setShipZip(resultSet.getString(16));
                order.setCardType(resultSet.getString(17));
                order.setCourier(resultSet.getString(18));
                order.setCreditCard(resultSet.getString(19));
                order.setExpiryDate(resultSet.getString(20));
                order.setLocale(resultSet.getString(21));
                order.setOrderDate(resultSet.getDate(22));
                order.setOrderId(resultSet.getInt(23));
                order.setTotalPrice(resultSet.getBigDecimal(24));
                order.setUsername(resultSet.getString(25));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void insertOrder(Order order) {
        java.sql.Date sd;
        sd = new java.sql.Date(order.getOrderDate().getTime());
        try {
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT_ORDER);
            preparedStatement.setString(1,String.valueOf(order.getOrderId()));
            preparedStatement.setString(2,order.getUsername());
            preparedStatement.setDate(3, sd);
            preparedStatement.setString(4,order.getShipAddress1());
            preparedStatement.setString(5,order.getShipAddress2());
            preparedStatement.setString(6,order.getShipCity());
            preparedStatement.setString(7,order.getShipState());
            preparedStatement.setString(8,order.getShipZip());
            preparedStatement.setString(9,order.getShipCountry());
            preparedStatement.setString(10,order.getBillAddress1());
            preparedStatement.setString(11,order.getBillAddress2());
            preparedStatement.setString(12,order.getBillCity());
            preparedStatement.setString(13,order.getBillState());
            preparedStatement.setString(14,order.getBillZip());
            preparedStatement.setString(15,order.getBillCountry());
            preparedStatement.setString(16,order.getCourier());
            preparedStatement.setString(17,String.valueOf(order.getTotalPrice()));
            preparedStatement.setString(18,order.getBillToFirstName());
            preparedStatement.setString(19,order.getBillToLastName());
            preparedStatement.setString(20,order.getShipToFirstName());
            preparedStatement.setString(21,order.getShipToLastName());
            preparedStatement.setString(22,order.getCreditCard());
            preparedStatement.setString(23,order.getExpiryDate());
            preparedStatement.setString(24,order.getCardType());
            preparedStatement.setString(25,order.getLocale());
            preparedStatement.execute();

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertOrderStatus(Order order) {
        try {
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT_ORDER_STATUS);
            preparedStatement.setString(1,String.valueOf(order.getOrderId()));
            preparedStatement.setString(2,String.valueOf(order.getOrderId()));
            preparedStatement.setString(3,String.valueOf(order.getOrderDate()));
            preparedStatement.setString(4,order.getStatus());
            preparedStatement.execute();

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
