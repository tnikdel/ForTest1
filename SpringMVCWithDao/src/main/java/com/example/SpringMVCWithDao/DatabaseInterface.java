package com.example.SpringMVCWithDao;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseInterface {

    public void add(Category cat) throws ClassNotFoundException, SQLException;
    public Category edit(Category cat, String catcode) throws SQLException, ClassNotFoundException;
    public void delete(String catcode) throws SQLException;
    public List<Category> display() throws ClassNotFoundException, SQLException;
}
