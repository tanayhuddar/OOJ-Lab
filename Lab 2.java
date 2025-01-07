import java.util.*;
import java.util.Scanner;

class Student{
	int usn;
	String name;
	int total_credits;
	int[] credits;
	int[] marks;

void SGPA(){
	int x=0;
	for(int i=0; i < marks.length; i++){
		int g = (marks[i]/10)+1;
		x = x +(credits[i] * g);
	}
		double s = (double) x / total_credits;
		System.out.println("SGPA is :" + s);
}


void DisplayDetails(){
	System.out.println("\nYour name is "+name);
	System.out.println(" and USN is "+usn);
}

}



class StudentSGPA{
	public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	Student s1 = new Student();

	System.out.println("Enter usn: ");
	s1.usn = sc.nextInt();

	sc.nextLine();

	System.out.println("\nEnter name: \n");
	s1.name = sc.nextLine();

	System.out.println("\nEnter total number of credits of all subjects: ");
	s1.total_credits = sc.nextInt();
	
	System.out.println("\nEnter total number of subjects: ");
	int subjects = sc.nextInt();
	
	s1.credits = new int[subjects];
	s1.marks = new int[subjects];

	System.out.println("\nEnter marks and credits earned in each subject: ");
	for(int i=0; i < subjects ; i++){
		System.out.println("Subject "+ (i + 1) +"-credit--: ");
		s1.credits[i] = sc.nextInt();

		System.out.println("Subject "+ (i + 1) +"-marks--: ");
		s1.marks[i] = sc.nextInt();
	}
	
	s1.DisplayDetails();
	s1.SGPA();

	sc.close();

    }
}
	