package com.example.atulc.red;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.atulc.blackspot_sih.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.adapters.FastItemAdapter;

import java.util.ArrayList;

public class FindDonorFragment extends Fragment {

    ArrayList<String> mNames;
    ArrayList<String> mImages;
    ArrayList<String> bloodTypes;
    ArrayList<String> mNumber;
    ArrayList<String> mLocation;
    FastItemAdapter<SampleItem> mFastAdapter;
    private RecyclerView recyclerView;
    private static final String TAG = "FindDonorFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find_donor_fragment,container,false);

        mFastAdapter = new FastItemAdapter<SampleItem>();
        recyclerView = (RecyclerView) view.findViewById(R.id.find_donor_recyclerView);

        mNames = new ArrayList<>();
        mImages = new ArrayList<>();
        bloodTypes = new ArrayList<>();
        mNumber = new ArrayList<>();
        mLocation = new ArrayList<>();


        mNames.add("robin das");
        mImages.add("https://i.pinimg.com/originals/05/18/fd/0518fd79519a81022779e0764485b106.jpg");
        bloodTypes.add("A-");
        mNumber.add("9756516904");
        mLocation.add("meerut");

        mNames.add("smarth singh");
        mImages.add("https://cdn.dribbble.com/users/1649532/screenshots/4502767/self_portrait.jpg");
        bloodTypes.add("AB-");
        mNumber.add("1234567890");
        mLocation.add("gaziabad");

        mNames.add("simmy jain");
        mImages.add("https://i.pinimg.com/originals/05/18/fd/0518fd79519a81022779e0764485b106.jpg");
        bloodTypes.add("B-");
        mNumber.add("9837359582");
        mLocation.add("delhi");

        mNames.add("aditya chauhan");
        mImages.add("https://cdn.dribbble.com/users/722453/screenshots/5661801/portrait-01.png");
        bloodTypes.add("O+");
        mNumber.add("8465617994");
        mLocation.add("delhi");


        mNames.add("sarthak rathi");
        mImages.add("https://i.pinimg.com/originals/05/18/fd/0518fd79519a81022779e0764485b106.jpg");
        bloodTypes.add("O-");
        mNumber.add("9564935496");
        mLocation.add("meerut");


        mNames.add("rishab dhama");
        mImages.add("https://i.pinimg.com/originals/c9/f8/29/c9f8293f4da7ce8daa03896bb28ffeb7.jpg");
        bloodTypes.add("A+");
        mNumber.add("97569494944");
        mLocation.add("meerut");

        mNames.add("divyank singh");
        mImages.add("https://cdn.dribbble.com/users/512961/screenshots/3686203/face3_r.png");
        bloodTypes.add("A+");
        mNumber.add("97569494");
        mLocation.add("meerut");


        mNames.add("shivam tomar");
        mImages.add("https://cdn.dribbble.com/users/2364329/screenshots/4808446/dribbble-19.jpg");
        bloodTypes.add("B-");
        mNumber.add("979494944");
        mLocation.add("delhi");

        mNames.add("delhi");
        mImages.add("https://i.pinimg.com/originals/c9/f8/29/c9f8293f4da7ce8daa03896bb28ffeb7.jpg");
        bloodTypes.add("A+");
        mNumber.add("97569494944");
        mLocation.add("meerut");


        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        Log.e("atulLOG", "rec>> " + recyclerView + lm);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(mFastAdapter);
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < mImages.size(); i++) {
                    SampleItem mObj1 = new SampleItem();
                    mObj1.setUserProfile(mImages.get(i));
                    mObj1.setUserName(mNames.get(i));
                    mObj1.setUserlocation(mLocation.get(i));
                    mObj1.setUserNumber(mNumber.get(i));
                    mObj1.setUserBloodType(bloodTypes.get(i));
                    mFastAdapter.add(mObj1);
                }
            }
        });


        mFastAdapter.withSelectable(true);
        mFastAdapter.withOnClickListener(new FastAdapter.OnClickListener<SampleItem>() {
            @Override
            public boolean onClick(View v, IAdapter<SampleItem> adapter, SampleItem item, int position) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0987654321"));
                startActivity(intent);

                return false;
            }
        });


        final SearchView searchView = view.findViewById(R.id.searchView_for_usersAndAdmin);
        searchView.setIconified(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.e(TAG, "onQueryTextSubmit: >>>" + query);
                //runQuery(query);
                //searchView.clearFocus();
                //animationView.setVisibility(View.VISIBLE);

                // Call this in onQueryTextSubmit() & onQueryTextChange() when using SearchView



                mFastAdapter.filter(query);
                mFastAdapter.withFilterPredicate(new IItemAdapter.Predicate<SampleItem>() {
                    @Override
                    public boolean filter(SampleItem item, CharSequence constraint) {
                        //return true if we should filter it out
                        //return false to keep it
                        return !item.getUserlocation().toLowerCase().contains(constraint.toString().toLowerCase());
                    }
                });



                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

//                mFastAdapter.clear();
//                animationView.setVisibility(View.INVISIBLE);
//                notFound_TextView.setVisibility(View.GONE);
//                animationView.setScaleX(1);
//                animationView.setScaleY(1);
//                animationView.setAnimation(R.raw.ripple_loading);
//                animationView.playAnimation();

                mFastAdapter.filter("");
                mFastAdapter.withFilterPredicate(new IItemAdapter.Predicate<SampleItem>() {
                    @Override
                    public boolean filter(SampleItem item, CharSequence constraint) {
                        //return true if we should filter it out
                        //return false to keep it
                        return !item.getUserlocation().toLowerCase().contains(constraint.toString().toLowerCase());
                    }
                });


                return false;
            }
        });

        return  view;


    }
}
