/*
    Name: Eli Ji and Rocky Xia
    Date: 9-9-19
    DA Data Structures
*/

public class Fraction implements Comparable<Fraction> {

    private int numerator;
    private int denominator;

    // constructor takes the numerator and denominator and sets up the fraction
    public Fraction(int numerator, int denominator) {
        if(denominator == 0) {
            throw new IllegalArgumentException("denominator can not be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        this.reduce();
        this.reduceSign();
    }

    // constructor takes a whole number and sets up the fraction
    public Fraction(int number) {
        this.numerator = number;
        this.denominator = 1;
        this.reduce();
        this.reduceSign();
    }

    // constructor takes a string representation of a fraction, say “5/12”, and
    // sets up the fraction
    //must have a slash, ex: will not accept "3"
    public Fraction(String fraction) {
        int slashIndex = fraction.indexOf("/");
        if (slashIndex==-1) {
            throw new IllegalArgumentException("fraction must contain a '/'.");
        }
        this.numerator = Integer.parseInt(fraction.substring(0,slashIndex));
        this.denominator = Integer.parseInt(fraction.substring(slashIndex+1,fraction.length()));
        if(this.denominator == 0) {
            throw new IllegalArgumentException("denominator can not be zero");
        }
        this.reduce();
        this.reduceSign();
    }

    // adds fraction f to this fraction - returns the resulting fraction
    public Fraction add(Fraction f) {
        int resultDenom = this.denominator * f.denominator;
        int resultNumer = this.numerator * f.denominator + this.denominator * f.numerator;
        Fraction result = new Fraction(resultNumer, resultDenom);
        return result;
    }

    // subtracts fraction f from this fraction - returns the resulting fraction
    public Fraction subtract(Fraction f) {
        int resultDenom = this.denominator * f.denominator;
        int resultNumer = this.numerator * f.denominator - this.denominator * f.numerator;
        Fraction result = new Fraction(resultNumer, resultDenom);
        return result;
    }

    // multiplies fraction f by this fraction -  returns the resulting fraction
    public Fraction multiply(Fraction f) {
        int numerator = this.numerator * f.numerator;
        int denominator = this.denominator * f.denominator;
        Fraction result = new Fraction (numerator,denominator);
        return result;
    }

    // divides fraction f to this fraction - returns the resulting fraction
    public Fraction divide(Fraction f) {
        int numerator = this.numerator * f.denominator;
        int denominator = this.denominator * f.numerator;
        Fraction result = new Fraction (numerator,denominator);
        return result;
    }

    // returns the decimal representation (approximation) of the fraction
    public double toDecimal() {
        double n = this.numerator;
        double d = this.denominator;
        return (n/d);
    }

    // compares this fraction to another fraction
    // return a negative number if this fraction is less than the other
    // return 0 if the fractions are equal
    // return a positive number if this fraction is greater than the other
    public int compareTo(Fraction f) {
        if(this.subtract(f).toDecimal()>0){
            return 1;
        } else if (this.subtract(f).toDecimal()<0){
            return -1;
        } else {
            return 0;
        }
    }

    // returns a string representation of the fraction
    public String toString() {
        if(denominator == 1 ){
            return Integer.toString(numerator);
        }
        return (numerator + "/" + denominator);
    }

    //returns the greatest common denominator of x and y using the Euclidean Algorithm
    private int GCD (int x, int y){
        int dividend = 0;
        int divisor = 0;
        int remainder =0;
        if(x > y){
            dividend = x;
            divisor = y;
        } else {
            dividend = y;
            divisor = x;
        }

        while(dividend % divisor != 0) {
            remainder = dividend % divisor;
            dividend = divisor;
            divisor = remainder;
        }
        return divisor;
    }

    //removes negative sign if found both in numerator and denominator, brings negative sign to numerator if found only in denominator
    private void reduceSign() {
        if(this.denominator < 0){
            this.numerator = this.numerator * -1;
            this.denominator = this.denominator * -1;
        }
    }

    //reduces fraction to lowest terms by dividing numerator and denominator by greatest common factor
    private void reduce() {
        if(this.numerator == 0){
            this.denominator = 1;
            return;
        }
        int myGCD = GCD(this.numerator, this.denominator);
        this.numerator = this.numerator / myGCD;
        this.denominator = this.denominator / myGCD;
    }
    // do unit testing of this class
   // public static void main(String[] args);
}
