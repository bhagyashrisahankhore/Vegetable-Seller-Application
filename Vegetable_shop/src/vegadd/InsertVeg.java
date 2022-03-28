package vegadd;


import java.util.Scanner;

import bean.Vegetable;
import dao.VegDaoImpl;


public class InsertVeg 
{
public static Vegetable inertveg()
{
	int id;
	String name;
	int quantity;
	float rate;	
	
	
	Scanner sc=new Scanner(System.in);
	id=sc.nextInt();
	name=sc.next();
	quantity=sc.nextInt();
	rate=sc.nextFloat();

	Vegetable vegetables=new Vegetable();
	vegetables.setId(id);
	vegetables.setName(name);
	vegetables.setQuantity(quantity);
	vegetables.setRate(rate);
	VegDaoImpl impl=new VegDaoImpl();
	impl.addVegetable(vegetables);
	System.out.println("more vegetables");
	String choice=sc.next();
	if(choice=="y")
	{
		InsertVeg.inertveg();
	}
	else
	{
		System.exit(1);
	}
	return vegetables;
	}	


	}


