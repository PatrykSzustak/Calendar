package solSoft.view;

import solSoft.view.planels.NotePanel;

import javax.swing.*;

public class NoteFrame extends JFrame {

    public NoteFrame(NotePanel notePanel) {
        setSize(400,300);
        add(notePanel);
        setVisible(true);
        setLayout(null);


    }




}
