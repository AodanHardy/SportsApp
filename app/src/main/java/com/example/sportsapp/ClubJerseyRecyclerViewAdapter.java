package com.example.sportsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.sportsapp.Models.ClubJersey;
import java.util.List;

public class ClubJerseyRecyclerViewAdapter extends RecyclerView.Adapter<ClubJerseyRecyclerViewAdapter.ViewHolder> {

    private List<ClubJersey> mValues;

    public ClubJerseyRecyclerViewAdapter(List<ClubJersey> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.club_jersey_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ClubJersey club = mValues.get(position);
        holder.mClubNameView.setText(club.getName());

        // Loop through the jerseys and display them as ImageViews
        holder.mJerseyContainer.removeAllViews(); // Clear any previous jerseys
        for (String jerseyUrl : club.getJerseyUrls()) {
            ImageView jerseyImage = new ImageView(holder.mJerseyContainer.getContext());
            Glide.with(holder.mJerseyContainer.getContext()).load(jerseyUrl).into(jerseyImage);
            holder.mJerseyContainer.addView(jerseyImage); // Add image view to the container
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mClubNameView;
        public final ViewGroup mJerseyContainer; // This will hold the jersey images

        public ViewHolder(View view) {
            super(view);
            mClubNameView = view.findViewById(R.id.clubName);
            mJerseyContainer = view.findViewById(R.id.jerseyContainer);
        }
    }

    public void updateData(List<ClubJersey> newClubs) {
        mValues = newClubs;
        notifyDataSetChanged();
    }
}

