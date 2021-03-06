package solSoft.view.planels;

import solSoft.controller.ViewMode;
import solSoft.view.components.LeftButton;
import solSoft.view.components.RightButton;
import solSoft.view.components.TextField;
import solSoft.view.components.ViewModeComboBox;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class TopPanel extends JPanel {

    public TopPanel() {
        setLayout(null);
        setSize(1000, 150);
        setBackground(Color.GRAY);
        List<ViewMode> list = new ArrayList<>();
        list.addAll(asList(ViewMode.values()));
        ViewModeComboBox comboBox = new ViewModeComboBox(list);
        LeftButton leftButton = new LeftButton();
        TextField textField = new TextField();
        RightButton rightButton = new RightButton();


        add(comboBox);
        add(leftButton);
        add(rightButton);
        add(textField);
    }
}
