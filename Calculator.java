package project;
import java.util.*;

public class Calculator 
{
	public void meth1() 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter student name:");
		String name=sc.nextLine();
		try {
			System.out.println("Enter Five Subject marks:");
			
			System.out.print("Maths: "); 
			int sub1=sc.nextInt();
			if(sub1<0||sub1>100)
			{
			   System.out.println("Inavlid Input...write marks between 0 to 100");	
			  return;
			}
			//------------------------------------
			System.out.print("English: "); 
			int sub2=sc.nextInt();
			if(sub2<0||sub2>100)
			{
			   System.out.println("Inavlid Input...write marks between 0 to 100");	
			   return;
			}
			//------------------------------------
			System.out.print("Biology: "); 
			int sub3=sc.nextInt();
			if(sub3<0||sub3>100)
			{
			   System.out.println("Inavlid Input...write marks between 0 to 100");	
			   return;
			}
			//------------------------------------
			System.out.print("Physics: "); 
			int sub4=sc.nextInt();
			if(sub4<0||sub4>100)
			{
			   System.out.println("Inavlid Input...write marks between 0 to 100");	
			   return;
			}
			//------------------------------------
			System.out.print("Chemistry: "); 
			int sub5=sc.nextInt();
			if(sub5<0||sub5>100)
			{
			   System.out.println("Inavlid Input...write marks between 0 to 100");	
			   return;
			}
			int sum=sub1+sub2+sub3+sub4+sub5;
			System.out.println("\n==========STUDENT RESULT==========\n");
			System.out.println("Total Marks: "+sum);
			
			 float per=(sum*100)/500;
			 System.out.println("Percentage: "+per);
			 
			 if(per >= 90) {
				    System.out.println("Grade: A+");
				}
				else if(per >= 75) {
				    System.out.println("Grade: A");
				}
				else if(per >= 60) {
				    System.out.println("Grade: B");
				}
				else if(per >= 40) {
				    System.out.println("Grade: C");
				}
				else {
				    System.out.println("Grade: Fail");
				}
		}
		catch(Exception e)
		{
			System.out.print("Invalid input! please enter numeric value only");
		}
		sc.close();
	}
 public static void main(String[] args)
   {
	 Calculator obj=new Calculator();
	 obj.meth1();
	 
   }
}