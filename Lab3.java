// 3) Develop a Java program that prints all real solutions to the quadratic equation
// ax 2 +bx+c = 0. Read in a, b, c and use the quadratic formula. If the discriminate b 2 -
// 4ac is negative, display a message stating that there are no real solutions.


import java.util.Scanner;


public class Lab3 {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);


System.out.print("Enter x: ");
       double x = scanner.nextDouble();


       System.out.print("Enter y: ");
       double y = scanner.nextDouble();


       System.out.print("Enter z: ");
       double z = scanner.nextDouble();


       double d = y * y - 4 * x * z;


       if (d < 0) {
           System.out.println("There are no real solutions.");
       } else {
           double sqrtD = Math.sqrt(d);
           double r1 = (-y + sqrtD) / (2 * x);
           double r2 = (-y - sqrtD) / (2 * x);


           System.out.println("The solutions are: ");
           System.out.println("r1 = " + r1);
           System.out.println("r2 = " + r2);
       }
   }
}
