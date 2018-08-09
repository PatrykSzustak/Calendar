package solSoft.view;

import solSoft.controller.Controller;
import solSoft.controller.ViewMode;

import java.time.LocalDate;

public class BottomPanel extends AbstractPanel implements ChangeView  {


    private ViewMode currentView = ViewMode.WEEK;
    private LocalDate actualDate = LocalDate.now();
    private WeekPanel weekPanel;
    private MonthPanel monthPanel;


    public BottomPanel() {

        Controller.getInstance().registerViewChange(this);

        weekPanel = new WeekPanel();
        monthPanel = new MonthPanel();
        weekPanel.createButtonsForWeek(actualDate);
        monthPanel.createButtonsForMonth(actualDate);


        add(weekPanel);
    }

    @Override
    public void onViewChange(ViewMode viewMode) {

        this.currentView = viewMode;
        if (currentView == ViewMode.WEEK) {
            removeAll();
            add(weekPanel);
        } else if (currentView == ViewMode.MONTH) {
            removeAll();
            add(monthPanel);
        }
        repaint();
        revalidate();
    }

}
