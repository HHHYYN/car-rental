package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.User;
import util.SqlHelper;

public class Impluser {
	//user数据库 

	//增 注册用户
		public void add(User a) throws Exception {
			Connection conn=SqlHelper.getConnection();
			Statement stmt = null;
			String name=a.getName();
			String passwd=a.getPasswd();
			String mail=a.getMail();
			int sf=a.getSf();
			System.out.println(name);
			System.out.println(passwd);
			System.out.println(mail);
			System.out.println(sf);
			String sql="INSERT INTO s(name,passwd,sf,meil) VALUES(?,?,?,?)";
			PreparedStatement pstm0=conn.prepareStatement(sql);
			pstm0.setString(1,name);
			pstm0.setString(2,passwd);
			pstm0.setInt(3,sf);
			pstm0.setString(4, mail);
			pstm0.executeUpdate();
			
			conn.close();
		}
		
		//删 管理员删除用户
		public void del(User a) throws Exception {
			// TODO Auto-generated method stub
			Connection conn=SqlHelper.getConnection();
			String sql="delete from s where name = ? and passwd=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, a.getName());
			pstmt.setString(2, a.getPasswd());
			pstmt.executeUpdate();
			conn.close();
		}
		
		// 修改密码
		public void update(User a) throws Exception {
			// TODO Auto-generated method stub
			Connection conn=SqlHelper.getConnection();
			String sql="UPDATE s SET passwd=?  WHERE name=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,a.getPasswd());
			pstmt.setString(2,a.getName());
			pstmt.executeUpdate();
			conn.close();
		}
		
		//改 修改用户邮箱
				public void updatemail(User a) throws Exception {
					Connection conn=SqlHelper.getConnection();
					String sql="UPDATE s SET meil=?  WHERE name=?";
					PreparedStatement pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, a.getMail());
					pstmt.setString(2,a.getName());
					pstmt.executeUpdate();
					conn.close();
				}
				
		//修改用户身份
		public void updatesf(User a) throws Exception {
					// TODO Auto-generated method stub
					Connection conn=SqlHelper.getConnection();
					String sql="UPDATE s SET sf=?  WHERE name=?";
					PreparedStatement pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, a.getSf());
					pstmt.setString(2,a.getName());
					pstmt.executeUpdate();
					conn.close();
				}

		
		
		//查用户是否存在
		public boolean getTel(User aUser) throws Exception {
			Connection conn=SqlHelper.getConnection();
			String sql="SELECT passwd,sf,meil FROM s WHERE name=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			if(aUser.getName().equals("")) {
				conn.close();
				return false;
			}
			else {
				pstmt.setString(1, aUser.getName());
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					conn.close();
					return false;
				}
				else {
					conn.close();
					return true;
				}
			}
			
		
			
		}
		
		

		//登录
		public boolean in(User aUser) throws Exception {
			// TODO Auto-generated method stub
			Connection conn=SqlHelper.getConnection();
			String sql="SELECT * FROM s WHERE name= ? AND passwd=? And sf=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, aUser.getName());
			pstmt.setString(2, aUser.getPasswd());
			pstmt.setInt(3, aUser.getSf());
			ResultSet rs=pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("登录成功");
				return true;
			}
			else {
				System.out.println("登录失败");
				return false;
			}
		}
		
	

}
