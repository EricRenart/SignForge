package data.panel_elements;

import data.SignConstants;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Panel extends Rectangle implements PanelElement {

    Label textLine1;
    Label textLine2;
    Label textLine3;
    Label bottomText;

    public Panel(Color c) {
        super();
        this.setFill(c);
        this.setStroke(Color.WHITE);
        initText();
    }

    private void initText() {
        // init labels
        textLine1 = new Label("New Panel");
        textLine1.setFont(new Font("Roadgeek 2005 Series 4W", 16));
        textLine2 = new Label();
        textLine2.setFont(new Font("Roadgeek 2005 Series 4W", 16));
        textLine3 = new Label();
        textLine3.setFont(new Font("Roadgeek 2005 Series 4W", 16));
        bottomText = new Label();
        bottomText.setFont(new Font("Roadgeek 2005 Series 4W", 12));
    }

    public void setMainText(String text1, String text2, String text3) {
        if(!(text1 == null)) {
            textLine1.setText(text1);
        }
        if(!(text2 == null)) {
            textLine2.setText(text2);
        }
        if(!(text3 == null)) {
            textLine3.setText(text3);
        }
    }

    public void setBottomText(String bottomText) {
        if(!(bottomText == null)) {
            this.bottomText.setText(bottomText);
        }
    }

    // Getters for our text fields.

    public String getTextLine1() {
        return textLine1.getText();
    }

    public String getTextLine2() {
        return textLine2.getText();
    }

    public String getTextLine3() {
        return textLine3.getText();
    }

    public String getBottomText() {
        return bottomText.getText();
    }

    @Override
    public Point2D getPanelCoords() {
        return null;
    }
}
