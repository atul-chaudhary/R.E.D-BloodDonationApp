package com.example.atulc.red;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.atulc.blackspot_sih.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.adapters.FastItemAdapter;

import java.util.ArrayList;

public class RequestDonotFragment extends Fragment {

    ArrayList<String> mRNames;
    ArrayList<String> mRImages;
    ArrayList<String> RbloodTypes;
    ArrayList<String> mRNumber;
    ArrayList<String> mRLocation;
    FastItemAdapter<FastAdapterRequestDonor> mRFastAdapter;
    private RecyclerView RrecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.request_donor_fragment,container,false);

        mRFastAdapter = new FastItemAdapter<FastAdapterRequestDonor>();
        RrecyclerView = (RecyclerView) view.findViewById(R.id.request_donor_recyclerView);

        mRNames = new ArrayList<>();
        mRImages = new ArrayList<>();
        RbloodTypes = new ArrayList<>();
        mRNumber = new ArrayList<>();
        mRLocation = new ArrayList<>();

        mRNames.add("robin das");
        mRImages.add("https://i.pinimg.com/originals/05/18/fd/0518fd79519a81022779e0764485b106.jpg");
        RbloodTypes.add("A-");
        mRNumber.add("9756516904");
        mRLocation.add("meerut");

        mRNames.add("smarth singh");
        mRImages.add("https://cdn.dribbble.com/users/1649532/screenshots/4502767/self_portrait.jpg");
        RbloodTypes.add("AB-");
        mRNumber.add("1234567890");
        mRLocation.add("gaziabad");

        mRNames.add("simmy jain");
        mRImages.add("https://i.pinimg.com/originals/05/18/fd/0518fd79519a81022779e0764485b106.jpg");
        RbloodTypes.add("B-");
        mRNumber.add("9837359582");
        mRLocation.add("delhi");

        mRNames.add("aditya chauhan");
        mRImages.add("https://cdn.dribbble.com/users/722453/screenshots/5661801/portrait-01.png");
        RbloodTypes.add("O+");
        mRNumber.add("8465617994");
        mRLocation.add("delhi");


        mRNames.add("sarthak rathi");
        mRImages.add("https://i.pinimg.com/originals/05/18/fd/0518fd79519a81022779e0764485b106.jpg");
        RbloodTypes.add("O-");
        mRNumber.add("9564935496");
        mRLocation.add("meerut");


        mRNames.add("rishab dhama");
        mRImages.add("https://i.pinimg.com/originals/c9/f8/29/c9f8293f4da7ce8daa03896bb28ffeb7.jpg");
        RbloodTypes.add("A+");
        mRNumber.add("97569494944");
        mRLocation.add("meerut");

        mRNames.add("divyank singh");
        mRImages.add("https://cdn.dribbble.com/users/512961/screenshots/3686203/face3_r.png");
        RbloodTypes.add("A+");
        mRNumber.add("97569494");
        mRLocation.add("meerut");


        mRNames.add("shivam tomar");
        mRImages.add("https://cdn.dribbble.com/users/2364329/screenshots/4808446/dribbble-19.jpg");
        RbloodTypes.add("B-");
        mRNumber.add("979494944");
        mRLocation.add("delhi");

        mRNames.add("delhi");
        mRImages.add("https://i.pinimg.com/originals/c9/f8/29/c9f8293f4da7ce8daa03896bb28ffeb7.jpg");
        RbloodTypes.add("A+");
        mRNumber.add("97569494944");
        mRLocation.add("meerut");

        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        //Log.e("atulLOG", "rec>> " + recyclerView + lm);
        RrecyclerView.setLayoutManager(lm);
        RrecyclerView.setAdapter(mRFastAdapter);
        RrecyclerView.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < mRNames.size(); i++) {
                    FastAdapterRequestDonor mObj2 = new FastAdapterRequestDonor();
                    mObj2.setUserProfile_(mRImages.get(i));
                    mObj2.setUserName_(mRNames.get(i));
                    mObj2.setUserBloodType_(RbloodTypes.get(i));
                    mObj2.setUserNumber_(mRNumber.get(i));
                    mObj2.setUserlocation_(mRLocation.get(i));
                    mRFastAdapter.add(mObj2);
                }
            }
        });

        mRFastAdapter.withSelectable(true);
        mRFastAdapter.withOnClickListener(new FastAdapter.OnClickListener<FastAdapterRequestDonor>() {
            @Override
            public boolean onClick(View v, IAdapter<FastAdapterRequestDonor> adapter, FastAdapterRequestDonor item, int position) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0987654321"));
                startActivity(intent);

                return false;
            }
        });

        LinearLayout request_donor_btn_ = (LinearLayout)view.findViewById(R.id.request_donor_btn_);
        request_donor_btn_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment registrationFragment = new RegisterFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.profile_frameLayout,registrationFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        return view;
    }
}
