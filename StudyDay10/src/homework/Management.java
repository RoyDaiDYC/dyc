package homework;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * RoyDai
 * 2019/12/30   19:36
 */
public class Management {
    private static final String PATH = "D:/test/人员表";
    private TreeMap<String, String> pInfoMap;
    private String adminName = "Admin";
    private String adminPassword = "CC123";

    public Management() {
        //创建初始化表
        pInfoMap = new TreeMap<>();
        //当未创建表时会自动创建
        if (readFromLocal() == null) {
            //创建管理员账号
            pInfoMap.put(adminName, adminPassword);
            addToLocal();
        }

    }

    //添加至本地
    private void addToLocal() {
        try (FileOutputStream fos = new FileOutputStream(PATH);
        ) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pInfoMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取本地数据
    private TreeMap readFromLocal() {
        try (FileInputStream fis = new FileInputStream(PATH);) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (TreeMap<String, String>) ois.readObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("路径下未能检测到表，会进行初始化创建");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    //判断是否有这个名字
    public boolean containsName(String name) {
        pInfoMap = readFromLocal();
        return pInfoMap.containsKey(name);

    }

    //判断密码是否正确
    public boolean isPassword(String name, String password) {
        pInfoMap = readFromLocal();
        return password.equals(pInfoMap.get(name));
    }

    //增
    public void add(String name, String password) {
        pInfoMap = readFromLocal();
        pInfoMap.put(name, password);
        addToLocal();
    }


    //删+把表写入本地覆盖
    public void del(String name) {
        pInfoMap = readFromLocal();
        pInfoMap.remove(name);
        addToLocal();
    }

    //改+把表写入本地覆盖
    public void update(String name, String upPassword) {
        pInfoMap = readFromLocal();
        pInfoMap.replace(name, upPassword);
        addToLocal();
    }

    //查
    public void show() {
        pInfoMap = readFromLocal();
        System.out.println("-------------------------人员信息-------------------------");
        System.out.println("用户名\t\t\t\t\t\t\t\t 密码\t");
        for (Map.Entry<String, String> stringStringEntry : pInfoMap.entrySet()) {
            System.out.println(stringStringEntry.getKey() + "\t\t\t\t\t\t|\t" + stringStringEntry.getValue());
        }

    }


    public String getAdminName() {
        return adminName;
    }

    public Management setAdminName(String adminName) {
        this.adminName = adminName;
        return this;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public Management setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
        return this;
    }


}
