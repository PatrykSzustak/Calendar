package solSoft.view;

import solSoft.controller.Controller;

import java.awt.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WeekPanel extends AbstractPanel implements ChangeDate {

    private LocalDate actualDate;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public WeekPanel() {

        Controller.getInstance().registerDateChange(this);

    }

    public void createButtonsForWeek(LocalDate date) {
        removeAll();
        setLayout(new GridLayout(1, 7));

        int count = 0;
        for (int i = 0; i <= 6; i++) {

            String actualDateString = date.format(formatter);

            LocalDate firstDateOfWeek = date.with(DayOfWeek.MONDAY);
            LocalDate nextDay = firstDateOfWeek.plusDays(count);
            String next = nextDay.format(formatter);
            Button button = new Button();
            button.setText(next);
            if (actualDateString.equals(next)) {
                button.setBackground(Color.GRAY);
            }
            add(button);
            count++;
        }
        revalidate();
    }

    @Override
    public void onDateChange(LocalDate date) {
        this.actualDate = date;
        createButtonsForWeek(date);
    }
}
