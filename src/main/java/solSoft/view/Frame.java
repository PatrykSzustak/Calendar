package solSoft.view;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private TopPanel topPanel;
    private BottomPanel bottomPanel;


    public Frame(TopPanel topPanel, BottomPanel bottomPanel) throws HeadlessException {
        setSize(1000, 700);
        this.topPanel = topPanel;
        this.bottomPanel = bottomPanel;
        add(topPanel);
        add(bottomPanel);
        setLayout(null);
        setVisible(true);
    }
}
