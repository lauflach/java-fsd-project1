package com.example.LockedMe;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileHandler {
	
	private static ArrayList<String> information = new ArrayList<String>();
	
/*	public static void main(String[] args) throws IOException {

		File file = new File("c://temp//testfile1.txt");
		File file2 = new File("testfile1.txt");
		
		scanInfo();
		
		FileWriter writer = new FileWriter(file);
		
		writer.write("This is your information file:\n\n");
		writer.write("Name: " + information.get(0) + "\n");
		writer.write("Address: " + information.get(1) + "\n");
		writer.write("Number: " + information.get(2) + "\n");		
		writer.close();
		
		FileWriter writer2 = new FileWriter(file2);
		writer2.write("Hello World in File!");
		writer2.close();
		
		readFile("testfile1.txt");
		updateFile("testfile1.txt");
		readFile("testfile1.txt");
		
		delete("testfile1.txt");
}*/
	public static void createFile() throws IOException {
		
		ArrayList<String> information = scanInfo();
		String fileName = information.get(0);
		
		File file = new File(fileName);
		FileWriter writer = new FileWriter(fileName);
		
		if(file.createNewFile()) {
			System.out.println("File is Created.");
			
			System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
			System.out.println("File Content:\n");
			System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
	
			writer.write("This is your LockedMe file:\n\n");
			writer.write("Name: " + information.get(0) + "\n");
			writer.write("Lock Number: " + information.get(1) + "\n");
			writer.close();
			
			System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
			System.out.println("Write in File completed! File Name: " + fileName);
			System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
			
		} else {
			System.out.println("File already Exists.");
		}
	}
	
	public static ArrayList<String> scanInfo() {
		
		ArrayList<String> information = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		String aux = "";
		System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		System.out.println("Provide information for the file:\n");
		System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		
		System.out.println("Please type your full name:");
		aux = s.nextLine();
		information.add(aux);
		
		System.out.println("Please type your locker number:");
		aux = s.nextLine();
		information.add(aux);
			
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("\nThank you! We are saving your information file\n");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		
		s.close();
		
		return information;
	}
	
	public static void readFile() {
		List<String> lines = Collections.emptyList();
		
		Scanner s = new Scanner(System.in);
		System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		System.out.println("Search file\n");
		System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		
		System.out.println("Please type your search criteria:");
		s.nextLine();
		
		try {
			//lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
			System.out.println("Lines=" + lines.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void delete() {
		Scanner s = new Scanner(System.in);
				
		System.out.println("Please type the file name to be deleted (without file extension):");
		String file = s.nextLine()+".txt";
		
		try {
			Files.deleteIfExists(Paths.get(file));
		} catch (NoSuchFileException e) {
			System.out.println("No such file/directory exists");
		} catch (DirectoryNotEmptyException e) {
			System.out.println("Directory is not empty");
		} catch (IOException e) {
			System.out.println("Invalid Permissions");
		}		
		System.out.println("Deletion completed successfull.");
		
		s.close();
	}

}