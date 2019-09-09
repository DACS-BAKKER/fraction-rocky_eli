/*
    Name: Eli Ji and Rocky Xia
    Date: 9-9-19
    DA Data Structures
*/

public class FractionRunner {
    public static void main(String[] args) {
        Fraction F1 = new Fraction(1,2);
        System.out.println(F1.getNumerator());
        System.out.println(F1.getDenominator());

        Fraction F2 = new Fraction(5);
        System.out.println(F2.getNumerator());
        System.out.println(F2.getDenominator());

        Fraction F3 = new Fraction("1002/1343");
        System.out.println(F3.getNumerator());
        System.out.println(F3.getDenominator());


    }
}
