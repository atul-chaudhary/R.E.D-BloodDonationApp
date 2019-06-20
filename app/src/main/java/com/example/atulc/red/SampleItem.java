package com.example.atulc.red;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.atulc.blackspot_sih.R;
import com.mikepenz.fastadapter.items.AbstractItem;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SampleItem extends AbstractItem<SampleItem, SampleItem.ViewHolder> {

    public String userProfile;
    public String userName;
    public String userlocation;
    public String userNumber;
    public String userBloodType;

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserlocation() {
        return userlocation;
    }

    public void setUserlocation(String userlocation) {
        this.userlocation = userlocation;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserBloodType() {
        return userBloodType;
    }

    public void setUserBloodType(String userBloodType) {
        this.userBloodType = userBloodType;
    }

    //The unique ID for this type of item
    @Override
    public int getType() {
        return R.id.fastadapter_sampleitem_id;
    }

    //The layout to be used for this type of item
    @Override
    public int getLayoutRes() {
        return R.layout.find_donor_recyclerview_item;
    }

    //The logic to bind your data to the view
    @Override
    public void bindView(ViewHolder viewHolder, List payloads) {
        //call super so the selection is already handled for you
        super.bindView(viewHolder, payloads);

        //bind our data
        //set the text for the name
        //viewHolder.name.setText(name);
        //set the text for the description or hide
        //viewHolder.description.setText(description);
        Picasso.get().load(getUserProfile()).into(viewHolder.userProfile);
        viewHolder.userName.setText(getUserName());
        viewHolder.userLocation.setText(getUserlocation());
        viewHolder.userNumber.setText(getUserNumber());
        viewHolder.userBType.setText(getUserBloodType());


    }

    //The viewHolder used for this item. This viewHolder is always reused by the RecyclerView so scrolling is blazing fast
    protected static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView userProfile;
        TextView userName;
        TextView userLocation;
        TextView userNumber;
        TextView userBType;


        public ViewHolder(View view) {
            super(view);

            userProfile = itemView.findViewById(R.id.find_donor_profile_pic);
            userName = itemView.findViewById(R.id.find_donor_user_name);
            userLocation = itemView.findViewById(R.id.location_name_user);
            userNumber = itemView.findViewById(R.id.find_donor_mnumber);
            userBType = itemView.findViewById(R.id.find_donor_btype);

        }
    }
}