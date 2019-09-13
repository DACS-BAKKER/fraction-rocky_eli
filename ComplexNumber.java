public class ComplexNumber<Public> {

    private double real;
    private double imaginary;

    // constructor takes the real and imaginary parts of the number and sets up the complex number
    public ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    // constructor takes a real number and sets up the complex number
    public ComplexNumber(double number){
        this.real = number;
        this.imaginary = 0;
    }

    // constructor takes a string representation of a complex number, say “1+2i”, and sets up the fraction
    public ComplexNumber(String complexNumber){
        int plusSignIndex = complexNumber.indexOf("+");
        int iIndex = complexNumber.indexOf("i");
        this.real = Double.valueOf(complexNumber.substring(0, plusSignIndex));
        this.imaginary = Double.valueOf(complexNumber.substring(plusSignIndex + 1, iIndex));
    }


    // adds complex number c to this complex number - returns the resulting complex number
    public ComplexNumber add(ComplexNumber c){
        return new ComplexNumber(this.real + c.real, this.imaginary + c.imaginary);
    }

    // subtracts complex number c from this complex number - returns the resulting complex number
    public ComplexNumber subtract(ComplexNumber c){
        return new ComplexNumber(this.real - c.real, this.imaginary - c.imaginary);
    }

    // multiplies complex number c by this complex number -  returns the resulting complex number
    public ComplexNumber multiply(ComplexNumber c){
        return new ComplexNumber(((this.real * c.real) - (this.imaginary * c.imaginary)),
                ((this.real * c.imaginary) + (this.imaginary * c.real)));
    }

    // divides complex number c to this complex number - returns the resulting complex number
    public ComplexNumber divide(ComplexNumber c){
        return new ComplexNumber(((this.real * c.real) + (this.imaginary + c.imaginary)) / ((c.real * c.real) + (c.imaginary * c.imaginary)), ((this.imaginary * c.real) - (this.real * c.imaginary) / ((c.real * c.real) + (c.imaginary * c.imaginary))));
    }

    // compares this complex number to another complex number
    // return a negative number if this complex number is less than the other
    // return 0 if the complex numbers are equal
    // return a positive number if this complex number is greater than the other
    public int compareTo(ComplexNumber c){
        if(this.real < c.real){
            return -1;
        }
        else if(this.real > c.real){
            return 1;
        }
        else if(this.real == c.real){
            if(this.imaginary < c.imaginary){
                return -1;
            }
            else if(this.imaginary > c.imaginary){
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
