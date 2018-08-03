package solSoft;


import solSoft.view.*;

public class Main {
    public static void main(String[] args) {


        Frame frame = new Frame(new TopPanel(new LeftButton(), new RightButton(), new ComboBox(), new TextField()));

        BottomPanel bottomPanel = new BottomPanel();
        frame.add(bottomPanel);
        bottomPanel.create7Fields();
//        bottomPanel.create35Buttons();
        frame.setVisible(true);

    }

}
