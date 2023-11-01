package com.jspiders.musicplayerjdbc.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.jspiders.musicplayerjdbc.operation.Operations;

public class MusicPlayer {
	
	static Scanner sc = new Scanner(System.in);
	
	private static void musicPlayer() throws SQLException {
		System.out.println("======MENU======");
		System.out.println("1. Play A Song");
		System.out.println("2. Add/Remove Song");
		System.out.println("3. Edit Song");
		System.out.println("4. Exit");
		
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			songPlay();
			int play = sc.nextInt();
			switch(play) {
			case 1:
				so.playAll();
				musicPlayer();
				break;
			case 2:
				so.playRandom();
				musicPlayer();
				break;
			case 3:
				so.chooseSong();
				musicPlayer();
				break;
			case 4:
				musicPlayer();
				break;
			default:
				System.out.println("Enter Valid Action");
				musicPlayer();
				break;
			}
			break;
		case 2:
			addOrRemove();
			int song = sc.nextInt();
			switch(song) {
			case 1:
				so.addSong();
				musicPlayer();
				break;
				
			case 2:
				so.removeSong();
				musicPlayer();
				break;
				
			case 3:
				musicPlayer();
				break;
				
			default:
				System.out.println("Enter Valid Action");
				musicPlayer();
				break;
			}
			break;
			
		case 3:
			so.editSong();
			musicPlayer();
			break;
		
		case 4:
			System.out.println("Thank You...!!");
			break;
			
		default:
			System.out.println("Enter Valid Action");
			musicPlayer();
			break;
		}
	}
	 
	private static void songPlay() {
		System.out.println("1. Play All");
		System.out.println("2. Play Random");
		System.out.println("3. Choose To Play");
		System.out.println("4. Go Back");
	}
	
	private static void addOrRemove() {
		System.out.println("1. Add Song");
		System.out.println("2. Remove Song");
		System.out.println("3. Go Back");
	}
	
	static Operations so = new Operations();
	
	
	
	public static void main(String[] args) throws SQLException {
		
		try {
			so.createPlayList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		musicPlayer();	
		
	}

	
}
