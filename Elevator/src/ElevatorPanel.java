import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ElevatorPanel extends JPanel {
    private ElevatorSystemGUI gui;
    private Elevator elevator;
    private List<ElevatorButton> elevatorButtons;

    private int doorAnimationCounter;
    private boolean doorsOpen;

    public ElevatorPanel(ElevatorSystemGUI gui, Elevator elevator) {
        this.gui = gui;
        this.elevator = elevator;
        this.elevatorButtons = new ArrayList<>();
        this.doorAnimationCounter = 0;
        this.doorsOpen = false;

        setLayout(new GridLayout(ElevatorSystemGUI.FLOOR_COUNT + 1, 1));

        for (int i = ElevatorSystemGUI.FLOOR_COUNT; i >= 1; i--) {
            ElevatorButton button = new ElevatorButton(i, gui, elevator);
            elevatorButtons.add(button);
            add(button);
        }

        elevator.setElevatorPanel(this);
        startDoorAnimation();
    }

    private void startDoorAnimation() {
        Timer doorTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doorAnimationCounter++;
                if (doorAnimationCounter == 4) {
                    doorsOpen = !doorsOpen;
                    doorAnimationCounter = 0;
                    repaint();
                }
            }
        });
        doorTimer.start();
    }

    public void disableAllButtons() {
        for (ElevatorButton button : elevatorButtons) {
            button.setEnabled(false);
        }
    }

    public void enableButtons() {
        for (ElevatorButton button : elevatorButtons) {
            button.setEnabled(true);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int elevatorPosition = ElevatorSystemGUI.FLOOR_COUNT - elevator.getCurrentFloor();
        int cabinHeight = getHeight() / (ElevatorSystemGUI.FLOOR_COUNT + 1);

        // Draw elevator doors
        if (doorsOpen) {
            g.setColor(Color.LIGHT_GRAY);
        } else {
            g.setColor(Color.DARK_GRAY);
        }
        g.fillRect(getWidth() - doorAnimationCounter * (getWidth() / 4), elevatorPosition * cabinHeight, doorAnimationCounter * (getWidth() / 4), cabinHeight);

        // Draw elevator cabin
        g.setColor(Color.BLUE);
        g.fillRect(0, elevatorPosition * cabinHeight, getWidth(), cabinHeight);

        // Draw elevator shaft
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }
}
