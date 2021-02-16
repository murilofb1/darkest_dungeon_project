package com.murilofb.darkestdungeonproject.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.murilofb.darkestdungeonproject.R;
import com.murilofb.darkestdungeonproject.models.Enemy;


import java.util.List;

public class EnemiesAdapter extends RecyclerView.Adapter<EnemiesAdapter.EnemiesViewHolder> {
    private List<Enemy> enemiesList;

    public EnemiesAdapter(List<Enemy> enemiesList) {
        this.enemiesList = enemiesList;
    }

    @NonNull
    @Override
    public EnemiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_enemies, parent, false);
        return new EnemiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EnemiesViewHolder holder, int position) {
        Enemy currentEnemy = enemiesList.get(position);
        String enemyName = currentEnemy.getName();

        holder.txtEnemyName.setText(splitName(enemyName));
    }

    @Override
    public int getItemCount() {
        if (enemiesList != null) return enemiesList.size();
        else return 0;
    }

    private String splitName(String name) {
        String[] splittedName = name.split(" ");
        String returnString = "";
        int i = 0;
        while (i < splittedName.length) {
            returnString += splittedName[i];
            if (i < splittedName.length - 1) {
                returnString += "\n";
            }
            i++;
        }
        return returnString;
    }

    ;

    protected class EnemiesViewHolder extends RecyclerView.ViewHolder {
        MaterialTextView txtEnemyName;

        public EnemiesViewHolder(@NonNull View itemView) {
            super(itemView);
            txtEnemyName = itemView.findViewById(R.id.txtEnemyName);
        }
    }
}
