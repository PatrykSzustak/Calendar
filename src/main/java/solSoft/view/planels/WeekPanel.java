package solSoft.view.planels;

import solSoft.NoteService;
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


    public String getNextDate(LocalDate date, int count) {
        LocalDate firstDateOfWeek = date.with(DayOfWeek.MONDAY);
        LocalDate nextDay = firstDateOfWeek.plusDays(count);
        return nextDay.format(formatter);
    }

    public void createButtonsForWeek() {
        setLayout(new GridLayout(1, 7));
        for (int i = 0; i <= 6; i++) {
            Button button = new Button();
            String actualDateString = actualDate.format(formatter);
            LocalDate firstDateOfWeek = actualDate.with(DayOfWeek.MONDAY);
            LocalDate nextDay = firstDateOfWeek.plusDays(i);
            String next = nextDay.format(formatter);
            button.setText(next);
            if (actualDateString.equals(next)) {
                button.setBackground(Color.GRAY);
            }
            add(button);
            buttons.add(button);
        }
        revalidate();
    }


    @Override
    public int howDays() {
        return 7;
    }

}
