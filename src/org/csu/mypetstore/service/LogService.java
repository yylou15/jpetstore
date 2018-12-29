package org.csu.mypetstore.service;

import org.csu.mypetstore.dao.LogDAO;
import org.csu.mypetstore.dao.impl.LogDAOImpl;
import org.csu.mypetstore.domain.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LogService {
    private LogDAO logDAO = new LogDAOImpl();

    public List<Log> getLogs(){
        return logDAO.getLogs();
    }

    public void insertLog(String userId, String action, String details, String createTime){
        System.out.println("sssss");
        Log AddItemToCartLog = new Log();
        AddItemToCartLog.setUserId(userId);
        AddItemToCartLog.setAction(action);
        AddItemToCartLog.setDetails(details);
        AddItemToCartLog.setCreateTime(createTime);

        System.out.println("asadas");
        logDAO.insertLog(AddItemToCartLog);
    }
}
