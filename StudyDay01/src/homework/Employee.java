package homework;

import java.util.Objects;

/**
 * 定义员工类Employee,有姓名,年龄,工资等属性;
 * RoyDai
 * 2019/12/24   17:26
 */
public class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary);
    }

    @Override
    public String toString() {
        return "员工{" +
                "姓名：'" + name + '\'' +
                ", 年龄：" + age +
                ", 薪资：" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Employee setAge(int age) {
        this.age = age;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public Employee setSalary(double salary) {
        this.salary = salary;
        return this;
    }
}
