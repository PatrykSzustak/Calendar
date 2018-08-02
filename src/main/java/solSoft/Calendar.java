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

    public Calendar(){

    }


    public Calendar(JFrame jFrame, JButton jButton, JTextField textField, JComboBox jComboBox) {
        this.jFrame = jFrame;
        this.jButton = jButton;
        this.textField = textField;
        this.jComboBox = jComboBox;
    }

    public void createJFrame() {
        jFrame.setSize(800, 600);
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

    public Vector<String> createVector() {
        Vector<String> module = new Vector<>();
        module.addElement("Week");
        module.addElement("Daily");
        return module;
    }

    public void createComboBox(Vector<String> vector) {
        JComboBox<String> comboModule = new JComboBox<String>(vector);
        comboModule.setBounds(500, 50, 100, 70);
        jFrame.add(comboModule);
    }

    /*public void createTextField(JTextField textField) {
        textField.setBounds(200, 50, 201, 70);
        jFrame.add(textField);
    }*/

    public JTextField createTextField(JTextField textField) {
        textField.setBounds(200, 50, 201, 70);
        jFrame.add(textField);
        return  textField;
    }

    public void create7Fields(){
        JTextField mainJTextField = createTextField(new JTextField());
        int space = 0;
        for (int i = 0; i <= 6 ; i++) {
            space += 90;
            JTextField jTextField = new JTextField();
            jTextField.setBounds(space, 130, 90, 400);
            jTextField.setBorder(BorderFactory.createLineBorder(Color.black));
            actionToMainTextField(mainJTextField,jTextField);
            jFrame.add(jTextField);
        }
    }



    public void actionToMainTextField(JTextField mainJTextField,JTextField jTextField){


        mainJTextField.addActionListener(e -> {
            if(mainJTextField.getText().isEmpty()){
                LocalDate currentDate = LocalDate.now();
                mainJTextField.setText(currentDate.toString());
                jTextField.setText(currentDate.toString());
            }else{
                String input = mainJTextField.getText();
                LocalDate localDate = LocalDate.parse(input);
                jTextField.setText(localDate.toString());
            }
        });
    }

    public  void init(){

        Calendar calendar = new Calendar(new JFrame(), new JButton(),new JTextField(),new JComboBox());

        calendar.createJFrame();
        calendar.createLeftButton(new JButton());
        calendar.createRightButton(new JButton());
        calendar.createComboBox(calendar.createVector());
//        calendar.createTextField(new JTextField());
        calendar.create7Fields();
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    public void setjFrame(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    public JButton getjButton() {
        return jButton;
    }

    public void setjButton(JButton jButton) {
        this.jButton = jButton;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JComboBox getjComboBox() {
        return jComboBox;
    }

    public void setjComboBox(JComboBox jComboBox) {
        this.jComboBox = jComboBox;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "jFrame=" + jFrame +
                ", jButton=" + jButton +
                ", textField=" + textField +
                ", jComboBox=" + jComboBox +
                '}';
    }
}
