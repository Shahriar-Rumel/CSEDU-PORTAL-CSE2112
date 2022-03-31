package com.example.cseduportalcse2112;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardScreenController extends Dashboard implements Initializable  {
//    @FXML
//    private Button logoutButton;
    @FXML
    private ImageView LogoutImage;
    @FXML
    private ImageView cgpaCalculatorIcon;

    @FXML
    private AnchorPane CgpaCalculatorPane;

    @FXML
    private Label studentName;
    @FXML
    private Text upcomingclassname1;

    private String name;
    private ArrayList<String>CourseNameList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        LogoutImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                CSEDUPORTALUtils.changeScenceforMouseEvent(mouseEvent,"LoginScreen.fxml","Log in",null);
            }
        });
        cgpaCalculatorIcon.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                CSEDUPORTALUtils.changeScenceforMouseEvent(mouseEvent,"CGPACalculatorScreen.fxml","CGPA Calculator",null);
            }
        });
        studentName.setText(getStudentName());
        upcomingclassname1.setText(getUpcomingList());

    }
    public DashboardScreenController() {
        super();
        setName(super.getName());
        super.getCourseName();
//        setUpcomingList(super.getCourseName());
    }
    public void setName(String Name){
        this.name = Name;
    }
    public String getStudentName() {
        return this.name;
    }
    public void setUpcomingList(String result){
        CourseNameList.add(result);
    }
    public String getUpcomingList(){
        String s = "okay";
        return s;
    }
}
