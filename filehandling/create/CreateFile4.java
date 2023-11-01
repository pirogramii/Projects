package com.jspiders.filehandling.create;

import java.io.File;
import java.io.IOException;

public class CreateFile4 {

	public static void main(String[] args) {
		
		File file1 = new File("D:\\FileHandling\\Simple.txt");
		File file2 = new File("D:\\FileHandling\\Simple.java");
		File file3 = new File("D:\\FileHandling\\Simple.html");
		File file4 = new File("D:\\FileHandling\\Simple.cpp");
		File file5 = new File("D:\\FileHandling\\Simple.js");
		
		File arr[] = new File[5];
		 arr[0] = file1;
		 arr[1] = file2;
		 arr[2] = file3;
		 arr[3] = file4;
		 arr[4] = file5;

		 for(int i = 0 ; i < 5 ; i++) {
			 try {
				arr[i].createNewFile();
				System.out.println(arr[i]+" file is created..");
			} catch (IOException e) {
				System.out.println("File is not created..!!");
			}
		 }
	}

}