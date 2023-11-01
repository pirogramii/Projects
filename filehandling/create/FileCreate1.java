package com.jspiders.filehandling.create;

import java.io.File;
import java.io.IOException;

public class FileCreate1 {

	public static void main(String[] args) {
		
		File file = new File("wejm5.txt");
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
