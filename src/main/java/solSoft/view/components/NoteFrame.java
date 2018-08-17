package solSoft.view.components;

import solSoft.service.NoteService;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class NoteFrame extends JFrame {

    private JPanel jPanel;
    private JTextArea jTextArea;
    private JButton jButton;

    NoteFrame(LocalDate localDate) {
        setSize(400, 300);
        createNotePanel();
        setVisible(true);
        setLayout(null);

        jButton.addActionListener(e -> {
            String input = jTextArea.getText();
            NoteService.getInstance().getMap().put(localDate, input);
            NoteService.getInstance().noteEvent(localDate, input);
        });

    }

    private void createNotePanel() {
        jPanel = new JPanel();
        jPanel.setSize(400, 300);
        jPanel.setBackground(Color.LIGHT_GRAY);
        add(jPanel);
        createTextArea();
        createNoteButton();
        jPanel.setLayout(null);
        jPanel.setVisible(true);
    }

    private void createTextArea() {
        jTextArea = new JTextArea();
        jTextArea.setBounds(10, 10, 360, 180);
        jPanel.add(jTextArea);
    }

    private void createNoteButton() {
        jButton = new JButton();
        jButton.setBounds(130, 200, 100, 50);
        jButton.setText("Save note");
        jPanel.add(jButton);
    }


    JTextArea getJTextArea() {
        return jTextArea;
    }

}
