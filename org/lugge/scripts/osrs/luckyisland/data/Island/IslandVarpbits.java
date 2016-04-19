package org.lugge.scripts.osrs.luckyisland.data.Island;

public enum IslandVarpbits {
    DESIGN_OPEN(22, 0),
    DESIGN_CLOSED(22, 33554432),
    WRENCH_FLASHING(281, 3),
    WRENCH_VISIBLE(281, 7),
    RUNESCAPE_GUIDE_FINISHED(281, 10),

    SURVIVAL_EXPERT_NOT_STARTED(281, 20),
    INVENTORY_FLASHING(281, 30),
    INVENTORY_VISIBLE(281, 40),
    LOGS_CUT(281, 50),
    SKILLS_FLASHING(281, 60),
    SKILLS_VISIBLE(281, 70),
    FISH(281, 80),
    FISH_CAUGHT(281, 90),
    FIRE_LIT(281, 100),
    FISH_BURNT(281, 110),
    FISH_COOKED(281, 120),
    SURVIVAL_EXPERT_FINISHED(281, 130),

    MASTER_CHEF_NOT_STARTED(281, 140),
    INGREDIENTS_RECEIVED(281, 150),
    DOUGH_MADE(281, 160),
    HARP_FLASHING(281, 170),
    HARP_VISIBLE(281, 180),
    EMOTES_FLASHING(281, 183),
    EMOTES_VISIBLE(281, 187),
    WRENCH_FLASHING_RUNNING(281, 190),
    ACTIVATE_RUNNING(281, 200),
    MASTER_CHEF_FINISHED(281, 210),


    QUEST_GUIDE_NOT_STARTED(281, 220),
    QUESTS_FLASHING(281, 230),
    QUESTS_VISIBLE(281, 240),
    GUEST_GUIDE_FINISHED(281, 250),

    MINING_INSTRUCTOR_NOT_STARTED(281, 260),
    PROSPECT_TIN(281, 270),
    PROSPECT_COPPER(281, 280),
    PROSPECTING_FINISHED(281, 290),
    MINE_TIN(281, 300),
    MINE_COPPER(281, 310),
    SMELT_BAR(281, 320),
    SMELTING_FINISHED(281, 330),
    USE_ANVIL(281, 340),
    SMITH_DAGGER(281, 350),
    MINING_INSTRUCTOR_FINISHED(281, 360),

    COMBAT_INSTRUCTOR_NOT_STARTED(281, 170),
    EQUIPMENT_FLASHING(281, 390),
    OPEN_EQUIPMENT(281, 400),
    EQUIP_DAGGER(281, 405),
    DAGGER_EQUIPPED(281, 410),
    MElEE_WEAPON_RECEIVED(281, 420),
    COMBAT_FLASHING(281, 430),
    COMBAT_VISIBLE(281, 440),
    MELEE_FIGHT_NOT_STARTED(281, 450),
    MELEE_FIGHTING(281, 460),
    MELEE_FIGHT_FINISHED(281, 470),
    RANGE_WEAPON_RECEIVED(281, 480),
    RANGE_FIGHTING(281, 490),
    COMBAT_INSTRUCTOR_FINISHED(281, 500),

    BANKER_NOT_STARTED(281, 510),

    POLL_BOOTH_NOT_STARTED(281, 520),
    POLL_BOOTH_FINISHED(281, 525),

    FINANCIAL_ADVISOR_NOT_STARTED(281, 530),
    FINANCIAL_ADVISOR_FINISHED(281, 540),

    BROTHER_BRACE_NOT_STARTED(281, 550),
    PRAYER_FLASHING(281, 560),
    PRAYER_VISIBLE(281, 570),
    FRIENDS_LIST_FLASHING(281, 580),
    IGNORE_LIST_FLASHING(281, 590),
    IGNORE_LIST_VISIBLE(281, 600),
    BROTHER_BRACE_FINISHED(281, 610),

    MAGIC_INSTRUCTOR_NOT_STARTED(281, 620),
    BOOK_FLASHING(281, 630),
    BOOK_VISIBLE(281, 640),
    RUNES_RECEIVED(281, 650),
    MAGIC_FIGHT_FINISHED(281, 670),

    ISLAND_FINISHED(281, 1000)
    ;

    private final int varpbit;
    private final int setting;

    IslandVarpbits(int varpbit, int setting) {
        this.varpbit = varpbit;
        this.setting = setting;
    }

    public final int getVarpbit() {
        return varpbit;
    }

    public int getSetting() {
        return setting;
    }
}
