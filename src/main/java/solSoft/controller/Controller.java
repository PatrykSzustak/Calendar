package solSoft.controller;

import solSoft.interfaces.DateChanged;
import solSoft.interfaces.ViewChanged;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller {

    List<DateChanged> dateChangedComponents = new ArrayList<>();
    List<ViewChanged> viewChangedComponents = new ArrayList<>();



    private static Controller instance = null;

    private Controller() {

    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    void dateEvent (Date date){

    }

    void viewEvent (View view){

    }

    public List<DateChanged> getDateChangedComponents() {
        return dateChangedComponents;
    }

    public void setDateChangedComponents(List<DateChanged> dateChangedComponents) {
        this.dateChangedComponents = dateChangedComponents;
    }

    public List<ViewChanged> getViewChangedComponents() {
        return viewChangedComponents;
    }

    public void setViewChangedComponents(List<ViewChanged> viewChangedComponents) {
        this.viewChangedComponents = viewChangedComponents;
    }

}
