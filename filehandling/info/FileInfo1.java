package com.jspiders.filehandling.info;

import java.io.File;

public class FileInfo1 {

	public static void main(String[] args) {
		
		File file = new File("D:\\FileHandling\\Simple.html");
		
		if(file.exists()) {
			System.out.println("Name of the file: "+file.getName());
			System.out.println("Path of the file: "+file.getAbsolutePath());
			System.out.println("Size of the file: "+file.getUsableSpace());
		}
		else {
			System.out.println("File is not present");
		}
		
		if(file.canExecute()) {
			System.out.println("File is executable");
		}else {
			System.out.println("File is not executable");
		}
		
		if(file.canRead()) {
			System.out.println("File is readable");
		}else {
			System.out.println("File is not readable");
		}
		
		if(file.canWrite()) {
			System.out.println("File is writable");
		}else {
			System.out.println("File is not writable");
		}
		

	}
}
