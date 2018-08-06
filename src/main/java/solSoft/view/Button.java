package solSoft.view;

import javax.swing.*;
import java.awt.*;


public class Button extends JButton  {


    public Button(int space){

        setBounds(space, 10, 100, 345);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
    public Button(int space,int topSpace){

        setBounds(space, topSpace, 100, 60);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }




}
