package com.sunbeam.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.sunbeam.pojos.Users;

public class UsersDaoImpl extends Dao implements UserDao {

	public UsersDaoImpl() throws Exception {
		
	}

	@Override
	public int insertUser(Users user) {
		String sql = "insert into users values(default,?,?,?,?,?,?)";
		int count = 0;
		try(PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getMobile());
			ps.setDate(6, user.getDob());
		 
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateUser(Users user) {
		String sql = "Update users set first_name = ?, last_name = ?, mobile = ?, dob = ? where user_id = ?";
		int count = 0;
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getMobile());
			stmt.setDate(4, user.getDob());
			stmt.setInt(5, user.getId());
			count = stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int findUser(Users user) {
		String sql = "Select * from users where email = ?";
	    int id = 0;
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, user.getEmail());
			ResultSet set = stmt.executeQuery();
			while(set.next())
			{
				if(set.getString("password").equals(user.getPassword()))
				{
					id = set.getInt("user_id");
					return id; //actual id
				}
				else 
				{
					return -1; //wrong password
				}
			}
			 return id; //email not found
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public List<Users> getSharedUsers(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
