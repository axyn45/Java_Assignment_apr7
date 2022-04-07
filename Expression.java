
public class Expression {
    int operation; //1:add, 2.sub, 3.max, 4.min, 5.doubleMe
    double para1;
    double para2;
    int left_bracket_pos=0;
    int right_bracket_pos=0;
    int coma_pos=-1;

    public double get(String Input){
        if(Input.startsWith("add")){
            operation=1;
        }
        else if(Input.startsWith("sub")){
            operation=2;
        }
        else if(Input.startsWith("max")){
            operation=3;
        }
        else if(Input.startsWith("min")){
            operation=4;
        }
        else if(Input.startsWith("doubleMe")){
            operation=5;
        }
        else{
            operation=0;
        }
        
        if(operation!=5){
            left_bracket_pos=Input.indexOf("(");
            right_bracket_pos=Input.indexOf(")");
            coma_pos=Input.indexOf(",");
            para1=Double.parseDouble(Input.substring(left_bracket_pos+1, coma_pos));
            para2=Double.parseDouble(Input.substring(coma_pos+1,right_bracket_pos));
        }
        else{
            left_bracket_pos=Input.indexOf("(");
            right_bracket_pos=Input.indexOf(")");
            para1=Double.parseDouble(Input.substring(left_bracket_pos+1, right_bracket_pos));
        }
        switch(operation){
            case 1:
                return para1+para2;
            case 2:
                return para1-para2;
            case 3:
                return para1>para2?para1:para2;
            case 4:
                return para1<para2?para1:para2;
            case 5:
                return para1*2;
            default:
                return 0;
        }
    }

}
