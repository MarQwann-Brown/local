package lugge.scripts.rs3.accountcreator.task.SuperState;

import lugge.scripts.rs3.accountcreator.data.Creation.TilesCreation;
import lugge.scripts.rs3.accountcreator.task.Options.ConditionsOptions;
import lugge.scripts.rs3.accountcreator.task.Options.StatesOptions;
import lugge.scripts.rs3.accountcreator.util.Paint;
import org.powerbot.script.rt6.ClientContext;

public class ConditionsSuperState {
    public static StatesSuperState getSuperState(ClientContext ctx) {
        switch (ctx.game.clientState()) {
            case -1:
                return StatesSuperState.CREATE_ACCOUNT;
            case 3:
                return StatesSuperState.CREATE_ACCOUNT;
            case 11:
                if (ctx.players.local().tile().floor() == 2) {
                    return StatesSuperState.CREATE_ACCOUNT;
                } else {
                    if (ConditionsOptions.getCurrentState(ctx) == StatesOptions.NULL) {
                        return StatesSuperState.PLACE_ACCOUNT;
                    } else {
                        if (ctx.players.local().tile().distanceTo(TilesCreation.SPAWN_POINT.getTile()) <= 5) {
                            Paint.setStatus(ConditionsOptions.getCurrentState(ctx).toString());
                            return StatesSuperState.CHANGE_OPTIONS;
                        }
                    }
                }
        }
        return StatesSuperState.NULL;
    }
}
