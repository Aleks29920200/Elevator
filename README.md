Elevator System for Base "Area 51"

Welcome to the Elevator System project for Base "Area 51"! This project aims to simulate the operation of an elevator within a highly secure facility, catering to agents with different security clearances. Below, you'll find all the necessary information to understand, set up, and run the project effectively.

Project Overview:
The Elevator System for Base "Area 51" is designed to provide secure and efficient transportation for agents across four floors of the facility. The elevator system incorporates various features such as security clearance checks, button controls, and multi-threading to ensure smooth operation within the base.

Features:

Security Clearance Levels: Agents are classified into three security clearance levels: Confidential, Secret, and Top-Secret, determining their access to different floors within the base.
Button Controls: Each floor is equipped with a button to call the elevator, while inside the elevator, there are buttons corresponding to each floor for agent selection.
Security Checks: The elevator door opens only if the agent inside possesses the required security clearance for the selected floor.
Multi-threading: Agents and the elevator are managed by separate threads, allowing concurrent operation within the system.
Random Agent Movement: Agents' movements within the base are simulated randomly, adding realism to the project.
Simulation: The project includes a simulation of agents arriving at the base, calling the elevator, moving around, and eventually leaving.
Project Structure:

Agent.cs: Defines the Agent class with properties for security clearance level.
Elevator.cs: Contains the implementation of the Elevator class with methods for elevator operation and security checks.
Program.cs: The entry point of the application where the simulation is initialized and executed.
README.md: This file, providing an overview of the project and instructions for setup and usage.
Setup Instructions:

Clone the repository to your local machine.
Open the project in your preferred Java development environment (e.g., Intellij).
Build the solution to ensure all dependencies are resolved.
Run the program to start the simulation.
Usage:

Upon running the program, agents of different security clearance levels will be simulated arriving at the base, calling the elevator, and moving around.
Follow the on-screen prompts to observe the elevator system in action.
Agents' movements and elevator operations will be displayed in the console.
Contributing:

Contributions to this project are welcome! Feel free to fork the repository, make improvements, and submit pull requests.
License:

This project is made by Alexandar Kovachev
