package solSoft.view;

import solSoft.controller.Controller;
import solSoft.controller.ViewMode;

import javax.swing.*;
import java.util.List;

public class ViewModeComboBox extends JComboBox<ViewMode> implements ChangeView {


    private ViewMode currentView = ViewMode.WEEK;


    public ViewModeComboBox(List<ViewMode> list) {

        setBounds(500, 50, 100, 70);
        Controller.getInstance().registerViewChange(this);

        for (ViewMode viewMode : list) {
            addItem(viewMode);
        }

        addActionListener(e -> {
            ViewMode selectedViewMode = (ViewMode) getSelectedItem();
            Controller.getInstance().changeView(selectedViewMode);
        });
    }


    @Override
    public void onViewChange(ViewMode viewMode) {
        this.currentView = viewMode;
    }
}
