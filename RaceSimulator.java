import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class RaceSimulator {

    // --- Configuration Constants ---
    private static final int MAX_TYRE_WEAR = 100;
    private static final int MAX_FUEL = 100;
    private static final int LAPS = 20;
    private static final int PIT_STOP_TIME = 20; // Seconds lost during pit stop
    private static final int FUEL_PER_LAP = 5;
    private static final int TYRE_WEAR_PER_LAP = 7;
    private static final double BASE_LAP_TIME = 80.0; // Base lap time in seconds

    // Race Strategy: pit every X laps
    private static final int PIT_EVERY = 7;

    public static class Car {
        private double tyreWear;
        private double fuel;
        private double totalTime;
        private List<Double> lapTimes;
        private Random random;

        public Car() {
            this.tyreWear = 0.0;
            this.fuel = MAX_FUEL;
            this.totalTime = 0.0;
            this.lapTimes = new ArrayList<>();
            // Initialize Random object for lap time variation
            this.random = new Random();
        }

        public void doLap(int lapNum) {
            // Calculate lap time penalties
            double tyrePenalty = this.tyreWear * 0.2;
            // Fuel penalty based on original Python logic
            double fuelPenalty = (MAX_FUEL - this.fuel) * 0.05;

            // Calculate final lap time including a random variation (-1.0 to +1.0)
            double lapTime = BASE_LAP_TIME + tyrePenalty + fuelPenalty + (random.nextDouble() * 2.0 - 1.0);

            // Update car state
            this.lapTimes.add(lapTime);
            this.totalTime += lapTime;

            this.tyreWear += TYRE_WEAR_PER_LAP;
            this.fuel -= FUEL_PER_LAP;

            // Output lap data, using Locale.US for consistent decimal formatting
            System.out.format(Locale.US, "Lap %d: %.2fs (Tyre wear: %.0f, Fuel left: %.0f)%n",
                    lapNum + 1, lapTime, this.tyreWear, this.fuel);
        }

        public void pitStop() {
            System.out.format("--> Pit stop! (+%ds)%n", PIT_STOP_TIME);
            // Apply pit stop time penalty
            this.totalTime += PIT_STOP_TIME;
            // Reset tyre wear and refuel
            this.tyreWear = 0.0;
            this.fuel = MAX_FUEL;
        }

        // Getter methods
        public double getTotalTime() {
            return totalTime;
        }

        public List<Double> getLapTimes() {
            return lapTimes;
        }
    }

    public static void simulateRace() {
        Car car = new Car();
        // Loop through all defined laps
        for (int lap = 0; lap < LAPS; lap++) {
            // Check pit strategy condition (pit before the lap starts)
            if (lap > 0 && lap % PIT_EVERY == 0) {
                car.pitStop();
            }
            car.doLap(lap);
        }

        // --- Final Results Output ---
        System.out.println("\nRace finished!");
        System.out.format(Locale.US, "Total time: %.2f seconds%n", car.getTotalTime());

        // Format and print all individual lap times
        System.out.print("Lap times: [");
        List<Double> times = car.getLapTimes();
        for (int i = 0; i < times.size(); i++) {
            System.out.format(Locale.US, "%.2fs", times.get(i));
            if (i < times.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Main method to execute the simulation
    public static void main(String[] args) {
        simulateRace();
    }
}