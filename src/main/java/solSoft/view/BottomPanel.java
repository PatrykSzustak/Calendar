package solSoft.view;

import solSoft.controller.Controller;
import solSoft.controller.ViewMode;

import javax.swing.*;
import java.awt.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BottomPanel extends JPanel implements ChangeView , ChangeDate {

    private LocalDate actualDate = LocalDate.now();
    private ViewMode currentView = ViewMode.WEEK;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public BottomPanel() {
        setBounds(0, 150, 1000, 550);
        setBackground(Color.LIGHT_GRAY);
        Controller.getInstance().registerViewChange(this);
        Controller.getInstance().registerDateChange(this);
        createButtonsForWeek(actualDate);

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
                if (actualDateString.equals(current)){
                    button.setBackground(Color.GRAY);
                }
                add(button);
                count++;
            }
        }
        revalidate();
    }



    public void createButtonsForWeek(LocalDate date) {
        removeAll();
        setLayout(new GridLayout(1, 7));

        int count=0;
        for (int i = 0; i <= 6; i++) {

            String actualDateString = date.format(formatter);

            LocalDate firstDateOfWeek = date.with(DayOfWeek.MONDAY);
            LocalDate nextDay = firstDateOfWeek.plusDays(count);
            String next = nextDay.format(formatter);
            Button button = new Button();
            button.setText(next);
            if (actualDateString.equals(next)){
                button.setBackground(Color.GRAY);
            }
            add(button);
            count++;
        }
        revalidate();
    }


    @Override
    public void onViewChange(ViewMode viewMode) {
        this.currentView = viewMode;
        updateView();
    }

    @Override
    public void onDateChange(LocalDate date) {
        this.actualDate = date;
        updateView();
    }

    private void updateView() {
        if(currentView== ViewMode.WEEK){
            createButtonsForWeek(actualDate);
        }else  if (currentView == ViewMode.MONTH){
            createButtonsForMonth(actualDate);
        }
    }
}
