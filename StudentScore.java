import java.util.ArrayList;

import javafx.scene.input.InputEvent;
import javafx.util.*;

class StudentScore {
    ArrayList<Student> Students = new ArrayList<Student>();
    ArrayList<Course> Courses = new ArrayList<Course>();

    // int listSize=0;
    public boolean addStudent(String INPUT) {
        if(INPUT.equals("end")) return false;
        String id;
        String name;
        boolean gender; //false for male, true for female

        String[] container=INPUT.split(",");
        id=container[0];
        name=container[1];
        gender=container[2].equals("f")?true:false;

        Student newcomer = new Student(id, name, gender);
        Students.add(newcomer);
        return true;
    }

    public boolean addRecord(String INPUT) {
        String id;
        String courseName;
        int score;

        String[] container = INPUT.split("，");
        id = container[0];
        if(id.equals("end")) return false;

        courseName = container[1];
        score = Integer.parseInt(container[2]);

        boolean flag_s = false, flag_c = false;
        for (int i = 0; i < Students.size(); i++) {
            if (flag_s && flag_c)
                break;

            if (i >= Courses.size() && !flag_c) {
                Course newcourse = new Course(courseName, score);
                Courses.add(newcourse);
                flag_c = true;
            }
            if (!flag_s) {
                if (id.equals(Students.get(i).getID())) {
                    Pair<String, Integer> newRecord = new Pair(courseName, score);
                    Students.get(i).AddScoreRecord(newRecord);
                    flag_s = true;
                }
            }
            if (!flag_c) {
                if (courseName.equals(Courses.get(i).getCourseName())) {
                    Courses.get(i).add(score);
                }
                flag_c = true;
            }
        }
        return true;
    }

    public void showScoresByStudent() {
        System.out.println("ID\t\tName\t\tGender\t\tAverage Score");
        for (int i = 0; i < Students.size(); i++) {
            System.out.printf("%s\t\t%s\t\t%\t\t%.0lf\n", Students.get(i).getID(), Students.get(i).getName(),
                    Students.get(i).getGender(), Students.get(i).getAvgScore());
        }
    }

    public void showScoresByCourse() {
        System.out.println("Course\t\tAverage Score");

        for (int i = 0; i < Courses.size(); i++) {
            System.out.printf("%s\t\t%.0lf\n", Courses.get(i).getCourseName(), Courses.get(i).getntAvgScore());
        }
    }
}