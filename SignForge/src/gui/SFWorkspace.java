package gui;

import com.sun.javafx.scene.control.skin.ColorPalette;
import data.SFDataManager;
import djf.AppTemplate;
import djf.components.AppDataComponent;
import djf.components.AppWorkspaceComponent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import properties_manager.PropertiesManager;

import java.util.Properties;

public class SFWorkspace extends AppWorkspaceComponent {

    AppTemplate app;
    SFDataManager dm;

    // ------- left-hand toolbar boxes for non-Diagrammatic/APL configuration -------
    HBox activePanelPane;
    GridPane signTypePane; // 1x2, 1st row length 2
    GridPane routeShieldsPane; // 5x4, 1st row length 5
    HBox exitTabPane;
    VBox signTextPane;
    VBox bottomTextPane;
    GridPane arrowPane; // 3x2
    HBox fontPane;
    FlowPane miscButtonsPane; // this is for miscellaneous buttons such as adding a custom image to a panel, supports, background

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
        initToolbarControls();
        linkToolbarControls();
    }

    // GUI HELPER METHODS

    public void initToolbarControls() {
        activePanelLabel = new Label("Active Panel");
        panelSelector = new ComboBox();
        addPanelButton = initGraphicalButton("plus.png");
        removePanelButton = initGraphicalButton("minus.png");

        signTypeLabel = new Label("Sign Type");
        signTypeSelector = new ComboBox();
        signColorSelector = new ComboBox();
    }

    public void linkToolbarControls() {

    }

    private Button initTextButton(String text) {
        return new Button(text);
    }

    private Button initGraphicalButton(String imagePath) {
        PropertiesManager pm = PropertiesManager.getPropertiesManager();
        String iconsPath = pm.getProperty("APP_PATH_ICON_IMAGES");
        Image img = new Image("file:///"+iconsPath+imagePath);
        ImageView imgView = new ImageView(img);
        Button graphicalButton = new Button();
        graphicalButton.setGraphic(imgView);
        return graphicalButton;
    }


    @Override
    public void resetLanguage() {

    }

    @Override
    public void reloadWorkspace(AppDataComponent dataComponent) {

    }
}
