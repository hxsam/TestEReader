package com.sag.ereader.model;

import com.sag.ereader.adapter.BookListAdapter;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;



public class BookListItem {
	
	
	private String title; 
	private String author;
	private Bitmap cover;
	private String filename;
	private BookListAdapter bAdapter;
	
	public BookListItem(String title, String author, String filename){
		this.cover = null;
		this.title = title;
		this.author = author;
		this.filename = filename;
	}

	public Bitmap getCover() {
		return cover;
	}
	public String getFilename(){
		return filename;
	}
	public void setFilename(String filename){
		this.filename = filename;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public BookListAdapter getAdapter() {
        return bAdapter;
    }
	public void setAdapter(BookListAdapter bAdapter) {
	        this.bAdapter = bAdapter;
	    }
	
    
}
