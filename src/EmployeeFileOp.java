import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class EmployeeFileOp {

    private static final String OLD_FILE_NAME = "core_dataset.csv";
    private static final String NEW_FILE_NAME = "old_employee.csv";
    private static final int CUR_DAY = 12;      // Manually set to avoid bug with current year.
    private static final int CUR_MONTH = 2;
    private static final int CUR_YEAR = 118;
    private static final int AGE_PREFERENCE = 50;

    public static void main(String[] args) {
        File oldFile = new File(OLD_FILE_NAME);
        File newFile = new File(NEW_FILE_NAME);

        List<Employee> emps = read(oldFile);
        emps = removeYoung(emps);

        try {
            if (newFile.createNewFile()) {
                write(emps, newFile);
            } else {
                if (newFile.delete()) {
                    write(emps, newFile);
                } else {
                    System.out.println("File exists and can not be deleted.");
                }
            }
        } catch (IOException e) {/* Unknown File Error, unhandled. */}
    }

    public static List<Employee> read(File f) {
        try {
            Scanner sc = new Scanner(f);
            List<String> headings = new ArrayList<>();

            Scanner header = new Scanner(sc.nextLine()).useDelimiter(",");
            while (true) {              // Simplistic "run until it breaks" system to find all headers
                try {
                    headings.add(header.next());
                } catch (NoSuchElementException e) { break; }
            }

            List<Employee> employees = new ArrayList<>();

            while (true) {
                try {
                    Scanner employeeCSV = new Scanner(sc.nextLine());
                    employeeCSV.useDelimiter(",").next();           // Unnecessary next() avoids necessary parsing for quotation marks in CSV
                    Map<String, String> tempEmp = new HashMap<>();
                    int i = 0;
                    while(true) {
                        try {       // Stores each employee into a temporary Hash Map, before adding an employee to the master list
                            String string = employeeCSV.next();
                            tempEmp.put(headings.get(i), string);
                            i++;
                        } catch (Exception e) { break; }
                    }

                    employees.add(new Employee(Integer.parseInt(tempEmp.get("Employee Number")), dobToAge(tempEmp.get("DOB"))));

                } catch (NoSuchElementException e) {
                    return employees;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File DNE");
        }
        return null;
    }

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

    public static List<Employee> removeYoung(List<Employee> employees) {
        List<Employee> temp = new ArrayList<>();    // Removes all employees from the list younger than AGE_PREFERENCE
        for (Employee employee : employees) {
            if (employee.age > AGE_PREFERENCE) {
                temp.add(employee);
            }
        }

        return temp;
    }

    public static void write(List<Employee> employees, File newFile) {
        try {
            PrintStream p = new PrintStream(newFile);   //Prints all Employees' ToString f(x) to new CSV
            employees.forEach((n) -> p.println(n));
        } catch (IOException e) {/* Unknown File Error, unhandled. */}
    }

    private static class Employee {

        // No getters or setters due to simplistic intended use. Class stores 2 variables.

        public int ID;
        public int age;

        public Employee(int ID, int age) {
            this.ID = ID;
            this.age = age;
        }

        public String toString() { // Returns CSV-friendly format containing all information
            return ID + "," + age;
        }
    }
}