package controller;

import bean.Customer;
import bean.Vegetable;
import dao.CustDaoImpl;

public class CustomerCall 
{
public static void main(String args[])
{
	
	CustDaoImpl custdaoimpl=new CustDaoImpl();
	Vegetable vegetable=new Vegetable();
   Customer cust=new Customer();
   custdaoimpl.displayVegetable(vegetable);
   System.out.println("Work Fine");
}
}
