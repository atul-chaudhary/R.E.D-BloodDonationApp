package com.example.atulc.red;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.atulc.blackspot_sih.R;
import com.mikepenz.fastadapter.adapters.FastItemAdapter;

import java.util.ArrayList;

public class ListFragment extends Fragment{

    ArrayList<String> mImageUrls;
    FastItemAdapter<RecyclerViewAdapter> mFastAdapter;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.list_fragment_layout,container,false);

        mFastAdapter = new FastItemAdapter<RecyclerViewAdapter>();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_android);
        mImageUrls = new ArrayList<String>();

        mImageUrls.add("https://i.pinimg.com/originals/5b/30/1d/5b301dcc48147791a8513c827bf3dc2b.jpg");
        mImageUrls.add("https://i.pinimg.com/originals/9f/9e/da/9f9eda074c5ca22b20535260b61d50c5.gif");
        mImageUrls.add("https://i.pinimg.com/564x/23/4f/a2/234fa2e01a34f6bb95af51457e84b2ba.jpg");
        mImageUrls.add("https://www.bloodtaker.com/wp-content/uploads/2014/07/spare15minutes.jpg");
        mImageUrls.add("https://www.bloodtaker.com/wp-content/uploads/2014/07/Blood-Drive-Hero.jpg");
        mImageUrls.add("https://www.bloodtaker.com/wp-content/uploads/2014/07/heterosexual.jpg");
        mImageUrls.add("https://image.slidesharecdn.com/motivational-presentation-ledja-151005180527-lva1-app6892/95/blood-donation-motivation-3-638.jpg?cb=1444068581");
        mImageUrls.add("https://www.overallmotivation.com/wp-content/uploads/bring-life-back-to-power-overallmotivation.png");
        mImageUrls.add("https://1.bp.blogspot.com/-HF8q1RCn0So/WNCrLauYNLI/AAAAAAAAAKQ/vm16PQi87bcTRgJzQvWqn4Zzzs8BUscgACLcB/s1600/4dcf6728bf9bb47527043c8a1ed0f9a9.jpg");
        mImageUrls.add("https://i.pinimg.com/236x/e8/ef/04/e8ef040c5087f32a7f2df96e6e7d80d2--red-cross-blood-donation-quotes.jpg");

        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        Log.e("atulLOG", "rec>> " + recyclerView + lm);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(mFastAdapter);
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < mImageUrls.size(); i++) {
                    RecyclerViewAdapter mObj = new RecyclerViewAdapter();
                    mObj.setmImageUrl(mImageUrls.get(i));
                    mFastAdapter.add(mObj);
                }
            }
        });

        return view;
    }
}
