package com.jspiders.filehandling.delete;

import java.io.File;

public class DeleteFile1 {

	public static void main(String[] args) {
		
		File file = new File("D:\\FileHandling\\Simple.c");
		
		if(file.exists()) {
			file.delete();
			System.out.println("File is deleted..");
		}else {
			System.out.println("File is not present..");
		}
	}
}
