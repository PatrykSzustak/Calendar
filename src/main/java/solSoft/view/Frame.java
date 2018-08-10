package solSoft.view;

import solSoft.view.planels.BottomPanel;
import solSoft.view.planels.TopPanel;

import javax.swing.*;

public class Frame extends JFrame {


    public Frame(TopPanel topPanel, BottomPanel bottomPanel) {
        setSize(1000, 700);
        add(topPanel);
        add(bottomPanel);
        setLayout(null);
        setVisible(true);
    }
}
