


class HexaToDecimal {
    // Method to convert a single hexadecimal character to its decimal value
    static int hexadecimal(char hexChar) {
        if (hexChar >= '0' && hexChar <= '9') {
            return hexChar - '0'; // Convert '0'-'9' to 0-9
        } else if (hexChar >= 'A' && hexChar <= 'F') {
            switch (hexChar) {
                case 'A': return 10;
                case 'B': return 11;
                case 'C': return 12;
                case 'D': return 13;
                case 'E': return 14;
                case 'F': return 15;
            }
        }
      return -1;
    }


    static int convert(String input) {
        input = input.toUpperCase(); // Convert the input string to uppercase
        int decimal = 0;
        int length = input.length();

        for (int i = 0; i < length; i++) {
            char hexChar = input.charAt(length - 1 - i); // Process characters from right to left
            decimal += hexadecimal(hexChar) * Math.pow(16, i);
        }

        return decimal;
    }

    public static void main(String[] args) {
        String hexString = "f"; // Example input
        int decimalValue = convert(hexString);
        System.out.println("The decimal value of hexadecimal " + hexString + " is " + decimalValue);
    }
}



class Adjacentspaces {
    static String removeAdjacentSpaces(String input) {
        StringBuilder result = new StringBuilder();
        boolean lastWasSpace = false;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == ' ') {
                if (!lastWasSpace) { 
                    result.append(currentChar);
                    lastWasSpace = true;
                }
            } else {
                result.append(currentChar); // Append non-space characters
                lastWasSpace = false;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String input = "This   is   an  example";
        System.out.println("Original: \"" + input + "\"");
        System.out.println("Processed: \"" + removeAdjacentSpaces(input) + "\"");

        String input2 = "   Leading and   trailing   spaces   ";
        System.out.println("Original: \"" + input2 + "\"");
        System.out.println("Processed: \"" + removeAdjacentSpaces(input2) + "\"");
    }
}



class DuplicateRemover {

    static String removeConsecutiveDuplicates(String input) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            
            if (i == 0 || input.charAt(i) != input.charAt(i - 1)) {
                result.append(input.charAt(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
      
        String input = "ABBCCCCCBBAB";
        System.out.println("Original: " + input);
        System.out.println("Processed: " + removeConsecutiveDuplicates(input));

        String input2 = "AABBBAA";
        System.out.println("Original: " + input2);
        System.out.println("Processed: " + removeConsecutiveDuplicates(input2));
    }
}


5) Write a function that takes as input a string and returns true if the string is a palindrome,
and false otherwise. A palindrome is a string that reads the same forwards or backwards.

public class PalindromeChecker {

    // Function to check if a string is a palindrome
    public static boolean isPalindrome(String input) {
        // Sanitize the input manually
        StringBuilder sanitizedBuilder = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) { // Check if character is alphanumeric
                sanitizedBuilder.append(Character.toLowerCase(c)); // Add lowercase version of the character
            }
        }
        String sanitized = sanitizedBuilder.toString();

        // Reverse the sanitized string
        String reversed = new StringBuilder(sanitized).reverse().toString();

        // Check if the original sanitized string matches the reversed string
        return sanitized.equals(reversed);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isPalindrome("A man, a plan, a canal, Panama")); // true
        System.out.println(isPalindrome("racecar")); // true
        System.out.println(isPalindrome("hello")); // false
        System.out.println(isPalindrome("No 'x' in Nixon")); // true
    }
}

6)
public class WatsonCrickPalindromeChecker {

    // Function to check if a DNA string is a Watson-Crick complemented palindrome
    public static boolean isWatsonCrickPalindrome(String dna) {
        // Validate the DNA string
        for (char c : dna.toUpperCase().toCharArray()) {
            if ("ATCG".indexOf(c) == -1) {
                return false; // Invalid DNA character
            }
        }

        // Compute the reverse complement
        StringBuilder reverseComplement = new StringBuilder();
        for (int i = dna.length() - 1; i >= 0; i--) {
            char complement = getComplement(dna.charAt(i));
            reverseComplement.append(complement);
        }

        // Check if the DNA string equals its reverse complement
        return dna.equalsIgnoreCase(reverseComplement.toString());
    }

    // Helper function to get the complement of a DNA base
    private static char getComplement(char base) {
        switch (Character.toUpperCase(base)) {
            case 'A': return 'T';
            case 'T': return 'A';
            case 'C': return 'G';
            case 'G': return 'C';
            default: return ' '; // Shouldn't happen if input is valid DNA
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isWatsonCrickPalindrome("ATCGAT")); // true
        System.out.println(isWatsonCrickPalindrome("ATGC"));   // false
        System.out.println(isWatsonCrickPalindrome("AATT"));   // true
        System.out.println(isWatsonCrickPalindrome("CCGG"));   // true
    }
}

7)
Write a function that takes as input a DNA string of A, C, G, and T characters and returns
the string in reverse order with all of characters replaced by their complements. For
example, if the input is ACGGAT, then return ATCCGT.
public class ReverseComplement {

    // Function to compute the reverse complement of a DNA string
    public static String reverseComplement(String dna) {
        StringBuilder reverseComplement = new StringBuilder();

        // Loop through the string in reverse order
        for (int i = dna.length() - 1; i >= 0; i--) {
            char complement = getComplement(dna.charAt(i));
            reverseComplement.append(complement);
        }

        return reverseComplement.toString();
    }

    // Helper function to get the complement of a DNA base
    private static char getComplement(char base) {
        switch (Character.toUpperCase(base)) {
            case 'A': return 'T';
            case 'T': return 'A';
            case 'C': return 'G';
            case 'G': return 'C';
            default: throw new IllegalArgumentException("Invalid DNA character: " + base);
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(reverseComplement("ACGGAT")); // ATCCGT
        System.out.println(reverseComplement("ATGC"));   // GCAT
        System.out.println(reverseComplement("AATT"));   // AATT
        System.out.println(reverseComplement("CCGG"));   // CCGG
    }
}

10)
In DNA sequence analysis, a complemented palindrome is a string equal to its reverse
complement. Adenine (A) and Thymine (T) are complements, as are Cytosine (C) and
Guanine (G). For example, ACGGT is a complement palindrome. Such sequences act as

transcription-binding sites and are associated with gene amplification and genetic
instability. Given a text input of N characters, find the longest complemented palindrome
that is a substring of the text. For example, if the text is GACACGGTTTTA then the
longest complemented palindrome is ACGGT. Hint: consider each letter as the center of a
possible palindrome of odd length, then consider each pair of letters as the center of a
possible palindrome of even length.

public class LongestComplementedPalindrome {

    // Function to find the longest complemented palindrome in a DNA string
    public static String findLongestComplementedPalindrome(String dna) {
        String longestPalindrome = "";
        int n = dna.length();

        for (int i = 0; i < n; i++) {
            // Odd-length palindromes (centered around a single character)
            String oddPalindrome = expandAroundCenter(dna, i, i);
            if (oddPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = oddPalindrome;
            }

            // Even-length palindromes (centered around a pair of characters)
            if (i < n - 1) {
                String evenPalindrome = expandAroundCenter(dna, i, i + 1);
                if (evenPalindrome.length() > longestPalindrome.length()) {
                    longestPalindrome = evenPalindrome;
                }
            }
        }

        return longestPalindrome;
    }

    // Function to expand around the center and find the complemented palindrome
    private static String expandAroundCenter(String dna, int left, int right) {
        int n = dna.length();

        while (left >= 0 && right < n && isComplement(dna.charAt(left), dna.charAt(right))) {
            left--;
            right++;
        }

        return dna.substring(left + 1, right);
    }

    // Function to check if two characters are Watson-Crick complements
    private static boolean isComplement(char a, char b) {
        return (a == 'A' && b == 'T') || (a == 'T' && b == 'A') ||
               (a == 'C' && b == 'G') || (a == 'G' && b == 'C');
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(findLongestComplementedPalindrome("GACACGGTTTTA")); // ACGGT
        System.out.println(findLongestComplementedPalindrome("ATGCGCTAGGCT")); // GCGC
        System.out.println(findLongestComplementedPalindrome("AATTCCGG"));     // AATTCCGG
        System.out.println(findLongestComplementedPalindrome("GATTACA"));      // TT
    }
}




11) 

Mypackage:: 
Mathoperation.java – 

package mypackage;

public class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

Tringoperation –

package mypackage;

public class StringOperations {
    public String concatenate(String a, String b) {
        return a + b;
    }

    public int getLength(String str) {
        return str.length();
    }
}


Main –

import mypackage.MathOperations;
import mypackage.StringOperations;

public class Main {
    public static void main(String[] args) {
      
        MathOperations m1 = new MathOperations();
        int sum = m1.add(5, 10);
        int product = m1.multiply(4, 7);

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);

      
        StringOperations s1 = new StringOperations();
        String concatenated = s1.concatenate("Hello, ", "World!");
        int length = s1.getLength("Java Programming");

        System.out.println("Concatenated String: " + concatenated);
        System.out.println("Length of String: " + length);
    }
}









