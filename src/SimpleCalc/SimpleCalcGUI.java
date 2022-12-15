package SimpleCalc;

import javax.swing.*;

public class SimpleCalcGUI extends JFrame{
    private JPanel panel1;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JButton btnCompute;
    private JTextField tfNumber2;
    private JTextField lblResult;

    public static void main(String[] args) {
        SimpleCalcGUI calc = new SimpleCalcGUI();
        calc.setContentPane(calc.panel1);
        calc.setTitle("Simple Calculator");
        calc.setSize(550, 250);
        calc.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        calc.setVisible(true);
    }
}
