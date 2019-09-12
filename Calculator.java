/*
    Name: Eli Ji and Rocky Xia
    Date: 9-9-19
    DA Data Structures
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

        JTextField tFrac1, tFrac2, tResult;
        JButton bAdd, bSubtract, bMultiply, bDivide;
        Calculator(){

            JFrame f= new JFrame();

            tFrac1 = new JTextField();
            tFrac1.setText("Enter Fraction 1");
            tFrac1.setHorizontalAlignment(JTextField.CENTER);
            tFrac1.setBounds(95,50,150,20);

            tFrac2 = new JTextField();
            tFrac2.setText("Enter Fraction 2");
            tFrac2.setHorizontalAlignment(JTextField.CENTER);
            tFrac2.setBounds(95,100,150,20);

            tResult = new JTextField();
            tResult.setText("Result");
            tResult.setHorizontalAlignment(JTextField.CENTER);
            tResult.setBounds(95,150,150,20);
            tResult.setEditable(false);

            bAdd = new JButton("+");
            bAdd.setBounds(40,200,50,50);
            bSubtract = new JButton("-");
            bSubtract.setBounds(110,200,50,50);
            bMultiply = new JButton("*");
            bMultiply.setBounds(180,200,50,50);
            bDivide = new JButton("/");
            bDivide.setBounds(250,200,50,50);

            bAdd.addActionListener(this);
            bSubtract.addActionListener(this);
            bMultiply.addActionListener(this);
            bDivide.addActionListener(this);

            f.add(tFrac1);f.add(tFrac2);f.add(tResult);f.add(bAdd);f.add(bSubtract);f.add(bMultiply);f.add(bDivide);
            f.setSize(340,300);
            f.setLayout(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            String sFrac1=tFrac1.getText();
            String sFrac2=tFrac2.getText();
            Fraction fFrac1 = new Fraction(sFrac1);
            Fraction fFrac2 = new Fraction(sFrac2);
            Fraction fResult = new Fraction(1,1); //eventually create null constructor
            if(e.getSource()==bAdd){
                fResult = fFrac1.add(fFrac2);
            }else if(e.getSource()==bSubtract){
                fResult = fFrac1.subtract(fFrac2);
            }else if(e.getSource()==bMultiply){
                fResult = fFrac1.multiply(fFrac2);
            }else if(e.getSource()==bDivide){
                fResult = fFrac1.divide(fFrac2);
            }
            tResult.setText(fResult.toString());
        }
        public static void main(String[] args) {
            new Calculator();
        }
    }

