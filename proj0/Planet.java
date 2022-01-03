public class Planet{
    public double xxPos; // x position //
    public double yyPos; // y position //
    public double xxVel; // current velocity in x direction //
    public double yyVel; // current velocity in y direction //
    public double mass; // its mass //
    public String imgFileName; // the name of the file that correspond to the image that depicts the planet //
                                // eg: Jupiter.gif //

    public Planet(double xxPos, double yyPos, double xxVel,
                  double yyVel, double mass, String imgFileName){
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }


    public double calcDistance(Planet b){
        double dx = this.xxPos - b.xxPos;
        double dy = this.yyPos - b.yyPos;
        double distance = dx * dx + dy * dy;
        return Math.sqrt(distance);

    }


    public double calcForceExertedBy(Planet p){
        double G = 6.67 * Math.pow(10,-11);
        double F = G * this.mass * p.mass / (this.calcDistance(p) * this.calcDistance(p));
        return F;

    }

    public double calcForceExertedByX(Planet p){
        double F = this.calcForceExertedBy(p);
        double dx = this.xxPos - p.xxPos;
        if (dx < 0){
            dx = -dx;
        }else{
            ;
        }
        return F * dx / this.calcDistance(p);
    }

    public double calcForceExertedByY(Planet p){
        double F = this.calcForceExertedBy(p);
        double dy = this.yyPos - p.yyPos;
        if (dy < 0){
            dy = -dy;
        }else{
            ;
        }
        return F * dy / this.calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] allPlanets){
        double fNetx = 0;
        for (Planet p: allPlanets){
            if (!this.equals(p)) {
                fNetx = fNetx + this.calcForceExertedByX(p);
            }
        }
        return fNetx;
    }
    public double calcNetForceExertedByY(Planet[] allPlanets){
        double fNety = 0;
        for (Planet p: allPlanets){
            if (!this.equals(p)) {
                fNety = fNety + this.calcForceExertedByY(p);
            }
        }
        return fNety;
    }
/*
1.Calculate the acceleration using the provided x- and y-forces.
2.Calculate the new velocity by using the acceleration and current velocity.
  Recall that acceleration describes the change in velocity per unit time, so the new velocity is (vx+dt⋅ax,vy+dt⋅ay).
3.Calculate the new position by using the velocity computed in step 2 and the current position.
  The new position is (px+dt⋅vx,py+dt⋅vy).
 */
    public void update(double period, double xForce,double yForce){
        double aNetx = xForce / this.mass;
        double aNety = yForce / this.mass;
        this.xxVel = this.xxVel + period * aNetx;
        this.yyVel = this.yyVel + period * aNety;
        this.xxPos = this.xxPos + period * this.xxVel;
        this.yyPos = this.yyPos + period * this.yyVel;

    }

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);

    }






        }






