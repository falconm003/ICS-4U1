public class Circle {
    public double radius;
    public Circle(double r) {
    radius = r;
    }
    public void setRadius(double rad) {
    radius = rad;
    }
    public double area() {
    return (Math.PI * Math.pow(radius, 2));
    }
    public double circumference() {
    return (2 * Math.PI * radius);
    }
    public double diameter() {
    return (2 * radius);
    } 
    public String toString() {
        return "Area: " + area()
                + "\nCircumfrence: " + circumference()
                + "\nDiameter: " + diameter();
    }
}
