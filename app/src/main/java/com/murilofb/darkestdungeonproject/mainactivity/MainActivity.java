package com.murilofb.darkestdungeonproject.mainactivity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.murilofb.darkestdungeonproject.R;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;
    private MainActivityViewModel mainVm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setCustomActionBar();
        initGlobalComponents();
        initNavDrawer();
    }

    @Override
    public boolean onSupportNavigateUp() {
        //return NavigationUI.navigateUp(navController, drawerLayout) || super.onSupportNavigateUp();
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isOpen()) drawerLayout.closeDrawer(GravityCompat.START);
        else if (mainVm.isValidDestination(R.id.nav_home)) navController.navigate(R.id.go_to_home);
        else super.onBackPressed();
    }

    private void setCustomActionBar() {
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initGlobalComponents() {
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        appBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_locations)
                .setDrawerLayout(drawerLayout)
                .build();
        mainVm = new MainActivityViewModel(navController);
    }

    private void initNavDrawer() {
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(mainVm.getNavDrawerListener(drawerLayout));
    }
}