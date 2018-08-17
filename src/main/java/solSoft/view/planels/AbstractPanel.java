package solSoft.view.planels;

import solSoft.DataFormat;
import solSoft.service.NoteService;
import solSoft.view.components.Button;
import solSoft.view.interfaces.NoteAdded;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPanel extends JPanel implements NoteAdded {

    LocalDate actualDate = LocalDate.now();
    List<Button> buttons = new ArrayList<>();


    AbstractPanel() {
        setBounds(0, 150, 1000, 550);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout());
        NoteService.getInstance().addToList(this);
    }


    public void onCreateNote(LocalDate localDate, String string) {
        this.actualDate = localDate;
        for (int i = 0; i < howDays(); i++) {
            Button button = buttons.get(i);
            String text = button.getText();
            LocalDate localDate1 = LocalDate.parse(text, DataFormat.getFormatter());
            if (NoteService.getInstance().getMap().containsKey(localDate1)) {
                buttons.get(i).setBackground(Color.RED);
            }
        }
    }

    public void onDateChange(LocalDate date) {
        this.actualDate = date;
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setBackground(Color.WHITE);
            String actualDateString = date.format(DataFormat.getFormatter());
            String current = getNextDate(actualDate, i);
            buttons.get(i).setText(current);
            if (actualDateString.equals(current)) {
                buttons.get(i).setBackground(Color.GRAY);
            }
            if (NoteService.getInstance().getMap().containsKey(LocalDate.parse(current, DataFormat.getFormatter()))) {
                buttons.get(i).setBackground(Color.RED);
            }
        }
    }

    void checkAndAddColor(String actualDateString, Button button, String current) {
        if (actualDateString.equals(current)) {
            button.setBackground(Color.GRAY);
        }
    }


    public abstract String getNextDate(LocalDate localDate, int count);

    public abstract int howDays();

}
