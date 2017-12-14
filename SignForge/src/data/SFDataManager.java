package data;

import djf.AppTemplate;
import djf.components.AppDataComponent;
import file.SFFiles;
import gui.SFWorkspace;

public class SFDataManager implements AppDataComponent {

    AppTemplate app;
    SFFiles fileManager;

    public void SFDataManager(AppTemplate app) {
        this.app = app;
        fileManager = (SFFiles) app.getFileComponent();
    }

    @Override
    public void resetData() {

    }
}
