package solSoft.view;

import solSoft.controller.Controller;
import solSoft.view.interfaces.ChangeDate;
import solSoft.view.interfaces.NoteAdded;
import solSoft.view.planels.NotePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Button extends JButton implements ChangeDate,NoteAdded {

    private LocalDate actualDate = LocalDate.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Button() {
        setBounds(0, 10, 100, 345);
        setBorder(BorderFactory.createLineBorder(Color.black));
        Controller.getInstance().registerDateChange(this);
        Controller.getInstance().registerNote(this);

        addActionListener(e -> {
            String input = getText();
            LocalDate localDate = LocalDate.parse(input, formatter);
            Controller.getInstance().changeDate(localDate);
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    String date = getText();
                    LocalDate localDate = LocalDate.parse(date,formatter);
                    new NoteFrame(new NotePanel(localDate));
                }
            }
        });
    }


    @Override
    public void onDateChange(LocalDate date) {
        this.actualDate = date;
    }

    @Override
    public void onCreateNote(LocalDate localDate) {
        LocalDate localDate1 = LocalDate.parse(getText(),formatter);
        if (localDate1.equals(localDate)){
            setBackground(Color.RED);

        }

    }

}
