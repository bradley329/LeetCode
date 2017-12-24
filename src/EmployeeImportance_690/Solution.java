package EmployeeImportance_690;

import java.util.*;

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
// we could have two intuitive solutions: BFS and DFS to get all the importance;
// making use of hashmap, we could get each Employee object in O(1) time.
public class Solution {
    private Map<Integer, Employee> map;
    // BFS solution
    public int getImportanceBFS(List<Employee> employees, int id) {
        int res = 0;
        map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        while (!queue.isEmpty()) {
            Employee cur = queue.poll();
            res += cur.importance;
            for (int subId : cur.subordinates) {
                queue.offer(map.get(subId));
            }
        }
        return res;
    }

    // DFS solution
    // this may runs faster, but takes up stack space
    public int getImportanceDFS(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return DFSHelper(map.get(id));
    }

    private int DFSHelper(Employee e){
        int res = e.importance;
        for(Integer subId: e.subordinates){
            res += DFSHelper(map.get(subId));
        }
        return res;
    }
}
