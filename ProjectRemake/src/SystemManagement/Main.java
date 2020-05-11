package SystemManagement;


import CsvFiles.ReadWrite;
import Interface.App;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
       /* ReadWrite<List<String>> readWrite=ReadWrite.getInstance();
        Services s=new Services();
        s.application(readWrite);
        App app=new App();
        app.showTable()*/
        try{
            Connection connection= DriverManager.getConnection( "jdbc:mysql://localhost:3306/employee","root","adrianros");// ai setat tu parola asta?
            Statement connectDB=connection.createStatement();
            ResultSet employeeData=connectDB.executeQuery("select * from employee.departments");
            while (employeeData.next()){
                System.out.println(employeeData.getString("lastName"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }

}
