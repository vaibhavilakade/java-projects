package project;
import java.util.*;

public class EmployeeManagement 
{
	Scanner sc=new Scanner(System.in);
	String[] emp= {"Tanya", "Kirti","Vishal","Shantanu","kunal","shruti"};
	   public void totalEmp()
	    {
		   System.out.println("Total employee number is "+emp.length);
	    }
		public void Searching()
		{
			System.out.print("sr.no of employee: ");
			int index = sc.nextInt();
			if(index >= 0 && index < emp.length) {
			    System.out.println(emp[index]);
			}
			else {
			    System.out.println("Only 6 employees are present. Enter a number between 0 and 5.");
			}
			
			System.out.println("==============================");
			System.out.println("Enter employee name");
			sc.nextLine();
			String search=sc.nextLine();
			boolean found=false;
			for(String name:emp)
			{
				if(name.equals(search))
				{
					 found = true;
				     break;
				}
			}
			if(found)
			{
			    System.out.println("Employee Found");
			}
			else
			{
			    System.out.println("Employee Not Found");
			}
			System.out.println("==============================");
		}
		public void updating()
		{
			System.out.println("Updated employee list");
			System.out.println("------------------------------");
			String[] emp= {"vaibhavi","gauri","aayushi","pallavi","kalyani","shreya","rupali"};
			for(String s:emp)
			{
				System.out.println(s);
			}
			System.out.println("==============================");
		}
		public void stringOperation()
		{
			System.out.println("Number of letters are present");
			for(String s:emp)
			{
				System.out.println(s+" = "+s.length());	
			}
			System.out.println("=============================");
			System.out.println("Upper case employee name");
			for(String s:emp)
			{
			    System.out.println(s.toUpperCase());
			}
		}
  public static void main(String[] args)
 {
	EmployeeManagement obj=new EmployeeManagement();
	obj.totalEmp();
	obj.Searching();
	obj.updating();
	obj.stringOperation();
 }
}
