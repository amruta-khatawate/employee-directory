package initializer;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import repository.EmployeeRepository;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Component
public class EmployeeDataLoader implements CommandLineRunner {

    private final ObjectMapper objectMapper;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeDataLoader(EmployeeRepository employeeRepository, ObjectMapper objectMapper){
        this.employeeRepository = employeeRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        count() is an inherited method from JpaRepository.
        It returns the total number of employee records in the database.
        */

        // Avoid inserting duplicate seed data
        if(employeeRepository.count() > 0){
            return;
        }

        // Read JSON file and convert it into Employee objects
        try (InputStream inputStream = getClass().
                                getResourceAsStream("/employees.json")) {

            if (inputStream == null) {
                throw new IllegalStateException("employees.json file nt found");
            }

            Employee[] employeeArray = objectMapper.readValue(
                    inputStream,
                    Employee[].class
            );

            List<Employee> employees = Arrays.asList(employeeArray);

            // Save all employees into the database
            employeeRepository.saveAll(employees);
            System.out.println(employees.size() + " employees inserted successfully!");
        }
    }
}
