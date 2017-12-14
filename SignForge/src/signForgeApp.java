import djf.AppTemplate;

import java.util.Locale;

public class signForgeApp extends AppTemplate {



    @Override
    public void buildAppComponentsHook() {

    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        launch(args);
    }
}
