package solSoft;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Vector;

public class Calendar {
    private JFrame jFrame;
    private JButton jButton;
    private JTextField textField;
    private JComboBox jComboBox;

    public Calendar() {

    }


    public Calendar(JFrame jFrame, JButton jButton, JTextField textField, JComboBox jComboBox) {
        this.jFrame = jFrame;
        this.jButton = jButton;
        this.textField = textField;
        this.jComboBox = jComboBox;
    }

    public void createJFrame() {
        jFrame.setSize(1000, 700);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }

    public void createLeftButton(JButton jButton) {
        jButton.setText("<");
        jButton.setBounds(130, 50, 70, 70);
        jFrame.add(jButton);
    }

    public void createRightButton(JButton jButton) {
        jButton.setText(">");
        jButton.setBounds(400, 50, 70, 70);
        jFrame.add(jButton);
    }

    /*public Vector<String> createVector() {
        Vector<String> module = new Vector<>();
        module.addElement("Week");
        module.addElement("Month");
        return module;
    }*/

    public JComboBox<String> createComboBox() {
        Vector<String> module = new Vector<>();
        module.addElement("Week");
        module.addElement("Month");
        JComboBox<String> comboModule = new JComboBox<>(module);
        comboModule.setBounds(500, 50, 100, 70);
        jFrame.add(comboModule);
        return comboModule;
    }

    /*public void createTextField(JTextField textField) {
        textField.setBounds(200, 50, 201, 70);
        jFrame.add(textField);
    }*/

    public JTextField createTextField(JTextField textField) {
        textField.setBounds(200, 50, 201, 70);
        jFrame.add(textField);
        return textField;
    }

    public void create7Buttons() {
        JTextField mainJTextField = createTextField(new JTextField());
        int space = 0;
        int addDays = -1;
        for (int i = 0; i <= 6; i++) {
            addDays++;
            space += 90;
            JButton jButton = new JButton();
            jButton.setBounds(space, 130, 90, 400);
            jButton.setBorder(BorderFactory.createLineBorder(Color.black));
            actionToMainTextField(mainJTextField, jButton, addDays);
            changeMainTextField(mainJTextField, jButton);
            jFrame.add(jButton);
        }
    }

//    public void actionLeftButton(JButton jButtonLeft,JTextField mainJTextField){
//        jButtonLeft.addActionListener(e->{
//            LocalDate date = LocalDate.parse(mainJTextField.getText());
//            LocalDate dateMinusOne = date.minusDays(1);
//            mainJTextField.setText(date.toString());
//        });
//    }


    public void actionToMainTextField(JTextField mainJTextField, JButton jButton, int addDays) {


        mainJTextField.addActionListener(e -> {
            if (mainJTextField.getText().isEmpty()) {
                LocalDate currentDate = LocalDate.now();
                mainJTextField.setText(currentDate.toString());
                LocalDate localDate = currentDate.plusDays(addDays);
                jButton.setText(localDate.toString());
//                changeButtonColor(mainJTextField,jButton);
            } else {
                String input = mainJTextField.getText();
                LocalDate localDate = LocalDate.parse(input);
                LocalDate localDate1 = localDate.plusDays(addDays);
                jButton.setText(localDate1.toString());
//                changeButtonColor(mainJTextField,jButton);
            }
        });

    }

    public void actionToComboBox(JComboBox jComboBox) {
        String yourChoice = (String) jComboBox.getSelectedItem();
        jComboBox.addActionListener(e -> {

            assert yourChoice != null;
            if (yourChoice.equals("Week")) {
                create7Buttons();
            } else if (yourChoice.equals("Month")) {
                create35Buttons();
            }
        });
    }

    public void changeMainTextField(JTextField mainJTextField, JButton jButton) {
        jButton.addActionListener(e -> {

                    String input = jButton.getText();
                    mainJTextField.setText(input);

                }
        );
    }

    /*public void changeButtonColor(JTextField mainJTextField, JButton jButton){
        mainJTextField.addActionListener(e -> {

                    String input = mainJTextField.getText();
                    if(input.equals(jButton.getText())){
                        jButton.setBackground(Color.LIGHT_GRAY);
                    }
                }
        );
    }*/

    public void create35Buttons() {
        JTextField mainJTextField = createTextField(new JTextField());
        jFrame.add(mainJTextField);
        int spaceFromTop = 50;
        for (int i = 0; i <= 4; i++) {
            spaceFromTop += 80;
            int spaceNextTo = 0;
            for (int j = 0; j <= 6; j++) {
                spaceNextTo += 100;
                JButton jButton = new JButton();
                jButton.setBounds(spaceNextTo, spaceFromTop, 100, 70);
                jButton.setBorder(BorderFactory.createLineBorder(Color.black));
                jFrame.add(jButton);

            }
        }
    }


    public void init() {

        Calendar calendar = new Calendar(new JFrame(), new JButton(), new JTextField(), new JComboBox());

        calendar.createJFrame();
        calendar.createLeftButton(new JButton());
        calendar.createRightButton(new JButton());
        calendar.createComboBox();
        calendar.create7Buttons();
//        actionToComboBox(calendar.createComboBox());
//        calendar.create35Buttons();
    }

}
