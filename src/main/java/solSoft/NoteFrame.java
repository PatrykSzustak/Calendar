package solSoft;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class NoteFrame extends JFrame {

    JPanel jPanel;
    JTextArea jTextArea;
    JButton jButton;

    public NoteFrame(LocalDate localDate) {
        setSize(400,300);
        createNotePanel();
        setVisible(true);
        setLayout(null);

        jButton.addActionListener(e -> {
            String input = jTextArea.getText();
            NoteService.getInstance().getMap().put(localDate,input);
            NoteService.getInstance().noteEvent(localDate,input);
        });

    }

    public void createNotePanel(){
        jPanel = new JPanel();
        jPanel.setSize(400, 300);
        jPanel.setBackground(Color.LIGHT_GRAY);
        add(jPanel);
        createTextArea();
        createNoteButton();
        jPanel.setLayout(null);
        jPanel.setVisible(true);
    }
    public void createTextArea(){
        jTextArea = new JTextArea();
        jTextArea.setBounds(10,10,360,180);
        jPanel.add(jTextArea);
    }

    public void createNoteButton(){
        jButton = new JButton();
        jButton.setBounds(130, 200, 100, 50);
        jButton.setText("Save note");
        jPanel.add(jButton);


    }



    public JTextArea getjTextArea() {
        return jTextArea;
    }



}
