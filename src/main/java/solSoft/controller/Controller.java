package solSoft.controller;

import solSoft.view.BottomPanel;
import solSoft.view.DateListener;
import solSoft.view.ViewModeListener;

import java.util.Date;

public class Controller implements DateListener,ViewModeListener {

    private BottomPanel bottomPanel;
    private Date date = new Date();
    private ViewMode viewMode = ViewMode.WEEK;


    public Controller(BottomPanel bottomPanel) {
        this.bottomPanel = bottomPanel;
    }


    @Override
    public void onViewModeChange(ViewMode viewMode) {
        updateState(viewMode,date);
        this.viewMode = viewMode;
    }

    @Override
    public void onDateChange(Date date) {
        this.date = date;
        updateState(viewMode,date);

    }

    private void updateState(ViewMode viewMode, Date date) {
        if (viewMode == ViewMode.WEEK) {
            bottomPanel.create7Buttons(date);
        } else if (viewMode == ViewMode.MONTH) {
            bottomPanel.create35Buttons(date);
        }
    }

}
