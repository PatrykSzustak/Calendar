package solSoft.view.planels;

import solSoft.controller.Controller;
import solSoft.view.Button;
import solSoft.view.interfaces.ChangeDate;

import java.awt.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekPanel extends AbstractPanel implements ChangeDate {

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
            solSoft.view.Button button = new Button();
            button.setText(next);
            if (actualDateString.equals(next)) {
                button.setBackground(Color.GRAY);
            }
            if (map.containsKey(LocalDate.parse(next,formatter))){
                button.setBackground(Color.RED);
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
