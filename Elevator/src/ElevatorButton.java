import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElevatorButton extends JButton {
    private int floor;
    private ElevatorSystemGUI gui;
    private Elevator elevator;

    public ElevatorButton(int floor, ElevatorSystemGUI gui, Elevator elevator) {
        super("Floor " + floor);
        this.floor = floor;
        this.gui = gui;
        this.elevator = elevator;

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elevator.addAgentToQueue(new Agent("Passenger", 1, gui), floor);
            }
        });
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
