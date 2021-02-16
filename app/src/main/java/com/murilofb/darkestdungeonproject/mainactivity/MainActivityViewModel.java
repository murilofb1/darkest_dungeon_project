package com.murilofb.darkestdungeonproject.mainactivity;

import android.annotation.SuppressLint;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;

import com.google.android.material.navigation.NavigationView;
import com.murilofb.darkestdungeonproject.R;

public class MainActivityViewModel {
    NavController navController;

    public MainActivityViewModel(NavController navController) {
        this.navController = navController;
    }

    public NavigationView.OnNavigationItemSelectedListener getNavDrawerListener(DrawerLayout drawerLayout) {
        NavigationView.OnNavigationItemSelectedListener navDrawerListener = new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        if (isValidDestination(R.id.nav_home)) {
                            navController.navigate(R.id.go_to_home);
                        }
                        return true;
                    case R.id.menu_locations:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        if (isValidDestination(R.id.nav_locations)) {
                            navController.navigate(R.id.go_to_locations);
                        }
                        return true;
                }
                return false;
            }
        };
        return navDrawerListener;
    }

    @SuppressLint("RestrictedApi")
    public boolean isValidDestination(int destinationId) {
        int currentItemId = navController.getCurrentDestination().getId();
        return currentItemId != destinationId;
    }
}
