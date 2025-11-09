# Java Race Simulator
A simple command-line application developed in Java to simulate a single race car's performance over multiple laps, accounting for factors like fuel consumption, tyre wear, and pit stop strategy.

# Project Overview
This simulator models basic vehicle dynamics to calculate the total race time. It is designed to illustrate object-oriented programming (OOP) principles through the Car class and to allow for easy modification of racing parameters and strategies.

 # Core Features
# Dynamic Lap Times:
Lap times are affected by accumulating tyre wear (slowing the car down) and fuel weight (which, based on the current logic, slightly speeds the car up as the fuel tank empties).
# Pit Stop Strategy:
Includes logic for automatic pit stops based on a pre-defined interval (PIT_EVERY).
# Random Variation:
Adds a small random element to each lap time to simulate unpredictable racing conditions.

# Technologies Used
Language: Java
Build Tool: Standard Java compiler (Javac) and runtime environment (JRE).

# Getting Started
Follow these steps to set up and run the simulator locally.

# Prerequisites
You need to have the Java Development Kit (JDK) installed on your system.

# Installation and Execution
Save the File: Save the provided code as a file named RaceSimulator.java.

Compile: Open your command line or terminal and navigate to the directory where you saved the file. Compile the code using the Java compiler:
javac RaceSimulator.java

Run: Execute the compiled class file:
java RaceSimulator

# Example Output
The console output will track the progress of the race lap-by-lap, showing the instantaneous speed and resource status, followed by the final results
Lap 1: 84.81s (Tyre wear: 7, Fuel left: 95)
...
--> Pit stop! (+20s)
Lap 8: 80.45s (Tyre wear: 7, Fuel left: 95)
...
Race finished!
Total time: 1720.55 seconds
Lap times: [84.81s, 84.15s, 83.50s, 82.85s, 82.25s, 81.67s, 81.02s, 80.45s, ...]

# Configuration
The racing parameters can be easily modified by changing the constant variables at the beginning of the RaceSimulator.java file.

# Constant Description
LAPS = Total number of laps in the race (default: 20)
BASE_LAP_TIME = The theoretical fastest lap time with new tyres and a full tank (default: 80.0s)
TYRE_WEAR_PER_LAP = Rate at which tyre wear accumulates each lap (default: 7)
FUEL_PER_LAP = Amount of fuel consumed each lap (default: 5)
PIT_STOP_TIME = Time added to the total race time for a pit stop (default: 20s)
PIT_EVERY = The lap interval for automatic pit stops (default: 7)
