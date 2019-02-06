package Assign4;

import java.security.interfaces.RSAKey;
import java.sql.*;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import org.omg.CORBA.PUBLIC_MEMBER;  

public class TestDatabase  {
	ResultSet rs;
	static Connection con;
//	public TestDatabase(){
//	
//	try {
//		Class.forName("com.mysql.jdbc.Driver");
//
//	con=DriverManager.getConnection("jdbc:mysql://localhost/faltu?"
//            + "user=root&password=password");
//	
//	System.out.println(con.getSchema());
//	//here sonoo is database name, root is username and password  
//	} catch (ClassNotFoundException e) {
//		System.out.println("yaha pe error");
//		e.printStackTrace();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}  
//	}
	
	
	/*public static void main(String args[]){
		Statement stmt;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/faltu?characterEncoding=utf8","root","password");
			stmt = con.createStatement();
			int rs=stmt.executeUpdate("update userinfo set username = 'ayush' where username = 'ayu95ptl'"); 
			System.out.println("value of rs" + rs );
//				while(rs.next()){
//					String user = rs.getString("username");
//					String name = rs.getString("name");
//					int age = rs.getInt("age");
//					System.out.println(user + " " + name + " " + age);
//		    //System.out.println("Driver successful" + rs.getMetaData().getColumnCount());
//		    
//				}
//		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   catch (ClassNotFoundException e) {
			System.out.println("yaha pe error");
			e.printStackTrace();
		}
			
	}*/
	
	public Details getorderdetails(String tracking_no){

		
		Statement stmt;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fedex?characterEncoding=utf8","root","password");
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from details where tracking_number = " + Integer.parseInt(tracking_no)); 
			System.out.println("value of rs" + rs );
				while(rs.next()){
					Details details = new Details(rs.getString("packaging"), 
							rs.getString("signature_services"), 
							String.valueOf(rs.getInt("weight")), 
							String.valueOf(rs.getInt("tracking_number")), 
							rs.getString("dimensions"), 
							rs.getString("services"), 
							rs.getString("special_handling_section"), 
							rs.getString("source_city"), 
							rs.getString("destination"), 
							String.valueOf(rs.getDate("estimated_date")), 
									String.valueOf(rs.getDate("shipping_date")));
					
			return details;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	public int storedetails(Details details) {
		Statement stmt;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			//System.out.println("Yaha pe aa gaya hun");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fedex?characterEncoding=utf8","root","password");
			stmt = con.createStatement();
			int rs=stmt.executeUpdate("Insert into details values('"+details.getTracking_number()+"',"+ details.getWeight()+
					",'"+details.getSignature_services()+"','"+details.getPackaging()+"','"+details.getServices()+"','"+details.getDimensions()
					+"','"+details.getSpecial_handling_section()+"','"+details.getSource_city()+"','"+details.getDestination()+"','"+details.getShipping_date()
					+"','"+details.getEstimated_date()+"');");
			
			System.out.println("Yaha se me chala");
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int store_activity(Activity activity) {
		// TODO Auto-generated method stub
		Statement stmt;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			//System.out.println("Yaha pe aa gaya hun");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fedex?characterEncoding=utf8","root","password");
			stmt = con.createStatement();
			int rs=stmt.executeUpdate("Insert into activity values('"+activity.getTracking_number()+"',"+ "null"+
					",'"+activity.getDelivery_status()+"','"+activity.getDate()+"','"+activity.getDay()+"','"+activity.getLocation()
					+"','"+activity.getMessage()+"');");
			
			System.out.println("Yaha se me chala");
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
		
	}

	public ArrayList<Activity> getactivities(String tracking_number) {
		// TODO Auto-generated method stub
		Statement stmt;
		ArrayList<Activity> activitylist = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fedex?characterEncoding=utf8","root","password");
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from activity where tracking_number = " + Integer.parseInt(tracking_number));
				while(rs.next()){
					Activity activity = new Activity(String.valueOf(rs.getInt("tracking_number")), 
							String.valueOf(rs.getInt("activity_id")), 
							rs.getString("delivery_status"), 
							rs.getString("Date"), 
							rs.getString("day"), 
							rs.getString("location"), 
							rs.getString("message"));
				activitylist.add(activity);
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return activitylist;
	}
	
	
}
