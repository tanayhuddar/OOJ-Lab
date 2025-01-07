// Programs to be completed This Week and to be submitted in Google Classroom on or before 13/11/2024 @11:30PM

// Write a Java program to create a character array containing the contents of a String 

//  // Write a Java program to create a character array containing the contents of a String

// public class Main {
//     public static void main(String[] args) {
//         String str = "Hello, World!";
        
      
//         char[] charArray = str.toCharArray();
        
  
//         System.out.println("Character Array: ");
//         for (char c : charArray) {
//             System.out.print(c + " ");
//         }
//     }
// }



// Write a Java program to check whether a given string starts with the contents of another string

// // checl wether string startw ith another string

// public class Main{
//     public static void main(String[] args) {
//         String str1 = "tanmay garwal";
//         String str2 = "Hello";
        
       
//         if (str1.startsWith(str2)) {
//             System.out.println("yes");
//         } else {
//             System.out.println("no");
//         }
//     }
// }


// Write a Java program to concatenate Two strings
// public class Main{
//     public static void main(String[] args) {
//         String str1 = "tan";
//         String str2 = " may";
        
//         // Concatenate two strings
//         String result = str1.concat(str2);
        
//         // Print the result
//         System.out.println("Concatenated String: " + result);
//     }
// }


// Write a Java program to get the character at the given index within the String

// public class Main{
//     public static void main(String[] args) {
//         String str = "Tanmay";
//         int index = 3;
        
      
//         char ch = str.charAt(index);

//         System.out.println("Character at index " + index + ": " + ch);
//     }
// }




// Write a Java program to get the character (Unicode code point) at the given index within the String
// public class Main{
//     public static void main(String[] args) {
//         String str = "Tanmay";
//         int index = 1;
        
     
//         int unicode = str.codePointAt(index);
 
//         System.out.println("Unicode code point at index " + index + ": " + unicode);
//     }
// }




// Work on String Methods discussed in the class.       
// In the following program, called ComputeResult, what is the value of result after each numbered line executes(Line no 7 to13)?

// public class ComputeResult {
//     public static void main(String[] args) {
//         String original = "software";
//         StringBuffer result = new StringBuffer("hi");
//         int index = original.indexOf('a');


//         result.setCharAt(0, original.charAt(0));
//         result.setCharAt(1, original.charAt(original.length()-1));
//         result.insert(1, original.charAt(4));
//      result.append(original.substring(1,4));
//      result.insert(3, (original.substring(index, index+2) + " "));


//         System.out.println(result);
//     }
// }
// Si
// Se
// Sweoft
// Sword t


// Show two ways to concatenate the following two strings together to get the string
//  "Hi, mom.":
// String hi = "Hi, ";
// String mom = "mom.";


// public class Main{
//     public static void main(String[] args) {
//         String hi = "Hi, ";
//         String mom = "mom.";
// 	 String result = hi.concat(mom)
// 	System.out.println(result);
//     }
// }










// public class Main{
//     public static void main(String[] args) {
//         String hi = "Hi, ";
//         String mom = "mom.";
        


//         String result = hi + mom;
    
//         System.out.println(result); 
//     }
// }




// Write a program that computes your initials from your full name and displays them.

// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);


//         System.out.print("Enter your full name: ");
//         String fullName = scanner.nextLine();
        
     
//         String[] nameParts = fullName.split(" ");
        

//         String initials = "";
        

//         for (String name : nameParts) {
//             initials += name.charAt(0); 
//         }
        

//         System.out.println("Your initials are: " + initials.toUpperCase());
//         0
    
//         scanner.close();
//     }
// }


// An anagram is a word or a phrase made by transposing the letters of another word or phrase; for example, "parliament" is an anagram of "partial men," and "software" is an anagram of "swear oft." Write a program that figures out whether one string is an anagram of another string. The program should ignore white space and punctuation.

