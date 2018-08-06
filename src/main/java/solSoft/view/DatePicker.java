package solSoft.view;

import javax.swing.*;
import java.awt.*;

public class DatePicker extends JPanel {

    private DateListener dateListener;

    public DatePicker(){

        setSize(400, 200);
        setLayout(null);
        setBackground(Color.GRAY);

        LeftButton leftButton = new LeftButton();
        TextField textField = new TextField();
        RightButton rightButton = new RightButton();


        add(leftButton);
        add(textField);
        add(rightButton);
    }
}
