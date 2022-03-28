package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import bean.Customer;
import bean.Vegetable;

public class CustDaoImpl implements CustVeg
{

	@Override
	public void displayVegetable(Vegetable vegetable) 
	{
     List<Vegetable>list=new LinkedList<Vegetable>();
		try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/6147","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM `6147`.`vegetables`");
			Vegetable cust=null;
			while(rs.next())
			{
				cust=new Vegetable();
				cust.setId(rs.getInt(1));
				cust.setName(rs.getString(2));
				cust.setQuantity(rs.getInt(3));
				cust.setRate(rs.getFloat(4));
				list.add(cust);
			}
			
			System.out.println(list);
			int size=list.size();
			int id[]=new int[size];
			int quan[]=new int[size];
			float rate[]=new float[size];
			int i=0;
			
			for(Vegetable customer:list) 
			{
				id[i]=customer.getId();
				quan[i]=customer.getQuantity();
				rate[i]=customer.getRate();
				
		System.out.print(customer.getId()+"   ");
		System.out.print(customer.getName()+"   ");
		System.out.print(customer.getQuantity()+"   ");
		System.out.println(customer.getRate()+"   ");
		//System.out.println(rate[i]+ "at position="+i);
		i++;
			}
			float billsum=0;
			Scanner sc=new Scanner(System.in);
		   float bill=0.0f;
            System.out.println("how many items want to purchase");
            int count=sc.nextInt();
            for(int ii=0;ii<count;ii++)
            {
            	System.out.println("Enter item id to purchase");
            	System.out.println("Enter item id");
            	int idd=sc.nextInt();
            	idd=idd-1;
            	System.out.println("Enter item Quantity");
            	int quantity=sc.nextInt();
            	if(quan[idd]>quantity)
            	{
            	System.out.println(bill);
            	
               bill=bill+quantity*rate[idd];
               Statement st2=con.createStatement();
               System.out.println("Cust="+quan[idd]);
               System.out.println("Quantity="+quantity+"Rate="+rate[idd]);
               billsum=billsum+bill;
               System.out.println("bill is="+bill);
               int uquan=quan[idd]-quantity;
               idd=idd+1;
               
               String queryUpdate="UPDATE `6147`.`vegetables` SET `quantity`='"+uquan+"' WHERE `id`='"+idd+"'";
               st2.executeUpdate(queryUpdate);

            }
            else
            {
            	System.out.println("Item not in stock");
            	ii--;
            }
            System.out.println(billsum);
	}
	}
			
	     catch(Exception e)
	     {
	    	 System.out.println(e);
	     }
		
	}
	}


	


	
		



