import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Elevator implements Runnable {
    private int currentFloor;
    private List<Agent> agentQueue;
    private ElevatorSystemGUI gui;
    private ElevatorPanel elevatorPanel;

    private Timer timer;
    private int targetFloor;
    private boolean movingUp;

    public Elevator(ElevatorSystemGUI gui) {
        this.currentFloor = 1;
        this.agentQueue = new ArrayList<>();
        this.gui = gui;
        this.targetFloor = currentFloor;
        this.movingUp = true;

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveElevator();
            }
        });
        timer.start();
    }

    public synchronized void addAgentToQueue(Agent agent, int targetFloor) {
        agent.setTargetFloor(targetFloor);
        agentQueue.add(agent);
        gui.log(agent.getName() + " called the elevator to go to floor " + getFloorName(targetFloor));
        elevatorPanel.repaint();
    }

    public synchronized void processQueue() {
        if (!agentQueue.isEmpty()) {
            Agent currentAgent = agentQueue.remove(0);
            gui.log("Elevator moving from floor " + getFloorName(currentFloor) + " to floor " + getFloorName(currentAgent.getTargetFloor()));
            targetFloor = currentAgent.getTargetFloor();
            elevatorPanel.repaint();
        }
    }

    private void moveElevator() {
        if (currentFloor == targetFloor) {
            processQueue();
            return;
        }

        if (currentFloor < targetFloor) {
            currentFloor++;
        } else {
            currentFloor--;
        }

        elevatorPanel.repaint();
    }

    public void setElevatorPanel(ElevatorPanel elevatorPanel) {
        this.elevatorPanel = elevatorPanel;
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

    public int getCurrentFloor() {
        return currentFloor;
    }

    @Override
    public void run() {

    }
}
