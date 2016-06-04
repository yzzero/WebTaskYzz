package pers.yinzhenzh.dao;

import java.sql.*;

import org.junit.Test;

import pres.yinzhenzh.servlet.User;
/**
 * @author yzz-13008082
 * */
public class JdbcOperation {
	
	@Test
	public static User getUserInfo(String username){
		User user = new User(null,null);
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try{
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			String sql = "select * from user where username = '"+username+"'";
			rs = st.executeQuery(sql);
			while(rs.next()){
//				System.out.println("id="+rs.getObject("id"));
//				System.out.println("username="+rs.getObject("username"));
//				System.out.println("password="+rs.getObject("password"));
				user.setUsername((String) rs.getObject("username"));
				user.setPassword((String) rs.getObject("password"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		return user;
	}
	
	public static boolean addUser(User user){
		boolean bool = false;
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			String sql = "insert into user(username,password) values ('"+user.getUsername()+"','"+user.getPassword()+"')";
			int num = st.executeUpdate(sql);
			if(num > 0){
				System.out.println("≤Â»Î≥…π¶£°");
				bool = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		return bool;
	};
}
