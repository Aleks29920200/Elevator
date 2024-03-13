public class Agent extends Thread {
    private String name;
    private int securityLevel;
    private int currentFloor;
    private int targetFloor;
    private boolean isPressingButtonInside;
    private ElevatorSystemGUI gui;

    public Agent(String name, int securityLevel, ElevatorSystemGUI gui) {
        this.name = name;
        this.securityLevel = securityLevel;
        this.currentFloor = 1;
        this.isPressingButtonInside = false;
        this.gui = gui;
    }

    public int getSecurityLevel() {
        return securityLevel;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public void setTargetFloor(int targetFloor) {
        this.targetFloor = targetFloor;
    }

    public boolean isPressingButtonInside() {
        return isPressingButtonInside;
    }

    public void setPressingButtonInside(boolean pressingButtonInside) {
        isPressingButtonInside = pressingButtonInside;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            int targetFloor = (int) (Math.random() * ElevatorSystemGUI.FLOOR_COUNT) + 1;
            gui.log(name + " is moving to floor " + getFloorName(targetFloor));
            gui.log(name + " pressed the elevator button on floor " + getFloorName(currentFloor) + " for floor " + getFloorName(targetFloor));
            gui.log(name + " is waiting for the elevator...");

            gui.log(name + " entered the elevator.");
            gui.log(name + " pressed the button inside the elevator for floor " + getFloorName(targetFloor));

            try {
                Thread.sleep(2000); // Simulate time inside the elevator
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            gui.log(name + " is leaving the elevator on floor " + getFloorName(targetFloor));
            currentFloor = targetFloor;
            isPressingButtonInside = false;
            gui.log(name + " is moving around...");
            try {
                Thread.sleep(2000); // Simulate time moving around
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gui.log(name + " left the base.");
        gui.log(name + " is moving around...");
        gui.log(name + " left the base.");
        gui.log(name + " is moving around...");
        gui.log(name + " left the base.");
    }

    private String getFloorName(int floor) {
        switch (floor) {
            case 1:
                return "G";
            case 2:
                return "S";
            case 3:
                return "T1";
            case 4:
                return "T2";
            default:
                return "Unknown";
        }
    }
}
