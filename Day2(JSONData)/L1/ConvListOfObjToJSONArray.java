package javaJSONHandling;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class ConvListOfObjToJSONArray {
        public static void main(String[] args) throws Exception {
            class Student {
                public String name;
                public int age;

                public Student(String name, int age) {
                    this.name = name;
                    this.age = age;
                }
            }

            List<Student> students = Arrays.asList(
                    new Student("Vachan", 20),
                    new Student("Ananya", 22)
            );

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(students);

            System.out.println(jsonArray);
        }
    }
