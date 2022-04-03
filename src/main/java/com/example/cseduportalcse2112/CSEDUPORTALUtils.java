package com.example.cseduportalcse2112;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class CSEDUPORTALUtils  {


    public static void changeScence(ActionEvent event, String fxmlFile, String Title, String StudentName){
        Parent root = null;
        if(StudentName != null){
            try{
                FXMLLoader loader = new FXMLLoader(CSEDUPORTALUtils.class.getResource(fxmlFile));
                root = loader.load();
                DashboardScreenController DashboardScreenController = loader.getController();
                DashboardScreenController.getClass();
            }

            catch (IOException e){
                System.out.println(e.getStackTrace());
            }
        }else{
            try{
                root = FXMLLoader.load(CSEDUPORTALUtils.class.getResource(fxmlFile));
            }catch (IOException e){
                System.out.println("Can't Load File");
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(Title);
        stage.setScene(new Scene(root,1100,680));
        stage.show();
    }
    public static void changeScenceWindow(WindowEvent event, String fxmlFile, String Title, String StudentName){
        Parent root = null;
        if(StudentName != null){
            try{
                FXMLLoader loader = new FXMLLoader(CSEDUPORTALUtils.class.getResource(fxmlFile));
                root = loader.load();
                DashboardScreenController DashboardScreenController = loader.getController();
                DashboardScreenController.getClass();
            }

            catch (IOException e){
                System.out.println(e.getStackTrace());
            }
        }else{
            try{
                root = FXMLLoader.load(CSEDUPORTALUtils.class.getResource(fxmlFile));
            }catch (IOException e){
                System.out.println("Can't Load File");
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(Title);
        stage.setScene(new Scene(root,1100,680));
        stage.show();
    }
    public static void changeScenceforMouseEvent(MouseEvent event, String fxmlFile, String Title, String StudentName){
        Parent root = null;
        if(StudentName != null){
            try{
                FXMLLoader loader = new FXMLLoader(CSEDUPORTALUtils.class.getResource(fxmlFile));
                root = loader.load();
                DashboardScreenController DashboardScreenController = loader.getController();
                DashboardScreenController.getClass();
            }

            catch (IOException e){
                System.out.println(e.getStackTrace());
            }
        }else{
            try{
                root = FXMLLoader.load(CSEDUPORTALUtils.class.getResource(fxmlFile));
            }catch (IOException e){
                System.out.println("Can't Load File");
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(Title);
        stage.setScene(new Scene(root,1100,680));
        stage.show();
    }

    public static void signUpUser(ActionEvent event,String Name,String Email,String Password,String semester,String year,String roll,String registration){
        Connection connection = null;
        PreparedStatement userInsert = null;
        PreparedStatement checkUserExist = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cseduportal","root","user");
            checkUserExist = connection.prepareStatement("SELECT * FROM student WHERE Registration = ?");
            checkUserExist.setString(1, registration);

            resultSet = checkUserExist.executeQuery();

            if(resultSet.isBeforeFirst()){
                System.out.println("User Already Exist");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User Already Exist");
                alert.show();
            }
            else{
                userInsert = connection.prepareStatement("INSERT INTO student (Name,Email,Password,Year,Semester,Roll,Registration) VALUES (?,?,?,?,?,?,? )");
                userInsert.setString(1,Name);
                userInsert.setString(2,Email);
                userInsert.setString(3,Password);
                userInsert.setString(4, String.valueOf(year));
                userInsert.setString(5, String.valueOf(semester));
                userInsert.setString(6, String.valueOf(roll));
                userInsert.setString(7,registration);
                userInsert.executeUpdate();
                changeScence(event,"DashboardScreen.fxml","Dashboard",null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(resultSet != null){
                try{
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(userInsert != null){
                try{
                    userInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if(checkUserExist != null){
                try{
                    checkUserExist.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }

    }
    public static void loginUser(ActionEvent event, String Registration, String Password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cseduportal","root","user");
            preparedStatement = connection.prepareStatement("SELECT Registration,Password FROM student WHERE Registration = ? ");
            preparedStatement.setString(1,Registration);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                System.out.println("User Not Found");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User Not Found");
                alert.show();
            }else{
                while(resultSet.next()) {
                    String retrivedPassword = resultSet.getString("Password");
                    String retrivedRegistration = resultSet.getString("Registration");
//                    String retrivedYear = resultSet.getString("Year");
//                    String retrivedSemester = resultSet.getString("Semester");

                    if(retrivedPassword.equals(Password)){
                        changeScence(event,"DashboardScreen.fxml","Dashboard",null);
                        DBDATAGETTER.courseGenerate("1","1");
                    }
                    else{
                        System.out.println("Password did not match");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("The provided credentials are incorrect!");
                        alert.show();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(resultSet != null){
                try{
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement != null){
                try{
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if(connection != null){
                try{
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}