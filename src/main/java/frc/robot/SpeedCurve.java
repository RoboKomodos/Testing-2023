package frc.robot;

public class SpeedCurve {
    
    Constants cons = new Constants();

    private double speedMultiplier = 0;
    private double lastJoy = 0;

    public double getSpeedMultiplier() {
        return speedMultiplier;
    }

    public void updateSpeedCurve(double joy) {
        if (joy > 0.05 || joy < -0.05) {
            lastJoy = joy;
            if (speedMultiplier < 1) {
                speedMultiplier = speedMultiplier+0.01;
            } else {
                speedMultiplier = 1;
            }
        }
        if (joy >= 0.05 && joy >= -0.05) {
            if (speedMultiplier > 0) {
                speedMultiplier = speedMultiplier - 0.01;
            } else {
                speedMultiplier = 0;
            }
        }
    }

    public double getFinalSpeed(double joy) {
        double multi = 0;
        if (joy > 0.05 || joy < -0.05) {
            multi = joy;
        } else if (joy <= 0.05 || joy >= -0.05) {
            multi = lastJoy;
        }
        return (multi*speedMultiplier);
    }

    public boolean useLastJoy(double joy) {
        if (joy > 0.05 || joy < -0.05) {
            return false;
        } else if (joy <= 0.05 || joy >= -0.05) {
            return true;
        } 
        return false;
    }

}
