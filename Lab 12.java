

import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  


public class DivisionApp extends Frame implements ActionListener {  
    TextField num1Field;  
    TextField num2Field;  
    TextField resultField;  
    Button divideButton;  


    public DivisionApp() {  
        // Create components  
        num1Field = new TextField();  
        num1Field.setBounds(60, 50, 170, 20);  
       
        num2Field = new TextField();  
        num2Field.setBounds(60, 80, 170, 20);  
       
        resultField = new TextField();  
        resultField.setBounds(60, 110, 170, 20);  
        resultField.setEditable(false);        
        divideButton = new Button("Divide");  
        divideButton.setBounds(100, 150, 80, 30);  
       
       
        divideButton.addActionListener(this);               add(num1Field);  
        add(num2Field);  
        add(resultField);  
        add(divideButton);  
       
        setSize(300, 300);  
        setLayout(null);  
        setVisible(true);  
       
   
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }  


    public void actionPerformed(ActionEvent e) {  
        try {
       
            int num1 = Integer.parseInt(num1Field.getText());
            int num2 = Integer.parseInt(num2Field.getText());
           
         
            if (num2 == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
           
       
            int result = num1 / num2;  
            resultField.setText(String.valueOf(result));  
        } catch (NumberFormatException ex) {
       
            JOptionPane.showMessageDialog(this, "Please enter valid integers.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
       
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Arithmetic Error", JOptionPane.ERROR_MESSAGE);
        }
    }  


    public static void main(String[] args) {  
        new DivisionApp();  
    }  
}



