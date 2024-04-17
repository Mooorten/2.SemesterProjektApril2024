package semesterprojekt.main;

import semesterprojekt.model.Cat;
import semesterprojekt.model.Member;
import semesterprojekt.service.UseCase;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("To close the program press 0");
        System.out.println("1. Create User");
        System.out.println("2. Create cat");
        System.out.println("3. Edit User");
        System.out.println("4. Edit cat");
        System.out.println("5. Delete User");
        System.out.println("6. Delete cat");
        System.out.println("7. Member list");
        System.out.println("8 Cat list");

        UseCase u = new UseCase();

        Scanner input = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    u.createMember(1,"Soren","Hansen","12345678","sorenhansen@gmail.com","1234");
                    System.out.println("Member has been created!");
                    break;
                case 2:
                    u.createCat(1, "Seline", 10,"Breed","M");
                    System.out.println("Cat has been created");
                    break;
                case 3:
                    u.editMember();
                    System.out.println("Member has been updated");
                    break;
                case 4:
                    u.editCat();
                    System.out.println("Cat has been updated");
                    break;
                case 5:
                    u.deleteMember(1);
                    System.out.println("Member has been deleted");
                    break;
                case 6:
                    u.deleteCat(1);
                    System.out.println("Cat has been deleted");
                    break;
                case 7:
                    ArrayList<Member> members;
                    members = u.memberlist();
                    for (int i = 0; i < members.size(); i++) {
                        System.out.println(members.get(i));
                    }
                    break;
                case 8:
                    ArrayList<Cat> cats;
                    cats = u.catlist();
                    for(int i = 0; i < cats.size(); i++){
                        System.out.println(cats.get(i));
                    }
                default:
                    System.exit(0);
            }
        }
    }
}
