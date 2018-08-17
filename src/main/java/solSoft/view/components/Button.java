package solSoft.view.components;

import solSoft.DataFormat;
import solSoft.service.NoteService;
import solSoft.controller.Controller;
import solSoft.view.interfaces.ChangeDate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;


public class Button extends JButton implements ChangeDate {

    private NoteFrame noteFrame;


    public Button() {
        setBounds(0, 10, 100, 345);
        setBorder(BorderFactory.createLineBorder(Color.black));


        Controller.getInstance().registerDateChange(this);

        addActionListener(e -> {
            String input = getText();
            LocalDate localDate = LocalDate.parse(input, DataFormat.getFormatter());
            Controller.getInstance().changeDate(localDate);
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String date = getText();
                LocalDate localDate = LocalDate.parse(date, DataFormat.getFormatter());
                if (e.getButton() == MouseEvent.BUTTON3) {
                    noteFrame = new NoteFrame(localDate);
                    String note = NoteService.getInstance().getMap().get(localDate);
                    noteFrame.getJTextArea().setText(note);
                }
            }
        });

    }


    @Override
    public void onDateChange(LocalDate date) {
    }


}
