package org.lugge.scripts.osrs.luckyisland.data.Island;

public enum IslandOre {
    TIN(0, 0),
    COPPER(0,0);

    private final int objectID;
    private final int itemID;

    IslandOre(int objectID, int itemID) {
        this.objectID = objectID;
        this.itemID = itemID;
    }

    public int getObjectID() {
        return objectID;
    }

    public int getItemID() {
        return itemID;
    }
}
