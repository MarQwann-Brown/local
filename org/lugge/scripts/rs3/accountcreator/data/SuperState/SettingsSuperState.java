package org.lugge.scripts.rs3.accountcreator.data.SuperState;

import org.lugge.scripts.rs3.accountcreator.util.File;

public class SettingsSuperState {
    public static void setLogfile(String FilePath, String FileName) {
        File.LOG_PATH = FilePath;
        File.LOG_NAME = FileName;
    }

    public static boolean running = false;
}
