import java.util.*;
import java.util.Scanner;
import java.lang.Math.*;


class Quadratic{
	public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a,b and c:\n");
	double a= sc.nextInt();
	double b= sc.nextInt();
	double c= sc.nextInt();

	if (b*b-4*a*c > 0) {
		double x=b*b-4*a*c; 
		double r1 = -b + Math.sqrt(x)/2*a;
		double r2 = -b - Math.sqrt(x)/2*a;
		System.out.println("Roots are : " +r1+" and "+r2);
	}
	else{
		System.out.println("There are no real solutions.");
	}
    }
}