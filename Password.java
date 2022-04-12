import java.util.Scanner;

class Password {
    private int strlen;
    private boolean NO_SPACES = true;
    private boolean HAS_LOWERCASE = false;
    private boolean HAS_UPPERCASE = false;
    private boolean HAS_NUMERIC = false;
    private boolean LENGTH_CHECK = true;

    public boolean check(String Input) {
        // Scanner sc=new Scanner(System.in);
        strlen = Input.length();
        if (strlen < 8 || strlen > 15) {
            LENGTH_CHECK = false;
        }
        if (Input.contains(" ")) {
            NO_SPACES = false;
        }
        for (int i = 0; i < strlen; i++) {
            if (!HAS_NUMERIC) {
                if (Input.charAt(i) <= '9' && Input.charAt(i) >= '0') {
                    HAS_NUMERIC = true;
                    // break;
                }
            }
            if (!HAS_LOWERCASE) {
                if (Input.charAt(i) >= 'a' && Input.charAt(i) <= 'z') {
                    HAS_LOWERCASE = true;
                }
            }
            if (!HAS_UPPERCASE) {
                if (Input.charAt(i) >= 'A' && Input.charAt(i) <= 'Z') {
                    HAS_UPPERCASE = true;
                }
            }
        }
        if(NO_SPACES&&HAS_LOWERCASE&&HAS_UPPERCASE&&HAS_NUMERIC&&LENGTH_CHECK){
            System.out.println("Your password is valid!");
            // sc.next();
            Driver.sleep(3000);
            return true;
        }
        else{
            System.out.println("Your password is invalid!");
            if(!LENGTH_CHECK){
                System.out.println("Password must be between 8 and 15 characters in length");
            }
            if(!NO_SPACES){
                System.out.println("Password shoulden't contain spaces");
            }
            if(!HAS_LOWERCASE||!HAS_UPPERCASE){
                System.out.println("Password must contain at least one uppercase and one lowercase character");
            }
            if(!HAS_NUMERIC){
                System.out.println("Password must contain at least one numeric digit");
            }
            // sc.next();
            Driver.sleep(3000);
            return false;
        }

    }
};