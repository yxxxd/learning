package com.yxd.webflux.stream;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yuxudong
 * @date 2019/11/10 22:28
 */
public class CollectDemo {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
          new Student("Kuuga", 2000, "M"),
          new Student("Agito", 2001, "F"),
          new Student("Yuki", 2002, "F"),
          new Student("Faiz", 2003, "M")
        );

        // 得到所有学生的年龄列表
        // 使用方法引用不会多生成类似 lambda$0 这样的函数
        List<Integer> ages = list.stream().map(Student::getAge).collect(Collectors.toList());
        // 去重
        Set<Integer> ages2 = list.stream().map(Student::getAge).collect(Collectors.toCollection(TreeSet::new));
        System.out.println("所有学生的年龄列表" + ages);

        // 统计汇总信息
        IntSummaryStatistics summaryStatistics = list.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println("年龄汇总信息：" + summaryStatistics);

        // 分块 partitioningBy() 中传入一个断言，根据断言分块 这里按照学生性别进行分块
        Map<Boolean, List<Student>> map = list.stream().collect(Collectors.partitioningBy(s->"M".equals(s.getGender())));
        System.out.println("男女生列表：" + map);

        // 分组
        Map<String, List<Student>> genders = list.stream().collect(Collectors.groupingBy(Student::getGender));
        System.out.println("男女生列表：" + genders);

        //得到男女生个数的列表
        Map<String, Long> genderCount =
                list.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
        System.out.println(genderCount);
    }
}
class Student{
    private String name;
    private Integer age;
    private String gender;

    public Student(){}

    public Student(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
