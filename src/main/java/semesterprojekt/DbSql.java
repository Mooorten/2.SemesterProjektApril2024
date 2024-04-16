package semesterprojekt;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DbSql {
    public static Connection connection;
    private Statement stmt;
    private Statement stmt1;

    public DbSql() {
        connection = null;
        stmt = null;
        try {
            String url = "jdbc:mysql://mysql35.unoeuro.com:3306/krudtraeven_dk_db_KatteKlubben";
            String user = "krudtraeven_dk";
            String password = "w5F4be2mGrpnxk3BytDH";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createMember(int memberid, String name, String surname, String phone, String email, String password) {
        String insertMemberQuery = "INSERT INTO member (memberid, name, surname, phone,email,password) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement createmember = connection.prepareStatement(insertMemberQuery)) {
            createmember.setInt(1, memberid);
            createmember.setString(2, name);
            createmember.setString(3, surname);
            createmember.setString(4, phone);
            createmember.setString(5, email);
            createmember.setString(6, password);
            createmember.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void createCat(int catid, String name, double weight, String breed) {
        String insertCatQuery = "INSERT INTO cat (catid, name, weight, breed) VALUES (?, ?, ?, ?)";
        try (PreparedStatement createcat = connection.prepareStatement(insertCatQuery)) {
            createcat.setInt(1, catid);
            createcat.setString(2, name);
            createcat.setDouble(3, weight);
            createcat.setString(4, breed);
            createcat.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void editMember() {
        try {
            System.out.println("Enter the Member ID to be updated: ");
            int memberID;
            Scanner scan = new Scanner(System.in);
            memberID = scan.nextInt();

            System.out.println("Do you want to change 'name', 'surname' ,'phone' or 'email', 'password'? ");
            String choice = scan.next().toLowerCase();

            if (choice.equals("name")) {
                System.out.println("Enter the new name: ");
                String newName = scan.next();
                String sql = "UPDATE member SET name = '" + newName + "' WHERE memberid = " + String.valueOf(memberID);
                Statement stmt = connection.createStatement();
                stmt.execute(sql);
                System.out.println("Name updated successfully.");
            } else if (choice.equals("surname")) {
                System.out.println("Enter the new surname: ");
                String newSurname = scan.next();
                String sql = "UPDATE member SET surname = '" + newSurname + "' WHERE surname = " + String.valueOf(memberID);
                Statement stmt = connection.createStatement();
                stmt.execute(sql);
                System.out.println("Surname updated successfully.");
            } else if (choice.equals("phone")) {
                System.out.println("Enter the new phone: ");
                String phone = scan.next();
                String sql = "UPDATE member SET phone = '" + phone + "' WHERE phone = " + String.valueOf(phone);
                Statement stmt = connection.createStatement();
                stmt.execute(sql);
                System.out.println("Phone has been updated");
            } else if (choice.equals("email")) {
                System.out.println("Enter the new email: ");
                String email = scan.next();
                String sql = "UPDATE member SET email = '" + email + "' WHERE email = " + String.valueOf(email);
                Statement stmt = connection.createStatement();
                stmt.execute(sql);
                System.out.println("Treatment time has been updated");
            } else if (choice.equals("password")) {
                System.out.println("Enter the new password: ");
                String password = scan.next();
                String sql = "UPDATE member SET password = '" + password + "' WHERE password = " + String.valueOf(password);
                Statement stmt = connection.createStatement();
                stmt.execute(sql);
                System.out.println("Password has been updated");
            } else {
                System.out.println("Invalid choice. Please select either 'name' , 'surname', 'phone', 'email' or 'password'.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editCat() {
        try {
            System.out.println("Enter the Cat ID to be updated: ");
            int catID;
            Scanner scan = new Scanner(System.in);
            catID = scan.nextInt();

            System.out.println("Do you want to change 'name', 'weight' or 'breed'?");
            String choice = scan.next().toLowerCase();

            if (choice.equals("name")) {
                System.out.println("Enter the new name: ");
                String newName = scan.next();
                String sql = "UPDATE cat SET name = '" + newName + "' WHERE catid = " + String.valueOf(catID);
                Statement stmt = connection.createStatement();
                stmt.execute(sql);
                System.out.println("Name updated successfully.");
            } else if (choice.equals("weight")) {
                System.out.println("Enter the new weight: ");
                String newWeight = scan.next();
                String sql = "UPDATE cat SET weight = '" + newWeight + "' WHERE weight = " + String.valueOf(newWeight);
                Statement stmt = connection.createStatement();
                stmt.execute(sql);
                System.out.println("weight updated successfully.");
            } else if (choice.equals("breed")) {
                System.out.println("Enter the new Breed: ");
                String newBreed = scan.next();
                String sql = "UPDATE cat SET breed = '" + newBreed + "' WHERE breed = " + String.valueOf(newBreed);
                Statement stmt = connection.createStatement();
                stmt.execute(sql);
                System.out.println("Breed has been updated");
            } else {
                System.out.println("Invalid choice. Please select either 'name' , 'weight', or 'breed'.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteMember(int memberid) {
        try {
            String sql = "delete from member where memberid=" + String.valueOf(memberid);
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteCat(int catid) {
        try {
            String sql = "delete from cat where catid=" + String.valueOf(catid);
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList getAllMembers() {
        ArrayList<Member> members = new ArrayList<>();
        try {
            String sql = "select * from member";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Member m = new Member();
                m.setMemberid(rs.getInt("memberid"));
                m.setName(rs.getString("name"));
                m.setSurname(rs.getString("surname"));
                m.setPhone(rs.getString("phone"));
                m.setEmail(rs.getString("email"));
                m.setPassword(rs.getString("password"));
                members.add(m);
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return members;
    }

    public ArrayList getAllCats() {
        ArrayList<Cat> catList = new ArrayList<>();
        try {
            String sql = "select * from cat";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Cat c = new Cat();
                c.setCatid(rs.getInt("catID"));
                c.setName(rs.getString("name"));
                c.setWeight(rs.getDouble("weight"));
                c.setBreed(rs.getString("breed"));
                catList.add(c);
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return catList;
    }
}