package solSoft.controller;

import solSoft.view.interfaces.ChangeDate;
import solSoft.view.interfaces.ChangeView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {


    private static Controller instance = null;

    private List<ChangeView> viewList = new ArrayList<>();
    private List<ChangeDate> dateList = new ArrayList<>();


    private Controller() {

    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void changeView(ViewMode viewMode) {
        viewList.forEach(p -> p.onViewChange(viewMode));
    }

    public void registerViewChange(ChangeView viewComponent) {
        viewList.add(viewComponent);
    }

    public void changeDate(LocalDate date) {
        dateList.forEach(p -> p.onDateChange(date));
    }

    public void registerDateChange(ChangeDate dateComponent) {
        dateList.add(dateComponent);
    }


}
