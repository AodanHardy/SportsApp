package com.example.sportsapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.sportsapp.Database.Club;
import java.util.List;

/**
 * The type Club fragment.
 */
public class ClubFragment extends Fragment {

    private RecyclerView recyclerView;
    private ClubRecyclerViewAdapter adapter;
    private List<Club> clubList;

    /**
     * New instance club fragment.
     *
     * @param clubs the clubs
     * @return the club fragment
     */
// Constructor to create a new instance of the fragment with club data
    public static ClubFragment newInstance(List<Club> clubs) {
        ClubFragment fragment = new ClubFragment();
        Bundle clubBundle = new Bundle();
        clubBundle.putSerializable("clubList", (java.io.Serializable) clubs);
        fragment.setArguments(clubBundle);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_club_list, container, false);


        recyclerView = view.findViewById(R.id.recyclerViewClubs);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if (getArguments() != null) {
            clubList = (List<Club>) getArguments().getSerializable("clubList");
        }

        if (clubList != null) {
            adapter = new ClubRecyclerViewAdapter(clubList);
            recyclerView.setAdapter(adapter);
        }

        return view;
    }
}
