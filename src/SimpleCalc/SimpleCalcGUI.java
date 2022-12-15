package SimpleCalc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalcGUI extends JFrame{
    private JPanel panel1;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JButton btnCompute;
    private JTextField tfNumber2;
    private JTextField lblResult;

    public SimpleCalcGUI() {
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    if (tfNumber1.getText().equals("") || tfNumber2.getText().equals("")) {
                        throw (new NoInputException("Please fill in two numbers."));
                    }

                    double num1 = Double.parseDouble(tfNumber1.getText());
                    double num2 = Double.parseDouble(tfNumber2.getText());
                    double result = 0;

                    switch (cbOperations.getSelectedIndex()) {
                        case 0:
                            result = num1 + num2;
                            break;
                        case 1:
                            result = num1 - num2;
                            break;
                        case 2:
                            result = num1 * num2;
                            break;
                        case 3:
                            if(num2 == 0) {
                                throw new ArithmeticException();
                            }
                            result = num1 / num2;
                            break;
                    }

                    if (String.valueOf(result).endsWith("0")) {
                        int noDec = (int) result;
                        lblResult.setText(String.valueOf(noDec));
                    } else {
                        lblResult.setText(String.valueOf(result));
                    }
                } catch (NoInputException x) {
                    JOptionPane.showMessageDialog(panel1, x.getMessage());
                } catch (NumberFormatException x) {
                    lblResult.setText("");
                    JOptionPane.showMessageDialog(panel1, "Input must be an integer. Try again.");
                } catch (ArithmeticException x) {
                    lblResult.setText("");
                    JOptionPane.showMessageDialog(panel1, "Divided by zero operation cannot possible.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SimpleCalcGUI calc = new SimpleCalcGUI();
        calc.setContentPane(calc.panel1);
        calc.setTitle("Simple Calculator");
        calc.setSize(550, 250);
        calc.lblResult.setEditable(false);
        calc.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        calc.setVisible(true);
    }

    public static class NoInputException extends Exception {
        public NoInputException(String s) {
            super(s);
        }
    }
}