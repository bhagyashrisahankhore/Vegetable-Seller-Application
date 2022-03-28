package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import bean.Vegetable;




public class VegDaoImpl implements addVeg
{

	@Override
	public void addVegetable(Vegetable vegetable) 
	{
		
		
	
		try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
     
		
	    List<Vegetable> list=new LinkedList<Vegetable>();
	     list.add(vegetable);
	     
	     
	     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/6147","root","root");
			Statement st=con.createStatement();
			int x=0;
			String query="INSERT INTO vegetables VALUES('"+vegetable.getId()+"','"+vegetable.getName()+"','"+vegetable.getQuantity()+"','"+vegetable.getRate()+"')";
			x=st.executeUpdate(query);
			if(x==0)
			{
				System.out.println("Data is not inserted");
			}
			else
			{
				System.out.println("Data inserted successfully");
			}
	}
	     catch(Exception e)
	     {
	    	 System.out.println(e);
	     }
		

	}

	

}


		
	

	

