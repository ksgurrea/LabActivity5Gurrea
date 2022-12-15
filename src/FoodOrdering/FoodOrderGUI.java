package FoodOrdering;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FoodOrderGUI extends JFrame{
    private JPanel panel1;
    private JCheckBox cPizza;
    private JRadioButton rbNone;
    private JButton btnOrder;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    List<JCheckBox> Foods;
    List<JRadioButton> Discounts;

    public FoodOrderGUI() {
        Foods = new ArrayList<>();
        Foods.add(cPizza);
        Foods.add(cBurger);
        Foods.add(cFries);
        Foods.add(cSoftDrinks);
        Foods.add(cTea);
        Foods.add(cSundae);
        Discounts = new ArrayList<>();
        Discounts.add(rbNone);
        Discounts.add(rb5);
        Discounts.add(rb10);
        Discounts.add(rb15);

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DecimalFormat df = new DecimalFormat(".00");

                    if(sumOfFoods() == 0)
                        throw (new NoFoodSelectedException("Please select a food."));
                    else if(discountedTotalPrice() == 0)
                        throw (new NoDiscountSelectedException("Please select a discount promo."));
                    else
                        JOptionPane.showMessageDialog(panel1, "The total price is Php " + df.format(discountedTotalPrice()));
                }
                catch(NoFoodSelectedException | NoDiscountSelectedException x){
                    JOptionPane.showMessageDialog(panel1, x.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        FoodOrderGUI order = new FoodOrderGUI();
        order.setContentPane(order.panel1);
        order.setTitle("Food Ordering System");
        order.setSize(500, 500);
        order.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        order.setVisible(true);
    }

    public int sumOfFoods() {
        int sum = 0;
        for (JCheckBox cb : Foods) {
            if (cb.isSelected()) {
                if (cb.equals(cPizza)) {
                    sum += 100;
                } else if (cb.equals(cBurger)) {
                    sum += 80;
                } else if (cb.equals(cFries)) {
                    sum += 65;
                } else if (cb.equals(cSoftDrinks)) {
                    sum += 55;
                } else if (cb.equals(cTea)) {
                    sum += 50;
                } else if (cb.equals(cSundae)) {
                    sum += 40;
                }
            }
        }
        return sum;
    }

    public double discountedTotalPrice(){
        double total;
        for (JRadioButton rb : Discounts) {
            if (rb.isSelected()) {
                if (rb.equals(rbNone)) {
                    return sumOfFoods();
                } else if (rb.equals(rb5)) {
                    total = sumOfFoods() - (sumOfFoods() * 0.05);
                    return total;
                } else if (rb.equals(rb10)) {
                    total = sumOfFoods() - (sumOfFoods() * 0.10);
                    return total;
                } else if (rb.equals(rb15)) {
                    total = sumOfFoods() - (sumOfFoods() * 0.15);
                    return total;
                }
            }
        }
        return 0;
    }

    public static class NoDiscountSelectedException extends Exception {
        public NoDiscountSelectedException (String s){
            super(s);
        }
    }

    public static class NoFoodSelectedException extends Exception {
        public NoFoodSelectedException(String s) {
            super(s);
        }
    }
}