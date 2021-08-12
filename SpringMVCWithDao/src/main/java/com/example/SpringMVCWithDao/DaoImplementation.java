package com.example.SpringMVCWithDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoImplementation implements DaoInterface {

        public Connection123 con3;

        public DaoImplementation(Connection123 con3) {
            this.con3 = con3;
        }

        @Override
        public void add(Category cat) throws SQLException, ClassNotFoundException {

            String qre1 = "insert into category values(?,?)";
            PreparedStatement obj1 = con3.connect().prepareStatement(qre1);
            obj1.setString(1, cat.getCatcode());
            obj1.setString(2, cat.getCatdesc());
            obj1.executeUpdate();
            System.out.println();
            System.out.println("One record added");

        }

        @Override
        public Category edit(Category cat, String ccCat) throws SQLException, ClassNotFoundException {

            String qre1 = "update category set catcode = ?, catdesc = ? where catcode = ?";
            PreparedStatement obj1 = con3.connect().prepareStatement(qre1);


            obj1.setString(1, cat.getCatcode());
            obj1.setString(2, cat.getCatdesc());
            obj1.setString(3, ccCat);
            obj1.executeUpdate();
            System.out.println("One record edited");
            return cat;
        }

        @Override
        public void delete(String catCode) throws SQLException, ClassNotFoundException {

            String qre1 = "delete from category where catcode = ?";
            PreparedStatement obj1 = con3.connect().prepareStatement(qre1);
            obj1.setString(1, catCode);
            obj1.executeUpdate();
            System.out.println("One record deleted");
        }

        @Override
        public void display() throws SQLException, ClassNotFoundException {

            Category catDisplay;

            String qre1 = "select * from category";
            PreparedStatement obj1 = con3.connect().prepareStatement(qre1);
            ResultSet rs = obj1.executeQuery();
            while(rs.next()){
                catDisplay = new Category(rs.getString("catcode"), rs.getString("catdesc"));
                System.out.println();
                System.out.println("Category code " + catDisplay.getCatcode());
                System.out.println("Category description " + catDisplay.getCatdesc());

            }

        }

        @Override
        public Category search(String catCode) throws SQLException, ClassNotFoundException {

            String qre1 = "select * from category where catcode = ?";
            PreparedStatement obj1 = con3.connect().prepareStatement(qre1, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            obj1.setString(1,catCode);
            ResultSet rs = obj1.executeQuery();

            if(!rs.first()){
                System.out.print("Record not existing, ");
                return null;
            }

            Category obj2 = new Category(rs.getString("catcode"), rs.getString("catdesc"));
            return obj2;
        }
}
