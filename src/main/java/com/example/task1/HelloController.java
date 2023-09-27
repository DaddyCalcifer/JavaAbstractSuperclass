package com.example.task1;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    Canvas canvas;
    @FXML
    ColorPicker colorPicker, outlineColor;
    @FXML
    TextField widthInput, heightInput;
    @FXML
            Label label;
    Shape shape;
    int current_shape = 0;

    @FXML
    protected void onHelloButtonClick() {
        current_shape = 1;
    }
    @FXML
    protected void DrawEx2() {
        current_shape = 0;
    }
    @FXML
    protected void onMouseClicked(MouseEvent event)
    {
        //Shape shape = new Ellipse(Color.AQUA,10,10);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        if(current_shape == 0) {
            Ellipse ellipse = new Ellipse(colorPicker.getValue(), event.getX(), event.getY(),
                    Double.parseDouble(widthInput.getText()),
                    Double.parseDouble(heightInput.getText()));
            shape = ellipse;
        }
        if(current_shape == 1)
        {
            Rectangle rectangle=new Rectangle(colorPicker.getValue(),event.getX(),event.getY(),
                    Double.parseDouble(widthInput.getText()),
                    Double.parseDouble(heightInput.getText()));
            shape = rectangle;
        }
        label.setText(shape.toString());
        shape.setBorder(outlineColor.getValue(), 5);
        shape.draw(gc);

        System.out.println(shape.toString());
    }


}