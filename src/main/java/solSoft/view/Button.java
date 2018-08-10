package solSoft.view;

import solSoft.controller.Controller;
import solSoft.view.interfaces.ChangeDate;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Button extends JButton implements ChangeDate {

    private LocalDate actualDate;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Button() {
        setBounds(0, 10, 100, 345);
        setBorder(BorderFactory.createLineBorder(Color.black));
        Controller.getInstance().registerDateChange(this);

        addActionListener(e -> {
            String input = getText();
            LocalDate localDate = LocalDate.parse(input, formatter);
            Controller.getInstance().changeDate(localDate);

        });

    }


    @Override
    public void onDateChange(LocalDate date) {
        this.actualDate = date;
    }
}
