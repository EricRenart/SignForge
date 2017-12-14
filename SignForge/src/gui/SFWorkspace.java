package gui;

import data.SFDataManager;
import djf.AppTemplate;
import djf.components.AppDataComponent;
import djf.components.AppWorkspaceComponent;

public class SFWorkspace extends AppWorkspaceComponent {

    AppTemplate app;
    SFDataManager dm;

    public SFWorkspace(AppTemplate app) {
        this.app = app;
        dm = (SFDataManager) app.getDataComponent();
    }

    @Override
    public void resetLanguage() {

    }

    @Override
    public void reloadWorkspace(AppDataComponent dataComponent) {

    }
}
