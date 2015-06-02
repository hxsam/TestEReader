package com.sag.ereader;

import java.io.IOException;



import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sag.ereader.adapter.ExtendedSimpleAdapter;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.epub.EpubReader;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentTestMyShelfScreen extends ListFragment {
	public FragmentTestMyShelfScreen(){
		
		Log.e("enter here", "enter at FragmentTestMyShelfScreen constructor");
	}
	
	//EpubFilter ep = new EpubFilter();
	
	private String[] books;
	//private List<String> bookLists;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		
		/*AssetManager aMgr = getResources().getAssets();

		try {
			books = aMgr.list("epub");
			for (String fileName : books) {
			      if (fileName.endsWith(".epub")){
			    	  Log.e("enter here", fileName.toString());
			       }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		List<HashMap<String, Object>> aList = new ArrayList<HashMap<String, Object>>();
		aList = getBookCoverNameAuthor();
		ExtendedSimpleAdapter adapter = new ExtendedSimpleAdapter(getActivity().getBaseContext(), aList, R.layout.fragment_myshelf_screen,new String[]{"bookCover","bookFileName","bookName","bookAuthor"}, new int[]{R.id.bookCover,R.id.bookFileName,R.id.bookName,R.id.bookAuthor});
        /** Creating an array adapter to store the list of countries **//*
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1,books);
        if(books == null || books.length == 0)
            Toast.makeText(getActivity(), "You still don't have any books", Toast.LENGTH_SHORT).show();
        *//** Setting the list adapter for the ListFragment */
        setListAdapter(adapter);
 
        return super.onCreateView(inflater, container, savedInstanceState);
    }
	
	@Override
	public void onListItemClick(ListView l, View v, int pos, long id) {
	  super.onListItemClick(l, v, pos, id);
	  if(v!=null){
		  Intent intent = new Intent(getActivity().getApplicationContext(), BookViewActivity.class);
		  
		 
		 
		  String chosen_book = ((TextView) v.findViewById(R.id.bookFileName)).getText().toString();
		  
		  //String book_name=(String)l.getItemAtPosition(pos);
		  Log.e("epub reader selected_book: ", chosen_book);
		  intent.putExtra("chosen_book",chosen_book);
		  startActivity(intent);
	  }
	  
	  
	
	}
	
	
	
public List<HashMap<String, Object>> getBookCoverNameAuthor(){
		
		List<HashMap<String, Object>> bookList = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map;
		//list all books from assets/epub folder
		AssetManager assetManager = getResources().getAssets();

		try {
			
			books = assetManager.list("epub");
			
			
			for(String book:books){
				
				Log.e("book file name: ", book);
				
				//get book name and author detail for each book
				 try {
					  
				      // find InputStream for book
					  map = new HashMap<String, Object>();
				      InputStream epubInputStream = assetManager.open("epub/"+book);

				      // Load Book from inputStream
				      Book each_book = (new EpubReader()).readEpub(epubInputStream);
				      
				      String book_title = each_book.getTitle();
				      String book_author = TextUtils.join(" ", each_book.getMetadata().getAuthors());
				      Bitmap book_cover = BitmapFactory.decodeStream(each_book.getCoverImage().getInputStream());
				      map.put("bookCover", book_cover);
				      map.put("bookFileName",book);
				      map.put("bookName",book_title);
				      Log.e("book title name: ", book_title);
				      map.put("bookAuthor",book_author);
				      
				      Log.e("book author's name: ", book_author);
				      bookList.add(map);
				      
				 }
				 catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 }
				
			}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return bookList;
	}	
	
}
