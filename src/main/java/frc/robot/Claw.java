package frc.robot;

public class Claw {
    
    private double inactiveSpeed = -0.1;
    private double activeSpeed = 0.1;
    private boolean active = false;

    public double getIdleSpeed() {
        if (active == true) {
            return activeSpeed;
        } else {
            return inactiveSpeed;
        }
    }

    public void setClawState(Boolean state) {
        active = state;
    }

}
