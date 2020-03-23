package com.example.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import java.util.List;
import timber.log.Timber;

public class MyPowerpointAdapter extends RecyclerView.Adapter {

    private List<Powerpoint> mPowerPointList;

    static class PagesViewHolder extends RecyclerView.ViewHolder {
        private ImageView mViewImageView;

        public PagesViewHolder(@NonNull View itemView) {
            super(itemView);
            mViewImageView = itemView.findViewById(R.id.fragment_pager_item_imageView);
        }
    }

    public MyPowerpointAdapter(List<Powerpoint> mPowerPointList) { this.mPowerPointList = mPowerPointList; }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_pager_item, parent, false);
        return new PagesViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Timber.i("On Bind Holder of My Pager Adapter");
        PagesViewHolder mViewHolder = (PagesViewHolder) holder;
        Powerpoint powerpoint = mPowerPointList.get(position);
        mViewHolder.mViewImageView.setImageResource(powerpoint.getTrialImage());
    }

    @Override
    public int getItemCount()  {return mPowerPointList.size();}
}