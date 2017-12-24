package gui;

import com.sun.javafx.scene.control.skin.ColorPalette;
import data.SFDataManager;
import djf.AppTemplate;
import djf.components.AppDataComponent;
import djf.components.AppWorkspaceComponent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import properties_manager.PropertiesManager;

import java.util.Properties;

import static djf.language.AppLanguageSettings.FILE_PROTOCOL;

public class SFWorkspace extends AppWorkspaceComponent {

    AppTemplate app;
    SFDataManager dm;

    // CANVAS FOR EDITING
    SFCanvas canvas;

    VBox sidebarControls;

    // ------- left-hand toolbar boxes for non-Diagrammatic/APL configuration -------
    HBox activePanelPane;
    GridPane signTypePane; // 1x2, 1st row length 2
    GridPane routeShieldsPane; // 5x4, 1st row length 5
    HBox exitTabPane;
    VBox signTextPane;
    VBox bottomTextPane;
    GridPane arrowPane; // 3x2
    HBox fontPane;
    HBox miscButtonsPane; // this is for miscellaneous buttons such as adding a custom image to a panel, supports, background

    // ------- ui elements that will go into each pane -------
    // Active Panel Pane
    Label activePanelLabel;
    ComboBox panelSelector;
    Button addPanelButton;
    Button removePanelButton;

    // Sign Type Pane
    Label signTypeLabel;
    ComboBox signTypeSelector;
    ComboBox signColorSelector;

    // Route Shields Pane
    Label routeShieldsLabel;
    Label toLabel1, toLabel2, toLabel3, toLabel4;
    CheckBox toCheckbox1, toCheckbox2, toCheckbox3, toCheckbox4;
    ComboBox directionSelector1, directionSelector2, directionSelector3, directionSelector4;
    ComboBox shieldTypeSelector1, shieldTypeSelector2, shieldTypeSelector3, shieldTypeSelector4;
    TextField routeNumField1, routeNumField2, routeNumField3, routeNumField4;

    // Exit Tab Pane
    CheckBox isLeftExitCheckBox;
    Label leftLabel;
    CheckBox exitTabToggleCheckbox;
    Label exitLabel;
    TextField exitNumField;

    // Sign Text Pane
    Label signTextLabel;
    TextField signTextLine1Field;
    TextField signTextLine2Field;
    TextField signTextLine3Field;

    // Bottom Text Pane
    Label bottomTextLabel;
    TextField bottomTextField;

    // Arrow Type Pane
    Label arrowTypeLabel;
    CheckBox exitOnlyCheckbox;
    Label exitOnlyLabel;
    ComboBox arrowTypeSelector;
    ComboBox arrowNumOfLanesSelector;
    Label arrowNumOfLanesLabel;

    // Font Pane
    Label fontLabel;
    ComboBox fontSelector;

    // Misc Buttons Pane
    Button addCustomImageButton;
    Button setSupportsTypeButton;
    Button setBackgroundButton;

    public SFWorkspace(AppTemplate app) {
        this.app = app;
        dm = (SFDataManager) app.getDataComponent();

        // THESE METHODS MUST BE CALLED IN THE CORRECT ORDER IN ORDER TO PROPERLY INIT THE GUI
        initToolbarControls();
        initCanvas();
        setGridPaneCoords();
        linkToolbarControls();
        addControlsToToolbar();
        applyCssStylesheet();
        initAppPane();
    }

    // GUI HELPER METHODS

    private void initCanvas() {
        canvas = new SFCanvas();

    }

    private void initAppPane() {
        workspace = new BorderPane();
        ((BorderPane)workspace).setLeft(sidebarControls);
        ((BorderPane)workspace).setCenter(canvas);
    }

    private void initToolbarControls() {
        activePanelPane = new HBox();
        activePanelLabel = new Label("Active Panel");
        panelSelector = new ComboBox();
        addPanelButton = initGraphicalButton("plus.png");
        removePanelButton = initGraphicalButton("minus.png");

        signTypePane = new GridPane();
        signTypeLabel = new Label("Sign Type");
        signTypeSelector = new ComboBox();
        signColorSelector = new ComboBox();

        routeShieldsPane = new GridPane();
        routeShieldsLabel = new Label("Route Shields");
        toLabel1 = new Label("To");
        toLabel2 = new Label("To");
        toLabel3 = new Label("To");
        toLabel4 = new Label("To");
        toCheckbox1 = new CheckBox();
        toCheckbox2 = new CheckBox();
        toCheckbox3 = new CheckBox();
        toCheckbox4 = new CheckBox();
        directionSelector1 = new ComboBox();
        directionSelector2 = new ComboBox();
        directionSelector3 = new ComboBox();
        directionSelector4 = new ComboBox();
        shieldTypeSelector1 = new ComboBox();
        shieldTypeSelector2 = new ComboBox();
        shieldTypeSelector3 = new ComboBox();
        shieldTypeSelector4 = new ComboBox();
        routeNumField1 = new TextField();
        routeNumField2 = new TextField();
        routeNumField3 = new TextField();
        routeNumField4 = new TextField();

        exitTabPane = new HBox();
        leftLabel = new Label("Left");
        isLeftExitCheckBox = new CheckBox();
        exitLabel = new Label("Exit");
        exitTabToggleCheckbox = new CheckBox();
        exitNumField = new TextField();

        signTextPane = new VBox();
        signTextLabel = new Label("Destinations/Messages");
        signTextLine1Field = new TextField();
        signTextLine2Field = new TextField();
        signTextLine3Field = new TextField();

        bottomTextPane = new VBox();
        bottomTextLabel = new Label("Bottom Text");
        bottomTextField = new TextField();

        arrowPane = new GridPane();
        arrowTypeLabel = new Label("Arrow Type");
        exitOnlyCheckbox = new CheckBox();
        exitOnlyLabel = new Label("Exit Only");
        arrowTypeSelector = new ComboBox();
        arrowNumOfLanesSelector = new ComboBox();
        arrowNumOfLanesLabel = new Label("lanes");

        fontPane = new HBox();
        fontLabel = new Label("Font");
        fontSelector = new ComboBox();

        miscButtonsPane = new HBox();
        addCustomImageButton = initTextButton("Add Custom Image");
        setSupportsTypeButton = initTextButton("Set Supports");
        setBackgroundButton = initTextButton("Set Background");
    }

    private void linkToolbarControls() {

    }

    private Button initTextButton(String text) {
        return new Button(text);
    }

    private Button initGraphicalButton(String imagePath) {
        PropertiesManager pm = PropertiesManager.getPropertiesManager();
        String iconsPath = pm.getProperty("APP_PATH_ICON_IMAGES");
        String fullPath = FILE_PROTOCOL+iconsPath+imagePath;
        Image img = new Image(fullPath);
        ImageView imgView = new ImageView(img);
        Button graphicalButton = new Button();
        graphicalButton.setGraphic(imgView);
        return graphicalButton;
    }

    private void setGridPaneCoords() {
        GridPane.setConstraints(activePanelLabel,0,0,1,1);
        GridPane.setConstraints(panelSelector, 1,0,1,1);
        GridPane.setConstraints(addPanelButton, 2,0,1,1);
        GridPane.setConstraints(removePanelButton, 3,0,1,1);

        GridPane.setConstraints(signTypeLabel,0,0,2,1);
        GridPane.setConstraints(signTypeSelector,0,1,1,1);
        GridPane.setConstraints(signColorSelector,0,2,1,1);

        GridPane.setConstraints(routeShieldsLabel,0,0,5,1);
        GridPane.setConstraints(toCheckbox1,0,1,1,1);
        GridPane.setConstraints(toCheckbox2,0,2,1,1);
        GridPane.setConstraints(toCheckbox3,0,3,1,1);
        GridPane.setConstraints(toCheckbox4,0,4,1,1);
        GridPane.setConstraints(toLabel1,1,1,1,1);
        GridPane.setConstraints(toLabel2,1,2,1,1);
        GridPane.setConstraints(toLabel3,1,3,1,1);
        GridPane.setConstraints(toLabel4,1,4,1,1);
        GridPane.setConstraints(directionSelector1,2,1,1,1);
        GridPane.setConstraints(directionSelector2,2,2,1,1);
        GridPane.setConstraints(directionSelector3,2,3,1,1);
        GridPane.setConstraints(directionSelector4,2,4,1,1);
        GridPane.setConstraints(shieldTypeSelector1,3,1,1,1);
        GridPane.setConstraints(shieldTypeSelector2,3,2,1,1);
        GridPane.setConstraints(shieldTypeSelector3,3,3,1,1);
        GridPane.setConstraints(shieldTypeSelector4,3,4,1,1);
        GridPane.setConstraints(routeNumField1,4,1,1,1);
        GridPane.setConstraints(routeNumField2,4,2,1,1);
        GridPane.setConstraints(routeNumField3,4,3,1,1);
        GridPane.setConstraints(routeNumField4,4,4,1,1);

        GridPane.setConstraints(arrowTypeLabel,0,0,1,1);
        GridPane.setConstraints(exitOnlyCheckbox,1,0,1,1);
        GridPane.setConstraints(exitOnlyLabel,2,0,1,1);
        GridPane.setConstraints(arrowTypeSelector,0,1,1,1);
        GridPane.setConstraints(arrowNumOfLanesSelector,1,1,1,1);
        GridPane.setConstraints(arrowNumOfLanesLabel,2,1,1,1);

    }

    private void addControlsToToolbar() {
        sidebarControls = new VBox();
        activePanelPane.getChildren().addAll(activePanelLabel,panelSelector,addPanelButton,removePanelButton);
        signTypePane.getChildren().addAll(signTypeLabel,signTypeSelector,signColorSelector);
        routeShieldsPane.getChildren().addAll(routeShieldsLabel,toLabel1,toCheckbox1,directionSelector1,
                shieldTypeSelector1,routeNumField1,toLabel2,toCheckbox2,directionSelector2,shieldTypeSelector2,
                routeNumField2,toLabel3,toCheckbox3,directionSelector3,shieldTypeSelector3,routeNumField3,
                toLabel4,toCheckbox4,directionSelector4,shieldTypeSelector4,routeNumField4);
        exitTabPane.getChildren().addAll(leftLabel,isLeftExitCheckBox,exitLabel,exitTabToggleCheckbox,exitNumField);
        signTextPane.getChildren().addAll(signTextLabel,signTextLine1Field,signTextLine2Field,signTextLine3Field);
        bottomTextPane.getChildren().addAll(bottomTextLabel,bottomTextField);
        arrowPane.getChildren().addAll(arrowTypeLabel,exitOnlyCheckbox,exitOnlyLabel,
                arrowTypeSelector,arrowNumOfLanesSelector,arrowNumOfLanesLabel);
        fontPane.getChildren().addAll(fontLabel,fontSelector);
        miscButtonsPane.getChildren().addAll(addCustomImageButton,setSupportsTypeButton,setBackgroundButton);

        sidebarControls.getChildren().addAll(activePanelPane,signTypePane,routeShieldsPane,exitTabPane,
                signTextPane,bottomTextPane,arrowPane,fontPane,miscButtonsPane);
    }

    private void applyCssStylesheet() {
        sidebarControls.getStyleClass().add("edit_toolbar_bg");
        activePanelPane.getStyleClass().add("bordered_pane");
        activePanelLabel.getStyleClass().add("edit_toolbar_text");

        signTypePane.getStyleClass().add("bordered_pane");
        signTypeLabel.getStyleClass().add("edit_toolbar_text");

        routeShieldsPane.getStyleClass().add("bordered_pane");
        routeShieldsLabel.getStyleClass().add("edit_toolbar_text");

        exitTabPane.getStyleClass().add("bordered_pane");
        leftLabel.getStyleClass().add("edit_toolbar_text");
        exitLabel.getStyleClass().add("edit_toolbar_text");

        signTextPane.getStyleClass().add("bordered_pane");
        signTextLabel.getStyleClass().add("edit_toolbar_text");

        bottomTextPane.getStyleClass().add("bordered_pane");
        bottomTextLabel.getStyleClass().add("edit_toolbar_text");

        arrowPane.getStyleClass().add("bordered_pane");
        arrowTypeLabel.getStyleClass().add("edit_toolbar_text");
        exitOnlyLabel.getStyleClass().add("edit_toolbar_text");
        arrowNumOfLanesLabel.getStyleClass().add("edit_toolbar_text");

        fontPane.getStyleClass().add("bordered_pane");
        fontLabel.getStyleClass().add("edit_toolbar_text");

        miscButtonsPane.getStyleClass().add("bordered_pane");
    }

    public void activateMainWorkspace() {
        app.getWorkspaceComponent().activateWorkspace((BorderPane)workspace);
    }

    public void reloadComboboxes() {

    }


    @Override
    public void resetLanguage() {

    }

    @Override
    public void reloadWorkspace(AppDataComponent dataComponent) {

    }
}
