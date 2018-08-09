package solSoft.view;


import solSoft.controller.Controller;
import solSoft.controller.ViewMode;

import javax.swing.*;
import java.time.LocalDate;

public class RightButton extends JButton implements ChangeView, ChangeDate {

    private ViewMode currentView = ViewMode.WEEK;
    private LocalDate currentDate = LocalDate.now();

    public RightButton() {
        setText(">");
        setBounds(300, 50, 70, 70);
        Controller.getInstance().registerViewChange(this);
        Controller.getInstance().registerDateChange(this);

        addActionListener(e -> {
            if (currentView == ViewMode.WEEK) {
                currentDate = currentDate.plusDays(7);
                Controller.getInstance().changeDate(currentDate);
            } else if (currentView == ViewMode.MONTH) {
                currentDate = currentDate.plusDays(31);
                Controller.getInstance().changeDate(currentDate);
            }
        });


    }


    @Override
    public void onViewChange(ViewMode viewMode) {
        this.currentView = viewMode;
    }

    @Override
    public void onDateChange(LocalDate date) {
        this.currentDate = date;
    }
}
