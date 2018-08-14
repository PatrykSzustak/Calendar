package solSoft.view.planels;

import solSoft.controller.Controller;
import solSoft.view.Button;
import solSoft.view.interfaces.ChangeDate;

import java.awt.*;
import java.time.LocalDate;

public class MonthPanel extends AbstractPanel implements ChangeDate {


    public MonthPanel() {
        Controller.getInstance().registerDateChange(this);
    }


    public String getNextDate(LocalDate date, int count) {
        LocalDate firstDayOfMonth = date.withDayOfMonth(1);
        LocalDate nextDay = firstDayOfMonth.plusDays(count);
        return nextDay.format(formatter);
    }

    public void createButtonsForMonth() {
        setLayout(new GridLayout(5, 7));
        int howLoop = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 7; j++) {
                String actualDateString = actualDate.format(formatter);
                howLoop++;
                int dayOfMonth = actualDate.lengthOfMonth();
                if (howLoop > dayOfMonth) break;
                Button button = new Button();
                String current = getNextDate(actualDate, j);
                button.setText(current);
                if (actualDateString.equals(current)) {
                    button.setBackground(Color.GRAY);
                }
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
