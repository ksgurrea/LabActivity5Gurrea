package LeapYear;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearGUI extends JFrame{
    private JPanel panel1;
    private JTextField tfYear;
    private JButton btnCheckYear;

    public LeapYearGUI(){
        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(tfYear.getText().equals("")){
                        throw (new InvalidInputException("Please input a year."));
                    } else if (Integer.parseInt(tfYear.getText()) < 0){
                        throw (new InvalidInputException("Input must be a year."));
                    }

                    int year = Integer.parseInt(tfYear.getText());
                    boolean leap;

                    if (year % 4 == 0) {
                        if (year % 100 == 0) {
                            leap = year % 400 == 0;
                        } else
                            leap = true;
                    } else
                        leap = false;

                    if (leap)
                        JOptionPane.showMessageDialog(panel1, "Leap year");
                    else
                        JOptionPane.showMessageDialog(panel1, "Not a leap year");
                }
                catch(InvalidInputException x) {
                    JOptionPane.showMessageDialog(panel1, x.getMessage());
                }
                catch(NumberFormatException x) {
                    JOptionPane.showMessageDialog(panel1, "Input must be a year.");
                }
            }
        });
    }

    public static void main(String[] args) {
        LeapYearGUI leapYear = new LeapYearGUI();
        leapYear.setContentPane(leapYear.panel1);
        leapYear.setTitle("Leap Year Checker");
        leapYear.setSize(450,300);
        leapYear.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        leapYear.setVisible(true);
    }

    public static class InvalidInputException extends Exception {
        public InvalidInputException(String s) {
            super(s);
        }
    }
}
