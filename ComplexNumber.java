public class ComplexNumber<Public> {

    private Fraction real;
    private Fraction imaginary;

    // constructor takes the real and imaginary parts of the number and sets up the complex number
    public ComplexNumber(Fraction real, Fraction imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    // constructor takes a real number and sets up the complex number
    public ComplexNumber(Fraction number){
        this.real = number;
        this.imaginary = new Fraction(0, 1);
    }

    // constructor takes a string representation of a complex number, say “1+2i”, and sets up the fraction
    public ComplexNumber(String complexNumber){
        int plusSignIndex = complexNumber.indexOf("+");
        int iIndex = complexNumber.indexOf("i");
        this.real = new Fraction(Integer.valueOf(complexNumber.substring(0, plusSignIndex)));
        this.imaginary = new Fraction(Integer.valueOf(complexNumber.substring(plusSignIndex + 1, iIndex)));
    }


    // adds complex number c to this complex number - returns the resulting complex number
    public ComplexNumber add(ComplexNumber c){
        return new ComplexNumber(this.real.add(c.real), this.imaginary.add(c.imaginary));
    }

    // subtracts complex number c from this complex number - returns the resulting complex number
    public ComplexNumber subtract(ComplexNumber c){
        return new ComplexNumber(this.real.subtract(c.real), this.imaginary.subtract(c.imaginary));
    }

    // multiplies complex number c by this complex number -  returns the resulting complex number
    public ComplexNumber multiply(ComplexNumber c){
        return new ComplexNumber(((this.real.multiply(c.real)).subtract((this.imaginary.multiply(c.imaginary)))),
                ((this.real.multiply(c.imaginary)).add((this.imaginary.multiply(c.real)))));
    }

    // divides complex number c to this complex number - returns the resulting complex number
    public ComplexNumber divide(ComplexNumber c){
        return new ComplexNumber(
                new Fraction((this.real.multiply(c.real).add(this.imaginary.multiply(c.imaginary))), (c.real.multiply(c.real).add(c.imaginary.multiply(c.imaginary)))),
                new Fraction((this.imaginary.multiply(c.real).subtract(this.real.multiply(c.imaginary))), (c.real.multiply(c.real).add(c.imaginary.multiply(c.imaginary))));
    }

    // compares this complex number to another complex number
    // return a negative number if this complex number is less than the other
    // return 0 if the complex numbers are equal
    // return a positive number if this complex number is greater than the other
    public int compareTo(ComplexNumber c){
        if(this.real.compareTo(c.real) < 0){
            return -1;
        }
        else if(this.real.compareTo(c.real) > 0){
            return 1;
        }
        else if(this.real.equals(c.real)){
            if(this.imaginary.compareTo(c.imaginary) < 0){
                return -1;
            }
            else if(this.imaginary.compareTo(c.imaginary) > 0){
                return 1;
            }
        }
        return 0;
    }

    // returns a string representation of the complex number
    public String toString(){
        return this.real + "+" + this.imaginary + "i";
    }

    // do unit testing of this class
    public static void main(String[] args){}
}
