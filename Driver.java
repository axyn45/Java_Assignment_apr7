import java.util.Scanner;

public class Driver {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int op;
        while(true){
            op=sc.nextInt();
            switch(op){
                case 1:
                    System.out.println("Enter the password");
                    String pass=sc.next();
                    Password p=new Password();
                    p.check(pass);
                    break;

                case 2:
                    System.err.println("Enter the expression");
                    String exp=sc.next();
                    Expression e=new Expression();
                    System.out.println(e.get(exp));
                    break;

                case 3:
                    System.err.println();

                case 4:
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    System.out.println("Exiting...");
                    return;

                default:

            }
        }
    }
    public static void menu(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();

        System.out.println("1. 密码有效性检查");
        System.out.println("2. 运算表达式求解");
        System.out.println("3. 学生成绩统计");
        System.out.println("4. 退出");
    }
}
