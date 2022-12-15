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
}
