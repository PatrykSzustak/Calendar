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

   

    public TopPanel getTopPanel() {
        return topPanel;
    }

    public void setTopPanel(TopPanel topPanel) {
        this.topPanel = topPanel;
    }

    public BottomPanel getBottomPanel() {
        return bottomPanel;
    }

    public void setBottomPanel(BottomPanel bottomPanel) {
        this.bottomPanel = bottomPanel;
    }
}
