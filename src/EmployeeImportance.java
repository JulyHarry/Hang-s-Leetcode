import Support.Employee;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeImportance {
    int total = 0;
    public int getImportance(List<Employee> employees, int id) {
        Employee manager = employees.stream().filter(e -> e.id == id).collect(Collectors.toList()).get(0);
        total += manager.importance;
        manager.subordinates.forEach(subId -> getImportance(employees, subId));
        return total;
    }
}
