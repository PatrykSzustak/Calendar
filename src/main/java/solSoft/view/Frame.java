package solSoft.view;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {


    private TopPanel topPanel;
    private BottomPanel bottomPanel;
//    private TextField textField;
//    private LeftButton leftButton;
//    private RightButton rightButton;
//    private ComboBox comboBox;

    /*public Frame(TopPanel topPanel, TextField textField, LeftButton leftButton, RightButton rightButton, ComboBox comboBox) throws HeadlessException {
        setSize(800,600);
        this.topPanel = topPanel;
        add(topPanel);
        setLayout(null);
        setVisible(true);
    }*/

    public Frame(TopPanel topPanel,BottomPanel bottomPanel) throws HeadlessException {
        setSize(1000,800);
        this.topPanel = topPanel;
        this.bottomPanel=bottomPanel;
        add(topPanel);
        add(bottomPanel);
        setLayout(null);
        setVisible(true);
    }

    public Frame (TopPanel topPanel){
        setSize(1000,600);
        this.topPanel = topPanel;
        add(topPanel);
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
