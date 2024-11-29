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

    private List<Club> mValues;

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
        Club club = mValues.get(position);
        holder.mItem = club;

        holder.mNameView.setText(club.getName());
        holder.mShortNameView.setText("Short Name: " + club.getShortName());
        holder.mAlternateNameView.setText("Alternate Name: " + club.getAlternateName());
        holder.mFormedYearView.setText("Formed Year: " + club.getFormedYear());
        holder.mLeagueView.setText("League: " + club.getLeague());
        holder.mStadiumView.setText("Stadium: " + club.getStadium());
        holder.mStadiumLocationView.setText("Location: " + club.getStadiumLocation());
        holder.mStadiumCapacityView.setText("Capacity: " + club.getStadiumCapacity());
        holder.mWebsiteView.setText("Website: " + club.getWebsite());

        // Load the logo using Glide
        Glide.with(holder.mLogoView.getContext())
                .load(club.getLogoUrl())
                .into(holder.mLogoView);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mNameView;
        public final TextView mShortNameView;
        public final TextView mAlternateNameView;
        public final TextView mFormedYearView;
        public final TextView mLeagueView;
        public final TextView mStadiumView;
        public final TextView mStadiumLocationView;
        public final TextView mStadiumCapacityView;
        public final TextView mWebsiteView;
        public final ImageView mLogoView;
        public Club mItem;

        public ViewHolder(View view) {
            super(view);
            mNameView = view.findViewById(R.id.clubName);
            mShortNameView = view.findViewById(R.id.clubShortName);
            mAlternateNameView = view.findViewById(R.id.clubAlternateName);
            mFormedYearView = view.findViewById(R.id.clubFormedYear);
            mLeagueView = view.findViewById(R.id.clubLeague);
            mStadiumView = view.findViewById(R.id.clubStadium);
            mStadiumLocationView = view.findViewById(R.id.clubStadiumLocation);
            mStadiumCapacityView = view.findViewById(R.id.clubStadiumCapacity);
            mWebsiteView = view.findViewById(R.id.clubWebsite);
            mLogoView = view.findViewById(R.id.clubLogo);
        }
    }

    public void updateData(List<Club> newClubs) {
        mValues = newClubs; // Replace the existing data
        notifyDataSetChanged(); // Notify the RecyclerView to rebind the views
    }
}
