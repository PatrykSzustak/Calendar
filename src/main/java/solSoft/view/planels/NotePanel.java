package solSoft.view.planels;

import solSoft.controller.Controller;
import solSoft.view.NoteButton;
import solSoft.view.NoteTextArea;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class NotePanel extends JPanel  {


    public NotePanel(LocalDate localDate) {
        setLayout(null);
        setSize(400, 300);
        setBackground(Color.LIGHT_GRAY);

        NoteButton noteButton = new NoteButton();
        NoteTextArea noteTextArea = new NoteTextArea();

        noteButton.addActionListener(e -> {
            Controller.getInstance().registerNoteInMap(localDate,Controller.getInstance().getNoteList());
            Controller.getInstance().addNote(localDate);
        });

        add(noteTextArea);
        add(noteButton);

    }

}
