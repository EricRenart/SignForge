package data;

import data.panel_elements.PanelElement;
import djf.AppTemplate;
import djf.components.AppDataComponent;
import file.SFFiles;
import gui.SFWorkspace;

public class SFDataManager implements AppDataComponent {

    AppTemplate app;
    SFFiles fileManager;

    // THE CURRENTLY LOADED SIGN
    Sign sign;

    // NEW ELEMENT TO ADD
    PanelElement newElement;

    // CURRENTLY SELECTED ELEMENT
    PanelElement selectedElement;

    // STATE OF THE DATA MANAGER
    DataState state;

    public SFDataManager(AppTemplate app) {
        this.app = app;
        fileManager = (SFFiles) app.getFileComponent();
    }

    @Override
    public void resetData() {

    }
}
