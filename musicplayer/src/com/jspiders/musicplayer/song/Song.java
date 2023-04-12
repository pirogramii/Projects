package com.jspiders.musicplayer.song;

import java.util.ArrayList;

public class Song {
	
	private ArrayList pl = new ArrayList();
	private int songId ;
	private String songName ; 
	private String singer ;
	private double duration ;
	
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	public ArrayList getPl() {
		return pl;
	}
	
	public void setPl(Object o) {
		pl.add(o);
	}
	
	public Song(){
		
	}
	public Song(int songId, String songName, String singer, double duration) {
		
		this.songId = songId;
		this.songName = songName;
		this.singer = singer;
		this.duration = duration;
	}
	
	public String toString() {
		return "SongID: "+songId+" SongName :"+songName+" SingerName :"+singer+" Duration: "+duration ;
	}
}
