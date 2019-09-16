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

        JTextField in1, in2, tResult;
        JButton bAdd, bSubtract, bMultiply, bDivide;
        JTextArea log;
        JScrollPane scroll;

    Calculator(){

            JFrame f= new JFrame();

            JLabel title = new JLabel("Calculator");
            title.setBounds(75,20,100,15);
            title.setHorizontalAlignment(JLabel.CENTER);

            in1 = new JTextField();
            in1.setText("Enter Value 1");
            in1.setHorizontalAlignment(JTextField.CENTER);
            in1.setBounds(50,50,150,20);

            in2 = new JTextField();
            in2.setText("Enter Value 2");
            in2.setHorizontalAlignment(JTextField.CENTER);
            in2.setBounds(50,100,150,20);

            tResult = new JTextField();
            tResult.setText("Result");
            tResult.setHorizontalAlignment(JTextField.CENTER);
            tResult.setBounds(50,150,150,20);
            tResult.setEditable(false);

            bAdd = new JButton("+");
            bAdd.setBounds(30,200,40,40);

            bSubtract = new JButton("-");
            bSubtract.setBounds(80,200,40,40);

            bMultiply = new JButton("×");
            bMultiply.setBounds(130,200,40,40);

            bDivide = new JButton("÷");
            bDivide.setBounds(180,200,40,40);

            bAdd.addActionListener(this);
            bSubtract.addActionListener(this);
            bMultiply.addActionListener(this);
            bDivide.addActionListener(this);


            log = new JTextArea();
            log.setEditable(false);
            scroll = new JScrollPane(log, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scroll.setBounds(250,10,240,260);


            f.add(in1);f.add(in2);f.add(  tResult);f.add(bAdd);f.add(bSubtract);f.add(bMultiply);f.add(bDivide);f.add(title);f.add(scroll);
            f.setSize(500,300);
            f.setLayout(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            int posCounter = 0;
            String sin1 = in1.getText();
            String sin2 = in2.getText();
            if((sin1.indexOf("i") == -1) && (sin2.indexOf("i") == -1)){
                Fraction f1, f2, rFraction;
                f1 = new Fraction(sin1);
                f2 = new Fraction(sin2);
                if(e.getSource()==bAdd){
                    rFraction = f1.add(f2);
                    tResult.setText(rFraction.toString());
                    String resultStr = f1.toString() + " + " + f2.toString() + " = " + rFraction.toString() + "\n";
                    log.insert(resultStr, posCounter);
                    posCounter++;
                }else if(e.getSource()==bSubtract){
                    rFraction = f1.subtract(f2);
                    String resultStr = f1.toString() + " - " + f2.toString() + " = " + rFraction.toString() + "\n";
                    log.insert(resultStr, posCounter);
                    posCounter++;
                    tResult.setText(rFraction.toString());
                }else if(e.getSource()==bMultiply){
                    rFraction = f1.multiply(f2);
                    String resultStr = f1.toString() + " × " + f2.toString() + " = " + rFraction.toString() + "\n";
                    log.insert(resultStr, posCounter);
                    posCounter++;
                    tResult.setText(rFraction.toString());
                }else if(e.getSource()==bDivide) {
                    rFraction = f1.divide(f2);
                    tResult.setText(rFraction.toString());
                    String resultStr = f1.toString() + " ÷ " + f2.toString() + " = " + rFraction.toString() + "\n";
                    log.insert(resultStr, posCounter);
                    posCounter++;
                }
            }
            else if((sin1.indexOf("i") != -1) && (sin2.indexOf("i") != -1)){
                ComplexNumber c1, c2, rComplexNumber;
                c1 = new ComplexNumber(sin1);
                c2 = new ComplexNumber(sin2);
                if(e.getSource()==bAdd){
                    rComplexNumber = c1.add(c2);
                    tResult.setText(rComplexNumber.toString());
                    String resultStr = c1.toString() + " + " + c2.toString() + " = " + rComplexNumber.toString() + "\n";
                    log.insert(resultStr, posCounter);
                    posCounter++;
                }else if(e.getSource()==bSubtract){
                    rComplexNumber = c1.subtract(c2);
                    tResult.setText(rComplexNumber.toString());
                    String resultStr = c1.toString() + " - " + c2.toString() + " = " + rComplexNumber.toString() + "\n";
                    log.insert(resultStr, posCounter);
                    posCounter++;
                }else if(e.getSource()==bMultiply){
                    rComplexNumber = c1.multiply(c2);
                    tResult.setText(rComplexNumber.toString());
                    String resultStr = c1.toString() + " × " + c2.toString() + " = " + rComplexNumber.toString() + "\n";
                    log.insert(resultStr, posCounter);
                    posCounter++;
                }else if(e.getSource()==bDivide){
                    rComplexNumber = c1.divide(c2);
                    tResult.setText(rComplexNumber.toString());
                    String resultStr = c1.toString() + " ÷ " + c2.toString() + " = " + rComplexNumber.toString() + "\n";
                    log.insert(resultStr, posCounter);
                    posCounter++;
                }
            }
            else{
                log.insert("ERROR: Mismatching value types" + "\n", posCounter);
                posCounter++;
            }
        }
        public static void main(String[] args) {
            new Calculator();
        }
    }

