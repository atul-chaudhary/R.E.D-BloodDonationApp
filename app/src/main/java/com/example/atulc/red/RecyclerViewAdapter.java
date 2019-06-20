package com.example.atulc.red;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.atulc.blackspot_sih.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.mikepenz.fastadapter.items.AbstractItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends AbstractItem<RecyclerViewAdapter,RecyclerViewAdapter.ViewHolder> {

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String mImageUrl;

    //The unique ID for this type of item
    @Override
    public int getType() {
        return R.id.list_item_id;
    }

    //The layout to be used for this type of item
    @Override
    public int getLayoutRes() {
        return R.layout.recyclerview_for_images_others;
    }

    //The logic to bind your data to the view
    @Override
    public void bindView(ViewHolder viewHolder, List payloads) {
        //call super so the selection is already handled for you
        super.bindView(viewHolder, payloads);

        //Log.e("myLog","student IMgaes  "+getmStudentImages());
        //Picasso.get().load(getmStudentImages()).into(viewHolder.circleImageView);
        Picasso.get().load(getmImageUrl()).into(viewHolder.imageView);
    }

    /*
    //reset the view here (this is an optional method, but recommended)
    @Override
    public void unbindView(ViewHolder holder) {
        super.unbindView(holder);
        holder.name.setText(null);
        holder.description.setText(null);
    }
    */

    //The viewHolder used for this item. This viewHolder is always reused by the RecyclerView so scrolling is blazing fast
    protected static class ViewHolder extends RecyclerView.ViewHolder {

        RoundedImageView imageView;

        public ViewHolder(View view) {
            super(view);

            imageView = (RoundedImageView) itemView.findViewById(R.id.imageView1);


        }
    }
}