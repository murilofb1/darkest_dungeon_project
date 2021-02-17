package com.murilofb.darkestdungeonproject.locations;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LocationsFragmentViewModel extends ViewModel {

    MutableLiveData<Boolean> isEnemiesOpen = new MutableLiveData<>();
    MutableLiveData<Boolean> isCuriosOpen = new MutableLiveData<>();

    public LocationsFragmentViewModel() {
        isEnemiesOpen.setValue(false);
        isCuriosOpen.setValue(false);
    }

    protected void showEnemies() {
        isEnemiesOpen.setValue(true);
        isCuriosOpen.setValue(false);
    }

    protected void hideEnemies() {
        isEnemiesOpen.setValue(false);
    }

    protected void showCurios() {
        isCuriosOpen.setValue(true);
        isEnemiesOpen.setValue(false);
    }

    protected void hideCurios() {
        isCuriosOpen.setValue(false);
    }

    public LiveData<Boolean> getIsEnemiesOpen() {
        return isEnemiesOpen;
    }

    public LiveData<Boolean> getIsCuriosOpen() {
        return isCuriosOpen;
    }
}
