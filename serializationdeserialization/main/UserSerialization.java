package com.jspiders.serializationdeserialization.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.jspiders.serializationdeserialization.user.User;

public class UserSerialization {

	public static void main(String[] args) throws IOException {
		
		File file = new File("User.txt");
		
		if(file.exists()) {
			System.out.println("File already exists..");
		}else {
			try {
				file.createNewFile();
				System.out.println("File created successfully..");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		User user = new User();
		user.setId(1);
		user.setName("Miller");
		user.setUserName("Miller_xyz");
		user.setPassword("nopassword");
		
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(user);
		System.out.println("Object written successfully..");
		objectOutputStream.close();
	}
}
