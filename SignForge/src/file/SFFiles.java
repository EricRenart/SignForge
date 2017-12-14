package file;

import data.SFDataManager;
import djf.AppTemplate;
import djf.components.AppDataComponent;
import djf.components.AppFileComponent;

import java.io.IOException;

public class SFFiles implements AppFileComponent {

    AppTemplate app;

    public SFFiles(AppTemplate app) {
        this.app = app;
    }

    @Override
    public void saveData(AppDataComponent data, String filePath) throws IOException {

    }

    @Override
    public void loadData(AppDataComponent data, String filePath) throws IOException {

    }

    @Override
    public void exportData(AppDataComponent data, String filePath) throws IOException {

    }

    @Override
    public void importData(AppDataComponent data, String filePath) throws IOException {

    }
}
