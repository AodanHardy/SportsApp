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

/**
 * The type Club jersey recycler view adapter.
 */
public class ClubJerseyRecyclerViewAdapter extends RecyclerView.Adapter<ClubJerseyRecyclerViewAdapter.ViewHolder> {

    private List<ClubJersey> clubList;

    /**
     * Instantiates a new Club jersey recycler view adapter.
     *
     * @param items the items
     */
    public ClubJerseyRecyclerViewAdapter(List<ClubJersey> items) {
        clubList = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.club_jersey_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ClubJersey club = clubList.get(position);
        holder.clubTextView.setText(club.getName());

        // Loop through the jerseys and display them as ImageViews
        holder.jerseyContainer.removeAllViews(); // Clear any previous jerseys
        for (String jerseyUrl : club.getJerseyUrls()) {
            ImageView jerseyImage = new ImageView(holder.jerseyContainer.getContext());
            Glide.with(holder.jerseyContainer.getContext()).load(jerseyUrl).into(jerseyImage);
            holder.jerseyContainer.addView(jerseyImage); // Add image view to the container
        }
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
         * The Club text view.
         */
        public final TextView clubTextView;
        /**
         * The Jersey container.
         */
        public final ViewGroup jerseyContainer;

        /**
         * Instantiates a new View holder.
         *
         * @param view the view
         */
        public ViewHolder(View view) {
            super(view);
            clubTextView = view.findViewById(R.id.clubName);
            jerseyContainer = view.findViewById(R.id.jerseyContainer);
        }
    }

    /**
     * Update data.
     *
     * @param newClubs the new clubs
     */
    public void updateData(List<ClubJersey> newClubs) {
        clubList = newClubs;
        notifyDataSetChanged();
    }
}

