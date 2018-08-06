package solSoft.view;

import solSoft.controller.ViewMode;

import javax.swing.*;
import java.util.List;

public class ViewModeComboBox extends JComboBox<ViewMode> {

    private ViewModeListener viewModeListener;


    public ViewModeComboBox(List<ViewMode> list) {

        for (ViewMode viewMode : list) {
            addItem(viewMode);
        }
        setBounds(500, 50, 100, 70);
        addActionListener(e -> {
            ViewMode selectedViewMode = (ViewMode) getSelectedItem();
            viewModeListener.onViewModeChange(selectedViewMode);
        });
    }


    public void setListener(ViewModeListener viewModeListener) {
        this.viewModeListener = viewModeListener;
    }


}
