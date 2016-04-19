package org.lugge.scripts.osrs.luckyisland.task.SuperState;

import org.powerbot.script.rt4.ClientAccessor;
import org.powerbot.script.rt4.ClientContext;

public class SuperStateConditions extends ClientAccessor {
    public SuperStateConditions(ClientContext ctx) {
        super(ctx);
    }

    public SuperStateStates getSuperState() {
        return SuperStateStates.DO_ISLAND;
    }
}
