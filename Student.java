import java.util.*;
import javafx.util.*;

public class Student {
    private String id;
    private String name;
    private boolean gender;
    ArrayList<Pair<String,Integer>> Scores=new ArrayList<Pair<String,Integer>>();
    // scores.li
    public Student(String id,String name,boolean gender){
        this.id=id;
        this.name=name;
        this.gender=gender;
    }
    public boolean AddScoreRecord(Pair<String,Integer> record){
        Scores.add(record);
        return true;
    }
    public String getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getGender(){
        return gender?"女":"男";
    }
    public double getAvgScore(){
        double avg=0;
        int ct=0;
        for(int i=0;i<Scores.size();i++){
            avg+=Scores.get(i).getValue();
            ct++;
        }
        if(ct==0) return avg;
        return avg/ct;
    }
}
