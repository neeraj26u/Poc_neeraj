package com.poc.resful.jersey;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	

        
    // Function to validate the password.
    public static boolean isValidPassword(String password)
    {
    	String s1 = "neeraj@1234";
    	System.out.println(s1.replaceAll("\\w(?=\\w{0,})|\\W(?=\\W{0,})", "*"));
  
        // Regex to check valid password.
		/*
		 * String regex = "^(?=.*[0-9])" + "(?=.*[a-zA-Z])" + "(?=.*[@#$%^&+=])" +
		 * "(?=\\S+$).{4,}$";
		 */
  
    	String regex = "\\b[a-zA-Z]{1,1}\\d{4}.\\b";
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
  
    	
   	 Date d=new  java.util.Date();
     LocalDate businessDay = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        int addedDays = 0;
        while (addedDays < 10) {
            businessDay = businessDay.plusDays(1);
            if (!(businessDay.getDayOfWeek() == DayOfWeek.SATURDAY || businessDay.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        System.out.println(Date.from(businessDay.atStartOfDay(defaultZoneId).toInstant()));
        
        // Test Case 1:
        String str1 = "A123456";
        System.out.println(isValidPassword(str1));
  
        // Test Case 2:
        String str2 = "234233";
        System.out.println(isValidPassword(str2));
  
        // Test Case 3:
        String str3 = "11111A";
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
