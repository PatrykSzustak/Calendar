package solSoft.view.planels;

import solSoft.DataFormat;
import solSoft.controller.Controller;
import solSoft.view.components.Button;
import solSoft.view.interfaces.ChangeDate;

import java.awt.*;
import java.time.LocalDate;

public class MonthPanel extends AbstractPanel implements ChangeDate {


    MonthPanel() {
        Controller.getInstance().registerDateChange(this);
    }


    public String getNextDate(LocalDate date, int count) {
        LocalDate firstDayOfMonth = date.withDayOfMonth(1);
        LocalDate nextDay = firstDayOfMonth.plusDays(count);
        return nextDay.format(DataFormat.getFormatter());
    }

    void createButtonsForMonth() {
        setLayout(new GridLayout(5, 7));
        int howManyLoops = 0;
        int rows = 5;
        int columns = 7;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                String actualDateString = actualDate.format(DataFormat.getFormatter());
                howManyLoops++;
                int dayOfMonth = actualDate.lengthOfMonth();
                if (howManyLoops > dayOfMonth) break;
                Button button = new Button();
                String current = getNextDate(actualDate, j);
                button.setText(current);
                checkAndAddColor(actualDateString, button, current);
                add(button);
                buttons.add(button);
            }
        }
        revalidate();
    }


    @Override
    public int howDays() {
        return actualDate.lengthOfMonth();
    }
}
