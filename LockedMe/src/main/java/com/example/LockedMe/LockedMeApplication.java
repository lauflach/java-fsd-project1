package com.example.LockedMe;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.spel.ast.OperatorBetween;

@SpringBootApplication
public class LockedMeApplication {
	private static FileHandler fh = new FileHandler();

	public static void main(String[] args) throws IOException {
		printWelcomeScreen();
	}
	
	public static void printWelcomeScreen () throws IOException {
		Scanner s = new Scanner(System.in);

		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("Welcome to LockedMe.com Prototype");
		System.out.println("Developer Name: Laura Flach");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");		
		System.out.println("Please type the numer of desired option to continue:");	
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("0 - Exit");
		System.out.println("1 - Return All Client Files Name List");
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
						fh.printOrderedFiles();
						break;
					case 2 :
						printFileMenu();
						break;
					default :
						System.out.println("\n\nOption Invalid!!!!!\n");
						System.out.println("Please type the numer of desired option to continue:");	
						System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
						System.out.println("0 - Exit");
						System.out.println("1 - Return All Client Files Name List");
						System.out.println("2 - File Options Menu");
						System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
						break;
					}
				}
			}
			else {
				System.out.println("\n\nOption Invalid!!!!!\n");
				System.out.println("Please type the numer of desired option to continue:");	
				System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
				System.out.println("0 - Exit");
				System.out.println("1 - Return All Client Files Name List");
				System.out.println("2 - File Options Menu");
				System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
				s.next();
			}
		}
	}
	
	public static void printFileMenu() throws IOException {
		Scanner s = new Scanner(System.in);

		System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("File Options Menu");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");		
		System.out.println("Please type the numer of desired option to continue:");	
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("0 - Return to Main Menu");
		System.out.println("1 - Add File");
		System.out.println("2 - Search File");
		System.out.println("3 - Delete File");
		System.out.println("4 - Update Your Current Locker");
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
						fh.createFile();
						break;
					case 2 :
						fh.searchFile();
						break;
					case 3 :
						fh.delete();
						break;
					case 4 :
						
						break;
					default :
						System.out.println("\n\nOption Invalid!!!!!\n");
						System.out.println("Please type the numer of desired option to continue:");	
						System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
						System.out.println("0 - Return to Main Menu");
						System.out.println("1 - Add File");
						System.out.println("2 - Search File");
						System.out.println("3 - Delete File");
						System.out.println("4 - Update Your Current Locker");
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
				System.out.println("4 - Update Your Current Locker");
				System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
				s.next();
			}
		}
	}
}
