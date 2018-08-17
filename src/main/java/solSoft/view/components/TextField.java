package solSoft.view.components;


import solSoft.DataFormat;
import solSoft.controller.Controller;
import solSoft.view.interfaces.ChangeDate;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.logging.Logger;

public class TextField extends JTextField implements ChangeDate {

    private LocalDate currentDate = LocalDate.now();

    public TextField() {
        setBounds(100, 50, 200, 70);

        Controller.getInstance().registerDateChange(this);

        String formattedString = currentDate.format(DataFormat.getFormatter());
        setText(formattedString);
        addActionListener(e -> {
            try {
                String input = getText();
                LocalDate localDate = LocalDate.parse(input, DataFormat.getFormatter());
                Controller.getInstance().changeDate(localDate);
            } catch (DateTimeParseException e1) {
                Logger.getLogger("Wrong Data");
            }
        });
    }


    @Override
    public void onDateChange(LocalDate date) {
        this.currentDate = date;
        this.setText(date.format(DataFormat.getFormatter()));
    }
}
