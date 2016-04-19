package org.lugge.scripts.rs3.accountcreator.task.Creation;

import org.lugge.scripts.rs3.accountcreator.data.Creation.*;
import org.lugge.scripts.rs3.accountcreator.util.File;
import org.lugge.scripts.rs3.accountcreator.util.Interface;
import org.lugge.scripts.rs3.accountcreator.util.Other;
import org.lugge.scripts.rs3.accountcreator.util.Paint;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Hud;

import java.util.concurrent.Callable;

public class ActionsCreation {
    public static void startCreation(ClientContext ctx) {
        File.writeLog("script started");
        Paint.setStatus("start account creation");
        File.writeLog("start account creation: " + (VariablesCreation.accountsCreated + 1));
        Interface.getComponent(WidgetsCreation.CREATE_ACCOUNT, ctx).click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.game.clientState() == -1;
            }
        }, 500, 10);
    }

    public static void selectGender(ClientContext ctx, GenderCreation gender) {
        switch (gender) {
            case MALE:
                Paint.setStatus("select male");
                Interface.getComponent(WidgetsCreation.SELECT_MALE, ctx).click();
                Interface.waitWidgetVisible(WidgetsCreation.SELECT_MALE, ctx);
                break;
            case FEMALE:
                Paint.setStatus("select male");
                Interface.getComponent(WidgetsCreation.SELECT_FEMALE, ctx).click();
                Interface.waitWidgetVisible(WidgetsCreation.SELECT_FEMALE, ctx);
                break;
        }
    }

    public static void finishDesign(ClientContext ctx) {
        Paint.setStatus("finish design");
        Interface.getComponent(WidgetsCreation.DESIGN_DONE, ctx).click();
        Interface.waitWidgetVisible(WidgetsCreation.RANDOMISE_NAME, ctx);
    }

    public static void randomiseName(ClientContext ctx) {
        Paint.setStatus("randomise name");
        Interface.getComponent(WidgetsCreation.RANDOMISE_NAME, ctx).click();
        Interface.waitValidCheckBox(WidgetsCreation.VALID_NAME, ctx);
    }

    public static void enterName(ClientContext ctx) {
        Paint.setStatus("enter name");
        Interface.getComponent(WidgetsCreation.NAME_FIELD, ctx).click();
        String name = SettingsCreation.NAME + (SettingsCreation.EXTENSION_BASE + VariablesCreation.extension);
        ctx.input.send(name);
        Interface.waitValidCheckBox(WidgetsCreation.VALID_NAME, ctx);
    }

    public static void deleteName(ClientContext ctx) {
        Paint.setStatus("delete name");
        String name = SettingsCreation.NAME + SettingsCreation.EXTENSION_BASE + VariablesCreation.extension;
        Other.deleteString(ctx, name.length());
        Interface.waitText(WidgetsCreation.NAME_FIELD, false, ctx);
    }

    public static void enterAge(ClientContext ctx) {
        Paint.setStatus("enter age");
        Interface.getComponent(WidgetsCreation.AGE_FIELD, ctx).click();
        ctx.input.send("" + Random.nextInt(SettingsCreation.MIN_AGE, SettingsCreation.MAX_AGE));
        Interface.waitValidCheckBox(WidgetsCreation.VALID_AGE, ctx);
    }

    public static void deleteAge(ClientContext ctx) {
        Paint.setStatus("delete age");
        Other.deleteString(ctx, 2);
        Interface.waitText(WidgetsCreation.AGE_FIELD, false, ctx);
    }

    public static void enterEmail(ClientContext ctx) {
        Paint.setStatus("enter email");
        Interface.getComponent(WidgetsCreation.EMAIL_FIELD, ctx).click();
        String email = SettingsCreation.E_MAIL + "+" + (SettingsCreation.EXTENSION_BASE + VariablesCreation.extension) + "@" + SettingsCreation.DOMAIN;
        ctx.input.send(email);
        Interface.waitValidCheckBox(WidgetsCreation.VALID_EMAIL, ctx);
    }

    public static void deleteEmail(ClientContext ctx) {
        Paint.setStatus("delete email");
        String email = SettingsCreation.E_MAIL + "+" + (SettingsCreation.EXTENSION_BASE + VariablesCreation.extension) + "@" + SettingsCreation.DOMAIN;
        Other.deleteString(ctx, email.length());
        Interface.waitText(WidgetsCreation.EMAIL_FIELD, false, ctx);
    }

    public static void enterPassword(ClientContext ctx) {
        Paint.setStatus("enter password");
        Interface.getComponent(WidgetsCreation.PASSWORD_FIELD, ctx).click();
        ctx.input.send(SettingsCreation.PASSWORD);
        Interface.waitValidCheckBox(WidgetsCreation.VALID_PASSWORD, ctx);
    }

    public static void deletePassword(ClientContext ctx) {
        Paint.setStatus("delete password");
        Other.deleteString(ctx, SettingsCreation.PASSWORD.length());
        Interface.waitText(WidgetsCreation.PASSWORD_FIELD, false, ctx);
    }

    public static void finishCreation(ClientContext ctx) {
        Paint.setStatus("finish creation");
        Interface.getComponent(WidgetsCreation.ENLIST_DONE, ctx).click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.game.clientState() != -1;
            }
        }, 500, 10);
    }

    public static void skipCutScene(ClientContext ctx) {
        Paint.setStatus("skip cut scene");
        Interface.getComponent(WidgetsCreation.SKIP_CUT_SCENE, ctx).click();
        Interface.waitWidgetVisible(WidgetsCreation.ARRIVED, ctx);
    }

    public static void skipTutorial(ClientContext ctx) {
        Paint.setStatus("skip tutorial");
        ctx.hud.open(Hud.Menu.OPTIONS);
        Interface.waitWidgetVisible(WidgetsCreation.SKIP_TUTORIAL, ctx);
        Interface.getComponent(WidgetsCreation.SKIP_TUTORIAL, ctx).click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.chat.canContinue();
            }
        }, 500, 10);
        ctx.chat.clickContinue();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.chat.select().text("Yes.").poll().valid();
            }
        }, 500, 10);
        ctx.chat.select().text("Yes.").poll().select(true);
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.players.local().tile() == TilesCreation.SPAWN_POINT.getTile();
            }
        }, 500, 10);
    }

    public static void endScript(ClientContext ctx) {
        Paint.setStatus("end script");
        File.writeLog("end script: " + VariablesCreation.accountsCreated);
        ctx.game.logout(false);
        ctx.controller.stop();
    }
}