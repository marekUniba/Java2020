public class Complx {
    private double real, imag;

    public Complx(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "[" +
                "real=" + real +
                ", imag=" + imag +
                ']';
    }
}
