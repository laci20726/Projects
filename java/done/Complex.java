public class Complex{


    private final double real;
    private final double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return real + "+" + imag + "i";
    }

    public Complex add(Complex alap) {
        double newReal = this.real + alap.real;
        double newImag = this.imag + alap.imag;

        return new Complex(newReal, newImag);
    }

    public Complex mul(Complex alap) {

        double newReal = this.real * alap.real - this.imag * alap.imag;
        double newImag = this.real * alap.imag + this.imag * alap.real;

        return new Complex(newReal, newImag);
    }

    public static void main(String[] args) {
        Complex numb1 = new Complex(5, 10);
        Complex numb2 = new Complex(10, 5);

        Complex addResult = numb2.add(numb1);
        Complex mulResult = numb2.mul(numb1);

        System.out.println(addResult);
        System.out.println(mulResult);

    }
    

}