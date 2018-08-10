package solSoft;


import solSoft.view.planels.BottomPanel;
import solSoft.view.Frame;
import solSoft.view.planels.TopPanel;

public class Main {
    public static void main(String[] args) {


        Frame frame = new Frame(new TopPanel(),new BottomPanel());
        frame.setVisible(true);


    }

}
