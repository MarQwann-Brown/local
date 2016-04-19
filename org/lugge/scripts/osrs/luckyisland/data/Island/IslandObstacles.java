package org.lugge.scripts.osrs.luckyisland.data.Island;

import org.powerbot.script.Tile;

public enum IslandObstacles {
    RUNESCAPE_GUIDE_DOOR(9398, new Tile(3098, 3107)),
    SURVIVAL_EXPERT_GATE(0, new Tile(0, 0)),
    MASTER_CHEF_DOOR1(0, new Tile(0, 0)),
    MASTER_CHEF_DOOR2(0, new Tile(0, 0)),
    QUEST_GUIDE_DOOR(0, new Tile(0, 0)),
    QUEST_GUIDE_LADDER(0, new Tile(0, 0)),
    MINING_INSTRUCTOR_GATE(0, new Tile(0, 0)),
    RAT_GATE(0, new Tile(0, 0)),
    COMBAT_INSTRUCTOR_LADDER(0, new Tile(0, 0)),
    BANK_DOOR(0, new Tile(0, 0)),
    FINANCIAL_ADVISOR_DOOR(0, new Tile(0, 0)),
    BROTHER_BRACE_DOOR1(0, new Tile(0, 0)),
    BROTHER_BRACE_DOOR2(0, new Tile(0, 0));

    private final int ID;
    private final Tile tile;

    IslandObstacles(int ID, Tile tile) {
        this.ID = ID;
        this.tile = tile;
    }

    public int getID() {
        return this.ID;
    }

    public Tile getTile() {
        return tile;
    }
}
