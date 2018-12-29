package org.csu.mypetstore.dao;

import org.csu.mypetstore.domain.Log;

import java.util.List;

public interface LogDAO {
    List<Log> getLogs();
    void insertLog(Log log);
}
