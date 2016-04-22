package lugge.scripts.rs3.accountcreator.task.Creation;

public enum StatesCreation {
    START_CREATION,

    SELECT_GENDER,
    FINISH_DESIGN,

    RANDOMISE_NAME,
    ENTER_NAME,
    DELETE_NAME,
    ENTER_AGE,
    DELETE_AGE,
    ENTER_EMAIL,
    DELETE_EMAIL,
    ENTER_PASSWORD,
    DELETE_PASSWORD,
    FINISH_CREATION,

    SKIP_CUT_SCENE,
    SKIP_TUTORIAL,

    END_SCRIPT,

    NULL
}
