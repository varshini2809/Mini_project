package com.example.lib;
import java.sql.Connection;
import java.sql.DriverManager;
public class Dbconnection {
    public Connection Link;
    public  Connection getConnection(){
        String database_n="kalai";
        String database_u="root";
        String database_p="D14m4y2004@";
        String url="jdbc:mysql://localhost/"+database_n;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Link=DriverManager.getConnection(url,database_u,database_p);
        }catch(Exception e){
           e.printStackTrace();
        }return  Link;
    }
}
