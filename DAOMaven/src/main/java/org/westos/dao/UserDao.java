package org.westos.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.westos.bean.User;

import java.sql.*;


public class UserDao {

    public boolean findUser(User user) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection conn = dataSource.getConnection();
        String sql="select * from hello where username=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,user.getUsername());
        ResultSet resultSet = statement.executeQuery();
        boolean b = resultSet.next();
        dataSource.close();
        return !b; //
    }

    public void addUser(User user) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection conn = dataSource.getConnection();
        String sql="insert into hello values(?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setNull(1,Types.NULL); //设置null值
        statement.setString(2, user.getUsername());
        statement.setString(3, user.getPassword());
        statement.executeUpdate();
        dataSource.close();

    }
    }
