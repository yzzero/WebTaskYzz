package pers.yinzhenzh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 * @author yzz-13008082
 * */
public class JdbcUtils {
	
	//�������ݿ�������Ϣ
	private static Properties config = new Properties();
	static{
		try {
			config.load(JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties"));
			Class.forName(config.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//��ȡ���ݿ�����
	public static Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(config.getProperty("url"),config.getProperty("username"),config.getProperty("password"));
		return conn;
	}
	
	//�ͷ�
	public static void release(Connection conn,Statement st,ResultSet rs){
		if(rs != null){
			try{
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			rs = null;
		}
		if(st != null){
			try{
			st.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			st = null;
		}
		if(conn != null){
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
