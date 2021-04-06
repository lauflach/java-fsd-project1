package com.example.LockedMe;

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
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecordKeeper {
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			writeFile("RecordKeeperTest.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InformationCustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		readFile("RecordKeeperTest.txt");
		updateFile("RecordKeeperTest.txt", "Laura", "Amanda");
		readFile("RecordKeeperTest.txt");
		
		delete("RecordKeeperTest.txt");

	}
	
	public static ArrayList<String> scanInfo() throws InformationCustomException {
		
		ArrayList<String> information = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		String aux = "";
		boolean validEmail = false;
		boolean validPhone = false;
		
		System.out.println("Please type your name:");
		aux = s.nextLine();
		information.add(aux);
		
		System.out.println("Please type your address:");
		aux = s.nextLine();
		information.add(aux);
		
		while (!validPhone) { 
			System.out.println("Please type your mobile number:");
			aux = s.nextLine();
			validPhone = validateMobile(aux);
			if(validPhone)
				information.add(aux);
		}
		
		while (!validEmail) {
			System.out.println("Please type your email address:");
			aux = s.nextLine();
			validEmail = validateEmail(aux);
			if(validEmail)
				information.add(aux);
		}
		
		System.out.println("\nThank you! We are updating your information file\n");
		
		return information;
	}
	
	public static boolean validateEmail(String email) throws InformationCustomException {

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        boolean isValid = matcher.find();

        try {
			//If the email is NOT valid
			if (!isValid)
				throw new InformationCustomException("Your Email Format is Incorrect!! It should be: *****@****.***");
		} catch (InformationCustomException e) {
			System.out.println(e.getErrorCode());
		}
        
        return isValid;
	}
	
	public static boolean validateMobile(String mobile) throws InformationCustomException {
		
		Pattern pattern = Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{2}\\))|\\d{2})[-.]?\\d{9}$");
		Matcher matcher = pattern.matcher(mobile);
		boolean isValid = matcher.matches();

		try {
			if(!isValid)
				throw new InformationCustomException("Your Mobile Number Format is Incorrect!! It should be: +99(99)999999999");

		} catch (InformationCustomException e) {
			System.out.println(e.getErrorCode());
		}
		
		return isValid;
	}
	
	public static File createFile(String fileName) {
		File file = new File(fileName);
		
		try {
			if(file.createNewFile()) {
				System.out.println("File is Created.");
			} else {
				System.out.println("File already Exists.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return file;
	}
	
	public static void writeFile(String fileName) throws IOException, InformationCustomException {
		FileWriter writer = new FileWriter(fileName);
		ArrayList<String> information = scanInfo();
		
		writer.write("This is your information file:\n\n");
		writer.write("Name: " + information.get(0) + "\n");
		writer.write("Address: " + information.get(1) + "\n");
		writer.write("Mobile Number: " + information.get(2) + "\n");
		writer.write("Email: " + information.get(3) + "\n");	
		writer.close();
		
		System.out.println("Write in File completed! File Name: " + fileName);
	}
	
	public static void readFile(String fileName) {
		// Read
		List<String> lines = Collections.emptyList();
		
		try {
			lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
			System.out.println("Lines=" + lines.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateFile(String fileName, String toReplace, String replacement) {
		File fileToBeModified = new File(fileName);
		String oldContent = "";
		BufferedReader reader = null;
		FileWriter writer2 = null;
		
		try {
			reader = new BufferedReader(new FileReader(fileToBeModified));
			String line = reader.readLine();
			//System.out.println("Line = " + line);
			while (line != null) {
				oldContent = oldContent + line + System.lineSeparator();
				//System.out.println("Old Content = " + oldContent);
				line = reader.readLine();
				//System.out.println("Line = " + line);
			}
			
			String newContent = oldContent.replaceAll(toReplace, replacement);
			System.out.println("New Content = \n" + newContent);
			writer2 = new FileWriter(fileToBeModified);
			writer2.write(newContent);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				writer2.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		System.out.println("File Update Complete! File Name: " + fileName);
	}
	
	public static void delete(String fileName) {
		try {
			Files.deleteIfExists(Paths.get(fileName));
		} catch (NoSuchFileException e) {
			System.out.println("No such file/directory exists");
		} catch (DirectoryNotEmptyException e) {
			System.out.println("Directory is not empty");
		} catch (IOException e) {
			System.out.println("Invalid Permissions");
		}
		
		System.out.println("Deletion completed successfull. File Name: " + fileName);
	}

}
