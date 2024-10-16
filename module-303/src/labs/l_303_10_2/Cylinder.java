package labs.l_303_10_2;

public class Cylinder extends Circle {
    private final double PI = Math.PI;

    public Cylinder(double radius, double height) {
        super(radius, height);
        // TODO Auto-generated constructor stub
    }

    public Cylinder(double radius) {
        super(radius);
    }

    /**
     * Returns the volume of this cylinder
     */
    public double getVolume() {
        return (PI * Math.pow(super.radius, 2)) * super.height;
    }

    public double getSurfaceArea() {
        return 2.0 * Math.PI * super.radius * super.height;
    }

    @Override
    public void displayShapeName() {
        System.out.println("Drawing a Cylinder for radius " + super.radius);
    }

    public String toString() {
        return "radius is: " + super.radius + "height is : " + super.height;

    }
}
