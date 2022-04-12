import java.util.Scanner;

public class Driver {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int op;
        Password p = new Password();
        Expression e = new Expression();
        StudentScore s = new StudentScore();
        String input;
        while (true) {
            menu();
            op = sc.nextInt();
            // sc.nextLine();
            switch (op) {
                case 1:
                    cls();
                    System.out.printf("Please input your password: ");
                    input = sc.nextLine();
                    while (!p.check(input)) {
                        cls();
                        System.out.printf("Please re-input your password: ");
                        input = sc.nextLine();
                    }
                    break;

                case 2:
                    System.out.println("Enter the expression");
                    input = sc.nextLine();
                    System.out.println(e.get(input));
                    sleep(3000);
                    break;
                case 3:
                    boolean q_flag = false;
                    while (!q_flag) {
                        scoreMSMenu();
                        input = sc.nextLine();
                        while (input.equals("")) {
                            input = sc.nextLine();
                        }
                        switch (input) {
                            case "1":
                                System.out.println("Enter the student information");
                                input = sc.nextLine();
                                while (input.equals("")) {
                                    input = sc.nextLine();
                                }
                                while (s.addStudent(input)) {
                                    input = sc.nextLine();
                                    while (input.equals("")) {
                                        input = sc.nextLine();
                                    }
                                }
                                break;

                            case "2":
                                System.out.println("Enter the score information");
                                input = sc.nextLine();
                                while (s.addRecord(input)) {
                                }
                                break;

                            case "3":
                                s.showScoresByStudent();
                                break;

                            case "4":
                                s.showScoresByCourse();

                            default:
                                q_flag = true;
                                break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;

                default:

            }
        }
    }

    public static void menu() {
        cls();
        System.out.println("1. 密码有效性检查");
        System.out.println("2. 运算表达式求解");
        System.out.println("3. 学生成绩统计");
        System.out.println("4. 退出");
    }

    public static void scoreMSMenu() {
        cls();
        System.out.println("1. Add a student");
        System.out.println("2. Add a score record");
        System.out.println("3. Display scores in student view");
        System.out.println("4. Display scores in course view");
        System.out.println("Enter any other key to return...");
    }

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
