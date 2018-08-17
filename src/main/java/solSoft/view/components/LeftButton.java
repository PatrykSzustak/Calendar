package solSoft.view.components;

import solSoft.controller.Controller;
import solSoft.controller.ViewMode;
import solSoft.view.interfaces.ChangeDate;
import solSoft.view.interfaces.ChangeView;

import javax.swing.*;
import java.time.LocalDate;

public class LeftButton extends JButton implements ChangeView, ChangeDate {

    private ViewMode currentView = ViewMode.WEEK;
    private LocalDate currentDate = LocalDate.now();

    public LeftButton() {
        setText("<");
        setBounds(30, 50, 70, 70);
        Controller.getInstance().registerViewChange(this);
        Controller.getInstance().registerDateChange(this);

        addActionListener(e -> {
            if (currentView == ViewMode.WEEK) {
                currentDate = currentDate.plusDays(-7);
                Controller.getInstance().changeDate(currentDate);
            } else if (currentView == ViewMode.MONTH) {
                currentDate = currentDate.plusDays(-31);
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
