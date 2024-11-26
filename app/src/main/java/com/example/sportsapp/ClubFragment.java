package com.example.sportsapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.sportsapp.Models.Club;
import java.util.List;

public class ClubFragment extends Fragment {

    private RecyclerView recyclerView;
    private MyClubRecyclerViewAdapter adapter;
    private List<Club> clubList;

    // Constructor to create a new instance of the fragment with club data
    public static ClubFragment newInstance(List<Club> clubs) {
        ClubFragment fragment = new ClubFragment();
        Bundle args = new Bundle();
        args.putSerializable("clubList", (java.io.Serializable) clubs);
        fragment.setArguments(args);
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
            adapter = new MyClubRecyclerViewAdapter(clubList);
            recyclerView.setAdapter(adapter);
        }

        return view;
    }
}
