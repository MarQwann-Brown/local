package lugge.scripts.rs3.accountcreator;

import lugge.scripts.rs3.accountcreator.data.SuperState.SettingsSuperState;
import lugge.scripts.rs3.accountcreator.task.SuperState.ActionsSuperState;
import lugge.scripts.rs3.accountcreator.task.SuperState.ConditionsSuperState;
import lugge.scripts.rs3.accountcreator.util.File;
import lugge.scripts.rs3.accountcreator.util.Gui;
import lugge.scripts.rs3.accountcreator.util.Paint;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt6.ClientContext;

import javax.swing.*;
import java.awt.*;

@Script.Manifest(name = "Accountcreator", description = "creates accounts", properties = "client=6; topic=1;")

public class Accountcreator extends PollingScript<ClientContext> implements PaintListener {
    @Override
    public void start() {
        ctx.properties.put("login.disable", "true");

        Paint.setStatus("Script Started");
        File.writeLog("Script Started");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gui("Settings");
            }
        });

        SettingsSuperState.setLogfile(getStorageDirectory().getPath(), getName() + ".txt");
    }

    @Override
    public void poll() {
        if (SettingsSuperState.running) {
            switch (ConditionsSuperState.getSuperState(ctx)) {
                case CREATE_ACCOUNT:
                    Paint.setSuperStatus("CREATE ACCOUNT");
                    ActionsSuperState.createAccount(ctx);
                    break;
                case CHANGE_OPTIONS:
                    Paint.setSuperStatus("CHANGE OPTIONS");
                    ActionsSuperState.changeOptions(ctx);
                    break;
                case PLACE_ACCOUNT:
                    Paint.setSuperStatus("PLACE ACCOUNT");
                    ActionsSuperState.placeAccount(ctx);
                    break;
                case NULL:
                    break;
            }
        }
    }

    @Override
    public void repaint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        Paint.drawMouse(g, ctx.input.getLocation());
        g.setFont(Paint.MAIN_FONT);
        if (Paint.status != null) {
            g.drawString(Paint.status, 0, 375);
        }
        if (Paint.superStatus != null) {
            g.drawString(Paint.superStatus, 0, 350);
        }
    }
}