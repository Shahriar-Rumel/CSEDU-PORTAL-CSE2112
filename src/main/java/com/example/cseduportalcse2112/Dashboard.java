package com.example.cseduportalcse2112;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Dashboard {
    protected static CSEDU CSEDUDEPT;
//
//    public void getData(){
//        CSEDUDEPT = new CSEDU();
//        CSEDUDEPT.setYearList(1);
//        CSEDUDEPT.YearList.get(0).setSemesterList(1);
//        CSEDUDEPT.YearList.get(0).getSemesterList().get(0).setClassroomList("OOP","CSE-2102","MIB",1.5);
//        if(CSEDUDEPT.getYearList().get(0).getSemesterList().get(0).getClassroomList().get(0).getClassroomTeacherName() != null)
//            System.out.println(CSEDUDEPT.getYearList().get(0).getSemesterList().get(0).getClassroomList().get(0).getClassroomTeacherName());
//
//    }
    public String getName(){
        CSEDUDEPT = new CSEDU();
        CSEDUDEPT.setYearList(1);
        CSEDUDEPT.YearList.get(0).setSemesterList(1);
        CSEDUDEPT.YearList.get(0).getSemesterList().get(0).setClassroomList("OOP","CSE-2102","MIB",1.5);
        CSEDUDEPT.YearList.get(0).getSemesterList().get(0).getClassroomList().get(0).setStudentList("Fahmida Ara","Demo","Demo",2,1,31,201971);

//        System.out.println(CSEDUDEPT.getYearList().get(0).getSemesterList().get(0).getClassroomList().get(0).getStudentList().get(0).getStudentName());
        return CSEDUDEPT.getYearList().get(0).getSemesterList().get(0).getClassroomList().get(0).getStudentList().get(0).getStudentName();

    }
}
