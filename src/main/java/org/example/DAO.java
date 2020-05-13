package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO<T>  {
    ConnectionDb cdb=new ConnectionDb();

    public abstract T create(T obj);

    public abstract T find(String id);

    public abstract void delete(String id);

    public abstract T update(T obj);

}