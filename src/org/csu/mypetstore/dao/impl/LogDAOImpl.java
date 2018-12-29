package org.csu.mypetstore.dao.impl;

import jdk.jfr.DataAmount;
import org.csu.mypetstore.dao.DBUtil;
import org.csu.mypetstore.dao.LogDAO;
import org.csu.mypetstore.domain.Log;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class LogDAOImpl implements LogDAO {
    private static String GET_LOGS = "SELECT * FROM log ORDER BY `createtime`";
    private static String INSERT_LOG = "INSERT INTO log (userid,createtime,action,details) VALUES(?,?,?,?)";


    @Override
    public List<Log> getLogs() {
        List<Log> logList = new ArrayList<Log>();
        try {
            Connection connection= DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_LOGS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Log log = new Log();
                log.setLid(resultSet.getInt(1));
                log.setUserId(resultSet.getString(2));
                log.setCreateTime(resultSet.getString(3));
                log.setDetails(resultSet.getString(4));
                log.setAction(resultSet.getString(5));
                logList.add(log);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  logList;
    }

    @Override
    public void insertLog(Log log) {

        try {
            Connection connection= DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LOG);
            preparedStatement.setString(1,log.getUserId());
            preparedStatement.setString(2,log.getCreateTime());
            preparedStatement.setString(3,log.getAction());
            preparedStatement.setString(4,log.getDetails());
            System.out.println(1111111);
            System.out.println(log.getUserId());
            System.out.println(log.getCreateTime());
            System.out.println(log.getAction());
            System.out.println(log.getDetails());
            preparedStatement.execute();

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
