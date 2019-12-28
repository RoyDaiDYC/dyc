package homework;

import java.util.Scanner;

/**
 * RoyDai
 * 2019/12/30   19:32
 */
public class Client {
    private Management mg;
    private Scanner input;
    private static final String PATTERN_NAME = ".{2,12}";   // 姓名定义
    private static final String PATTERN_PASSWORD = "\\w{8,16}"; //密码定义
    private String adminName;

    static {
        System.out.println("\t~欢迎来到CC客户端~");
    }

    public Client() {
        mg = new Management();
        input = new Scanner(System.in);
        adminName = mg.getAdminName();
    }

    //界面
    public void access() {
        String control;
        while (true) {
            System.out.println("1.注册\t2.登录\t3.退出\t0.登录管理员");
            System.out.println("输入序号进行选择");
            control = input.next();
            if ("1".equals(control)) {
                register();
            } else if ("2".equals(control)) {
                logIn();
            } else if ("3".equals(control)) {
                System.out.println("再见");
                System.exit(0);
            } else if ("0".equals(control)) {
                adminLogIn();
            } else {
                System.out.println("未识别的输入");
            }
        }
    }

    //管理员登录
    private void adminLogIn() {
        String password;
        String control;
        System.out.println("请输入管理员密码");
        password = input.next();
        if (mg.isPassword(adminName, password)) {
            System.out.println("登录成功！\n欢迎回来~[" + "管理员" + "]");
            while (true) {
                System.out.println("1.显示人员信息\t2.删除人员信息\t3.返回主菜单\t0.更改密码");
                control = input.next();
                if ("1".equals(control))
                    mg.show();
                else if ("2".equals(control))
                    delPreson();
                else if ("3".equals(control))
                    return;
                else if ("0".equals(control))
                    //updatePassword(adminName);
                    System.out.println("抱歉，当前无法进行管理员密码修改，请联系RoyDai");
                else
                    System.out.println("检测到错误的输入");
            }
        }
        System.out.println("名称或密码错误");
    }

    //注册
    private void register() {

        System.out.println("请输入名称");
        String name = input.next();
        while (!name.matches(PATTERN_NAME) || mg.containsName(name)) {
            if (!name.matches(PATTERN_NAME))
                System.out.println("请重新输入名字\n名字需要2到12个字符，请重新选择一个名称\t退出或继续请输入y/n");
            if (mg.containsName(name))
                System.out.println("名称已注册，请重新选择一个名称\t退出或继续请输入y/n");
            name = input.next();
            if ("y".equals(name))
                return;
        }
        System.out.println("请输入密码");
        String password = input.next();
        while (!password.matches(PATTERN_PASSWORD)) {
            System.out.println("请重新输入密码\n密码至少需要8位，最多不能超过16位");
            password = input.next();
        }
        mg.add(name, password);
        System.out.println("注册成功！");
    }

    //登录
    private void logIn() {
        String name;
        String password;
        String control;
        System.out.println("请输入名称");
        name = input.next();
        System.out.println("请输入密码");
        password = input.next();
        if (mg.isPassword(name, password)) {
            System.out.println("登录成功！\n欢迎回来~[" + name + "]");
            while (true) {
                System.out.println("1.更改密码\t2.返回主菜单");
                control = input.next();
                if ("1".equals(control)) {
                    updatePassword(name);
                } else if ("2".equals(control))
                    return;
                else
                    System.out.println("检测到错误的输入");
            }
        }
        System.out.println("名称或密码错误");
    }

    //修改密码
    private void updatePassword(String name) {
        String password;
        System.out.println("请输入新的密码");
        password = input.next();
        while (!password.matches(PATTERN_PASSWORD) || mg.isPassword(name, password)) {
            if (!password.matches(PATTERN_PASSWORD))
                System.out.println("请重新输入密码\n密码至少需要8位，最多不能超过16位");
            if (mg.isPassword(name, password))
                System.out.println("新密码不能和老密码一致");
            password = input.next();
        }
        mg.update(name, password);
        System.out.println("修改密码成功");
    }

    //管理员删除用户
    private void delPreson() {
        System.out.println("请输入需要删除的人员的名称");
        String name = input.next();
        while (!mg.containsName(name) || adminName.equals(name)) {
            if (adminName.equals(name))
                System.out.println("管理员账号无法删除,请重新输入，如果要退出输入0");
            if (!mg.containsName(name))
                System.out.println("未查询到此名字，请重新输入，如果要退出输入0");
            name = input.next();
            if ("0".equals(name))
                return;
        }

        mg.del(name);
        System.out.println("[" + name + "]用户已删除成功");
    }

}
