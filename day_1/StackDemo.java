import java.util.*; 
class StackImplementation {
 
    int stack[] = new int[5];
    int top = -1;
 
    
    void push(int value) {
 
        if (top == 4) {
            System.out.println("Stack Overflow!");
        } else {
            top++;
            stack[top] = value;
 
            System.out.println(value + " push successfully");
        }
    }
 
    
    void pop() {
 
        if (top == -1) {
            System.out.println("Stack Underflow!");
        } else {
            System.out.println("Deleted Element: " + stack[top]);
            top--;
        }
    }
 
    // SHOW FUNCTION
    void show() {
 
        if (top == -1) {
            System.out.println("Stack is Empty");
        } else {
 
            System.out.println("Stack Elements:");
 
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }
        void peek() {

        if (top == -1) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("Topmost Element: " + stack[top]);
        }
    }
}
 
public class StackDemo {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        StackImplementation s = new StackImplementation();
 
        int choice, value;
 
        do {
 
            System.out.println("\n===== STACK MENU =====");
            System.out.println("1. PUSH");
            System.out.println("2. POP");
            System.out.println("3. SHOW");
            System.out.println("4. PEEK");
            System.out.println("5. EXIT");
 
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
 
            switch (choice) {
 
                case 1:
                    System.out.print("Enter value: ");
                    value = sc.nextInt();
                    s.push(value);
                    break;
 
                case 2:
                    s.pop();
                    break;
 
                case 3:
                    s.show();
                    break;
                case 4:
                    s.peek();
                    break;    
 
                case 5:
                    System.out.println("Thank You!");
                    break;
 
                default:
                    System.out.println("Invalid Choice!");
            }
 
        } while (choice != 5);
 
        sc.close();
    }
}