package com.example.LockedMe;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.spel.ast.OperatorBetween;

@SpringBootApplication
public class LockedMeApplication {
	private static FileHandler fh = new FileHandler();

	public static void main(String[] args) {
		printWelcomeScreen();
	}
	
	public static void printWelcomeScreen () {
		Scanner s = new Scanner(System.in);

		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("Welcome to LockedMe.com Prototype");
		System.out.println("Developer Name: Laura Flach");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");		
		System.out.println("Please type the numer of desired option to continue:");	
		System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("0 - Exit");
		System.out.println("1 - Return All Current File Names");
		System.out.println("2 - File Options Menu");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		
		while(s.hasNext()) {
			if(s.hasNextInt()) {
				while(s.hasNextInt()) {
					int choice = s.nextInt();
					
					switch (choice) {
					case 0 :
						Runtime.getRuntime().exit(0);
						break;
					case 1 :
						System.out.println("Chegou no 1");
						break;
					case 2 :
						printFileMenu();
						break;
					default :
						System.out.println("\n\nOption Invalid!!!!!\n");
						System.out.println("Please type the numer of desired option to continue:");	
						System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
						System.out.println("0 - Exit");
						System.out.println("1 - Return All Current File Names");
						System.out.println("2 - File Options Menu");
						System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
						break;
					}
				}
			}
			else {
				System.out.println("\n\nOption Invalid!!!!!\n");
				System.out.println("Please type the numer of desired option to continue:");	
				System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
				System.out.println("0 - Exit");
				System.out.println("1 - Return All Current File Names");
				System.out.println("2 - File Options Menu");
				System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
				s.next();
			}
		}
	}
	
	public static void printFileMenu() {
		Scanner s = new Scanner(System.in);

		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("File Options Menu");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");		
		System.out.println("Please type the numer of desired option to continue:");	
		System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("0 - Return to Main Menu");
		System.out.println("1 - Add File");
		System.out.println("2 - Search File");
		System.out.println("3 - Delete File");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		
		while(s.hasNext()) {
			if(s.hasNextInt()) {
				while(s.hasNextInt()) {
					int choice = s.nextInt();
					
					switch (choice) {
					case 0 :
						printWelcomeScreen();
						break;
					case 1 :
						System.out.println("Chegou no Add File");
						break;
					case 2 :
						System.out.println("Chegou no Search File");
						break;
					case 3 :
						fh.delete();
						break;
					default :
						System.out.println("\n\nOption Invalid!!!!!\n");
						System.out.println("Please type the numer of desired option to continue:");	
						System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
						System.out.println("0 - Return to Main Menu");
						System.out.println("1 - Add File");
						System.out.println("2 - Search File");
						System.out.println("3 - Delete File");
						System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
						break;
					}
				}
			}
			else {
				System.out.println("\n\nOption Invalid!!!!!\n");
				System.out.println("Please type the numer of desired option to continue:");	
				System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
				System.out.println("0 - Return to Main Menu");
				System.out.println("1 - Add File");
				System.out.println("2 - Search File");
				System.out.println("3 - Delete File");
				System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
				s.next();
			}
		}
	}
	
	public static <E> void printFile (E[] fleet) {
		System.out.println("########################################################################\n");
		System.out.println("This is the Airplane Current Fleet\n");
		for(E element : fleet) {
			System.out.println(element);
		}
		System.out.println("End of Fleet");
		System.out.println("\n########################################################################");
	}

}
