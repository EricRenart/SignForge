package data.panel_elements;

import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class PanelText extends Label implements PanelElement {

    public PanelText(String text, Color c) {
        this.setText(text);
        this.setTextFill(c);
    }

    @Override
    public Point2D getPanelCoords() {
        return null;
    }
}
