package org.lugge.scripts.rs3.accountcreator.util;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;

import java.util.concurrent.Callable;

public class Teleport {
    public static boolean home(int destination, ClientContext ctx) {
        if (!ctx.widgets.component(1092, 0).visible()) {
            ctx.widgets.component(1465, 56).click();
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return ctx.widgets.component(1092, 0).visible();
                }
            }, 200, 5);
            return false;
        } else {
            ctx.widgets.component(1092, destination).click();
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return ctx.players.local().animation() != -1;
                }
            }, 200, 10);
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return ctx.players.local().animation() == -1;
                }
            }, 500, 20);
            return true;
        }
    }
}
