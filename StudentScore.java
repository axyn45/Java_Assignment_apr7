import java.util.ArrayList;
import javafx.util.*;

class StudentScore {
    ArrayList<Student> Students = new ArrayList<Student>();
    ArrayList<Course> Courses = new ArrayList<Course>();

    // int listSize=0;
    public void addStudent(String id, String name, boolean gender) {
        Student newcomer = new Student(id, name, gender);
        Students.add(newcomer);
        // listSize++;

    }

    public void addRecord(String id, String courseName, int score) {
        boolean flag_s = false, flag_c = false;
        for (int i = 0; i < Students.size(); i++) {
            if(flag_s&&flag_c) break;

            if(i>=Courses.size()&&!flag_c){
                Course newcourse=new Course(courseName,score);
                Courses.add(newcourse);
                flag_c=true;
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
                flag_c=true;
            }
        }
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

        for(int i=0;i<Courses.size();i++){
            System.out.printf("%s\t\t%.0lf\n", Courses.get(i).getCourseName(),Courses.get(i).getntAvgScore());
        }
    }
}