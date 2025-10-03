package sample;
import java.sql.ResultSet;
public class DepartmentTable {
    String department,budget;

    public DepartmentTable(String department, String budget) {
        this.department = department;
        this.budget = budget;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }
}
