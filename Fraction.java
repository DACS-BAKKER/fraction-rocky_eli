public class Fraction implements Comparable<Fraction>{

    private int numerator;
    private int denominator

    // constructor takes the numerator and denominator and sets up the fraction
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // constructor takes a whole number and sets up the fraction
    public Fraction(int number) {
        this.numerator = number;
        this.denominator = 1;
    }

    // constructor takes a string representation of a fraction, say “5/12”, and
    // sets up the fraction
    public Fraction(String fraction) {
        int slashIndex = fraction.indexOf("/");
        this.numerator = Integer.parseInt(fraction.substring(0,slashIndex));
        this.denominator = Integer.parseInt(fraction.substring(slashIndex,fraction.length()-1));
    }

    // adds fraction f to this fraction - returns the resulting fraction
    public Fraction add(Fraction f)

    // subtracts fraction f from this fraction - returns the resulting fraction
    public Fraction subtract(Fraction f)

    // multiplies fraction f by this fraction -  returns the resulting fraction
    public Fraction multiply(Fraction f)

    // divides fraction f to this fraction - returns the resulting fraction
    public Fraction divide(Fraction f)

    // returns the decimal representation (approximation) of the fraction
    public double toDecimal()

    // compares this fraction to another fraction
    // return a negative number if this fraction is less than the other
    // return 0 if the fractions are equal
    // return a positive number if this fraction is greater than the other
    public int compareTo(Fraction f)

    // returns a string representation of the fraction
    public String toString()

    // do unit testing of this class
    public static void main(String[] args);

    public
}
