package solSoft.view.planels;

import solSoft.controller.Controller;
import solSoft.view.interfaces.NoteAdded;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public abstract class AbstractPanel extends JPanel {

    LocalDate actualDate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Map<LocalDate, List<NoteAdded>> map = Controller.getInstance().getMap();

    public AbstractPanel() {
        setBounds(0, 150, 1000, 550);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout());
    }



}
