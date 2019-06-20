package com.example.atulc.red;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.atulc.blackspot_sih.R;
import com.google.android.gms.vision.text.Line;

public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_layout,container,false);

        LinearLayout findDonor_home = view.findViewById(R.id.find_donor_btn_home);
        findDonor_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment  = new FindDonorFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.profile_frameLayout,fragment)
                        .addToBackStack(null)
                        .commit();

            }
        });

        LinearLayout requestDonor_home = view.findViewById(R.id.request_for_donor_btn_home);
        requestDonor_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment  = new RequestDonotFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.profile_frameLayout,fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        ImageView home_search_fragment = view.findViewById(R.id.home_search_fragment);
        home_search_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment  = new FindDonorFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.profile_frameLayout,fragment)
                        .addToBackStack(null)
                        .commit();

            }
        });


        return view;
    }
}
