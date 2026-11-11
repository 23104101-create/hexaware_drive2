import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Integer, Double> employee = new HashMap<>();

        employee.put(101, 25000.0);
        employee.put(102, 30000.0);
        employee.put(103, 35000.0);

        // Updating the salary for employee ID 101
        employee.put(101, 40000.0);

        for (Integer key : employee.keySet()) {
            System.out.println(key + "    " + employee.get(key));
        }
    }
}