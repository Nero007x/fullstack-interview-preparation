class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];

        // Step 1: Create a car object with position and time to reach target
        for (int i = 0; i < n; i++) {
            double time = (double)(target - position[i]) / speed[i];
            cars[i] = new Car(position[i], time);
        }

        // Step 2: Sort cars by position in descending order
        Arrays.sort(cars, (a, b) -> b.position - a.position);

        // Step 3: Use stack to count fleets
        Stack<Double> stack = new Stack<>();
        for (Car car : cars) {
            if (stack.isEmpty() || car.time > stack.peek()) {
                stack.push(car.time); // New fleet
            }
            // else: car joins previous fleet → do nothing
        }

        return stack.size();
    }

    // Helper class to pair position and time
    static class Car {
        int position;
        double time;
        Car(int pos, double t) {
            this.position = pos;
            this.time = t;
        }
    }
}
