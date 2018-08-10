package solSoft.view.planels;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class AbstractPanel extends JPanel {

    LocalDate actualDate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public AbstractPanel() {
        setBounds(0, 150, 1000, 550);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout());
    }

}
