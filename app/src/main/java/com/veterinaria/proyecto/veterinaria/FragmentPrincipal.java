package com.veterinaria.proyecto.veterinaria;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

/**
 * Created by Cmoreno on 25/03/2016.
 */
public class FragmentPrincipal extends Fragment {

    private FragmentTabHost mTabHost;

    public FragmentPrincipal(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_principal, container, false);
        /*AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle("");*/
        Resources res = getResources();
       // View rootView = inflater.inflate(R.layout.content_principal, container, false);
        TabHost tabs = (TabHost) rootView.findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("", res.getDrawable(android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("TAB2", res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        //tabs.addTab(mTabHost.newTabSpec("tab3").setIndicator("Tab 3", null),FragmentMascota.class, null);

        tabs.setCurrentTab(0);


        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {
        inflater.inflate(R.menu.menu_principal, menu);
    }


}
