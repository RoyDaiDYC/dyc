package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * RoyDai
 * 2019/12/26   19:20
 */
public class UserClient {
    private Scanner input;
    private HashMap<String, String> userHashMap;
    private String adminPassword;

    static {
        System.out.println("\t\t\t欢迎登陆CC客户端");
    }

    public UserClient() {
        userHashMap = new HashMap<>();
        input = new Scanner(System.in);
        adminPassword = "CC123";
    }

    //显示已注册的用户信息
    private void showUsersInfo() {
        System.out.println("用户名\t\t\t\t\t\t\t\t 密码\t");
        int index = 1;
        for (Map.Entry<String, String> stringStringEntry : userHashMap.entrySet()) {
            System.out.println(index++ + "|" + stringStringEntry.getKey() + "\t\t\t\t\t\t|\t" + stringStringEntry.getValue());
        }
    }

    //用户登录注册面板
    public void accessClient() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("[1]进行注册\t[2]进行登录\t[3]退出\t[4]管理员模式");
            String choice = input.next();
            if ("1".equals(choice)) {
                register();
            } else if ("2".equals(choice)) {
                login();
            } else if ("3".equals(choice)) {
                System.out.println("\t\t\t再见~");
                //return;     //结束main方法
                System.exit(0);   //退出JVM
            } else if ("4".equals(choice)) {
                System.out.print("请输入后台密码,");
                do {
                    System.out.println("输入0返回");
                    String adminPassword = input.next();
                    if (this.adminPassword.equals(adminPassword))
                        showUsersInfo();
                    else if ("0".equals(adminPassword))
                        break;
                    else
                        System.out.println("密码错误");
                } while (true);
            } else
                System.out.println("输入内容有误");
        } while (true);
    }

    //修改密码功能
    private void revisePassword(String name) {
        String patternPassword = "\\w{8,16}";
        System.out.println("请输入新的密码");
        String password = input.next();
        //判断输入的密码是否符合正则表达式
        if (!password.matches(patternPassword))
            System.out.println("密码格式不对，请重新输入密码\n密码至少需要8位，最多不能超过16位");
        else if (password.equals(userHashMap.get(name)))
            System.out.println("存在和之前相同密码，请重新输入密码");
        else {
            userHashMap.replace(name, password);
            System.out.println("密码修改成功！");
        }
    }

    //登陆功能
    private void login() {
        System.out.println("请输入用户名");
        First:
        do {
            String name = input.next();
            //判断用户名是否在集合内
            if (!userHashMap.containsKey(name)) {   //如果在集合内返回!true==false
                System.out.println("此用户名尚未注册");
                break;
            } else {
                do {
                    System.out.println("请输入密码");
                    String password = input.next();
                    //判断密码是否是集合内对应键的值
                    if (password.equals(userHashMap.get(name))) {
                        System.out.println("登录成功\n\t\t您好\'" + name + "\'~~\n" + "\t\t欢迎回来~~");
                        do {
                            System.out.println("输入1进行密码修改，输入0返回主界面");
                            String control = input.next();
                            if ("1".equals(control))
                                //调用修改密码的方法
                                revisePassword(name);
                            else if ("0".equals(control))
                                break First;        //跳出外循环
                            else
                                System.out.println("输入错误");
                        } while (true);
                    } else {
                        System.out.println("密码错误,请重新输入");
                    }
                } while (true);
            }

        } while (true);
    }

    //注册功能
    private void register() {
        String patternName = ".{2,12}";   //定义
        String patternPassword = "\\w{8,16}";
        System.out.println("请输入用户名");
        First:
        do {
            String name = input.next();
            //判断输入的用户名是否和规定的正则表达式相同
            if (!name.matches(patternName)) {
                System.out.println("请重新输入名字\n名字需要2到12个字符");
            } else {
                //判断输入的用户名是否在集合中存在
                if (userHashMap.containsKey(name))  //如果在返回true
                    System.out.println("该用户名已存在，请重新输入");
                else {
                    do {
                        System.out.println("请输入密码");
                        String password = input.next();
                        //判断输入的密码是否和规定的正则表达式相同
                        if (!password.matches(patternPassword)) {
                            System.out.println("请重新输入密码\n密码至少需要8位，最多不能超过16位");
                        } else {
                            //把输入的名字和密码添加到集合中
                            userHashMap.put(name, password);
                            System.out.println("注册成功");
                            //跳出外循环
                            break First;
                        }
                    } while (true);
                }
            }
        } while (true);
    }
}
