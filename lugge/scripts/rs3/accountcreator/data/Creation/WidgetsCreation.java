package lugge.scripts.rs3.accountcreator.data.Creation;

public enum WidgetsCreation {
    CREATE_ACCOUNT(596, 96, -1),

    SELECT_MALE(1420, 179, -1),
    SELECT_FEMALE(1420, 178, -1),
    DESIGN_DONE(1420, 470, -1),

    RANDOMISE_NAME(1420, 302, -1),
    NAME_FIELD(1420, 272, -1),
    VALID_NAME(1420, 79, -1),
    AGE_FIELD(1420, 265, -1),
    VALID_AGE(1420, 77, -1),
    EMAIL_FIELD(1420, 5, -1),
    VALID_EMAIL(1420, 75, -1),
    EMAIL_IN_USE(1420, 315, -1),
    PASSWORD_FIELD(1420, 258, -1),
    VALID_PASSWORD(1420, 73, -1),
    ENLIST_DONE(1420, 470, -1),

    SKIP_CUT_SCENE(548, 8, -1),
    ARRIVED(669, 17, 1),
    SKIP_TUTORIAL(1433, 135, -1);

    private final int widgetID;
    private final int componentID;
    private final int childID;

    WidgetsCreation(int widgetID, int componentID, int childID) {
        this.widgetID = widgetID;
        this.componentID = componentID;
        this.childID = childID;
    }

    public int getWidgetId() {
        return this.widgetID;
    }

    public int getComponentId() {
        return this.componentID;
    }

    public int getChildID() {
        return this.childID;
    }
}