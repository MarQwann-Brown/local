package org.lugge.scripts.osrs.luckyisland;

import org.lugge.scripts.osrs.luckyisland.data.Paint.PaintVariables;
import org.lugge.scripts.osrs.luckyisland.data.SuperState.SuperStateVariables;
import org.lugge.scripts.osrs.luckyisland.task.SuperState.SuperStateConditions;
import org.lugge.scripts.osrs.luckyisland.task.SuperState.SuperStatedActions;
import org.powerbot.script.*;
import org.powerbot.script.rt4.BasicQuery;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

import java.awt.*;

@Script.Manifest(name = "LuckyIsland", description = "finishes the tutorial island", properties = "client=4; topic=1;")

public class LuckyIsland extends PollingScript<ClientContext> implements PaintListener, MessageListener {

    SuperStateConditions SuperStateConditions = new SuperStateConditions(ctx);
    SuperStatedActions SuperStatedActions = new SuperStatedActions(ctx);
    SuperStateVariables SuperStateVariables = new SuperStateVariables();

    PaintVariables PaintVariables = new PaintVariables();

    @Override
    public void start() {

    }

    @Override
    public void poll() {
        if (SuperStateVariables.isRunning) {
            switch (SuperStateConditions.getSuperState()) {
                case DO_ISLAND:
                    SuperStatedActions.doIsland();
                    break;
            }
        }
    }

    @Override
    public void messaged(MessageEvent messageEvent) {
    }

    @Override
    public void repaint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.GREEN);
        g.setFont(new Font("Arial" , 10, 20));
        GameObject obstacle = ctx.objects.select().name("Door", "Gate").nearest().poll();
        Point obstaclePoint = obstacle.centerPoint();
        g.drawString(obstacle.id() + "   " + obstacle.tile(), obstaclePoint.x, obstaclePoint.y);
        GameObject interact = ctx.objects.select().name("Tree", "Fire", "Range", "Anvil", "Rock").nearest().poll();
        Point interactPoint = interact.centerPoint();
        g.drawString(interact.id() + "   " + interact.tile(), interactPoint.x, interactPoint.y);
        Condition.sleep(100);
    }
}