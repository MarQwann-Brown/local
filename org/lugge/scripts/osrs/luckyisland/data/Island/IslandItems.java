package org.lugge.scripts.osrs.luckyisland.data.Island;

public enum IslandItems {
    DAGGER(0),
    SWORD_AND_SHIELD(0, 0),
    BOW_AND_ARROWS(0, 0);

    private int mainID = -1;
    private int secondID = -1;

    IslandItems(int mainID) {
        this.mainID = mainID;
    }

    IslandItems(int mainID, int secondID) {
        this.mainID = mainID;
        this.secondID = secondID;
    }

    public int getMainID() {
        return mainID;
    }

    public void setSecondID(int secondID) {
        this.secondID = secondID;
    }
}
