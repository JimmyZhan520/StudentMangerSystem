package com.itheima.test;

import com.itheima.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManger {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 创建集合容器对象
        ArrayList<Student> list = new ArrayList<>();

        lo:
        while (true) {
            // 1.搭建主界面菜单
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看学生");
            System.out.println("5 退出");
            System.out.println("请输入您的选择:");

            String choice = sc.next();

            switch (choice) {
                case "1":
//                    System.out.println("添加学生");
                    addStudent(list);
                    break;
                case "2":
//                    System.out.println("删除学生");
                    delStudent(list);
                    break;
                case "3":
//                    System.out.println("修改学生");
                    updateStudent(list);
                    break;
                case "4":
//                    System.out.println("查看学生");
                    checkStudent(list);
                    break;
                case "5":
                    System.out.println("退出");
                    break lo;
                default:
                    System.out.println("您的输入有误");
                    break;
            }
        }

    }

    public static void updateStudent(ArrayList<Student> list) {
        System.out.println("给出要修改的学号");
        Scanner sc = new Scanner(System.in);
        String updateSid = sc.next();
        int index = getIndex(list, updateSid);
        if (index == -1) {
            System.out.println("查无信息，重新输入");
        } else {
            System.out.println("请输入新的学生名字：");
            String name = sc.next();
            System.out.println("请输入新的学生年龄：");
            int age = sc.nextInt();
            System.out.println("请输入新的学生生日:");
            String birthday = sc.next();

            Student stu = new Student(updateSid, name, age
                    , birthday);
            list.set(index, stu);
            System.out.println("修改成功！");
        }
    }

    public static void delStudent(ArrayList<Student> list) {
        System.out.println("给出要删除的学号");
        Scanner sc = new Scanner(System.in);
        String delSid = sc.next();
        int index = getIndex(list, delSid);
        if (index == -1) {
            System.out.println("学号不存在");
        } else {
            list.remove(index);
            System.out.println("删除成功！");
        }
    }

    //查看学生的方法
    public static void checkStudent(ArrayList<Student> list) {
        if (list.size() == 0) {
            System.out.println("无信息");
            return;
        }
        System.out.println("学号\t\t姓名\t\t年龄\t\t生日");
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getSid() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getBirthday());
        }
    }

    //添加学生的方法
    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        String sid;
        //1.给出录入的提示信息
        while (true) {
            System.out.println("请输入学号：");
            sid = sc.next();
            int index = getIndex(list, sid);
            if (index == -1) {
                break;
            }

        }

        System.out.println("请输入姓名：");
        String name = sc.next();
        System.out.println("请输入年龄:");
        int age = sc.nextInt();
        System.out.println("请输入生日:");
        String birthday = sc.next();
        //2.将键盘录入的信息封装为学生对象
        Student stu = new Student(sid, name, age, birthday);
        //3.添加到集合容器当中去
        list.add(stu);
        //4.给出添加成功的提示信息
        System.out.println("添加成功!");
    }

    /*
    getIndex:接收一个集合对象，接收一个学生学号
    查找这个学号在集合中出现的索引位置

     */
    public static int getIndex(ArrayList<Student> list, String sid) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            String id = stu.getSid();
            if (id.equals(sid)) {
                index = i;
            }
        }
        return index;
    }
}
