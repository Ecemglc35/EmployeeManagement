package Models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EmployeeFileManager {

    public static ArrayList<Employee> getEmployees() throws IOException {
        ArrayList<Employee> employees = new ArrayList<>();
        FileReader fileReader = new FileReader("Employee.dat");
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();

            while (line != null) {
                StringTokenizer tokenizerEmployee = new StringTokenizer(line, ",");
                int id = Integer.parseInt(tokenizerEmployee.nextToken());
                String firstName = tokenizerEmployee.nextToken();
                String lastName = tokenizerEmployee.nextToken();
                String department = tokenizerEmployee.nextToken();
                String employeeType = tokenizerEmployee.nextToken();
                Double salary = Double.parseDouble(tokenizerEmployee.nextToken());

                Employee employee = new Employee();
                employee.setId(id);
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setDepartment(department);
                employee.setEmployeeType(employeeType);
                employee.setSalary(salary);

                line = bufferedReader.readLine();
                employees.add(employee);
            }
        }

        return employees;
    }

    public static void saveEmployees(ArrayList<Employee> newEmployees) throws IOException {
        FileWriter fileWriter = new FileWriter("Employee.dat", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Employee employee : newEmployees) {

            bufferedWriter.write(employee.toString());
            bufferedWriter.newLine();

        }

        bufferedWriter.close();
        fileWriter.close();

    }
}
