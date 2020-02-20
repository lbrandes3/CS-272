import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// ask how remove(eno) should handle multiple Employees with that number
// test remove(eno) f(x)


public class EmployeeSet {
    private Employee[] employees;
    private int next;
    private static final String OLD_FILE_NAME = "C:\\Users\\lbran\\IdeaProjects\\CS 272\\src\\core_dataset.csv";
    private static final int CUR_DAY = 12;      // Manually set to avoid bug with current year.
    private static final int CUR_MONTH = 2;
    private static final int CUR_YEAR = 118;

    /**
     * @param args
     *  input from cmd line
     * @precondition
     *  none
     * @postcondition
     *  class is tested
     */
    public static void main(String[] args) {
        EmployeeSet employeeSet = new EmployeeSet();

        // tests add(e) and ensureCapacity()
        for (int i = 11; i > 0; i--) {
            employeeSet.add(new Employee(i));
        }

        System.out.println(employeeSet);

        // tests add(e, pos)
        employeeSet.add(new Employee(5), 3);

        System.out.println(employeeSet);

        // tests get(i)
        System.out.println(employeeSet.get(1));
        System.out.println(employeeSet.get(5));
        System.out.println(employeeSet.get(3));
        System.out.println();

        // tests set()
        employeeSet.set(new Employee(2), 3);
        System.out.println(employeeSet.get(3));
        System.out.println();

        // tests capacity() and size()
        System.out.println(employeeSet.size());
        System.out.println(employeeSet.capacity());
        System.out.println();

        // tests addOrdered(e) and contains(e)
        EmployeeSet ordered = new EmployeeSet();
        for (int i = 10; i > 0 ; i--) {
            ordered.add(new Employee(i));
        }

        System.out.println(ordered);

        ordered.addOrdered(new Employee(6));
        System.out.println(ordered);
        ordered.addOrdered(new Employee(-1 ));
        System.out.println(ordered);
        ordered.addOrdered(new Employee(15));
        System.out.println(ordered);

        // tests copy constructor
        EmployeeSet copied = new EmployeeSet(ordered);
        System.out.println(copied == ordered);
        System.out.println(copied.equals(ordered));
        System.out.println(copied == employeeSet);
        System.out.println(copied.equals(employeeSet));

        EmployeeSet fileSet = read(new File(OLD_FILE_NAME));
        System.out.println(fileSet);

        // tests remove(eno)
        ordered.remove(10);
        System.out.println(ordered);
    }

    /**
     * @precondition
     *  none
     * @postcondition
     *  initialized EmployeeSet
     */
    public EmployeeSet() {
        employees = new Employee[10];
        next = 0;
    }

    /**
     * @param o
     *  Object to copy
     * @precondition
     *  EmployeeSet or child copied
     * @postcondition
     *  EmployeeSet copied
     */
    public EmployeeSet(Object o) {
        if (o instanceof EmployeeSet) {
            EmployeeSet temp = (EmployeeSet) o;
            this.next = temp.size();
            this.employees = new Employee[temp.capacity()];
            for (int i = 0; i < temp.size(); i++) {
                this.employees[i] = new Employee(temp.get(i));
            }
        }
    }

    /**
     * @param minimumCapacity
     *  capacity needed
     * @precondition
     *  EmployeeSet intialized
     * @postcondition
     *  array is of proper size
     */
    private void ensureCapacity(int minimumCapacity) {
        if (employees.length < minimumCapacity) {
            Employee[] temp = new Employee[minimumCapacity];
            for (int i = 0; i < employees.length; i++) {
                temp[i] = new Employee(employees[i]);
            }
            employees = temp;
        }
    }
    /**
     *
     * @param f
     *  file to be read
     * @return employeeSet
     *  EmployeeSet generated from file
     * @precondition
     *  file is readable and exists
     * @postcondition
     *  EmployeeSet returned
     */
    public static EmployeeSet read(File f) {
        try {
            Scanner sc = new Scanner(f);
            EmployeeSet employeeSet = new EmployeeSet();
            sc.nextLine();

            while (sc.hasNextLine()) {
                employeeSet.add(new Employee());
                Scanner employeeCSV = new Scanner(sc.nextLine()).useDelimiter(",");
                String last = employeeCSV.next();
                String first = employeeCSV.next();

                last = last.substring(1);
                first = first.substring(1, first.length() - 1);
                employeeSet.get(employeeSet.size() - 1).setName(first + " " + last);
                employeeSet.get(employeeSet.size() - 1).setNo(employeeCSV.nextInt());
                employeeSet.get(employeeSet.size() - 1).setState(employeeCSV.next());
                employeeSet.get(employeeSet.size() - 1).setZip(employeeCSV.nextInt());
                employeeSet.get(employeeSet.size() - 1).setAge(dobToAge(employeeCSV.next()));
            }
            return employeeSet;
        } catch (FileNotFoundException e) {
            System.out.println("File DNE");
        }
        return null;
    }

    /**
     *
     * @param dateOfBirth
     *  date of birth of employee
     * @return age
     *  age in yrs
     * @precondition
     *  dob in correct format
     * @postcondition
     *  age in proper format
     */
    public static int dobToAge(String dateOfBirth) {
        Scanner dob = new Scanner(dateOfBirth).useDelimiter("/");
        int birMon = dob.nextInt();
        int birDay = dob.nextInt();
        int birYer = dob.nextInt();

        int curAge = CUR_YEAR - birYer - 1;

        if (birMon < CUR_MONTH) {
            curAge++;
        } else if (birMon == CUR_MONTH) {
            if (birDay <= CUR_DAY) {
                curAge++;
            }
        }
        return curAge;
    }

    /**
     * @param e
     *  employee to add
     * @precondition
     *  EmployeeSet initialized
     * @postcondition
     *  employee added
     */
    public void add(Employee e) {
        if (e != null) {
            if(this.contains(e)) {
                return;
            }
            if (next == employees.length) {
                ensureCapacity(employees.length * 2);
            }
            employees[next] = e;
            next++;
        }
    }

    /**
     * @param e
     *  employee to add
     * @param pos
     *  position to add employee at
     * @precondition
     *  EmployeeSet initialized, pos less than or equal to next
     * @postcondition
     *  Employee added at a specific index
     */
    public void add(Employee e, int pos) {
        if (this.contains(e)) {
            return;
        }
        ensureCapacity(next + 1);

        EmployeeSet temp = new EmployeeSet();
        int tracker = 0;
        for (int i = 0; i <= next; i++) {
            if (i == pos) {
                temp.add(new Employee(e));
            }
            temp.add(new Employee(this.get(i)));
        }
        next++;

        for (int i = 0; i < next; i++) {
            employees[i] = temp.get(i);
        }
    }

    /**
     * @param i
     *  which employee to get
     * @return
     *  employee at given index
     * @precondition
     *  employee exists at given index
     * @postcondition
     *  employee at index returned
     */
    public Employee get(int i) {
        if (i >= next) {
            return null;
        }
        return employees[i];
    }

    /**
     * @param o
     *  Employee to set index at
     * @param i
     *  index to set Employee at
     * @precondition
     *  index i exists, o is an Employee or child of an employee
     */
    public void set(Object o, int i) {
        // Error handling in Employee Copy Constructor
        if (next > i) {
            if (o == null) {
                employees[i] = null;
                return;
            }
            employees[i] = new Employee(o);
        }
    }

    /**
     * @return
     *  returns number of elements in the EmployeeSet
     * @precondition
     *  intialized EmployeeSet
     * @postcondition
     *  number of elements returned
     */
    public int size() { return next; }

    /**
     * @return
     *  returns current capacity of employees array
     * @precondition
     *  EmployeeSet intiialized
     * @postcondition
     *  length returned
     */
    public int capacity() { return employees.length; }

    /**
     * @param eno
     *  number of employee to remove
     * @return
     *  returns whether an employee was removed
     * @precondition
     *  employee with given number exists
     * @postcondition
     *  EmployeeSet without the given Employee exists
     */
    public boolean remove(int eno) {
        for (int i = 0; i < employees.length; i++) {
            if (this.get(i).getNo() == eno) {
                for (int j = i; j < employees.length - 1; j++) {
                    employees[j] = new Employee(this.get(j + 1));
                }
                this.set(null, this.capacity() - 1);
                next--;
                return true;
            }
        }
        return false;
    }

    /**
     * @param e
     *  employee to add
     * @precondition
     *  list is sorted
     * @postcondition
     *  employee is added
     */
    public void addOrdered(Employee e) {
        int temp = employees[0].getNo();
        for (int i = 1; i < next; i++) {
            if (employees[i].getNo() > temp) {
                return;
            }
            temp = employees[i].getNo();
        }
        for (int i = 0; i < next; i++) {
            if (e.getNo() >= employees[i].getNo()) {
                add (e, i);
                return;
            }
        }
        add(e);
    }

    /**
     * @param e
     *  employee to test for
     * @return
     *  whether the employee exists
     * @precondition
     *  EmployeeList is initialized
     * @postcondition
     *  whether the employee exists is returned
     */
    public boolean contains(Employee e) {
        for (int i = 0; i < next; i++) {
            if (this.get(i).getNo() == e.getNo()) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param es
     *  EmployeeSet to check if they are similar
     * @return
     *  whether the employee sets are identical
     * @precondition
     *  EmployeeSet intialized
     * @postcondition
     *  whether the EmployeeSets are similar is returned
     */
    public boolean equals(EmployeeSet es) {
        if (es.size() != this.size()) { return false; }

        for (int i = 0; i < es.size(); i++) {
            if (!es.get(i).equals(this.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return
     *  returns a string representation of the EmployeeSet
     * @precondition
     *  EmployeeSet initialized
     * @postcondition
     *  string representation returned
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < next; i++) {
            s += this.get(i) + "\n";
        }

        return s + "\n";
    }
}
