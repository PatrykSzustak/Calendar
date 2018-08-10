package solSoft.view;


import solSoft.controller.Controller;
import solSoft.view.interfaces.ChangeDate;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TextField extends JTextField implements ChangeDate {

    private LocalDate currentDate = LocalDate.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public TextField() {
        setBounds(100, 50, 200, 70);

        Controller.getInstance().registerDateChange(this);

        String formattedString = currentDate.format(formatter);
        setText(formattedString);
        addActionListener(e -> {
            String input = getText();
            LocalDate localDate = LocalDate.parse(input,formatter);
            Controller.getInstance().changeDate(localDate);
        });
    }


    @Override
    public void onDateChange(LocalDate date) {
        this.currentDate = date;
        this.setText(date.format(formatter));
    }
}
