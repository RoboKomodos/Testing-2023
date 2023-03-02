package frc.robot;

public class SpeedCurve {
    
    Constants cons = new Constants();

    private double speedMultiplier = 0;

    public double getSpeedMultiplier() {
        return speedMultiplier;
    }

    public void updateSpeedCurve(double joy) {
        if (joy > 0) {
            if (speedMultiplier < 1) {
                speedMultiplier = speedMultiplier + 0.01;
            }
        } else {
            if (speedMultiplier > 0) {
                speedMultiplier = speedMultiplier - 0.01;
            }
        }
        if (speedMultiplier < 0) {
            speedMultiplier = 0;
        } else if (speedMultiplier > 1) {
            speedMultiplier = 1;
        }
    }

}
