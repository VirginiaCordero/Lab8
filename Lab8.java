import java.util.Scanner;

public class Lab8 {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		String[] students = { "Kris", "Darby", "Louis", "Sharde", "Amna", "Jasmine", "Lauren", "Stan" };
		String[] hometown = { "Dexter", "College Station", "Cincinnatti", "Detroit", "Detroit", "Detroit", "Ann Arbor",
				"Holland" };
		String[] favoriteFood = { "Thai food", "Chicken Alfredo", "Wasabi peas", "Japanese food", "Fried Chicken",
				"Cheesecake", "Bananas", "Thai food" };
		
		System.out.println("Welcome to our Java class sample.");					
		
		boolean shouldContinue = true;
		do {			
			System.out.println("Which student would you like to learn more about? <Enter a number from 1-8>:");
			int selection = scnr.nextInt() - 1;
			scnr.nextLine(); // After calling nextInt, we need to call nextLine, so the next time we call nextLine can work
			//To know more about this please read https://stackoverflow.com/questions/23450524/java-scanner-doesnt-wait-for-user-input
			
			try {		
				System.out.println("Student " + (selection + 1) + " is " + students[selection] + ".");
			} catch (ArrayIndexOutOfBoundsException | IllegalArgumentException ex) {			
				System.out.println("That student does not exist. Please try again. Enter a number 1-8 (no spaces, letters or special characters).");
			}
			
			boolean userWantsToKnowMore = true;
			do { 
				System.out.println("What would you like to know about " + students[selection] + "? (enter 'hometown' or 'favorite food')");
				String selection2 = scnr.nextLine(); //This line will only work with the stackoverflow fix
				
				try {				
					if (selection2.equals("hometown")) {
						System.out.println(students[selection] + " is from " + hometown[selection] + ".");
					} else if (selection2.equals("favorite food")) {
						System.out.println(students[selection] + "'s favorite food is " + favoriteFood[selection] + ".");
					}
				} catch (ArrayIndexOutOfBoundsException | IllegalArgumentException ex) {
					System.out.println("That data does not exist. Please try again. Enter 'hometown' or 'favorite food'");
				}
				
				System.out.println("Would you like to know more about " + students[selection] + "?" +  "(enter 'yes' or 'no')");
				String knowMoreAnswer = scnr.nextLine();
				if (!knowMoreAnswer.equals("yes")) {				
					userWantsToKnowMore = false;					
				} 								
			} while(userWantsToKnowMore);
			
			System.out.println("Would you like to know about someone else? " +  "(enter 'yes' or 'no')");
			String continueAnswer = scnr.nextLine();
			if (!continueAnswer.equals("yes")) {				
				shouldContinue = false;
			}							
		}
		while(shouldContinue == true);
		System.out.println("Program ended");
	}		
}
