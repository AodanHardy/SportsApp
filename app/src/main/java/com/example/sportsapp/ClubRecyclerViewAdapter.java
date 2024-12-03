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

/**
 * The type Club recycler view adapter.
 */
public class ClubRecyclerViewAdapter extends RecyclerView.Adapter<ClubRecyclerViewAdapter.ViewHolder> {

    private List<Club> clubList;

    /**
     * Instantiates a new Club recycler view adapter.
     *
     * @param items the items
     */
    public ClubRecyclerViewAdapter(List<Club> items) {
        clubList = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_club_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Club club = clubList.get(position);
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
        return clubList.size();
    }

    /**
     * The type View holder.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        /**
         * The Name view.
         */
        public final TextView nameView;
        /**
         * The Short name view.
         */
        public final TextView shortNameView;
        /**
         * The Alt name view.
         */
        public final TextView altNameView;
        /**
         * The Formed year view.
         */
        public final TextView formedYearView;
        /**
         * The League view.
         */
        public final TextView leagueView;
        /**
         * The Stadium view.
         */
        public final TextView stadiumView;
        /**
         * The Stadium location view.
         */
        public final TextView stadiumLocationView;
        /**
         * The Stadium capacity view.
         */
        public final TextView stadiumCapacityView;
        /**
         * The Website view.
         */
        public final TextView websiteView;
        /**
         * The Logo view.
         */
        public final ImageView logoView;
        /**
         * The Item.
         */
        public Club item;

        /**
         * Instantiates a new View holder.
         *
         * @param view the view
         */
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

    /**
     * Update data.
     *
     * @param newClubs the new clubs
     */
    public void updateData(List<Club> newClubs) {
        clubList = newClubs;
        notifyDataSetChanged();
    }
}
