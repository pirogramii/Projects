
package com.jspiders.musicplayer.operations;

import java.util.ArrayList;

import java.util.Scanner;

import com.jspiders.musicplayer.song.Song;

public class SongOperations {
	
	static Scanner sc = new Scanner(System.in);
	
	Song song1 = new Song(1,"Tum Hi Ho","Arijit Singh",4.50);
	Song song2 = new Song(2,"Pehli Najar Me","Atif Aslam",3.44);
	Song song3 = new Song(3,"Lag Ja Gale","Lata Mangeshkar",7.22);
	Song song4 = new Song(4,"Beetein Lamhe","KK",5.30);
	Song song5 = new Song(5,"Mere Sapno Ki Raani","Kishore Kumar",6.10);
	Song song6 = new Song(6,"Chura Ke Dil Mera","Kumar Sanu",6.35);
	Song song7 = new Song(7,"Apna Bana Le","Arijit Singh",3.40);
	Song song8 = new Song(8,"Jeena Jeena","Atif Aslam",4.51);
	Song song9 = new Song(9,"SaudeBaaji","Javed Ali",5.23);
	Song song10 = new Song(10,"Tu Aake Dekhle","KING",3.50);
	
	ArrayList<Song> playList = new ArrayList<Song>();
	
	public void createPlayList() {
		playList.add(song1);
		playList.add(song2);
		playList.add(song3);
		playList.add(song4);
		playList.add(song5);
		playList.add(song6);
		playList.add(song7);
		playList.add(song8);
		playList.add(song9);
		playList.add(song10);
	}
	
	public void playAll() {
		for(Song s : playList) {
			System.out.println(s.getSongName()+" is now playing..");
		}
	}
	
	public void playRandom() {
		double doubleNumber = Math.random()*10;
		int randomNumber = (int)doubleNumber;
		for(Song s : playList) {
			int id = s.getSongId();
			if(randomNumber == id) {
				System.out.println(s.getSongName()+" is now playing..");
			}
		}
	}
	
	public void chooseSong() {
		for(Song s : playList) {
			System.out.println(s);
		}
		System.out.println("\nChoose Any Favourite..!!");
		int choice = sc.nextInt();
		for(Song s : playList) {
			if(choice == s.getSongId()) {
				System.out.println(s.getSongName()+" is now playing...");
			}
		}
	}
	
	public void addSong() {
		System.out.print("Enter Song Id :");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("\nEnter Song Name :");
		String song = sc.nextLine();
		
		System.out.print("\nEnter Singer Name :");
		String singer = sc.nextLine();
		System.out.print("\nEnter Duration :");
		double duration = sc.nextDouble();
		Song newSong = new Song(id,song,singer,duration);
		playList.add(newSong);
		System.out.println("Song added successfully...!!");
	}
	
	public void removeSong() {
		for(Song s : playList) {
			System.out.println(s);
		}
		
		System.out.print("Enter Song Id to remove song :");
		int remove = sc.nextInt();
		
		try {
			for(Song s : playList) {
				int id = s.getSongId();
				if(id == remove) {
					playList.remove(remove - 1);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Remove Song..!!");
	}
	
	public void editSong() {
		
		for(Song s : playList) {
			System.out.println(s);
		}
		
		System.out.print("Enter Song Id to Edit Song :");
		int edit = sc.nextInt();
		
		boolean flag = false ;

		for(Song s : playList) {
			
			int id = s.getSongId();
			
			if(id == edit) {
				
				System.out.println("What You Want to Edit \n1 .Song Name \n2. Singer Name \n3. Both Song and Singer Name");
				int choice = sc.nextInt();
				
				switch (choice) {
				
				case 1:
					System.out.println("Enter New Song Name :");
					sc.nextLine();
					String songName = sc.nextLine();
					s.setSongName(songName);
					break;
					
				case 2:
					System.out.println("Enter New Singer Name :");
					sc.nextLine();
					String singerName = sc.nextLine();
					s.setSinger(singerName);
					break;
					
				case 3:
					System.out.println("Enter New Song Name :");
					sc.nextLine();
					String songName1 = sc.nextLine();
					s.setSongName(songName1);
			
					System.out.println("Enter New Singer Name :");
					//sc.nextLine();
					String singerName1 = sc.nextLine();
					s.setSinger(singerName1);
					break;
					
				default:
					System.out.println("Enter Valid Option..!!");
					break;
				}
				flag = true ;
			}
		}
		if(flag) {
			System.out.println("Updated Successfully..!!");
		}else {
			System.out.println("Enter Valid Song Id");
		}
	}
}
		

