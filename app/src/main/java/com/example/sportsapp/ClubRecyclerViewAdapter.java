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

public class ClubRecyclerViewAdapter extends RecyclerView.Adapter<ClubRecyclerViewAdapter.ViewHolder> {

    private List<Club> mValues;

    public ClubRecyclerViewAdapter(List<Club> items) {
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
        holder.item = club;

        holder.nameView.setText(club.getName());
        holder.shortNameView.setText("Short Name: " + club.getShortName());
        holder.altNameView.setText("Alternate Name: " + club.getAlternateName());
        holder.formedYearView.setText("Formed Year: " + club.getFormedYear());
        holder.leagueView.setText("League: " + club.getLeague());
        holder.stadiumView.setText("Stadium: " + club.getStadium());
        holder.stadiumLocationView.setText("Location: " + club.getStadiumLocation());
        holder.stadiumCapacityView.setText("Capacity: " + club.getStadiumCapacity());
        holder.websiteView.setText("Website: " + club.getWebsite());

        // Load the logo using Glide
        Glide.with(holder.logoView.getContext())
                .load(club.getLogoUrl())
                .into(holder.logoView);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView nameView;
        public final TextView shortNameView;
        public final TextView altNameView;
        public final TextView formedYearView;
        public final TextView leagueView;
        public final TextView stadiumView;
        public final TextView stadiumLocationView;
        public final TextView stadiumCapacityView;
        public final TextView websiteView;
        public final ImageView logoView;
        public Club item;

        public ViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.clubName);
            shortNameView = view.findViewById(R.id.clubShortName);
            altNameView = view.findViewById(R.id.clubAlternateName);
            formedYearView = view.findViewById(R.id.clubFormedYear);
            leagueView = view.findViewById(R.id.clubLeague);
            stadiumView = view.findViewById(R.id.clubStadium);
            stadiumLocationView = view.findViewById(R.id.clubStadiumLocation);
            stadiumCapacityView = view.findViewById(R.id.clubStadiumCapacity);
            websiteView = view.findViewById(R.id.clubWebsite);
            logoView = view.findViewById(R.id.clubLogo);
        }
    }

    public void updateData(List<Club> newClubs) {
        mValues = newClubs; // Replace the existing data
        notifyDataSetChanged(); // Notify the RecyclerView to rebind the views
    }
}
