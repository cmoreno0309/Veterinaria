package com.veterinaria.proyecto.veterinaria;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by iMessi on 22/04/16.
 */
public class FragmentSalir extends Fragment {

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("FragmentSalir", "FragmentSalir");
        pref = this.getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        editor= pref.edit();
        editor.clear();
        editor.commit();
    }

}
