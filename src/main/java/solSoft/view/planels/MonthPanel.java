package solSoft.view.planels;

import solSoft.NoteService;
import solSoft.controller.Controller;
import solSoft.view.Button;
import solSoft.view.interfaces.ChangeDate;

import java.awt.*;
import java.time.LocalDate;

public class MonthPanel extends AbstractPanel implements ChangeDate {


    public MonthPanel() {
        Controller.getInstance().registerDateChange(this);
    }


    private String getNextDate(LocalDate date, int count) {
        LocalDate firstDateOfWeek = date.withDayOfMonth(1);
        LocalDate nextDay = firstDateOfWeek.plusDays(count);
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
    public void onDateChange(LocalDate date) {
        this.actualDate = date;
        for (int i = 0; i <buttons.size() ; i++) {
            buttons.get(i).setBackground(Color.WHITE);
            String actualDateString = date.format(formatter);
            String current = getNextDate(actualDate, i);
            buttons.get(i).setText(current);
            if (actualDateString.equals(current)) {
                buttons.get(i).setBackground(Color.GRAY);
            }
            if (NoteService.getInstance().getMap().containsKey(LocalDate.parse(current,formatter))) {
                buttons.get(i).setBackground(Color.RED);
            }
        }
    }

    @Override
    public int howDays() {
        return actualDate.lengthOfMonth();
    }
}
