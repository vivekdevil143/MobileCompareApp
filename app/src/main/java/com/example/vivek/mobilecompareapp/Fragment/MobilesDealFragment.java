package com.example.vivek.mobilecompareapp.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vivek.mobilecompareapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MobilesDealFragment extends Fragment {


    public MobilesDealFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mobiles_deal, container, false);
    }

}
