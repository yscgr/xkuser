package com.xk.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.xk.model.User;
import com.xk.util.SQLHelper;
public class UserService {
	//checkUser
	public boolean checkUser(User user) {
		boolean flag = false;
		String sql = "select * from user where username = ? and password = ?";
		String []parameters = {user.getUsername(),user.getPassword()};
		ResultSet rs = SQLHelper.executeQuery(sql, parameters); 
		try {
			if(rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			SQLHelper.close(rs, SQLHelper.getPs(),SQLHelper.getCt());
		}
		return flag;
	}
	//getAllUsers
	public ArrayList<User> getAllUsers(){
		ArrayList<User> allUsers = new ArrayList<User>();
		String sql = "select * from user";
		String []parameters = null;
		ResultSet rs = SQLHelper.executeQuery(sql, parameters); 
		try {
			while(rs.next()){
				User user=new User();
				user.setId(rs.getString(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setIdentity(rs.getString(5));
				allUsers.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLHelper.close(rs, SQLHelper.getPs(),SQLHelper.getCt());
		}		
		return allUsers;
	}
}
