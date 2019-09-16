/*
    Name: Eli Ji and Rocky Xia
    Date: 9-9-19
    DA Data Structures
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

        JTextField tFrac1, tFrac2, tResult;
        JButton bAdd, bSubtract, bMultiply, bDivide;
        Calculator(){

            JFrame f= new JFrame();

            JLabel title = new JLabel("Calculator");
            title.setBounds(75,20,100,15);
            title.setHorizontalAlignment(JLabel.CENTER);

            tFrac1 = new JTextField();
            tFrac1.setText("Enter Value 1");
            tFrac1.setHorizontalAlignment(JTextField.CENTER);
            tFrac1.setBounds(50,50,150,20);

            tFrac2 = new JTextField();
            tFrac2.setText("Enter Value 2");
            tFrac2.setHorizontalAlignment(JTextField.CENTER);
            tFrac2.setBounds(50,100,150,20);

            tResult = new JTextField();
            tResult.setText("Result");
            tResult.setHorizontalAlignment(JTextField.CENTER);
            tResult.setBounds(50,150,150,20);
            tResult.setEditable(false);

            bAdd = new JButton("+");
            bAdd.setBounds(30,200,40,40);

            bSubtract = new JButton("-");
            bSubtract.setBounds(80,200,40,40);

            bMultiply = new JButton("*");
            bMultiply.setBounds(130,200,40,40);

            bDivide = new JButton("/");
            bDivide.setBounds(180,200,40,40);

            bAdd.addActionListener(this);
            bSubtract.addActionListener(this);
            bMultiply.addActionListener(this);
            bDivide.addActionListener(this);


            JTextArea log = new JTextArea();
            log.setBounds(250,10,240,260);
            log.setEditable(false);
            JScrollPane scroll = new JScrollPane(log, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


            f.add(tFrac1);f.add(tFrac2);f.add(tResult);f.add(bAdd);f.add(bSubtract);f.add(bMultiply);f.add(bDivide);f.add(title);f.add(log);f.add(scroll);
            f.setSize(500,300);
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

