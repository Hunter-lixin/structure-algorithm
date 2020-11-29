package com.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 比较器
 */
public class ComparatorSort {


    public static class Student{
        private int id;
        private String name;
        private int age;

        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }

    public static void main(String[] args) {

//        System.out.println(Math.pow(10, 2));
//        PriorityQueue<Student> queue = new PriorityQueue<>(new StudentComparator());

        //
        /*PriorityQueue<Student> queue = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }
        });*/

        // Lamda
        PriorityQueue<Student> queue = new PriorityQueue<>((o1, o2) -> o2.age - o1.age);

        // Comparator.comparingInt
//        PriorityQueue<Student> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.age));

        Student s1 = new Student(1, "a", 10);
        Student s2 = new Student(2, "b", 15);
        Student s3 = new Student(3, "c", 12);

        queue.add(s1);
        queue.add(s2);
        queue.add(s3);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }

}
