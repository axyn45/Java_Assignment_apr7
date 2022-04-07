public class Course {
    private String name;
    private double sumScore=0;
    private int countStudent=0;

    public Course(String name,double score){
        this.name=name;
        sumScore+=score;
        countStudent++;
    }
    public void add(int x){
        sumScore+=x;
        countStudent++;
    }
    public String getCourseName(){
        return name;
    }

    public double getntAvgScore(){
        // System.out.printf("%s %lf\n",name,sumScore/countStudent);
        return sumScore/countStudent;
    }
}
