
package gui;
public class Student
{
  int ID;
  String name,DOB;
  double CPI;
  public Student(int ID,String name,String DOB,double CPI)
    {
        this.ID=ID;
        this.name=name;
        this.DOB=DOB;
	this.CPI=CPI;	

     }
 public int getID()
  {
   return this.ID;
   }
 
 public String getName()
  {
    return this.name;
   }

 public String getDOB()
  {
    return this.DOB;
   }
 
 public double getCPI()
  {
    return this.CPI;
   }
   
}
