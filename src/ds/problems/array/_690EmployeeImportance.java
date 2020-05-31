package ds.problems.array;
//https://leetcode.com/problems/employee-importance/
//690. Employee Importance

import java.util.*;

public class _690EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map = new HashMap();
        for(Employee emp: employees) {
            map.put(emp.id,emp);
        }
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        while (!queue.isEmpty()) {
            Employee emp = map.get(queue.poll());
            sum = sum + emp.importance;
            for(int empId: emp.subordinates) {
                queue.add(empId);
            }
        }
        return sum;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
}
