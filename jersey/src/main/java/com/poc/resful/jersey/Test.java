package com.poc.resful.jersey;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {


    // Function to validate the password.
    public static boolean
    isValidPassword(String password)
    {
  
        // Regex to check valid password.
		/*
		 * String regex = "^(?=.*[0-9])" + "(?=.*[a-zA-Z])" + "(?=.*[@#$%^&+=])" +
		 * "(?=\\S+$).{4,}$";
		 */
  
    	String regex = "\b[a-zA-Z]{1,1}\\d{5,5}.?\b";
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
  
        // If the password is empty
        // return false
        if (password == null) {
            return false;
        }
  
        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);
  
        // Return if the password
        // matched the ReGex
        return m.matches();
    }
  
    // Driver Code.
    public static void main(String args[])
    {
  
        // Test Case 1:
        String str1 = "A12345";
        System.out.println(isValidPassword(str1));
  
        // Test Case 2:
        String str2 = "Aer234";
        System.out.println(isValidPassword(str2));
  
        // Test Case 3:
        String str3 = "A1234567";
        System.out.println(isValidPassword(str3));
  
        // Test Case 4:
        String str4 = "1234rt";
        System.out.println(isValidPassword(str4));
  
        // Test Case 5:
        String str5 = "223@20";
        System.out.println(isValidPassword(str5));
  
        // Test Case 6:
        String str6 = "geeks@portal20";
        System.out.println(isValidPassword(str6));
    }
}
