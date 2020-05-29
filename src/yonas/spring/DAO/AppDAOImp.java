package yonas.spring.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import yonas.spring.model.Users;

public class AppDAOImp implements AppDAO {
	
	private DataSource dataSource;

	public AppDAOImp(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Users> listUsers() {
		String SQL = "Select * from users";
		List<Users> listUsers = new ArrayList<Users>();
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs =  ps.executeQuery();
	        while(rs.next()){
	        	Users temp = new Users(
	        			rs.getInt("user_id"),
	        			rs.getString("username"),
	        			rs.getString("password"),
	        			rs.getString("first_name"),
	        			rs.getString("last_name")
	        			);
	        	listUsers.add(temp);
	        }
	     rs.close();
	     ps.close();     
	     return listUsers;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {e.printStackTrace();}
			}
			
		}
			
	
	}

}