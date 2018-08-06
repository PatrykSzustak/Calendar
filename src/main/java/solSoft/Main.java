package solSoft;


import solSoft.controller.Controller;
import solSoft.view.BottomPanel;
import solSoft.view.Frame;
import solSoft.view.TopPanel;

import java.util.Date;

public class Main {
    public static void main(String[] args) {


        BottomPanel bottomPanel = new BottomPanel();
        bottomPanel.create7Buttons(new Date());

        Controller controller = new Controller(bottomPanel);


        Frame frame = new Frame(new TopPanel(controller),bottomPanel);
        frame.add(bottomPanel);
        frame.setVisible(true);

    }

}
