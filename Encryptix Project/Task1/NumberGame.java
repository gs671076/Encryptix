import java.util.*;
class NumberGame
{ 
static int score=0;
static int round=0;
static int atmp=0;
static int roundWin=0;
Scanner k =new Scanner(System.in);
void play()
{
int randomNumber;
int number;
int attempts=0;
randomNumber=(int)(Math.random()*100);
while(attempts<10){
System.out.print("\nAttempt " + (attempts + 1) + "/ 10 : Enter your guess (1-100): ");
number=k.nextInt();
//System.out.println(Math.abs(number-randomNumber));
if(randomNumber<number)
{
System.out.println("Guess is too High");
}
else if(Math.abs(number-randomNumber)==0)
{
System.out.println("Guess is Correct.");
++score;
++roundWin;
break;
}
else
{
System.out.println("Guess is too Low.");
}
attempts++;
}
if(attempts==10)
{
System.out.println("Your attempt is Over.");
}
atmp=atmp+attempts;
System.out.print("Correct Guess Number is: ");
System.out.println(randomNumber);
}
public static void main(String args[])
{
NumberGame n=new NumberGame();
Scanner k =new Scanner(System.in);
int choice;
boolean flag=true;
while(flag)
{
System.out.println("<<<Menu>>>");
System.out.println("Press 1 for Play the Game.");
System.out.println("Press 2 for Exit from Game.");
System.out.print("Enter Your Choice: ");
choice=k.nextInt();
switch(choice)
{
case 1: 
{
round++;
n.play();
break;
}
case 2:
{
flag=false;
break;
}
default :
System.out.println("Please Choose Valid Option.");
}
}
System.out.println("\nTotal rounds you played: "+round);
System.out.println("Total rounds you Win: "+roundWin);
System.out.println("Your attempt is: "+atmp);
System.out.println("Your Current Score is "+score);
}
}