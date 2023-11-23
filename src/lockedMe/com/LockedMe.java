package lockedMe.com;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe {
	public static final String FILES_PATH = "D:\\Kavin\\SimpliLearn-Phase1-Project\\Files";
public static void welcomeScreen()
{
	System.out.println("\n***************************************************");
	System.out.println("\tWelcome to LockedMe.com secure App");
	System.out.println("\tDeveloped by: KAVIN K R");
	System.out.println("***************************************************");
	System.out.println("\n\nENTER YOUR CHOICE:");
	System.out.println("\n1. Display all files");
	System.out.println("2. Create a new file");
	System.out.println("3. Delete a file");
	System.out.println("4. Search a file");
	System.out.println("5. Exit");
}
public static void getAllFiles() 
{
	File folder = new File(FILES_PATH);
	File[] listOfFiles = folder.listFiles();
	if(listOfFiles.length>0) {
		System.out.println("The file list is displayed below:");
		for(var a:listOfFiles) {
		System.out.println(a.getName());
	}
	}
	else {
		System.out.println("\n------------------The Folder is empty!!------------------");
	}
}
public static void createNewFiles(){
	try {
		Scanner sc = new Scanner (System.in);
		String filename;
		System.out.println("Enter the file name to be created:");
		filename = sc.nextLine();
		int linescount;
		System.out.println("Enter the number of line to be written:");
		linescount =Integer.parseInt(sc.nextLine());
		
		FileWriter fw = new FileWriter(FILES_PATH+"\\"+filename);
		for(int i=0;i<linescount;i++) {
			System.out.println("Enter the content to be written in the file");
			fw.write(sc.nextLine()+ "\n");
		}
		System.out.println("Content written successfully!!");
		fw.close();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
}
public static void deleteFile() {
	try 
	{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the filename to be deleted:");
	String filename = sc.nextLine();
	File f = new File(FILES_PATH+"\\"+filename);
	if(f.exists()) {
		f.delete();
		System.out.println("File deleted Successfully!!");
	}
	else {
		System.out.println("File does not exists!!");
	}
	}
	catch(Exception e) {
		
	}
}
public static void searchFile() {
	try
	{
		LinkedList<String> filenames = new LinkedList<String>();
		Scanner obj= new Scanner(System.in);
		String filename;
		System.out.println("Enter the file to be searched for:");
		filename=obj.nextLine();
		File[] listOfFiles = new File(FILES_PATH).listFiles();
		for(File f:listOfFiles) {
			filenames.add(f.getName());
		}
		if(filenames.contains(filename)) {
			System.out.println("The file is available!!!");
		}
		else {
			System.out.println("The file is not available!!!");
		}
		
	}
	catch(Exception e)
	{
		
	}
}
}
