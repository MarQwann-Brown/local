package org.lugge.scripts.rs3.accountcreator.util;

import org.powerbot.script.rt6.ClientContext;

public class Other {
    public static void deleteString(ClientContext ctx, int length) {
        for (int i = 0; i <= length; i++) {
            ctx.input.send("\b");
        }
    }
}
