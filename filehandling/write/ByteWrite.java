package com.jspiders.filehandling.write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteWrite {

	public static void main(String[] args) {
		
		File file = new File("Byte.txt");
		
		if(file.exists()) {
			System.out.println("File already present..");
		}else {
			try {
				file.createNewFile();
				System.out.println("File created successfully..");
			} catch (IOException e) {
				System.out.println("File not created..");
			}
		}
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(50);
			fileOutputStream.close();
			System.out.println("Data written to the file..");
		} catch (FileNotFoundException e) {
			System.out.println("File not found..");
		} catch (IOException e) {
			System.out.println("File is not writable..");
		}
	}
}
