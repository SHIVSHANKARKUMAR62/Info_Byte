package InfoByte_Task;

import java.util.*;

interface AdminPart {


    ArrayList<String> library = new ArrayList<>();

    ArrayList<String> issuelibrarybook = new ArrayList<>();

    ArrayList<String> AdminName = new ArrayList<>();

    ArrayList<String> AdminPass = new ArrayList<>();

    ArrayList<String> UserName = new ArrayList<>();

    ArrayList<String> UserPass = new ArrayList<>();

    void update();
    void delete();
    void modify();
    void search();
    void summit();
    void issue();

}

class Methods implements AdminPart{


    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book Name to add the Library: ");
        String book = sc.nextLine();
        library.add(book);
    }

    @Override
    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book Name which you want to remove in the Library: ");
        String book = sc.nextLine();
        if (library.contains(book)){
            library.remove(book);
        }else {
            System.out.println(book+" book is not Found in the Library...\nThank You...");
        }
    }

    @Override
    public void modify() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book name: ");
        String oldBook = sc.nextLine();
        System.out.print("Enter New Name of the book for update: ");
        String newbook = sc.nextLine();
        if(library.contains(oldBook)){
            library.remove(oldBook);
            library.add(newbook);
        }else {
            System.out.println(oldBook+" Book is not found in the Library...\nThanks You...");
        }
    }

    public void seeTheLibraryBook(){
        System.out.println("Library Books are: ");

        for (String s : library) {

            System.out.println(s+" ");

        }

    }

    public void seeTheissueLibraryBook(){
        System.out.println("Library issues Books are: ");

        for (String s : issuelibrarybook) {

            System.out.println(s+" ");

        }
    }

    @Override
    public void summit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Summit book Name: ");
        String book = sc.nextLine();
        if (issuelibrarybook.contains(book)){
            issuelibrarybook.remove(book);
            library.add(book);
            System.out.println("SuccessFully Summit "+book+" Book.");
            System.out.println("Thank You...");
        } else {
            System.out.println("You Don't Take any book from The Library...\nThank You...");
        }
    }

    @Override
    public void issue() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Issue book Name: ");
        String book = sc.nextLine();
        if (library.contains(book)){
            library.remove(book);
            issuelibrarybook.add(book);
            System.out.println("SuccessFully Issue "+book+" Book.");
            System.out.println("Thank You...");
        }else {
            System.out.println(book+" is not Found in the Library\nThank You... ");
        }
    }

    @Override
    public void search() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter searching book name: ");
        String book = sc.nextLine();
        if (library.contains(book)){
            System.out.println(book+" book is Found in the Library...");
        }else {
            System.out.println(book+" book is not Found in the Library...");
        }
    }
}

class AccountUser extends Methods {

    public void UserAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter User Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();
        UserName.add(name);
        UserPass.add(pass);
    }
}

class UserLogin extends Methods {

    Methods admin = new Methods();
    int aa;

    public void usLogin(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter User Name: ");
        String nameU = sc.nextLine();
        System.out.print("Enter Password: ");
        String passU = sc.nextLine();
        do {
            if (UserName.contains(nameU)&& UserPass.contains(passU)) {
                System.out.print("1.Search The Book\n2.Issue The Book\n3.Summit the Book\nEnter Your Choice: ");
                int userchoice = sc.nextInt();
                switch (userchoice) {
                    case 1 -> {
                        System.out.println("..................................");
                        admin.search();
                        System.out.println("..................................");
                    }

                    case 2 -> {
                        System.out.println("..................................");
                        admin.issue();
                        System.out.println("..................................");
                    }

                    case 3 -> {
                        System.out.println("..................................");
                        admin.summit();
                        System.out.println("..................................");
                    }

                    default -> {
                        System.out.println("..................................");
                        System.out.println("Wrong Choice Please enter a Write Choice...");
                        System.out.println("..................................");
                    }
                }
            }else {
                System.out.println("Please Check Your Name and Password...\nThank You...");
            }
            System.out.print("Enter 1 if you want to run once's again and see the library part otherwise press any other number key: ");
            aa = sc.nextInt();
        }while (aa==1);
    }
}

class AccountAdmin extends Methods {

    void AdminAccount() {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter Admin Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();
        AdminName.add(name);
        AdminPass.add(pass);
    }

}
class AdminLogin extends Methods {

    Methods user = new Methods();
    int aa;

    public void adLogin(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Admin Name: ");
        String nameA = sc.nextLine();
        System.out.print("Enter Password: ");
        String passA = sc.nextLine();
        do {
            if (AdminName.contains(nameA)&& AdminPass.contains(passA)){
                System.out.print("1.Update(Add) The Book\n2.Delete The Book\n3.Modify the Book Name\n4.See the Library Book\n5.See the Issue Book\nEnter Your Choice: ");
                int adminchoice = sc.nextInt();
                switch (adminchoice){
                    case 1 -> {
                        System.out.println("..................................");
                        user.update();
                        System.out.println("..................................");
                    }

                    case 2 -> {
                        System.out.println("..................................");
                        user.delete();
                        System.out.println("..................................");
                    }

                    case 3-> {
                        System.out.println("..................................");
                        user.modify();
                        System.out.println("..................................");
                    }

                    case 4 -> {
                        System.out.println("..................................");
                        user.seeTheLibraryBook();
                        System.out.println("..................................");
                    }

                    case 5 -> {
                        System.out.println("..................................");
                        user.seeTheissueLibraryBook();
                        System.out.println("..................................");
                    }

                    default -> {
                        System.out.println("..................................");
                        System.out.println("Wrong Choice Please enter a Write Choice...");
                        System.out.println("..................................");
                    }
                }
            }else {
                System.out.println("Please Check Your Name and Password...\nThank You...");
            }

            System.out.print("Enter 1 if you want to run once's again otherwise press any other number key: ");
            aa = sc.nextInt();
        }while (aa == 1);
    }
}

class CreateAccountClass{

    Scanner sc = new Scanner(System.in);

    AccountAdmin ad = new AccountAdmin();
    AccountUser ul = new AccountUser();


    public void Create(){

        int b;

        do {
            System.out.print("1.Create Admin Account\n2.Create Users Account\nEnter Your Choice: ");
            int choicePart = sc.nextInt();
            switch (choicePart) {
                case 1 -> ad.AdminAccount();

                case 2 -> ul.UserAccount();


                default -> System.out.println("Wrong Choice, Please enter a Right Choice...");
            }
            System.out.print("Enter 1 if you want to run once's again Creating account Part otherwise press any other number key: ");
            b = sc.nextInt();
        }while (b==1);
    }

}

class LoginAccountClass {

    Scanner sc = new Scanner(System.in);
    UserLogin ul = new UserLogin();
    AdminLogin ad = new AdminLogin();
    int a;

    public void Login(){

        do {
            System.out.print("1.Admin Login\n2.User Login\nEnter Your Choice: ");
            int choicePart = sc.nextInt();
            switch (choicePart) {

                case 1-> ad.adLogin();

                case 2 -> ul.usLogin();

                default -> System.out.println("Wrong Choice, Please enter a Right Choice...");
            }
            System.out.print("Enter 1 if you want to run once's again Login Part otherwise press any other number key: ");
            a = sc.nextInt();
        }while (a==1);
    }
}


public class Library_Management_Task {
    public static void main(String[] args) {
        CreateAccountClass createAccount = new CreateAccountClass();
        LoginAccountClass loginAccount = new LoginAccountClass();
        createAccount.Create();
        loginAccount.Login();
        System.out.print("Thanks For Using Me...");
    }
}
