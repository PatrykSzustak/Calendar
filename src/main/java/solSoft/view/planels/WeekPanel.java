package solSoft.view.planels;

import solSoft.DataFormat;
import solSoft.controller.Controller;
import solSoft.view.components.Button;
import solSoft.view.interfaces.ChangeDate;

import java.awt.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekPanel extends AbstractPanel implements ChangeDate {


    WeekPanel() {
        Controller.getInstance().registerDateChange(this);
    }


    public String getNextDate(LocalDate date, int count) {
        LocalDate firstDateOfWeek = date.with(DayOfWeek.MONDAY);
        LocalDate nextDay = firstDateOfWeek.plusDays(count);
        return nextDay.format(DataFormat.getFormatter());
    }

    void createButtonsForWeek() {
        setLayout(new GridLayout(1, 7));
        for (int i = 0; i <= 6; i++) {
            Button button = new Button();
            String actualDateString = actualDate.format(DataFormat.getFormatter());
            LocalDate firstDateOfWeek = actualDate.with(DayOfWeek.MONDAY);
            LocalDate nextDay = firstDateOfWeek.plusDays(i);
            String current = nextDay.format(DataFormat.getFormatter());
            button.setText(current);
            checkAndAddColor(actualDateString, button, current);
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
