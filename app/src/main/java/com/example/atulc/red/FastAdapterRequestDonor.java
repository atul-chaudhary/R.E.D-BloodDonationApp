package com.example.atulc.red;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.atulc.blackspot_sih.R;
import com.mikepenz.fastadapter.items.AbstractItem;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FastAdapterRequestDonor extends AbstractItem<FastAdapterRequestDonor, FastAdapterRequestDonor.ViewHolder> {
    public String userProfile_;
    public String userName_;
    public String userlocation_;
    public String userNumber_;
    public String userBloodType_;

    public String getUserProfile_() {
        return userProfile_;
    }

    public void setUserProfile_(String userProfile_) {
        this.userProfile_ = userProfile_;
    }

    public String getUserName_() {
        return userName_;
    }

    public void setUserName_(String userName_) {
        this.userName_ = userName_;
    }

    public String getUserlocation_() {
        return userlocation_;
    }

    public void setUserlocation_(String userlocation_) {
        this.userlocation_ = userlocation_;
    }

    public String getUserNumber_() {
        return userNumber_;
    }

    public void setUserNumber_(String userNumber_) {
        this.userNumber_ = userNumber_;
    }

    public String getUserBloodType_() {
        return userBloodType_;
    }

    public void setUserBloodType_(String userBloodType_) {
        this.userBloodType_ = userBloodType_;
    }

    //The unique ID for this type of item
    @Override
    public int getType() {
        return R.id.fastadapter_sampleitem_id1;
    }

    //The layout to be used for this type of item
    @Override
    public int getLayoutRes() {
        return R.layout.request_donor_recyclerview_item;
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

        Picasso.get().load(getUserProfile_()).into(viewHolder.userProfile_);
        viewHolder.userName_.setText(getUserName_());
        viewHolder.userLocation_.setText(getUserlocation_());
        viewHolder.userNumber_.setText(getUserNumber_());
        viewHolder.userBType_.setText(getUserBloodType_());
    }

    //The viewHolder used for this item. This viewHolder is always reused by the RecyclerView so scrolling is blazing fast
    protected static class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView userProfile_;
        TextView userName_;
        TextView userLocation_;
        TextView userNumber_;
        TextView userBType_;

        public ViewHolder(View view) {
            super(view);

            userProfile_ = itemView.findViewById(R.id.request_user_profile_);
            userName_ = itemView.findViewById(R.id.request_donor_user_name);
            userLocation_ = itemView.findViewById(R.id.requested_location_of_user);
            userNumber_ = itemView.findViewById(R.id.request_donor_mnumber_);
            userBType_ = itemView.findViewById(R.id.request_donor_btype_);


        }
    }
}