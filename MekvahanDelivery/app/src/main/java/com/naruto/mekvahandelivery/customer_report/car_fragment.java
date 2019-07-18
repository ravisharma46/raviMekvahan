package com.naruto.mekvahandelivery.customer_report;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.naruto.mekvahandelivery.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link car_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link car_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class car_fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_fragment, container, false);
    }


}
