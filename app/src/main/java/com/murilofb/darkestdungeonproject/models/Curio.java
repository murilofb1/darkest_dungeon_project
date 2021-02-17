package com.murilofb.darkestdungeonproject.models;

import java.util.ArrayList;
import java.util.List;

import com.murilofb.darkestdungeonproject.R;
import com.murilofb.darkestdungeonproject.repository.MyConst;

public class Curio {
    private String name;
    private String[] types;
    private String description = "No description.";
    private int imageDrawable;
    private List<Interaction> interactions;

    public Curio() {
    }

    public String getName() {
        return name;
    }

    public Curio setName(String name) {
        this.name = name;
        return this;
    }

    public String[] getTypes() {
        return types;
    }

    public Curio setTypes(String[] types) {
        this.types = types;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Curio setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getImageDrawable() {
        return imageDrawable;
    }

    public Curio setImageDrawable(int imageDrawable) {
        this.imageDrawable = imageDrawable;
        return this;
    }

    public Curio addInteraction(Interaction cleasing) {
        if (interactions == null) interactions = new ArrayList<>();
        interactions.add(cleasing);
        return this;
    }

    public List<Interaction> getInteractions() {
        return interactions;
    }

    public static class Interaction {
        private Provision provisionItem;
        private int type;
        private String effect;
        int IconId;

        //Constructor for provisions Interactions
        public Interaction(Provision provisionItem, int type, String effect) {
            this.provisionItem = provisionItem;
            this.type = type;
            this.effect = effect;
        }

        //Constructor for defaultInteractions
        public Interaction(int type, String effect) {
            this.type = type;
            this.effect = effect;
            this.provisionItem = null;
        }

        private void setIconId(int interactionType) {
            switch (interactionType) {
                case MyConst.CurioStats.INTERACTION_NOTHING:
                    this.IconId = R.drawable.interaction_nothing;
                    break;
                case MyConst.CurioStats.INTERACTION_HEIRLOOM:
                    this.IconId = R.drawable.interaction_heirloom;
                    break;
            }
        }

        public int getIconId() {
            return IconId;
        }

        public Provision getProvisionItem() {
            return provisionItem;
        }

        public int getType() {
            return type;
        }

        public String getMessage() {
            return effect;
        }
    }

}
