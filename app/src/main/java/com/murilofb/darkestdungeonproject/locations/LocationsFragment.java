package com.murilofb.darkestdungeonproject.locations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.murilofb.darkestdungeonproject.R;
import com.murilofb.darkestdungeonproject.adapters.EnemiesAdapter;
import com.murilofb.darkestdungeonproject.models.Enemy;
import com.murilofb.darkestdungeonproject.repository.MyConst;

import java.util.ArrayList;
import java.util.List;

public class LocationsFragment extends Fragment {
    private RecyclerView recyclerEnemies;
    private EnemiesAdapter enemiesAdapter;
    private MaterialTextView txtOpenEnemies;
    private MaterialTextView txtOpenCurios;
    private boolean isEnemiesOpen = false;
    private boolean isCuriosOpen = false;

    public LocationsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_locations, container, false);
        initGlobalComponents(view);
        configRecyler();
        return view;
    }

    private void initGlobalComponents(View view) {
        recyclerEnemies = view.findViewById(R.id.recyclerEnemies);
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(MyConst.Enemies.BRAWLER(MyConst.APPRENTICE_LEVEL, MyConst.DIFFICULTY_STYGIAN));
        enemies.add(MyConst.Enemies.BRAWLER(MyConst.APPRENTICE_LEVEL, MyConst.DIFFICULTY_STYGIAN));
        enemies.add(MyConst.Enemies.BRAWLER(MyConst.APPRENTICE_LEVEL, MyConst.DIFFICULTY_STYGIAN));
        enemiesAdapter = new EnemiesAdapter(enemies);
        txtOpenEnemies = view.findViewById(R.id.txtOpenEnemies);
        txtOpenCurios = view.findViewById(R.id.txtOpenCurios);
    }

    private void configRecyler() {
        recyclerEnemies.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerEnemies.setAdapter(enemiesAdapter);
        recyclerEnemies.setHasFixedSize(true);
    }

    private void setClickListeners() {
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
        txtOpenEnemies.setOnClickListener(clickListener);
        txtOpenCurios.setOnClickListener(clickListener);
    }
}
