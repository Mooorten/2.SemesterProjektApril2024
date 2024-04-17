package semesterprojekt.service;

import semesterprojekt.model.Cat;
import semesterprojekt.dal.DbSql;
import semesterprojekt.model.Member;

import java.util.ArrayList;

public class UseCase{
    public void createMember(int memberID, String name, String surname, String phone, String email, String password) {
        DbSql db = new DbSql();
        db.createMember(memberID, name, surname, phone, email, password);
    }
    public void createCat(int catid, String name, double weight, String breed, String gender){
        DbSql db = new DbSql();
        db.createCat(catid, name, weight, breed, gender);
    }

    public void editMember(){
        DbSql db = new DbSql();
        db.editMember();
    }

    public void editCat() {
        DbSql db = new DbSql();
        db.editCat();
    }
    public void deleteMember(int memberid){
        DbSql db = new DbSql();
        db.deleteMember(memberid);
    }
    public void deleteCat(int catid){
        DbSql db = new DbSql();
        db.deleteCat(catid);
    }

    public ArrayList memberlist() {
        ArrayList<Member> members;
        DbSql db = new DbSql();
        members = db.getAllMembers();
        return members;
    }
    public ArrayList catlist() {
        ArrayList<Cat> cats;
        DbSql db = new DbSql();
        cats = db.getAllCats();
        return cats;
    }
}