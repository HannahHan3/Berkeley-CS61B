/**
 * test planet class
 */

public class TestPlanet{
    public static void main(String[] var0){
        Planet a = new Planet(0,0,0.1,0.1,2,"jupiter.gif");
        Planet b = new Planet(3,4,4,5,1,"jupyter2.gif");
        double F = a.calcForceExertedBy(b);
        System.out.println("The force between a and b is: " + F);
    }
}