import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class ElevatorSystemGUI extends JFrame {
    public static final int FLOOR_COUNT = 4;

    private JTextArea logArea;

    private Elevator elevator;
    private List<Agent> agents;
    private ElevatorPanel elevatorPanel;

    public ElevatorSystemGUI() {
        super("Area 51");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        add(scrollPane, BorderLayout.CENTER);

        elevator = new Elevator(this);
        agents = new ArrayList<>();
        elevatorPanel = new ElevatorPanel(this, elevator);

        createControlPanel();

        add(elevatorPanel, BorderLayout.WEST);

        setVisible(true);
    }

    private void createControlPanel() {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Add Agent");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Agent agent = new Agent("Agent " + (agents.size() + 1), (int) (Math.random() * FLOOR_COUNT) + 1, ElevatorSystemGUI.this);
                agents.add(agent);
                agent.start();
            }
        });

        JButton callButton = new JButton("Call Elevator");
        callButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int targetFloor = (int) (Math.random() * FLOOR_COUNT) + 1;
                elevator.addAgentToQueue(new Agent("Random Agent", (int) (Math.random() * FLOOR_COUNT) + 1, ElevatorSystemGUI.this), targetFloor);
            }
        });

        controlPanel.add(addButton);
        controlPanel.add(callButton);
        add(controlPanel, BorderLayout.SOUTH);
    }

    public synchronized void log(String message) {
        logArea.append(message + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ElevatorSystemGUI();
            }
        });
    }
}

