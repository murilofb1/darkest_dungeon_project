package com.murilofb.darkestdungeonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.murilofb.darkestdungeonproject.models.Character;
import com.murilofb.darkestdungeonproject.models.MyConst;

public class MainActivity extends AppCompatActivity {
    ImageView imgVIcon;
    TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Character brawler = MyConst.Enemies.BRAWLER(
                MyConst.DifficultyAndLevels.VETERAN_LEVEL,
                MyConst.DifficultyAndLevels.DIFFICULTY_STYGIAN);
        imgVIcon = findViewById(R.id.imgVIcon);
        txtName = findViewById(R.id.txtName);
        txtName.setText(String.valueOf(brawler.getHp()));
        imgVIcon.setImageResource(brawler.getImageResource());
    }
}