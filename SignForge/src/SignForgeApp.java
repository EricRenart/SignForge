import data.SFDataManager;
import djf.AppTemplate;
import file.SFFiles;
import gui.SFWorkspace;

import java.util.Locale;

public class SignForgeApp extends AppTemplate {


    @Override
    public void buildAppComponentsHook() {
        fileComponent = new SFFiles(this);
        dataComponent = new SFDataManager(this);
        workspaceComponent = new SFWorkspace(this);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        launch(args);
    }
}
