package com.murilofb.darkestdungeonproject.locations;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
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
    private LocationsFragmentViewModel locationsViewModel;

    public LocationsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_locations, container, false);
        initGlobalComponents(view);
        setObservers();
        configRecycler();
        setClickListeners();
        return view;
    }

    private void initGlobalComponents(View view) {
        recyclerEnemies = view.findViewById(R.id.recyclerEnemies);
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(MyConst.EnemiesDB.BRAWLER(MyConst.APPRENTICE_LEVEL, MyConst.DIFFICULTY_STYGIAN));
        enemies.add(MyConst.EnemiesDB.BRAWLER(MyConst.APPRENTICE_LEVEL, MyConst.DIFFICULTY_STYGIAN));
        enemies.add(MyConst.EnemiesDB.BRAWLER(MyConst.APPRENTICE_LEVEL, MyConst.DIFFICULTY_STYGIAN));
        enemies.add(MyConst.EnemiesDB.BRAWLER(MyConst.APPRENTICE_LEVEL, MyConst.DIFFICULTY_STYGIAN));
        enemies.add(MyConst.EnemiesDB.BRAWLER(MyConst.APPRENTICE_LEVEL, MyConst.DIFFICULTY_STYGIAN));
        enemies.add(MyConst.EnemiesDB.BRAWLER(MyConst.APPRENTICE_LEVEL, MyConst.DIFFICULTY_STYGIAN));
        enemies.add(MyConst.EnemiesDB.BRAWLER(MyConst.APPRENTICE_LEVEL, MyConst.DIFFICULTY_STYGIAN));
        enemies.add(MyConst.EnemiesDB.BRAWLER(MyConst.APPRENTICE_LEVEL, MyConst.DIFFICULTY_STYGIAN));
        enemies.add(MyConst.EnemiesDB.BRAWLER(MyConst.APPRENTICE_LEVEL, MyConst.DIFFICULTY_STYGIAN));
        enemies.add(MyConst.EnemiesDB.BRAWLER(MyConst.APPRENTICE_LEVEL, MyConst.DIFFICULTY_STYGIAN));
        enemies.add(MyConst.EnemiesDB.BRAWLER(MyConst.APPRENTICE_LEVEL, MyConst.DIFFICULTY_STYGIAN));
        enemies.add(MyConst.EnemiesDB.BRAWLER(MyConst.APPRENTICE_LEVEL, MyConst.DIFFICULTY_STYGIAN));
        enemies.add(MyConst.EnemiesDB.BRAWLER(MyConst.APPRENTICE_LEVEL, MyConst.DIFFICULTY_STYGIAN));
        enemies.add(MyConst.EnemiesDB.BRAWLER(MyConst.APPRENTICE_LEVEL, MyConst.DIFFICULTY_STYGIAN));
        enemies.add(MyConst.EnemiesDB.BRAWLER(MyConst.APPRENTICE_LEVEL, MyConst.DIFFICULTY_STYGIAN));
        enemiesAdapter = new EnemiesAdapter(enemies);
        txtOpenEnemies = view.findViewById(R.id.txtOpenEnemies);
        txtOpenCurios = view.findViewById(R.id.txtOpenCurios);
        locationsViewModel = new ViewModelProvider(this).get(LocationsFragmentViewModel.class);
    }

    private void setObservers() {
        Drawable openedItem = ContextCompat.getDrawable(getContext(), R.drawable.ic_drop_up);
        Drawable closedItem = ContextCompat.getDrawable(getContext(), R.drawable.ic_drop_down);
        locationsViewModel.getIsEnemiesOpen().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    recyclerEnemies.setVisibility(View.VISIBLE);
                    txtOpenEnemies.setCompoundDrawables(null, null, closedItem, null);
                } else {
                    recyclerEnemies.setVisibility(View.GONE);
                    txtOpenEnemies.setCompoundDrawables(null, null, openedItem, null);
                }
            }
        });
    }

    private void configRecycler() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerEnemies.setLayoutManager(gridLayoutManager);
        recyclerEnemies.setAdapter(enemiesAdapter);
        recyclerEnemies.setHasFixedSize(true);
    }

    private void setClickListeners() {
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.txtOpenEnemies:
                        if (locationsViewModel.isEnemiesOpen.getValue()) {
                            locationsViewModel.hideEnemies();
                        } else {
                            locationsViewModel.showEnemies();
                        }
                        break;
                    case R.id.txtOpenCurios:
                        if (locationsViewModel.isCuriosOpen.getValue()) {
                            locationsViewModel.hideCurios();
                        } else {
                            locationsViewModel.showCurios();
                        }
                        locationsViewModel.showCurios();
                        break;
                }
            }
        };
        txtOpenEnemies.setOnClickListener(clickListener);
        txtOpenCurios.setOnClickListener(clickListener);
    }
}
