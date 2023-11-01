package com.jspiders.musicplayerjdbc.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.jspiders.musicplayerjdbc.song.Song;

public class Operations {
	
	private static Connection connection ;
	private static Statement statement ;
	private static PreparedStatement preparedStatement ;
	private static String query ;
	private static int result ;
	private static ResultSet resultSet ;
	
	static Scanner sc = new Scanner(System.in);
	
	public void openConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicplayer?user=root&password=root");
		statement = connection.createStatement();
		
	}
	
	public void closeConnection() throws SQLException {
		
		connection.close();
		statement.close();
	}
	
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
	
	public void createPlayList() throws ClassNotFoundException, SQLException {
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
		
		openConnection();
		result = 0 ;
		query = "insert into album values(?,?,?,?)";
		preparedStatement = connection.prepareStatement(query);
		
		for(Song s : playList) {
			preparedStatement.setInt(1, s.getSongId());
			preparedStatement.setString(2, s.getSongName());
			preparedStatement.setString(3, s.getSinger());
			preparedStatement.setDouble(4, s.getDuration());
			result = result + preparedStatement.executeUpdate();
		}
		
		
	}
	
	public void playAll() throws SQLException {
		query = "select * from album";
		resultSet = statement.executeQuery(query);
		while(resultSet.next()) {
			System.out.println(resultSet.getString(2) + " is now playing..");
		}
	}
	
	public void playRandom() throws SQLException {
		double doubleNumber = Math.random()*10;
		int randomNumber = (int)doubleNumber;
		query = "select * from album";
		resultSet = statement.executeQuery(query);
		while(resultSet.next()) {
			if(randomNumber == resultSet.getInt(1)) {
				System.out.println(resultSet.getString(2)+" is now playing");
			}
		}
		
	}
	
	public void chooseSong() throws SQLException {
		
		query = "select * from album";
		resultSet = statement.executeQuery(query);
		
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2));
		}
		
		System.out.println("\nChoose Any Favourite..!!");
		int choice = sc.nextInt();
		
		query = "select * from album";
		resultSet = statement.executeQuery(query);
		
		while(resultSet.next()) {
			if(choice == resultSet.getInt(1)) {
				System.out.println(resultSet.getString(2)+" is now playing");
			}
		}
	}
	
	public void addSong() throws SQLException {
		
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
		query = "insert into album values(?,?,?,?)";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, song);
		preparedStatement.setString(3, singer);
		preparedStatement.setDouble(4, duration);
		result = result + preparedStatement.executeUpdate();
		
		System.out.println("Song added successfully...!!");
	}
	
	public void removeSong() throws SQLException {
		
		query = "select * from album";
		resultSet = statement.executeQuery(query);
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2));
		}
		System.out.print("Enter Song Id to remove song :");
		int remove = sc.nextInt();
		
		query = "delete from album where id = "+remove ;
		statement.execute(query);
		System.out.println("Remove Song..!!");
	}
	
	public void editSong() throws SQLException {
		
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
					query = "update album set s_name = '"+songName+"' where id ="+id;
					statement.execute(query);
					break;
					
				case 2:
					System.out.println("Enter New Singer Name :");
					sc.nextLine();
					String singerName = sc.nextLine();
					s.setSinger(singerName);
					query = "update album set s_name = '"+singerName+"' where id ="+id;
					statement.execute(query);
					break;
					
				case 3:
					System.out.println("Enter New Song Name :");
					sc.nextLine();
					String songName1 = sc.nextLine();
					s.setSongName(songName1);
					query = "update album set s_name = '"+songName1+"' where id ="+id;
					statement.execute(query);
			
					System.out.println("Enter New Singer Name :");
					//sc.nextLine();
					String singerName1 = sc.nextLine();
					s.setSinger(singerName1);
					query = "update album set s_name = '"+singerName1+"' where id ="+id;
					statement.execute(query);
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
		closeConnection();
	}
	
}
		