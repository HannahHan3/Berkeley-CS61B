/**
 * NBody is a class that will actually run your simulation.
 * This class will have NO constructor.
 * The goal of this class is to simulate a universe specified in one of the data files
 */

public class NBody{

    public static double readRadius(String fileName) {
        if (fileName.length() == 0) {
            System.out.println("Please supply a filename.");
        }
        /* Start reading */
        In in = new In(fileName);
        in.readLine();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String fileName){
        In in = new In(fileName);
        int N = in.readInt();
        double radius = in.readDouble();
        Planet[] allPlanets = new Planet[5];

        for(int i=0; i<5; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            allPlanets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return allPlanets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] allPlanets = NBody.readPlanets(filename);
        double radius = NBody.readRadius(filename);
        String background = "images/starfield.jpg";
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        double st = 0;

        for (st = 0; st <= T; st += dt) {
            double[] xForce = new double[5];
            double[] yForce = new double[5];
            for (int i = 0; i < 5; i++) {
                xForce[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
                yForce[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
                allPlanets[i].update(dt, xForce[i], yForce[i]);
            }

            StdDraw.picture(0, 0, background);
            for (Planet p : allPlanets) {
                p.draw();
            }
            StdDraw.show(10);
        }
    }



}