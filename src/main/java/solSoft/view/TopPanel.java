package solSoft.view;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {

    private LeftButton leftButton;
    private RightButton rightButton;
    private ComboBox comboBox;
    private TextField textField;


    public TopPanel(LeftButton leftButton, RightButton rightButton, ComboBox comboBox, TextField textField) {
        setLayout(null);
        setSize(1000,200);
        setBackground(Color.GRAY);
        this.leftButton = leftButton;
        this.rightButton = rightButton;
        this.comboBox = comboBox;
        this.textField = textField;
        add(leftButton);
        add(rightButton);
        add(comboBox);
        add(textField);
    }
}
