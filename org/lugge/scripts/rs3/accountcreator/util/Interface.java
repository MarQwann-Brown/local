package org.lugge.scripts.rs3.accountcreator.util;

import org.lugge.scripts.rs3.accountcreator.data.Creation.WidgetsCreation;
import org.lugge.scripts.rs3.accountcreator.data.Options.WidgetsOptions;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;

import java.util.concurrent.Callable;

public class Interface {
    public static Component getComponent(WidgetsCreation widget, ClientContext ctx) {
        if (widget.getChildID() == -1) {
            return ctx.widgets.component(widget.getWidgetId(), widget.getComponentId());
        } else {
            return ctx.widgets.component(widget.getWidgetId(), widget.getComponentId()).component(widget.getChildID());
        }
    }

    public static Component getComponent(WidgetsOptions widget, ClientContext ctx) {
        if (widget.getChildID() == -1) {
            return ctx.widgets.component(widget.getWidgetId(), widget.getComponentId());
        } else {
            return ctx.widgets.component(widget.getWidgetId(), widget.getComponentId()).component(widget.getChildID());
        }
    }

    public enum checkBox {
        VALID,
        INVALID,
        UNKNOWN,
        NULL
    }

    public static checkBox checkBoxes(WidgetsCreation widget, ClientContext ctx) {
        switch (getComponent(widget, ctx).textureId()) {
            case 19716:
                return checkBox.VALID;
            case 19717:
                return checkBox.INVALID;
            case 19718:
                return checkBox.UNKNOWN;
        }
        return checkBox.NULL;
    }

    public static boolean waitValidCheckBox(WidgetsCreation widget, ClientContext ctx) {
        return Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.checkBoxes(widget, ctx) != Interface.checkBox.UNKNOWN;
            }
        }, 500, 10);
    }

    public static boolean waitText(WidgetsCreation widget, boolean textValid, ClientContext ctx) {
        if (textValid) {
            return Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return !Interface.getComponent(widget, ctx).text().isEmpty();
                }
            }, 500, 10);
        }else {
            return Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return Interface.getComponent(widget, ctx).text().isEmpty();
                }
            }, 500, 10);
        }
    }

    public static boolean waitWidgetVisible(WidgetsCreation widget, ClientContext ctx) {
        return Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.getComponent(widget, ctx).visible();
            }
        }, 500, 10);
    }

    public static boolean waitWidgetVisible(WidgetsOptions widget, ClientContext ctx) {
        return Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.getComponent(widget, ctx).visible();
            }
        }, 500, 10);
    }
}
