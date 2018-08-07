package solSoft.view;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatePicker extends JPanel {

    private DateListener dateListener;

    private Date currentDate = new Date();

    public DatePicker() {

        setSize(400, 200);
        setLayout(null);
        setBackground(Color.GRAY);

        LeftButton leftButton = new LeftButton();
        TextField textField = new TextField();
        textField.setDate(currentDate);
        RightButton rightButton = new RightButton();

        leftButton.addActionListener(e -> {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(currentDate);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            currentDate = calendar.getTime();
            textField.setDate(currentDate);
            dateListener.onDateChange(currentDate);
        });

        rightButton.addActionListener(e -> {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(currentDate);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            currentDate = calendar.getTime();
            textField.setDate(currentDate);
            dateListener.onDateChange(currentDate);
        });

        textField.addActionListener(e -> {
            String input = textField.getText();

            Calendar calendar = new GregorianCalendar();
            try {
                Date dateFormat = new SimpleDateFormat("dd/MM/yyyy").parse(input);
                calendar.setTime(dateFormat);
                currentDate = calendar.getTime();
                textField.setDate(currentDate);
                dateListener.onDateChange(currentDate);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        });

        add(leftButton);
        add(textField);
        add(rightButton);

    }

    public void setDateListener(DateListener dateListener) {
        this.dateListener = dateListener;
    }


}
