package org.csu.mypetstore.dao.impl;

import org.csu.mypetstore.dao.DBUtil;
import org.csu.mypetstore.dao.SequenceDAO;
import org.csu.mypetstore.domain.Sequence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class SequenceDAOImpl implements SequenceDAO {
    private static final String GET_SEQUENCE="SELECT name, nextid FROM SEQUENCE WHERE NAME = ?";
    private static final String UPDATE_SEQUENCE="UPDATE SEQUENCE SET NEXTID = ? WHERE NAME = ?";
    @Override
    public Sequence getSequence(Sequence sequence) {
        try{
            Connection connection= DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(GET_SEQUENCE);
            preparedStatement.setString(1,sequence.getName());
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                sequence.setName(resultSet.getString(1));
                sequence.setNextId(resultSet.getInt(2));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sequence;
    }

    @Override
    public void updateSequence(Sequence sequence) {
        try {
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_SEQUENCE);
            preparedStatement.setString(1,String.valueOf(sequence.getNextId()));
            preparedStatement.setString(2,sequence.getName());
            preparedStatement.executeUpdate();

            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
