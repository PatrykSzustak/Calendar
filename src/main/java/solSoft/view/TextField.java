package solSoft.view;


import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TextField extends JTextField  {

    public TextField(){
        setBounds(100, 50, 200, 70);

    }

    void setDate(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String string = dateFormat.format(date);
        setText(string);
    }



}
