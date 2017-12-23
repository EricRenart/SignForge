package data.panel_elements;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Panel extends Rectangle implements PanelElement {

    public Panel(Color c) {
        super();
        this.setFill(c);
    }

    @Override
    public Point2D getPanelCoords() {
        return null;
    }
}
