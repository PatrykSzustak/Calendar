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

    public void createButtonsForMonth(LocalDate date) {
        removeAll();
        setLayout(new GridLayout(5, 7));
        int count = 0;
        int howLoop = 0;
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 6; j++) {
                String actualDateString = date.format(formatter);
                howLoop++;
                int dayOfMonth = date.lengthOfMonth();
                if (howLoop > dayOfMonth) break;
                solSoft.view.Button button = new Button();
                String current = getNextDate(date, count);
                button.setText(current);
                if (actualDateString.equals(current)) {
                    button.setBackground(Color.GRAY);
                }
                add(button);
                count++;
            }
        }
        revalidate();
    }

    private String getNextDate(LocalDate date, int count) {
        LocalDate firstDateOfWeek = date.withDayOfMonth(1);
        LocalDate nextDay = firstDateOfWeek.plusDays(count);
        return nextDay.format(formatter);
    }


    @Override
    public void onDateChange(LocalDate date) {
        this.actualDate = date;
        createButtonsForMonth(date);
    }
}
