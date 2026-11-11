
public class BusiestTrafficWindow {

    public static void main(String[] args) {

        // Requests per minute for 24 hours
        int[] requests = new int[1440];

        // Generate sample traffic data
        for (int i = 0; i < 1440; i++) {

            requests[i] = 10 + (i % 5);

            // High traffic between 10 AM and 1 PM
            if (i >= 600 && i < 780) {
                requests[i] += 40;
            }
        }

        // 3 hours = 180 minutes
        int window = 180;

        // Calculate first window sum
        int sum = 0;

        for (int i = 0; i < window; i++) {
            sum += requests[i];
        }

        int maxSum = sum;
        int start = 0;

        // Sliding Window technique
        for (int i = window; i < requests.length; i++) {

            sum = sum + requests[i] - requests[i - window];

            if (sum > maxSum) {
                maxSum = sum;
                start = i - window + 1;
            }
        }

        // Calculate ending time
        int end = start + window;

        // Display result
        System.out.println("BUSIEST TRAFFIC WINDOW");

        System.out.println("Start Time: " + getTime(start));

        System.out.println("End Time: " + getTime(end));

        System.out.println("Total Requests: " + maxSum);

        System.out.println("Duration: 3 Hours");
    }

    // Convert minutes into HH:MM format
    static String getTime(int minutes) {

        int hour = minutes / 60;
        int min = minutes % 60;

        return String.format("%02d:%02d", hour, min);
    }
}
