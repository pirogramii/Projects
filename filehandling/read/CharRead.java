package com.jspiders.filehandling.read;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CharRead {

	public static void main(String[] args) {
		
		File file = new File("Char.txt");
		
		if(file.exists()) {
			try {
				FileReader fileReader = new FileReader(file);
				System.out.println(fileReader.read());
				fileReader.close();
				
				Scanner obj = new Scanner(file);
				while(obj.hasNextLine()) {
					System.out.println(obj.nextLine());
				}
				obj.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("File not found..");
			} catch (IOException e) {
				System.out.println("File is not readable..");
			}
		}else {
			System.out.println("File is not present..");
		}
	}
}
