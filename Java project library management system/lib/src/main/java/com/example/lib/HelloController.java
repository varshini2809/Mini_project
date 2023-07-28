package com.example.lib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    public void onHelloButtonClick(ActionEvent event) {

        Dbconnection connect=new Dbconnection();
        Connection ConnectDB =connect.getConnection();
        String connectQuery="SELECT idbookdetails FROM bookdetails";
        try{
            Statement statement=ConnectDB.createStatement();
            ResultSet queryOutput=statement.executeQuery(connectQuery);
            while(queryOutput.next()){
                welcomeText.setText(queryOutput.getString("idbookdetails"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}