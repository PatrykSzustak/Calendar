package solSoft.view;

import solSoft.NoteFrame;
import solSoft.NoteService;
import solSoft.controller.Controller;
import solSoft.view.interfaces.ChangeDate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Button extends JButton implements ChangeDate {

    NoteFrame noteFrame;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Button() {
        setBounds(0, 10, 100, 345);
        setBorder(BorderFactory.createLineBorder(Color.black));


        Controller.getInstance().registerDateChange(this);

        addActionListener(e -> {
            String input = getText();
            LocalDate localDate = LocalDate.parse(input, formatter);
            Controller.getInstance().changeDate(localDate);
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String date = getText();
                LocalDate localDate = LocalDate.parse(date, formatter);
                if (e.getButton() == MouseEvent.BUTTON3) {
                    noteFrame = new NoteFrame(localDate);
                    String note = NoteService.getInstance().getMap().get(localDate);
                    noteFrame.getjTextArea().setText(note);
                }
            }
        });

    }


    @Override
    public void onDateChange(LocalDate date) {
        LocalDate actualDate = date;
    }


}
