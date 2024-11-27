package com.example.sportsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.sportsapp.Database.Club;
import java.util.List;

public class MyClubRecyclerViewAdapter extends RecyclerView.Adapter<MyClubRecyclerViewAdapter.ViewHolder> {

    private final List<Club> mValues;

    public MyClubRecyclerViewAdapter(List<Club> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_club_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNameView.setText(mValues.get(position).getName());
        // Load the logo image using Glide
        Glide.with(holder.mLogoView.getContext())
                .load(mValues.get(position).getLogoUrl())
                .into(holder.mLogoView);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mNameView;
        public final ImageView mLogoView;
        public Club mItem;

        public ViewHolder(View view) {
            super(view);
            mNameView = view.findViewById(R.id.clubName);
            mLogoView = view.findViewById(R.id.clubLogo);
        }
    }
}
