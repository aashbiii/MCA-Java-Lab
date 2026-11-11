public class PG37GenericClassDemo {

    // Generic class with type parameter <T>
    static class Box<T> {
        private T value;

        public Box(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void displayType() {
            System.out.println("Type : " + value.getClass().getName());
            System.out.println("Value: " + value);
        }
    }

    // Generic class with TWO type parameters <K, V> — like a Key-Value Pair
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key   = key;
            this.value = value;
        }

        public K getKey()   { return key;   }
        public V getValue() { return value; }

        public void display() {
            System.out.println("Key: " + key + "  |  Value: " + value);
        }
    }

    // Generic Stack class using an array
    static class Stack<T> {
        private Object[] data;
        private int top;
        private int capacity;

        public Stack(int capacity) {
            this.capacity = capacity;
            data = new Object[capacity];
            top  = -1;
        }

        public void push(T item) {
            if (top == capacity - 1) {
                System.out.println("Stack Overflow!");
                return;
            }
            data[++top] = item;
            System.out.println(item + " pushed to stack");
        }

        @SuppressWarnings("unchecked")
        public T pop() {
            if (top == -1) {
                System.out.println("Stack Underflow!");
                return null;
            }
            return (T) data[top--];
        }

        @SuppressWarnings("unchecked")
        public T peek() {
            if (top == -1) return null;
            return (T) data[top];
        }

        public boolean isEmpty() { return top == -1; }

        public void display() {
            System.out.print("Stack (top→bottom): ");
            for (int i = top; i >= 0; i--)
                System.out.print(data[i] + " ");
            System.out.println();
        }
    }

    // ── main ──────────────────────────────────────────────────────────────
    public static void main(String[] args) {

        // ---- Box<T> demo ------------------------------------------------
        System.out.println("===== Box<T> =====");

        Box<Integer> intBox = new Box<>(42);
        intBox.displayType();

        Box<String> strBox = new Box<>("Hello Java");
        strBox.displayType();

        Box<Double> dblBox = new Box<>(3.14);
        dblBox.displayType();

        // ---- Pair<K,V> demo ---------------------------------------------
        System.out.println("\n===== Pair<K,V> =====");

        Pair<Integer, String> student = new Pair<>(101, "Alice");
        student.display();

        Pair<String, Double> score = new Pair<>("Math", 98.5);
        score.display();

        Pair<String, String> country = new Pair<>("Capital", "New Delhi");
        country.display();

        // ---- Stack<T> demo ----------------------------------------------
        System.out.println("\n===== Stack<T> (Integer) =====");
        Stack<Integer> intStack = new Stack<>(5);
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        intStack.display();
        System.out.println("Peek : " + intStack.peek());
        System.out.println("Pop  : " + intStack.pop());
        intStack.display();

        System.out.println("\n===== Stack<T> (String) =====");
        Stack<String> strStack = new Stack<>(5);
        strStack.push("Apple");
        strStack.push("Banana");
        strStack.push("Cherry");
        strStack.display();
        System.out.println("Pop  : " + strStack.pop());
        strStack.display();
    }
}