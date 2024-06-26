import java.util.*;
class StudentGradeCalculator
{
float percentage;

void calculateMarks()
{
int sub1,sub2,sub3,sub4,sub5;
Scanner k=new Scanner(System.in);
System.out.println("Enter the marks out of 100. ");
System.out.print("Enter the marks of first subject: ");
sub1=k.nextInt();
System.out.print("Enter the marks of second subject: ");
sub2=k.nextInt();
System.out.print("Enter the marks of third subject: ");
sub3=k.nextInt();
System.out.print("Enter the marks of fourth subject: ");
sub4=k.nextInt();
System.out.print("Enter the marks of fifth subject: ");
sub5=k.nextInt();

int sum=sub1+sub2+sub3+sub4+sub5;
float avg=sum/5.0f;
percentage=avg;
System.out.println("\n\nTotal Marks: "+sum);
System.out.println("Percentage:  "+percentage+"%");
}

void gradeCalculate()
{
if(percentage>90)
System.out.println("Grade: A+");
else if(percentage>80)
System.out.println("Grade: A");
else if(percentage>70)
System.out.println("Grade: B+");
else if(percentage>60)
System.out.println("Grade: B");
else if(percentage>50)
System.out.println("Grade: C+");
else if(percentage>40)
System.out.println("Grade: C");
else if(percentage>33)
System.out.println("Grade: D");
else
System.out.println("Grade: F(Fail)");
}

public static void main(String args[])
{
StudentGradeCalculator g1=new StudentGradeCalculator();
g1.calculateMarks();
g1.gradeCalculate();
}
}