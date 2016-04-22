package lugge.scripts.rs3.accountcreator.task.Options;

import lugge.scripts.rs3.accountcreator.data.Options.WidgetsOptions;
import lugge.scripts.rs3.accountcreator.util.Interface;
import lugge.scripts.rs3.accountcreator.util.Paint;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Hud;

import java.util.concurrent.Callable;

public class ActionsOptions {
    public static void openGameSettings(ClientContext ctx) {
        Paint.setStatus("open game settings");
        ctx.hud.open(Hud.Menu.OPTIONS);
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.getComponent(WidgetsOptions.GAME_SETTINGS, ctx).visible();
            }
        }, 500, 10);
        Interface.getComponent(WidgetsOptions.GAME_SETTINGS, ctx).click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.getComponent(WidgetsOptions.DISABLE_HINTS, ctx).visible();
            }
        }, 500, 10);
    }

    public static void disableHints(ClientContext ctx) {
        Paint.setStatus("disable hints");
        Interface.getComponent(WidgetsOptions.DISABLE_HINTS, ctx).click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.varpbits.varpbit(3925) != 0;
            }
        }, 500, 10);
    }

    public static void enableLegacyLayout(ClientContext ctx) {
        Paint.setStatus("enable legacy layout");
        Interface.getComponent(WidgetsOptions.ENABLE_LEGACY_LAYOUT, ctx).click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.getComponent(WidgetsOptions.SWITCH_LEGACY, ctx).visible();
            }
        }, 500, 10);
    }

    public static void switchToLegacy(ClientContext ctx) {
        Paint.setStatus("switch to legacy layout");
        Interface.getComponent(WidgetsOptions.SWITCH_LEGACY, ctx).click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !Interface.getComponent(WidgetsOptions.SWITCH_LEGACY, ctx).visible();
            }
        }, 500, 10);
    }

    public static void closeGameSettings(ClientContext ctx) {
        Paint.setStatus("close game settings");
        Interface.getComponent(WidgetsOptions.CLOSE_GAME_SETTINGS, ctx).click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !Interface.getComponent(WidgetsOptions.CLOSE_GAME_SETTINGS, ctx).visible();
            }
        }, 500, 10);
    }
}
