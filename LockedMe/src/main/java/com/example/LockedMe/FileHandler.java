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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class FileHandler {
	
	private static final String folderPath = "Clients\\";

	public static void createFile() throws IOException {
		
		Scanner s = new Scanner(System.in);
		String newLocker = "";
		String oldLocker = "";
		String fileName;
		String name;
		File file;
			
		System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("Provide information for the file:");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		
		System.out.println("Please type your full name:");
		name = s.nextLine();
		fileName = folderPath + name + ".txt";		
		file = new File(fileName);
		
		System.out.println("Please type your locker number:");
		newLocker = s.nextLine();

		if(file.createNewFile()) {
			FileWriter writer = new FileWriter(fileName);

			writer.write("This is your LockedMe file:\n\n");
			writer.write("Name: " + name + "\n");
			writer.write("Locker Number: " + newLocker + "\n");
			writer.close();
			
			System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
			System.out.println("File Creation Completed! File Name: " + fileName);
			System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
			
		} else {
			System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
			System.out.println("Error: File already Exists.");
			System.out.println("Do you wish to update the current locker? Select:");
			System.out.println("1 - Yes");
			System.out.println("2 - No");
			System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
			
			while(s.hasNext()) {
				if(s.hasNextInt()) {
					while(s.hasNextInt()) {
						int choice = s.nextInt();
						
						switch (choice) {
						case 1 :
							oldLocker = getFileLocker(fileName);
							updateFile(fileName, oldLocker, newLocker);
							LockedMeApplication.printFileMenu();
							break;
						case 2 :
							LockedMeApplication.printFileMenu();
							break;
						default :
							System.out.println("\n\nOption Invalid!!!!!\n");
							System.out.println("Please type the numer of desired option to continue...");	
							System.out.println("Do you wish to update the current locker?");
							System.out.println("1 - Yes");
							System.out.println("2 - No");
							System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
							break;
						}
					}
				}
				else {
					System.out.println("\n\nOption Invalid!!!!!\n");
					System.out.println("Please type the numer of desired option to continue...");	
					System.out.println("Do you wish to update the current locker?");
					System.out.println("1 - Yes");
					System.out.println("2 - No");
					System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
					s.next();
				}
			}
		}

		LockedMeApplication.printFileMenu();		
		s.close();
	}
	
	public static ArrayList<String> scanInfo() {
		
		ArrayList<String> information = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		String aux = "";
		System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("Provide information for the file:");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		
		System.out.println("Please type your full name:");
		aux = s.nextLine();
		information.add(aux);
		
		System.out.println("Please type your locker number:");
		aux = s.nextLine();
		information.add(aux);
			
		System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("Thank you! We are saving your information file");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		
		s.close();
		
		return information;
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
	
	public static void searchFile() throws IOException {		
		
		Scanner s = new Scanner(System.in);
		File file;
		
		System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("Search file");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		
		System.out.println("Please type your full name:");
		String fileName = s.nextLine();
		String ext = ".txt";
		
		if(!fileName.toLowerCase().contains(ext.toLowerCase())) {
			fileName = fileName+ext;
		}
		
		fileName = folderPath+fileName;		
		file = new File(fileName);
		
		if(file.exists()) {
			System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
			System.out.println("File Found...Reading the File content:");
			System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
			readFile(fileName);
		}
		else {
			System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
			System.out.println("Error: File not Found!! Returnig to File Options Menu");
			System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		}
		
		LockedMeApplication.printFileMenu();
		s.close();		
	}
	
	public static void delete() throws IOException {
		Scanner s = new Scanner(System.in);
				
		System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("Please type the file name to be deleted:");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		
		String file = s.nextLine();
		String ext = ".txt";
		
		if(!file.toLowerCase().contains(ext.toLowerCase())) {
			file = file+ext;
		}
						
		try {
			Files.delete(Paths.get(folderPath+file));
			System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
			System.out.println("Deletion completed successfully!!");
			System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		} catch (NoSuchFileException e) {
			System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
			System.out.println("Error: No such file/directory exists");
			System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		} catch (DirectoryNotEmptyException e) {
			System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
			System.out.println("Error: Directory is not empty");
			System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		} catch (IOException e) {
			System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
			System.out.println("Error: Invalid Permissions");
			System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		}
		
		LockedMeApplication.printFileMenu();	
		s.close();
	}
	
	public static void updateFile(String fileName, String toReplace, String replacement) {
		File fileToBeModified = new File(fileName);
		String oldContent = "";
		BufferedReader reader = null;
		FileWriter writer2 = null;
		String line;
		
		System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("Updating your File:");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		System.out.println("Old Locker Number: " + toReplace);
		System.out.println("New Locker Number: " + replacement);
		System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		
		try {
			reader = new BufferedReader(new FileReader(fileToBeModified));
			line = reader.readLine();
			
			while (line != null) {
				oldContent = oldContent + line + System.lineSeparator();
				line = reader.readLine();
			}
			
			String newContent = oldContent.replaceAll(toReplace, replacement);
			System.out.println("New Content = \n\n" + newContent);
			
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
		
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("File Update Complete! File Name: " + fileName);
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
	}
	
	public static String getFileLocker(String fileName) {
		String locker = "";		
		File file = new File(fileName);
		BufferedReader reader = null;
		int index;
		String line;
		
		try {
			reader = new BufferedReader(new FileReader(file));
			line = reader.readLine();
			
			while (!line.toLowerCase().contains("locker")) {
				line = reader.readLine();
			}
			
			index = line.toLowerCase().lastIndexOf(" ");			
			line = line.substring(index+1);
			locker = line;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return locker;
	}
	
	public static void updateFileLocker() throws IOException {
		
		Scanner s = new Scanner(System.in);
		String ext = ".txt";
		String newLocker = "";
		String oldLocker = "";
		String fileName = "";
		File file;
		
		System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
		System.out.println("Update Locker");
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''\n");
		
		System.out.println("Please type your full name:");
		fileName = s.nextLine();
		fileName = folderPath+fileName;
				
		if(!fileName.toLowerCase().contains(ext.toLowerCase())) {
			fileName = fileName+ext;
		}
		
		file = new File(fileName);
		
		System.out.println("Please type your new locker number:");
		newLocker = s.nextLine();
		
		if(file.exists()) {
			oldLocker = getFileLocker(fileName);
			updateFile(fileName, oldLocker, newLocker);
		}
		else {
			System.out.println("\n\nYour name does not exist in our catalog!!!!!");
			System.out.println("Please go to option 1 on the Files Menu to register\n\n");	
		}
		
		LockedMeApplication.printFileMenu();	
		s.close();
	}

	public static void printOrderedFiles() throws IOException {
        File folder = new File("Clients");
        File[] fileList;
        
        if(folder.isDirectory())
        {
            fileList = folder.listFiles();

            System.out.println("\n''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''");           
            System.out.println("Please find below all Client Name Files in Alphabetic order");
            System.out.println("Total number of Client Files: " + fileList.length);
            System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
                    
            Arrays.sort(fileList);
            
            for(File file:fileList)
            {
                System.out.println(file.getName());
            }
            System.out.println("\n");
        }
        
        LockedMeApplication.printWelcomeScreen();
    }
}