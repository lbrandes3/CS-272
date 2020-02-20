import java.util.Arrays;

public class Employee {

    public static void main(String[] args) {
        Employee en = null; // employee null
        Employee e1, e2, e3, e4;

        int[] advisors1 = {1, 2, 3};
        int[] advisors2 = {2, 3, 4};
        int[] advisors3 = {4, 5, 6};

        // Constructors Test
        e1 = new Employee(15, 1, 10000, "Jake", "WA", advisors1);
        e2 = new Employee(16, 1, 10001, "John", "NM", advisors2);
        e3 = new Employee(17, 2, 10002, "Jeff", "CA", advisors3);
        e4 = new Employee(e3);

        // ToString test
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);

        // Equals test
        System.out.println("e1 == e2 " + e1.equals(e2));
        System.out.println("e2 == e3 " + e2.equals(e3));
        System.out.println("e3 == e4 " + e3.equals(e4));
        System.out.println("e1 == en " + e1.equals(en));

        // Advisors test
        for (int i : getAllAdvisors(e1, e2)) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : getAllAdvisors(e1, e3)) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : getAllAdvisors(e3, e4)) {
            System.out.print(i + " ");
        }
    }

    // variable initialization
    private int age;
    private int no;
    private int zip;
    private String name;
    private String state;
    private int[] advisors;

    public Employee() {
        age = -1;
        no = -1;
        zip = -1;
        name = "";
        state = "";
        advisors = new int[3];
    }

    // copy constructor
    public Employee(Object o) {
        if (o instanceof Employee) {
            Employee temp = (Employee) o;
            age = temp.getAge();
            no = temp.getNo();
            zip = temp.getZip();
            name = temp.getName();
            state = temp.getState();
            advisors = temp.getAdvisors().clone();
        }
        // if null then if won't run
    }

    // number constructor
    public Employee (int no) {
        this.no = no;
        age = -1;
        zip = -1;
        name = "";
        state = "";
        advisors = new int[3];
    }

    // generic constructor
    public Employee(int age, int no, int zip, String name, String state, int[] advisors) {
        this.age = age;
        this.no = no;
        this.zip = zip;
        this.name = name;
        this.state = state;
        this.advisors = advisors;
    }

    public void setAge(int age) { this.age = age; }

    public void setAdvisors(int[] advisors) { this.advisors = Arrays.copyOf(advisors, advisors.length); }

    public void setName(String name) { this.name = name; }

    public void setNo(int no) { this.no = no; }

    public void setState(String state) { this.state = state; }

    public void setZip(int zip) { this.zip = zip; }

    public int getAge() { return age; }

    public int getNo() { return no; }

    public int getZip() { return zip; }

    public int[] getAdvisors() { return advisors; }

    public String getName() { return name; }

    public String getState() { return state; }

    public String toString() {
        return String.format("name: %s number: %d age: %d " +
                "state: %s zip: %d " +
                "advisor1: %d advisor2: %d advisor3: %d ",
                name, no, age, state, zip,
                advisors[0], advisors[1], advisors[2]);
    }

    // returns if inputted object and this object are employees & have the same id
    public boolean equals(Object o) {
        if (o instanceof Employee) {
            return ((Employee) o).getNo() == no;
        }
        return false;
    }

    // iterates through both employee's advisors and checks for uniqueness
    public static int[] getAllAdvisors(Employee e1, Employee e2) {
        if (e1 == null || e2 == null) { return null; }

        int counter = 0;
        int[] uniqueAdvisors = new int[6];

        for (int i : e1.getAdvisors()) {
            if (!contains(uniqueAdvisors, i)) {
                uniqueAdvisors[counter] = i;
                counter++;
            }
        }

        for (int i : e2.getAdvisors()) {
            if (!contains(uniqueAdvisors, i)) {
                uniqueAdvisors[counter] = i;
                counter++;
            }
        }

        return uniqueAdvisors;
    }

    // helper method for getAllAdvisors
    public static boolean contains(int[] arr, int x) {
        for (int i : arr) {
            if (i == x) {
                return true;
            }
        }
        return false;
    }
}
