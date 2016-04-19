package org.lugge.scripts.osrs.luckyisland.data.Island;

public enum IslandNPCs {
    RUNESCAPE_GUIDE(3308),
    SURVIVAL_EXPERT(0),
    MASTER_CHEF(0),
    QUEST_GUIDE(0),
    MINING_INSTRUCTOR(0),
    COMBAT_INSTRUCTOR(0),
    RAT(0),
    BANKER(0),
    FINANCIAL_INSTRUCTOR(0),
    BROTHER_BRACE(0),
    MAGIC_INSTRUCTOR(0),
    CHICKEN(0);

    private final int id;

    IslandNPCs(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }
}
