package solSoft.view;

import solSoft.controller.Controller;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MonthPanel extends AbstractPanel implements ChangeDate {


    private LocalDate actualDate;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
                Button button = new Button();
                LocalDate firstDateOfWeek = date.withDayOfMonth(1);
                LocalDate nextDay = firstDateOfWeek.plusDays(count);
                String current = nextDay.format(formatter);
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


    @Override
    public void onDateChange(LocalDate date) {
        this.actualDate = date;
        createButtonsForMonth(date);
    }
}
