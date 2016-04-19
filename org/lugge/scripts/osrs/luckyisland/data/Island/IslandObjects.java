package org.lugge.scripts.osrs.luckyisland.data.Island;

public enum IslandObjects {
    TREE(3308),
    FIRE(0),
    FISHING_SPOT(0),
    ANVIL(0);



    private final int id;

    IslandObjects(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }
}
