package com.example.SpringMVCWithDao;

import java.sql.SQLException;

public interface DaoInterface {

    public void add(Category cat) throws SQLException, ClassNotFoundException;
    //saves the old value(ccCat)
    public Category edit(Category cat,String ccCat) throws SQLException, ClassNotFoundException ;
    public void delete (String catCode) throws SQLException, ClassNotFoundException;
    public void display() throws SQLException, ClassNotFoundException;
    //check if it exists
    public Category search(String catCode) throws SQLException, ClassNotFoundException;


}
