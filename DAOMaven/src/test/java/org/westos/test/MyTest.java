package org.westos.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.westos.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MyTest {
    @Test
    public void test() throws Exception{
        ComboPooledDataSource source = new ComboPooledDataSource();
        User user = new User();
        Connection con = source.getConnection();
        PreparedStatement ps = con.prepareStatement("insert into hello(username,password) values(?,?)");
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());

        ps.executeUpdate();

        System.out.println(source);
    }
}
