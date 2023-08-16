import java.util.Arrays;
import java.util.Scanner;

public class secondApp {
    private static final Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        
        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String RESET = "\033[0m";

        final String DASHBOARD = " 💰Welcome to Smart Banking ";
        final String NEW_ACCOUNT = "Open new account";
        final String DEPOSITE="Deposite Money";
        final String WITHDRAWAL = "Withdrawal Money";
        final String TRANSFER = "Tranfer Money";
        final String BALANCE= "Check Account Balance";
        final String DROP= "Drop Exsisting Account";

        final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);

        String screen=DASHBOARD;
        String [][]account=new String[0][];
     
        do{
            System.out.println(CLEAR);
            final String APP_TITLE = String.format("%s%s%s",
            COLOR_BLUE_BOLD, screen, RESET);
            System.out.println(APP_TITLE);

            switch(screen){
                case DASHBOARD: 
                        System.out.println("\n[1]. Open New Account");
                        System.out.println("[2].Deposite Money");
                        System.out.println("[3]. Withdrawel Money");
                        System.out.println("[4]. Transfer Money");
                        System.out.println("[5]. Check Account Balance");
                        System.out.println("[6]. Drop Exsisting Account");
                        System.out.println("[7]. Exit\n");
                        System.out.print("Enter an option to continue > ");
                        int option = scanner.nextInt();
                        scanner.nextLine();

                        switch (option){
                            case 1: screen = NEW_ACCOUNT; break;
                            case 2: screen = DEPOSITE; break;
                            case 3: screen = WITHDRAWAL; break;
                            case 4: screen = WITHDRAWAL; break;
                            case 5: screen = TRANSFER ; break;
                            case 6: screen = BALANCE; break;
                            case 7: screen = DROP; break;
                            case 8: System.exit(0); break;
                            default: continue;
                        }
                        break;
                        case NEW_ACCOUNT:
                        String accountid=String.format("ABD-%05d", (account.length + 1));
                        System.out.println(accountid);
                        boolean valid;
                        String name1;
                        String initialDeposit;
                        
                        do{
                            valid = true;
                            System.out.print("Enter a Name: ");
                            name1 = scanner.nextLine().strip();
                            if (name1.isBlank()){
                                System.out.printf(ERROR_MSG,"Name can't be Empty");
                                valid = false;
                                continue;
                            }
                            for (int i = 0; i < name1.length(); i++) {
                                if (!(Character.isLetter(name1.charAt(i)) || 
                                    Character.isSpaceChar(name1.charAt(i))) ) {
                                    System.out.printf(ERROR_MSG, "Invalid name");
                                    valid = false;
                                    break;
                                    }
                            }
                        }while(!valid);

                        do{
                            valid = true;
                            System.out.print("Initial Deposite: ");
                           initialDeposit = scanner.nextLine();
                            Double x=Double.valueOf(initialDeposit);
                            if (x<5000){
                                System.out.printf("%sminimam value mor than 5000%s\n", COLOR_RED_BOLD, RESET);
                                valid = false;
                                continue;
                            }else System.out.println("Name has been creat Sucsess");
                            
                        }while(!valid);

                        String[][] tempAccount = new String[account.length + 1][3];
                   
                        for (int i = 0; i < account.length; i++) {
                        tempAccount[i] = account[i];
                       
                        }
                        tempAccount[tempAccount.length-1][0]=accountid;
                        tempAccount[tempAccount.length-1][1]=name1;
                        tempAccount[tempAccount.length-1][2]=initialDeposit;

                    
                        account=tempAccount;
                        



                    System.out.println();

                    System.out.print("\t" + account + " added sucessfully.\n\tDo you want to add new student (Y/n)? ");
                    if (scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
                    screen = DASHBOARD;
                    break;
                       

            }


        }while(true);

    }
    
}
