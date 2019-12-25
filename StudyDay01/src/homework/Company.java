package homework;

import java.text.Collator;
import java.util.*;

/**
 * 定义公司类,公司中包含若干的员工,使用集合保存员工的信息;
 * 定义方法添加员工;
 * 定义方法显示所有员工的信息;
 * 定义方法判断是否存在指定姓名的员工;
 * 定义方法删除指定姓名的员工
 * RoyDai
 * 2019/12/24   17:25
 */
public class Company {
    List<Employee> employeesList;

    public Company() {
        employeesList = new ArrayList<>();
    }

    //添加员工
    public void insert(Employee employee) {
        employeesList.add(employee);
    }

    //显示员工
    public void show() {
        //System.out.println(employeesList);
        int index = 0;
        System.out.println("--------------------员工信息--------------------");
        for (Employee employee : employeesList) {
            System.out.println("第" + index++ + "号" + employee);
        }
        System.out.println();
    }

    //获得通过姓名查找员工并显示出来
    public String getShowHasByName(String name) {
        for (int i = 0; i < employeesList.size(); i++) {
            Employee employee = employeesList.get(i);
            if (name.equals(employee.getName()))
                return "找到员工姓名=['" + name + "']\n第" + i + "号" + employee;
        }
        return "未能找到姓名：" + name + "员工";
    }

    //获得通过年龄查找员工并显示出来
    public String getShowHasByAge(int age) {
        for (int i = 0; i < employeesList.size(); i++) {
            Employee employee = employeesList.get(i);
            if (age == employee.getAge())
                return "找到员工年龄=[" + age + "]\n第" + i + "号" + employee;
        }
        return "未能找到年龄：" + age + "员工";
    }

    //获得通过薪资查找员工并显示出来
    public String getShowHasBySalary(double salary) {
        for (int i = 0; i < employeesList.size(); i++) {
            Employee employee = employeesList.get(i);
            if (salary == employee.getSalary())
                return "找到员工=[" + salary + "]\n第" + i + "号" + employee;
        }
        return "未能找到薪资：" + salary + "员工";
    }

    //通过姓名删除员工
    public void delEmployeeByName(String name) {
        int index = 0;
        for (Iterator<Employee> iterator = employeesList.iterator(); iterator.hasNext(); ) {
            Employee next = iterator.next();
            if (name.equals(next.getName())) {
                iterator.remove();
                index++;
            }
        }
        System.out.println(index == 0 ? "没有找到姓名为[" + name + "]此员工" : "找到相同姓名[" + name + "]员工" + index + "名，并已删除");
    }

    //通过年龄删除员工
    public void delEmployeeByAge(int age) {
        int index = 0;
        for (Iterator<Employee> iterator = employeesList.iterator(); iterator.hasNext(); ) {
            Employee next = iterator.next();
            if (age == next.getAge()) {
                iterator.remove();
                index++;
            }
        }
        System.out.println(index == 0 ? "没有找到年龄为[" + age + "]此员工" : "找到相同年龄[" + age + "]员工" + index + "名，并已删除");
    }

    //通过薪资删除员工
    public void delEmployeeBySalary(double salary) {
        int index = 0;
        for (Iterator<Employee> iterator = employeesList.iterator(); iterator.hasNext(); ) {
            Employee next = iterator.next();
            if (salary == next.getSalary()) {
                iterator.remove();
                index++;
            }
        }
        System.out.println(index == 0 ? "没有找到薪资为[" + salary + "]此员工" : "找到相同薪资[" + salary + "]员工" + index + "名，并已删除");
    }

    //通过姓名给员工升序
    public void sortByName() {
        System.out.println("根据员工姓名进行升序");
        Comparator cmp = Collator.getInstance(Locale.CHINESE);
        employeesList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return cmp.compare(o1.getName(), o2.getName());
            }
        });
    }

    //通过年龄给员工升序
    public void sortByAge() {
        System.out.println("根据员工年龄进行升序");
        employeesList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
    }

    //通过薪资给员工升序
    public void sortBySalary() {
        System.out.println("根据员工薪资进行升序");
        employeesList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o1.getSalary(), o2.getSalary());
            }
        });
    }

}
