package com.sag.ereader;
import com.sag.ereader.R;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class FragmentRecentScreen extends Fragment {
	
	// this Fragment will be called from MainActivity
	public FragmentRecentScreen(){}
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_recent_screen, container, false);
         
        return rootView;
    }

}
