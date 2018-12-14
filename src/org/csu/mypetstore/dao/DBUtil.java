package org.csu.mypetstore.dao;

import java.sql.*;

public class DBUtil {
    private static String driverString ="com.mysql.cj.jdbc.Driver";
    private static String connectString="jdbc:mysql://localhost:3306/mypetstore?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
    private static String username="root";
    private static String password="";

    public static Connection getConnection() throws Exception{
        Connection connection=null;
        try{
            Class.forName(driverString);
            connection= DriverManager.getConnection(connectString,username,password);
        }catch (Exception e){
            throw e;
        }
        return connection;
    }
    public static void closeStatement(Statement statement) throws SQLException {
        statement.close();
    }
    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.close();
    }
    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        resultSet.close();
    }

    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
//    public static void main(String[] args) throws Exception {
//        Connection conn=DBUtil.getConnection();
//        System.out.println(conn);
//    }

}
