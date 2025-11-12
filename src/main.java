import java.util.Scanner;
import java.util.Arrays;

public class main {
	public static int findIndexInt(String arr[], String t){
		for (int i = 0; i < arr.length ; i++) {
			if (arr[i].equalsIgnoreCase(t)) {
				return i;
			}
			}
		return -1;
	}
	public static void main(String[] args) {
		String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int[] temp = {33, 35, 43, 50, 59, 70, 75, 73, 65, 52, 41, 32};
		Scanner scnr = new Scanner(System.in);
		int i = 0;
		double annualAverage = 0; 
		while (true){
		System.out.print("Type month or year to view temperature data: ");
        String userInput = scnr.nextLine().toLowerCase();
        
        if (userInput.equals("month")){
        	System.out.println("What month would you like to view?");
        	String monthChoice = scnr.nextLine().toLowerCase();
        	i = findIndexInt(month, monthChoice);
        		if(i!= -1) {
        			System.out.println(month[i] + " had an average temperature of " + temp[i] + " degrees farenheit.");
        			System.out.println("Source: https://weatherspark.com/y/3709/Average-Weather-in-Denver-Colorado-United-States-Year-Round");
        			System.out.println();
        			// findIndex function
        		}
        		else {
        			System.out.println("Try again.");
        		}
        	}
        else if (userInput.equals("year")){
        	for (int m : temp) {
        		annualAverage += m;
        	}
        	annualAverage /= temp.length;
        	System.out.printf("The average temperature for the year 2024 is %.1f degrees Fahrenheit.%n", annualAverage);
        	System.out.println("Source: https://weatherspark.com/y/3709/Average-Weather-in-Denver-Colorado-United-States-Year-Round");
        	System.out.println();
        }
        else {
        	System.out.println("Try again.");
        }
		}
	}

}
