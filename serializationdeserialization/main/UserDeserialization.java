package com.jspiders.serializationdeserialization.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.jspiders.serializationdeserialization.user.User;

public class UserDeserialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		File file = new File("User.txt");
		
		if(file.exists()) {
			
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			System.out.println("Trying to read object from the file..");
			User user = (User) objectInputStream.readObject();
			System.out.println(user);
			objectInputStream.close();
		}else {
			System.out.println("File does not exists..");
		}

	}

}
