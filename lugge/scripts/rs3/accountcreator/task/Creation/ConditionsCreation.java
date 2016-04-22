package lugge.scripts.rs3.accountcreator.task.Creation;

import lugge.scripts.rs3.accountcreator.data.Creation.SettingsCreation;
import lugge.scripts.rs3.accountcreator.data.Creation.TilesCreation;
import lugge.scripts.rs3.accountcreator.data.Creation.VariablesCreation;
import lugge.scripts.rs3.accountcreator.data.Creation.WidgetsCreation;
import lugge.scripts.rs3.accountcreator.util.Interface;
import org.powerbot.script.rt6.ClientContext;

public class ConditionsCreation {
    public static StatesCreation getCurrentState(ClientContext ctx) {
        switch (ctx.game.clientState()) {
            case -1:
                if (Interface.getComponent(WidgetsCreation.DESIGN_DONE, ctx).visible() && !Interface.getComponent(WidgetsCreation.RANDOMISE_NAME, ctx).visible()) {
                    switch (SettingsCreation.GENDER) {
                        case MALE:
                            if (!Interface.getComponent(WidgetsCreation.SELECT_MALE, ctx).visible()) {
                                return StatesCreation.SELECT_GENDER;
                            }
                            break;
                        case FEMALE:
                            if (!Interface.getComponent(WidgetsCreation.SELECT_FEMALE, ctx).visible()) {
                                return StatesCreation.SELECT_GENDER;
                            }
                            break;
                    }
                    return StatesCreation.FINISH_DESIGN;
                }
                if (Interface.getComponent(WidgetsCreation.RANDOMISE_NAME, ctx).visible()) {
                    boolean invalid = false;
                    boolean unknown = false;
                    WidgetsCreation[] components = {WidgetsCreation.VALID_NAME, WidgetsCreation.VALID_AGE, WidgetsCreation.VALID_EMAIL, WidgetsCreation.VALID_PASSWORD};
                    for (WidgetsCreation component : components) {
                        switch (Interface.checkBoxes(component, ctx)) {
                            case INVALID:
                                invalid = true;
                                unknown = false;
                                break;
                            case UNKNOWN:
                                invalid = false;
                                unknown = true;
                                break;
                        }
                        if (component == WidgetsCreation.VALID_NAME) {
                            if (SettingsCreation.NAME == null && (invalid || unknown)) {
                                return StatesCreation.RANDOMISE_NAME;
                            }
                            if (Interface.getComponent(WidgetsCreation.NAME_FIELD, ctx).text().isEmpty() && (invalid || unknown)) {
                                return StatesCreation.ENTER_NAME;
                            }
                            if (!Interface.getComponent(WidgetsCreation.NAME_FIELD, ctx).text().isEmpty() && invalid) {
                                return StatesCreation.DELETE_NAME;
                            }
                        } else if (component == WidgetsCreation.VALID_AGE) {
                            if (Interface.getComponent(WidgetsCreation.AGE_FIELD, ctx).text().isEmpty() && (invalid || unknown)) {
                                return StatesCreation.ENTER_AGE;
                            }
                            if (invalid) {
                                return StatesCreation.DELETE_AGE;
                            }
                        } else if (component == WidgetsCreation.VALID_EMAIL) {
                            if (Interface.getComponent(WidgetsCreation.EMAIL_FIELD, ctx).text().isEmpty() && (invalid || unknown)) {
                                return StatesCreation.ENTER_EMAIL;
                            }
                            if (invalid) {
                                if (Interface.getComponent(WidgetsCreation.EMAIL_IN_USE, ctx).visible()) {
                                    VariablesCreation.extension++;
                                }
                                return StatesCreation.DELETE_EMAIL;
                            }
                        } else if (component == WidgetsCreation.VALID_PASSWORD) {
                            if (Interface.getComponent(WidgetsCreation.PASSWORD_FIELD, ctx).text().isEmpty() && (invalid || unknown)) {
                                return StatesCreation.ENTER_PASSWORD;
                            }
                            if (invalid) {
                                return StatesCreation.DELETE_PASSWORD;
                            }
                            return StatesCreation.FINISH_CREATION;
                        }
                    }
                }
                break;
            case 3:
                if (SettingsCreation.QUANTITY > VariablesCreation.accountsCreated) {
                    return StatesCreation.START_CREATION;
                }
                return StatesCreation.END_SCRIPT;

            case 11:
                if (!ctx.players.local().tile().equals(TilesCreation.SPAWN_POINT.getTile())) {
                    if (Interface.getComponent(WidgetsCreation.SKIP_CUT_SCENE, ctx).visible()) {
                        return StatesCreation.SKIP_CUT_SCENE;
                    }
                    if (Interface.getComponent(WidgetsCreation.ARRIVED, ctx).visible()) {
                        return StatesCreation.SKIP_TUTORIAL;
                    }
                }
        }
        return StatesCreation.NULL;
    }
}
