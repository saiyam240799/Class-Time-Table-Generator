package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.mysql.jdbc.Statement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application implements EventHandler<ActionEvent>{
    Stage window;
    Scene scene1,scene2,scene3,scene4,scene5,scene6,scene7,scene8,scene9,scene10;
    TableView<lecinfo> table;
    Button Lecturer,Course,Home,addinfo,deleteinfo,coursesubmit,addcourses,allocate;
    Button CE,IT,EC,ME;
    TextField lecinput,depinput,courseinput,leclinput;
    Label label7,label8,label9,label10,label11,label12;
    String lecturername_it[] = new String[20];
    String lecturerdepartment_it[] = new String[20];
    String lecturerid_it[] = new String[20];
    String temp="";
    int iterator=0;
    int day=0;
    int timing=0;
    int countlecturer=0;
    
    String lecturername_ce[] = new String[20];
    String lecturerdepartment_ce[] = new String[20];
    String lecturerid_ce[] = new String[20];
    
    String allocation_final[][] = new String[60][60];
    String allocation_final1[][] = new String[60][60];
    String allocation_final3[][] = new String[60][60];
    String allocation_final4[][] = new String[60][60];
    String allocation_final22[][] = new String[60][60];
    String allocation_final11[][] = new String[60][60];
    String allocation_final33[][] = new String[60][60];
    String allocation_final44[][] = new String[60][60];
    String allocation[][][] = new String[200][200][200];
    String allocation1[][][] = new String[200][200][200];
    String lecturername_me[] = new String[20];
    String lecturerdepartment_me[] = new String[20];
    String lecturerid_me[] = new String[20];
    String lecturername_ec[] = new String[20];
    String lecturerdepartment_ec[] = new String[20];
    String lecturerid_ec[] = new String[20];
    int countcourses[]=new int[50];
    int countcourses1[]=new int[50];
    int countmonday[] = new int[20];
    int countmonday1[]=new int[20];
    int counttuesday[] = new int[20];
    int counttuesday1[]=new int[20];
    int countwednesday[] = new int[20];
    int countwednesday1[]=new int[20];
    int countthursday[] = new int[20];
    int countthursday1[]=new int[20];
    int countfriday[] = new int[20];
    int countfriday1[]=new int[20];
    String s2="abc";
    String s1="";
    String s="";
    String s3="";
    String firstname = "";
    String lastname = "";
    String course = "";
    String monday1 = "";
    String tuesday1 = "";
    String wednesday1 = "";
    String thursday1 = "";
    String friday1 = "";
    String depar = "";
    String name ="";
    String lname = "";
    Label hello4;
    ObservableList<String> courses;
    ObservableList<String> monday;
    ObservableList<String> tuesday;
    ObservableList<String> wednesday;
    ObservableList<String> thursday;
    ObservableList<String> friday;
    ChoiceBox<String> choicecourses = new ChoiceBox<>();
    ChoiceBox<String> choicedepartment = new ChoiceBox<>();
    lecinfo addlec = new lecinfo();
     ListView<String> listview = new ListView<>();
     ListView<String> listmonday = new ListView<>();
     ListView<String> listtuesday = new ListView<>();
     ListView<String> listwednesday = new ListView<>();
     ListView<String> listthursday = new ListView<>();
     ListView<String> listfriday = new ListView<>();
    int i1=301,i2=301,i3=301,i4=301,j1 = 0,j2=0,j3=0,j4=0;
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) throws Exception{
        window=primaryStage;
        window.setOnCloseRequest(e ->{
            //    e.consume();
            //closeProgram();
            });
        
        
        Label label1=new Label("Welcome to time table Generator");
        allocate = new Button("Allocate");
        allocate.setOnAction(e->{
            addsubmit1_info();
            window.setScene(scene6);
        });
        Lecturer = new Button("Lecturer");
        Lecturer.setOnAction(e -> window.setScene(scene2));
        Course = new Button("Courses");
        Course.setOnAction(e -> window.setScene(scene3));
        
        VBox layout1 = new VBox(20);
        
        Image image = new Image("file:timetablewhite.png");
        ImageView iv = new ImageView();
        iv.setImage(image);
        iv.setFitWidth(1560);
        iv.setFitHeight(760);
        StackPane root = new StackPane();
        
        layout1.getChildren().addAll(label1,Lecturer,allocate);
        
        Lecturer.setStyle("-fx-font-weight:bold;");
        Course.setStyle("-fx-font-weight:bold;");
        allocate.setStyle("-fx-font-weight:bold;");
        
        root.getChildren().addAll(iv,layout1);
        scene1=new Scene(root,1560,760);
        scene1.getStylesheets().add("effect.css");
        
        //layout2 scene2
        
        
        Label label2=new Label("Enter Lecturer's information: ");
        
        VBox leclayout = new VBox(20);
        
        TableColumn<lecinfo,String> leccolumn=new TableColumn<>("First Name:");
        leccolumn.setMinWidth(200);
        leccolumn.setCellValueFactory(new PropertyValueFactory<>("lecname"));
        
        TableColumn<lecinfo,String> leclcolumn=new TableColumn<>("last Name:");
        leclcolumn.setMinWidth(200);
        leclcolumn.setCellValueFactory(new PropertyValueFactory<>("leclname"));
        
        
        TableColumn<lecinfo,String> depcolumn=new TableColumn<>("Department:");
        depcolumn.setMinWidth(200);
        depcolumn.setCellValueFactory(new PropertyValueFactory<>("Department"));
        
        TableColumn<lecinfo,String> lecidcolumn=new TableColumn<>("LectecurerID:");
        lecidcolumn.setMinWidth(200);
        lecidcolumn.setCellValueFactory(new PropertyValueFactory<>("lecid"));
        
        
        table=new TableView<>();
        table.setItems(getLecinfo());
        table.getColumns().addAll(leccolumn,leclcolumn,depcolumn,lecidcolumn);
        
        lecinput = new TextField();
        lecinput.setPromptText("First Name ");
        lecinput.setMinWidth(80);
        
        leclinput = new TextField();
        leclinput.setPromptText(" Last Name ");
        leclinput.setMinWidth(80);
        
        
        
        choicedepartment.getItems().addAll("IT","CE","ME","EC");
        choicedepartment.setValue("IT");

        
        
        addinfo = new Button("ADD");
        addinfo.setOnAction(e ->{
            addinfoClicked(choicedepartment);
            window.setScene(scene5);
        });
        
        
        
        //scene 6
        
        VBox vbox1=new VBox(15);
        Button home = new Button("Return to home page");
        CE = new Button("   Computer Engineering    ");
        IT = new Button("  Information Technology   ");
        EC = new Button("Electronics & Communication");
        ME = new Button("  Mechanical Engineering   ");
        CE.setOnAction(e ->{
            window.setScene(scene8);
        });
        IT.setOnAction(e -> {
            window.setScene(scene7);
        });
        EC.setOnAction(e -> {
            window.setScene(scene9);
        });
        ME.setOnAction(e -> {
            window.setScene(scene10);
        });
        
        home.setOnAction(e ->{
            window.setScene(scene1);
        });
        
        Image image2 = new Image("file:timetablewhite.png");
        ImageView iv2 = new ImageView();
        iv2.setImage(image2);
        iv2.setFitWidth(1560);
        iv2.setFitHeight(760);
        StackPane root2 = new StackPane();
        
        vbox1.getChildren().addAll(CE,IT,EC,ME,home);
        root2.getChildren().addAll(iv2,vbox1);
        scene6=new Scene(root2,1360,750);
        
        
       
        //scene 5
                VBox next=new VBox(15);
                
                Image image1 = new Image("file:timetablewhite.png");
                ImageView iv1 = new ImageView();
                iv1.setImage(image1);
                iv1.setFitWidth(1560);
                iv1.setFitHeight(760);
                StackPane root1 = new StackPane();
                
                Button submit = new Button("Submit");
                submit.setOnAction(e -> {
                    addsubmit_info();
                      window.setScene(scene4);
                });
                next.getChildren().addAll(submit);
                root1.getChildren().addAll(iv1,next);
                scene5=new Scene(root1,1360,750);
                
                
                
                
        //scene 4        
                VBox allocationlayout = new VBox(15);
                label7=new Label("Select Courses for the Lecturer Added");
                label8=new Label("Select Monday Free");
                label9=new Label("Select Tuesday Free Slot of Faculty");
                label10=new Label("Select Wednesday Free Slot of Faculty");
                label11=new Label("Select Thursday Free Slot of Faculty");
                label12=new Label("Select Friday Free Slot of Faculty");
                
                HBox hboxmon=new HBox(20);
                hboxmon.getChildren().addAll(label8,listmonday,label9,listtuesday);
                
                
                addcourses = new Button("ADD COURSE");
                addcourses.setOnAction(e -> {
                    addlist_info();
                    window.setScene(scene2);
                });
                allocationlayout.getChildren().addAll(label7,listview,hboxmon,label10,listwednesday);
                allocationlayout.getChildren().addAll(label11,listthursday,label12,listfriday,addcourses);
                scene4=new Scene(allocationlayout,1000,1000);
                scene4.getStylesheets().add("effect.css");
                
        deleteinfo =new Button("DELETE");
        deleteinfo.setOnAction(e -> deleteinfoClicked());
        
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10,10,10,10));
        hbox.setSpacing(20);
        Home = new Button("Go to Main time table page");
        Home.setOnAction(e -> window.setScene(scene1));
        hbox.getChildren().addAll(lecinput,leclinput,choicedepartment,addinfo,deleteinfo,Home);
        
        addinfo.setStyle("-fx-font-weight:bold;");
        deleteinfo.setStyle("-fx-font-weight:bold;");
        Home.setStyle("-fx-font-weight:bold;");
        
        leclayout.getChildren().addAll(table,hbox);
        scene2=new Scene(leclayout,800,500);
        scene2.getStylesheets().add("effect2.css");
        
        // int day=0,timing=0;String allocation_final[][] = new String[60][60];
        /*
         loop
             1-number of teachers
             2-courses
             3-lecture or lab if lecture 3 loop and if lab 1 loop
             4-days mon,tue,wed
             5-free time i.e. countmonday, counttuesday ...
         */
        //scene 7
        VBox allocate=new VBox(5);
        Label hello,hello1,hello2,hello5,hello6,hello7,hello8,hello9,hello10,hello11,hello12,hello13,hello14,hello15;
        
        Pair pair = addsubmit1_info();
        allocation1=pair.getArray1();
        countcourses1=pair.getArray2();
        countmonday1 = pair.getArray3();
        counttuesday1 = pair.getArray4();
        countwednesday1 = pair.getArray5();
        countthursday1 = pair.getArray6();
        countfriday1 = pair.getArray7();
        countlecturer = pair.getArray8();
        
        //short form conversion for subjects and teachers
        
        char split[] = new char[100];
        char x1 ='a';
        char y1;
        String s10 = "";
        String s20 = "";
        String s30 = "";
        String alloc_lec[][] = new String[4][10];
        String alloc_lecs[][] = new String[4][10];
        for(int i=0;i<countlecturer;i++)
        {
            s30=  allocation[i][1][0] + " " + allocation[i][2][0] ;
            split = s30.toCharArray();
            y1 = split[0];
                for(int j=0;j<split.length-1;j++)
                {
                    if(split[j]==' ')
                    {
                        x1 = split[j+1];
                    }
                }
                s10 = Character.toString(x1);
                s20 = Character.toString(y1);
                if(allocation[i][0][0].charAt(0)=='C')
                {
                	alloc_lec[0][i] = allocation[i][1][0] + " " + allocation[i][2][0];
                	alloc_lecs[0][i] = s20 + s10;
                }
                
                if(allocation[i][0][0].charAt(0)=='I')
                {
                	alloc_lec[1][i] = allocation[i][1][0] + " " + allocation[i][2][0];
                	alloc_lecs[1][i] = s20 + s10;
                }
                if(allocation[i][0][0].charAt(0)=='E')
                {
                	alloc_lec[2][i] = allocation[i][1][0] + " " + allocation[i][2][0];
                	alloc_lecs[2][i] = s20 + s10;
                }
                if(allocation[i][0][0].charAt(0)=='M')
                {
                	alloc_lec[3][i] = allocation[i][1][0] + " " + allocation[i][2][0];
                	alloc_lecs[3][i] = s20 + s10;
                }
                allocation[i][1][0] = s20 + s10;
                
        }
        
        for(int i=0;i<countlecturer;i++)
        {
            for(int j=0;j<countcourses[i];j++)
            {
                
                if(allocation1[i][3][j].equals("Data Structures"))
                {
                    allocation1[i][3][j] = "DS";    
                }
                else if(allocation1[i][3][j].equals("Probability Statistics and numerical Analysis") || allocation1[i][3][j].equals("Probability Statistics and numerical Analysis") )
                {
                    allocation1[i][3][j] = "PSNA";
                }
                else if(allocation1[i][3][j].equals("Computer Organisations"))
                {
                    allocation1[i][3][j] = "CO";
                }
                else if(allocation1[i][3][j].equals("Communication Engineering"))
                {
                    allocation1[i][3][j] = "CE";
                }
                else if(allocation1[i][3][j].equals("Computer Peripherals Workshop"))
                {
                    allocation1[i][3][j] = "CPW";
                }
                else if(allocation1[i][3][j].equals("Mini Project-1"))
                {
                    allocation1[i][3][j] = "MP-1";
                    
                }
                else if(allocation1[i][3][j].equals("Economics"))
                {
                    allocation1[i][3][j] = "ECO";
                }
                else if(allocation1[i][3][j].equals("Seminar"))
                {
                    allocation1[i][3][j] = "SEM";        
                }
                else if(allocation1[i][3][j].equals("Data Communications"))
                {
                    allocation1[i][3][j] = "DC";
                }
                else if(allocation1[i][3][j].equals("Probability Distributions and Numerical Methods"))
                {
                    allocation1[i][3][j] = "PDNM";
                }
                else if(allocation1[i][3][j].equals("Signals and Systems"))
                {
                    allocation1[i][3][j] = "SS";
                }
                else if(allocation1[i][3][j].equals("Signals and Systems Lab"))
                {
                    allocation1[i][3][j] = "SS Lab";
                }
                else if(allocation1[i][3][j].equals("Electronic Devices and Circuits-2"))
                {
                    allocation1[i][3][j] = "EDC";
                }
                else if(allocation1[i][3][j].equals("Electrical Machines and Drives "))
                {
                    allocation1[i][3][j] = "EMD";
                }
                else if(allocation1[i][3][j].equals("Communication Systems"))
                {
                    allocation1[i][3][j] = "CS";
                }
                else if(allocation1[i][3][j].equals("Communication Systems Lab"))
                {
                    allocation1[i][3][j] = "CS Lab";
                }
                else if(allocation1[i][3][j].equals("Electronic Design Tools and Packages"))
                {
                    allocation1[i][3][j] = "EDTP";
                }
                else if(allocation1[i][3][j].equals("ICT Tools and Packages"))
                {
                    allocation1[i][3][j] = "ICT";
                }
                else if(allocation1[i][3][j].equals("ICT Tools & Security"))
                {
                    allocation1[i][3][j] = "ICT";
                }
                else if(allocation1[i][3][j].equals("Dynamics of Machinery"))
                {
                    allocation1[i][3][j] = "DM";
                }
                else if(allocation1[i][3][j].equals("Dynamics of Machinery Lab"))
                {
                    allocation1[i][3][j] = "DM Lab";
                }
                else if(allocation1[i][3][j].equals("Metrology and Instrumentation"))
                {
                    allocation1[i][3][j] = "MI";
                }
                else if(allocation1[i][3][j].equals("Metrology and Instrumentation Lab"))
                {
                    allocation1[i][3][j] = "MI Lab";
                }
                else if(allocation1[i][3][j].equals("Mathematics of Mechanical Engineering"))
                {
                    allocation1[i][3][j] = "MME";
                }
                else if(allocation1[i][3][j].equals("Manufacturing Processes"))
                {
                    allocation1[i][3][j] = "MP";
                }
                else if(allocation1[i][3][j].equals("Mathematics of Mechanical Engineering Lab"))
                {
                    allocation1[i][3][j] = "MME Lab";
                }
                else if(allocation1[i][3][j].equals("Manufacturing Processes Lab"))
                {
                    allocation1[i][3][j] = "MP Lab";
                }
                else if(allocation1[i][3][j].equals("Fluid mechanics"))
                {
                    allocation1[i][3][j] = "FM";
                }
            }
        }
        /*
        //MONDAY[][4][0] tuseday[5] wednesday[6] thursday[7] friday[8]
            hello =  new Label(allocation1[0][0][0] + " || " + allocation1[0][1][0] + " || " + allocation1[0][2][0] + " || " + allocation1[0][3][0] + " || " + allocation1[0][3][1] + " || " + allocation1[0][3][2] + " || " + allocation1[0][4][0] + " || " + allocation1[0][4][1] + " || " + allocation1[0][5][0] + " || " + allocation1[0][5][1] + " || " + allocation1[0][5][2] + " || " + allocation1[0][6][0] + " || " + allocation1[0][7][0] + " || " + allocation1[0][7][1] + " || " + allocation1[0][8][0]);
            hello1 = new Label(allocation1[1][0][0] + " || " + allocation1[1][1][0] + " || " + allocation1[1][2][0] + " || " + allocation1[1][3][0] + " || " + allocation1[1][3][1] + " || " + allocation1[1][3][2] + " || " + allocation1[1][4][0] + " || " + allocation1[1][5][0] + " || " + allocation1[1][5][1] + " || " + allocation1[1][6][0] + " || " + allocation1[1][7][0] + " || " + allocation1[1][7][1] + " || " + allocation1[1][7][2] + " || " + allocation1[1][8][0]);
            hello2 = new Label(allocation1[2][0][0] + " || " + allocation1[2][1][0] + " || " + allocation1[2][2][0] + " || " + allocation1[2][3][0] + " || " + allocation1[2][3][1] + " || " + allocation1[2][3][2] + " || " + allocation1[2][3][3] + " || " + allocation1[2][3][4] + " || " + allocation1[2][4][0] + " || " + allocation1[2][5][0] + " || " + allocation1[2][5][1] + " || " + allocation1[2][6][0] + " || " + allocation1[2][7][0] + " || " + allocation1[2][7][1] + " || " + allocation1[2][7][2] + " || " + allocation1[2][7][3] + " || " + allocation1[2][8][0]);
       
            //allocation_final[0][1]="5";
            
            hello4 = new Label(countlecturer + " || " + countcourses1[0] + " || " + countcourses1[1] + " || " + countcourses1[2]);
            hello5 = new Label(countmonday1[0] + " || " + countmonday1[0] + " || " + countmonday1[0]);
            hello6 = new Label(counttuesday1[0] + " || " + counttuesday1[1] + " || " + counttuesday1[2]);
            hello7 = new Label(countwednesday1[0] + " || " + countwednesday1[1] + " || " + countwednesday1[2]);
            hello8 = new Label(countthursday1[0] + " || " + countthursday1[1] + " || " + countthursday1[2]);
            hello9 = new Label(countfriday1[0] + " || " + countfriday1[1] + " || " + countfriday1[2]);
       */
            
            for(int i=0;i<countlecturer;i++)
            {
                System.out.println(countcourses[i]);
                for(int j=0;j<countcourses1[i];j++)
                {
                    if(allocation1[i][0][0].charAt(0)=='I' && allocation1[i][0][0].charAt(1)=='T')
                           if((allocation1[i][3][j].charAt(allocation1[i][3][j].length()-1)=='b' && allocation1[i][3][j].charAt(allocation1[i][3][j].length()-2)=='a' && allocation1[i][3][j].charAt(allocation1[i][3][j].length()-3)=='L') ||  allocation1[i][3][j].equalsIgnoreCase("CPW") || allocation1[i][3][j].equalsIgnoreCase("MP-1") || allocation[i][3][j].equalsIgnoreCase("SEM"))
                        {
                            int k=0;
                            while(k<1)
                            {
                                for(int a=0;a<countmonday1[i];a++)
                                {
                                    System.out.println(allocation1[i][4][a]);
                                    if(allocation1[i][4][a].charAt(0)=='9')
                                    {
                                        if(allocation_final[0][0]==null)
                                        {
                                            allocation_final[0][0]=allocation1[i][3][j];
                                            allocation_final[0][1]=allocation1[i][3][j];
                                            allocation_final22[0][0]=allocation[i][1][0];
                                            allocation_final22[0][1]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        
                                    }
                                    if(allocation1[i][4][a].charAt(0)=='1' && allocation1[i][4][a].charAt(1)=='1')
                                    {
                                        if(allocation_final[0][2]==null)
                                        {
                                            allocation_final[0][2]=allocation1[i][3][j];
                                            allocation_final[0][3]=allocation1[i][3][j];
                                            allocation_final22[0][2]=allocation[i][1][0];
                                            allocation_final22[0][3]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        
                                    }
                                    if(allocation1[i][4][a].charAt(0)=='2')
                                    {
                                        if(allocation_final[0][4]==null)
                                        {
                                            allocation_final[0][4]=allocation1[i][3][j];
                                            allocation_final[0][5]=allocation1[i][3][j];
                                            allocation_final22[0][4]=allocation[i][1][0];
                                            allocation_final22[0][5]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        
                                    }
                                    if(allocation1[i][4][a].charAt(0)=='4')
                                    {
                                        if(allocation_final[0][6]==null)
                                        {
                                            allocation_final[0][6]=allocation1[i][3][j];
                                            allocation_final[0][7]=allocation1[i][3][j];
                                            allocation_final22[0][6]=allocation[i][1][0];
                                            allocation_final22[0][7]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                }
                                if(k>=1)
                                    break;
                                
                                for(int a=0;a<counttuesday1[i];a++)
                                {
                                    if(allocation1[i][5][a].charAt(0)=='9')
                                    {
                                        if(allocation_final[1][0]==null)
                                        {
                                            allocation_final[1][0]=allocation1[i][3][j];
                                            allocation_final[1][1]=allocation1[i][3][j];
                                            allocation_final22[1][0]=allocation[i][1][0];
                                            allocation_final22[1][1]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        
                                    }
                                    if(allocation1[i][5][a].charAt(0)=='1' && allocation1[i][5][a].charAt(1)=='1')
                                    {
                                        if(allocation_final[1][2]==null)
                                        {
                                            allocation_final[1][2]=allocation1[i][3][j];
                                            allocation_final[1][3]=allocation1[i][3][j];
                                            allocation_final22[1][2]=allocation[i][1][0];
                                            allocation_final22[1][3]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][5][a].charAt(0)=='2')
                                    {
                                        if(allocation_final[1][4]==null)
                                        {
                                            allocation_final[1][4]=allocation1[i][3][j];
                                            allocation_final[1][5]=allocation1[i][3][j];
                                            allocation_final22[1][4]=allocation[i][1][0];
                                            allocation_final22[1][5]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        
                                    }
                                    if(allocation1[i][5][a].charAt(0)=='4')
                                    {
                                        if(allocation_final[1][6]==null)
                                        {
                                            allocation_final[1][6]=allocation1[i][3][j];
                                            allocation_final[1][7]=allocation1[i][3][j];
                                            allocation_final22[1][6]=allocation[i][1][0];
                                            allocation_final22[1][7]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                }
                                if(k>=1)
                                    break;
                                for(int a=0;a<countwednesday1[i];a++)
                                {
                                    if(allocation1[i][6][a].charAt(0)=='9')
                                    {
                                        if(allocation_final[2][0]==null)
                                        {
                                            allocation_final[2][0]=allocation1[i][3][j];
                                            allocation_final[2][1]=allocation1[i][3][j];
                                            allocation_final22[2][0]=allocation[i][1][0];
                                            allocation_final22[2][1]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][6][a].charAt(0)=='1' && allocation1[i][6][a].charAt(1)=='1')
                                    {
                                        if(allocation_final[2][2]==null)
                                        {
                                            allocation_final[2][2]=allocation1[i][3][j];
                                            allocation_final[2][3]=allocation1[i][3][j];
                                            allocation_final22[2][2]=allocation[i][1][0];
                                            allocation_final22[2][3]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][6][a].charAt(0)=='2')
                                    {
                                        if(allocation_final[2][4]==null)
                                        {
                                            allocation_final[2][4]=allocation1[i][3][j];
                                            allocation_final[2][5]=allocation1[i][3][j];
                                            allocation_final22[2][4]=allocation[i][1][0];
                                            allocation_final22[2][5]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][6][a].charAt(0)=='4')
                                    {
                                        if(allocation_final[2][6]==null)
                                        {
                                            allocation_final[2][6]=allocation1[i][3][j];
                                            allocation_final[2][7]=allocation1[i][3][j];
                                            allocation_final22[2][6]=allocation[i][1][0];
                                            allocation_final22[2][7]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                }
                                if(k>=1)
                                    break;
                                for(int a=0;a<countthursday1[i];a++)
                                {
                                    if(allocation1[i][7][a].charAt(0)=='9')
                                    {
                                        if(allocation_final[3][0]==null)
                                        {
                                            allocation_final[3][0]=allocation1[i][3][j];
                                            allocation_final[3][1]=allocation1[i][3][j];
                                            allocation_final22[3][0]=allocation[i][1][0];
                                            allocation_final22[3][1]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][7][a].charAt(0)=='1' && allocation1[i][7][a].charAt(1)=='1')
                                    {
                                        if(allocation_final[3][2]==null)
                                        {
                                            allocation_final[3][2]=allocation1[i][3][j];
                                            allocation_final[3][3]=allocation1[i][3][j];
                                            allocation_final22[3][2]=allocation[i][1][0];
                                            allocation_final22[3][3]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][7][a].charAt(0)=='2')
                                    {
                                        if(allocation_final[3][4]==null)
                                        {
                                            allocation_final[3][4]=allocation1[i][3][j];
                                            allocation_final[3][5]=allocation1[i][3][j];
                                            allocation_final22[3][4]=allocation[i][1][0];
                                            allocation_final22[3][5]=allocation[i][1][0];
                                            break;
                                        }
                                    }
                                    if(allocation1[i][7][a].charAt(0)=='4')
                                    {
                                        if(allocation_final[3][6]==null)
                                        {
                                            allocation_final[3][6]=allocation1[i][3][j];
                                            allocation_final[3][7]=allocation1[i][3][j];
                                            allocation_final22[3][6]=allocation[i][1][0];
                                            allocation_final22[3][7]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                }
                                if(k>=1)
                                    break;
                                for(int a=0;a<countfriday1[i];a++)
                                {
                                    if(allocation1[i][8][a].charAt(0)=='9')
                                    {
                                        if(allocation_final[4][0]==null)
                                        {
                                            allocation_final[4][0]=allocation1[i][3][j];
                                            allocation_final[4][1]=allocation1[i][3][j];
                                            allocation_final22[4][0]=allocation[i][1][0];
                                            allocation_final22[4][1]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][8][a].charAt(0)=='1' && allocation1[i][8][a].charAt(1)=='1')
                                    {
                                        if(allocation_final[4][2]==null)
                                        {
                                            allocation_final[4][2]=allocation1[i][3][j];
                                            allocation_final[4][3]=allocation1[i][3][j];
                                            allocation_final22[4][2]=allocation[i][1][0];
                                            allocation_final22[4][3]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][8][a].charAt(0)=='2')
                                    {
                                        if(allocation_final[4][4]==null)
                                        {
                                            allocation_final[4][4]=allocation1[i][3][j];
                                            allocation_final[4][5]=allocation1[i][3][j];
                                            allocation_final22[4][4]=allocation[i][1][0];
                                            allocation_final22[4][5]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][8][a].charAt(0)=='4')
                                    {
                                        if(allocation_final[4][6]==null)
                                        {
                                            allocation_final[4][6]=allocation1[i][3][j];
                                            allocation_final[4][7]=allocation1[i][3][j];
                                            allocation_final22[4][6]=allocation[i][1][0];
                                            allocation_final22[4][7]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                }
                                
                                    break;
                            }
                            
                        }
                        else
                        {
                            int k=0;
                            while(k<3)
                            {
                                for(int a=0;a<countmonday1[i];a++)
                                {
                                    if(allocation1[i][4][a].charAt(0)=='9')
                                    {
                                        if(allocation_final[0][0]==null)
                                        {
                                            allocation_final[0][0]=allocation1[i][3][j];
                                            allocation_final22[0][0]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        else if(allocation_final[0][1]==null)
                                        {
                                            allocation_final[0][1]=allocation1[i][3][j];
                                            allocation_final22[0][1]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][4][a].charAt(0)=='1' && allocation1[i][4][a].charAt(1)=='1')
                                    {
                                        if(allocation_final[0][2]==null)
                                        {
                                            allocation_final[0][2]=allocation1[i][3][j];
                                            allocation_final22[0][2]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        else if(allocation_final[0][3]==null)
                                        {
                                            allocation_final[0][3]=allocation1[i][3][j];
                                            allocation_final22[0][3]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][4][a].charAt(0)=='2')
                                    {
                                        if(allocation_final[0][4]==null)
                                        {
                                            allocation_final[0][4]=allocation1[i][3][j];
                                            allocation_final22[0][4]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        else if(allocation_final[0][5]==null)
                                        {
                                            allocation_final[0][5]=allocation1[i][3][j];
                                            allocation_final22[0][5]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][4][a].charAt(0)=='4')
                                    {
                                        if(allocation_final[0][6]==null)
                                        {
                                            allocation_final[0][6]=allocation1[i][3][j];
                                            allocation_final22[0][6]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        else if(allocation_final[0][7]==null)
                                        {
                                            allocation_final[0][7]=allocation1[i][3][j];
                                            allocation_final22[0][7]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                }
                                if(k>=3)
                                    break;
                                
                                for(int a=0;a<counttuesday1[i];a++)
                                {
                                    if(allocation1[i][5][a].charAt(0)=='9')
                                    {
                                        if(allocation_final[1][0]==null)
                                        {
                                            allocation_final[1][0]=allocation1[i][3][j];
                                            allocation_final22[1][0]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        else if(allocation_final[1][1]==null)
                                        {
                                            allocation_final[1][1]=allocation1[i][3][j];
                                            allocation_final22[1][1]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][5][a].charAt(0)=='1' && allocation1[i][5][a].charAt(1)=='1')
                                    {
                                        if(allocation_final[1][2]==null)
                                        {
                                            allocation_final[1][2]=allocation1[i][3][j];
                                            allocation_final22[1][2]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        else if(allocation_final[1][3]==null)
                                        {
                                            allocation_final[1][3]=allocation1[i][3][j];
                                            allocation_final22[1][3]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][5][a].charAt(0)=='2')
                                    {
                                        if(allocation_final[1][4]==null)
                                        {
                                            allocation_final[1][4]=allocation1[i][3][j];
                                            allocation_final22[1][4]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        else if(allocation_final[1][5]==null)
                                        {
                                            allocation_final[1][5]=allocation1[i][3][j];
                                            allocation_final22[1][5]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][5][a].charAt(0)=='4')
                                    {
                                        if(allocation_final[1][6]==null)
                                        {
                                            allocation_final[1][6]=allocation1[i][3][j];
                                            allocation_final22[1][6]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        else if(allocation_final[1][7]==null)
                                        {
                                            allocation_final[1][7]=allocation1[i][3][j];
                                            allocation_final22[1][7]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                }
                                if(k>=3)
                                    break;
                                for(int a=0;a<countwednesday1[i];a++)
                                {
                                    if(allocation1[i][6][a].charAt(0)=='9')
                                    {
                                        if(allocation_final[2][0]==null)
                                        {
                                            allocation_final[2][0]=allocation1[i][3][j];
                                            allocation_final22[2][0]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        else if(allocation_final[2][1]==null)
                                        {
                                            allocation_final[2][1]=allocation1[i][3][j];
                                            allocation_final22[2][1]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][6][a].charAt(0)=='1' && allocation1[i][6][a].charAt(1)=='1')
                                    {
                                        if(allocation_final[2][2]==null)
                                        {
                                            allocation_final[2][2]=allocation1[i][3][j];
                                            allocation_final22[2][2]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        else if(allocation_final[2][3]==null)
                                        {
                                            allocation_final[2][3]=allocation1[i][3][j];
                                            allocation_final22[2][3]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][6][a].charAt(0)=='2')
                                    {
                                        if(allocation_final[2][4]==null)
                                        {
                                            allocation_final[2][4]=allocation1[i][3][j];
                                            allocation_final22[2][4]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        else if(allocation_final[2][5]==null)
                                        {
                                            allocation_final[2][5]=allocation1[i][3][j];
                                            allocation_final22[2][5]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][6][a].charAt(0)=='4')
                                    {
                                        if(allocation_final[2][6]==null)
                                        {
                                            allocation_final[2][6]=allocation1[i][3][j];
                                            allocation_final22[2][6]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        else if(allocation_final[2][7]==null)
                                        {
                                            allocation_final[2][7]=allocation1[i][3][j];
                                            allocation_final22[2][7]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                }
                                if(k>=3)
                                    break;
                                for(int a=0;a<countthursday1[i];a++)
                                {
                                    if(allocation1[i][7][a].charAt(0)=='9')
                                    {
                                        if(allocation_final[3][0]==null)
                                        {
                                            allocation_final[3][0]=allocation1[i][3][j];
                                            allocation_final22[3][0]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        else if(allocation_final[3][1]==null)
                                        {
                                            allocation_final[3][1]=allocation1[i][3][j];
                                            allocation_final22[3][1]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][7][a].charAt(0)=='1' && allocation1[i][7][a].charAt(1)=='1')
                                    {
                                        if(allocation_final[3][2]==null)
                                        {
                                            allocation_final[3][2]=allocation1[i][3][j];
                                            allocation_final22[3][2]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        else if(allocation_final[3][3]==null)
                                        {
                                            allocation_final[3][3]=allocation1[i][3][j];
                                            allocation_final22[3][3]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][7][a].charAt(0)=='2')
                                    {
                                        if(allocation_final[3][4]==null)
                                        {
                                            allocation_final[3][4]=allocation1[i][3][j];
                                            allocation_final22[3][4]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        else if(allocation_final[3][5]==null)
                                        {
                                            allocation_final[3][5]=allocation1[i][3][j];
                                            allocation_final22[3][5]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][7][a].charAt(0)=='4')
                                    {
                                        if(allocation_final[3][6]==null)
                                        {
                                            allocation_final[3][6]=allocation1[i][3][j];
                                            allocation_final22[3][6]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        else if(allocation_final[3][7]==null)
                                        {
                                            allocation_final[3][7]=allocation1[i][3][j];
                                            allocation_final22[3][7]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                }
                                if(k>=3)
                                    break;
                                for(int a=0;a<countfriday1[i];a++)
                                {
                                    if(allocation1[i][8][a].charAt(0)=='9')
                                    {
                                        if(allocation_final[4][0]==null)
                                        {
                                            allocation_final[4][0]=allocation1[i][3][j];
                                            allocation_final22[4][0]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        else if(allocation_final[4][1]==null)
                                        {
                                            allocation_final[4][1]=allocation1[i][3][j];
                                            allocation_final22[4][1]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][8][a].charAt(0)=='1' && allocation1[i][8][a].charAt(1)=='1')
                                    {
                                        if(allocation_final[4][2]==null)
                                        {
                                            allocation_final[4][2]=allocation1[i][3][j];
                                            allocation_final22[4][2]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        else if(allocation_final[4][3]==null)
                                        {
                                            allocation_final[4][3]=allocation1[i][3][j];
                                            allocation_final22[4][3]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][8][a].charAt(0)=='2')
                                    {
                                        if(allocation_final[4][4]==null)
                                        {
                                            allocation_final[4][4]=allocation1[i][3][j];
                                            allocation_final22[4][4]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        else if(allocation_final[4][5]==null)
                                        {
                                            allocation_final[4][5]=allocation1[i][3][j];
                                            allocation_final22[4][5]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                    if(allocation1[i][8][a].charAt(0)=='4')
                                    {
                                        if(allocation_final[4][6]==null)
                                        {
                                            allocation_final[4][6]=allocation1[i][3][j];
                                            allocation_final22[4][6]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                        else if(allocation_final[4][7]==null)
                                        {
                                            allocation_final[4][7]=allocation1[i][3][j];
                                            allocation_final22[4][7]=allocation[i][1][0];
                                            k++;
                                            break;
                                        }
                                    }
                                }
                                    break;
                            }
                        }
                
                    
                //CE
                    if(allocation1[i][0][0].charAt(0)=='C' && allocation1[i][0][0].charAt(1)=='E')         
                          if(allocation1[i][3][j].charAt(allocation1[i][3][j].length()-1)=='b' && allocation1[i][3][j].charAt(allocation1[i][3][j].length()-2)=='a' && allocation1[i][3][j].charAt(allocation1[i][3][j].length()-3)=='L')
                                {
                                    int k=0;
                                    while(k<1)
                                    {
                                        for(int a=0;a<countmonday1[i];a++)
                                        {
                                            System.out.println(allocation1[i][4][a]);
                                            if(allocation1[i][4][a].charAt(0)=='9')
                                            {
                                                if(allocation_final1[0][0]==null)
                                                {
                                                    allocation_final1[0][0]=allocation1[i][3][j];
                                                    allocation_final1[0][1]=allocation1[i][3][j];
                                                    allocation_final11[0][0]=allocation[i][1][0];
                                                    allocation_final11[0][1]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                
                                            }
                                            if(allocation1[i][4][a].charAt(0)=='1' && allocation1[i][4][a].charAt(1)=='1')
                                            {
                                                if(allocation_final1[0][2]==null)
                                                {
                                                    allocation_final1[0][2]=allocation1[i][3][j];
                                                    allocation_final1[0][3]=allocation1[i][3][j];
                                                    allocation_final11[0][2]=allocation[i][1][0];
                                                    allocation_final11[0][3]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                
                                            }
                                            if(allocation1[i][4][a].charAt(0)=='2')
                                            {
                                                if(allocation_final1[0][4]==null)
                                                {
                                                    allocation_final1[0][4]=allocation1[i][3][j];
                                                    allocation_final1[0][5]=allocation1[i][3][j];
                                                    allocation_final11[0][4]=allocation[i][1][0];
                                                    allocation_final11[0][5]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                
                                            }
                                            if(allocation1[i][4][a].charAt(0)=='4')
                                            {
                                                if(allocation_final1[0][6]==null)
                                                {
                                                    allocation_final1[0][6]=allocation1[i][3][j];
                                                    allocation_final1[0][7]=allocation1[i][3][j];
                                                    allocation_final11[0][6]=allocation[i][1][0];
                                                    allocation_final11[0][7]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                        }
                                        if(k>=1)
                                            break;
                                        
                                        for(int a=0;a<counttuesday1[i];a++)
                                        {
                                            if(allocation1[i][5][a].charAt(0)=='9')
                                            {
                                                if(allocation_final1[1][0]==null)
                                                {
                                                    allocation_final1[1][0]=allocation1[i][3][j];
                                                    allocation_final1[1][1]=allocation1[i][3][j];
                                                    allocation_final11[1][0]=allocation[i][1][0];
                                                    allocation_final11[1][1]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                
                                            }
                                            if(allocation1[i][5][a].charAt(0)=='1' && allocation1[i][5][a].charAt(1)=='1')
                                            {
                                                if(allocation_final1[1][2]==null)
                                                {
                                                    allocation_final1[1][2]=allocation1[i][3][j];
                                                    allocation_final1[1][3]=allocation1[i][3][j];
                                                    allocation_final11[1][2]=allocation[i][1][0];
                                                    allocation_final11[1][3]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][5][a].charAt(0)=='2')
                                            {
                                                if(allocation_final1[1][4]==null)
                                                {
                                                    allocation_final1[1][4]=allocation1[i][3][j];
                                                    allocation_final1[1][5]=allocation1[i][3][j];
                                                    allocation_final11[1][4]=allocation[i][1][0];
                                                    allocation_final11[1][5]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                
                                            }
                                            if(allocation1[i][5][a].charAt(0)=='4')
                                            {
                                                if(allocation_final1[1][6]==null)
                                                {
                                                    allocation_final1[1][6]=allocation1[i][3][j];
                                                    allocation_final1[1][7]=allocation1[i][3][j];
                                                    allocation_final11[1][6]=allocation[i][1][0];
                                                    allocation_final11[1][7]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                        }
                                        if(k>=1)
                                            break;
                                        for(int a=0;a<countwednesday1[i];a++)
                                        {
                                            if(allocation1[i][6][a].charAt(0)=='9')
                                            {
                                                if(allocation_final1[2][0]==null)
                                                {
                                                    allocation_final1[2][0]=allocation1[i][3][j];
                                                    allocation_final1[2][1]=allocation1[i][3][j];
                                                    allocation_final11[2][0]=allocation[i][1][0];
                                                    allocation_final11[2][1]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][6][a].charAt(0)=='1' && allocation1[i][6][a].charAt(1)=='1')
                                            {
                                                if(allocation_final1[2][2]==null)
                                                {
                                                    allocation_final1[2][2]=allocation1[i][3][j];
                                                    allocation_final1[2][3]=allocation1[i][3][j];
                                                    allocation_final11[2][2]=allocation[i][1][0];
                                                    allocation_final11[2][3]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][6][a].charAt(0)=='2')
                                            {
                                                if(allocation_final1[2][4]==null)
                                                {
                                                    allocation_final1[2][4]=allocation1[i][3][j];
                                                    allocation_final1[2][5]=allocation1[i][3][j];
                                                    allocation_final11[2][4]=allocation[i][1][0];
                                                    allocation_final11[2][5]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][6][a].charAt(0)=='4')
                                            {
                                                if(allocation_final1[2][6]==null)
                                                {
                                                    allocation_final1[2][6]=allocation1[i][3][j];
                                                    allocation_final1[2][7]=allocation1[i][3][j];
                                                    allocation_final11[2][6]=allocation[i][1][0];
                                                    allocation_final11[2][7]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                        }
                                        if(k>=1)
                                            break;
                                        for(int a=0;a<countthursday1[i];a++)
                                        {
                                            if(allocation1[i][7][a].charAt(0)=='9')
                                            {
                                                if(allocation_final1[3][0]==null)
                                                {
                                                    allocation_final1[3][0]=allocation1[i][3][j];
                                                    allocation_final1[3][1]=allocation1[i][3][j];
                                                    allocation_final11[3][0]=allocation[i][1][0];
                                                    allocation_final11[3][1]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][7][a].charAt(0)=='1' && allocation1[i][7][a].charAt(1)=='1')
                                            {
                                                if(allocation_final1[3][2]==null)
                                                {
                                                    allocation_final1[3][2]=allocation1[i][3][j];
                                                    allocation_final1[3][3]=allocation1[i][3][j];
                                                    allocation_final11[3][2]=allocation[i][1][0];
                                                    allocation_final11[3][3]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][7][a].charAt(0)=='2')
                                            {
                                                if(allocation_final1[3][4]==null)
                                                {
                                                    allocation_final1[3][4]=allocation1[i][3][j];
                                                    allocation_final1[3][5]=allocation1[i][3][j];
                                                    allocation_final11[3][4]=allocation[i][1][0];
                                                    allocation_final11[3][5]=allocation[i][1][0];
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][7][a].charAt(0)=='4')
                                            {
                                                if(allocation_final1[3][6]==null)
                                                {
                                                    allocation_final1[3][6]=allocation1[i][3][j];
                                                    allocation_final1[3][7]=allocation1[i][3][j];
                                                    allocation_final11[3][6]=allocation[i][1][0];
                                                    allocation_final11[3][7]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                        }
                                        if(k>=1)
                                            break;
                                        for(int a=0;a<countfriday1[i];a++)
                                        {
                                            if(allocation1[i][8][a].charAt(0)=='9')
                                            {
                                                if(allocation_final1[4][0]==null)
                                                {
                                                    allocation_final1[4][0]=allocation1[i][3][j];
                                                    allocation_final1[4][1]=allocation1[i][3][j];
                                                    allocation_final11[4][0]=allocation[i][1][0];
                                                    allocation_final11[4][1]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][8][a].charAt(0)=='1' && allocation1[i][8][a].charAt(1)=='1')
                                            {
                                                if(allocation_final1[4][2]==null)
                                                {
                                                    allocation_final1[4][2]=allocation1[i][3][j];
                                                    allocation_final1[4][3]=allocation1[i][3][j];
                                                    allocation_final11[4][2]=allocation[i][1][0];
                                                    allocation_final11[4][3]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][8][a].charAt(0)=='2')
                                            {
                                                if(allocation_final1[4][4]==null)
                                                {
                                                    allocation_final1[4][4]=allocation1[i][3][j];
                                                    allocation_final1[4][5]=allocation1[i][3][j];
                                                    allocation_final11[4][4]=allocation[i][1][0];
                                                    allocation_final11[4][5]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][8][a].charAt(0)=='4')
                                            {
                                                if(allocation_final1[4][6]==null)
                                                {
                                                    allocation_final1[4][6]=allocation1[i][3][j];
                                                    allocation_final1[4][7]=allocation1[i][3][j];
                                                    allocation_final11[4][6]=allocation[i][1][0];
                                                    allocation_final11[4][7]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                        }
                                        
                                            break;
                                    }
                                    
                                }
                                else
                                {
                                    int k=0;
                                    while(k<3)
                                    {
                                        for(int a=0;a<countmonday1[i];a++)
                                        {
                                            if(allocation1[i][4][a].charAt(0)=='9')
                                            {
                                                if(allocation_final1[0][0]==null)
                                                {
                                                    allocation_final1[0][0]=allocation1[i][3][j];
                                                    allocation_final11[0][0]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final1[0][1]==null)
                                                {
                                                    allocation_final1[0][1]=allocation1[i][3][j];
                                                    allocation_final11[0][1]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][4][a].charAt(0)=='1' && allocation1[i][4][a].charAt(1)=='1')
                                            {
                                                if(allocation_final1[0][2]==null)
                                                {
                                                    allocation_final1[0][2]=allocation1[i][3][j];
                                                    allocation_final11[0][2]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final1[0][3]==null)
                                                {
                                                    allocation_final1[0][3]=allocation1[i][3][j];
                                                    allocation_final11[0][3]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][4][a].charAt(0)=='2')
                                            {
                                                if(allocation_final1[0][4]==null)
                                                {
                                                    allocation_final1[0][4]=allocation1[i][3][j];
                                                    allocation_final11[0][4]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final1[0][5]==null)
                                                {
                                                    allocation_final1[0][5]=allocation1[i][3][j];
                                                    allocation_final11[0][5]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][4][a].charAt(0)=='4')
                                            {
                                                if(allocation_final1[0][6]==null)
                                                {
                                                    allocation_final1[0][6]=allocation1[i][3][j];
                                                    allocation_final11[0][6]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final1[0][7]==null)
                                                {
                                                    allocation_final1[0][7]=allocation1[i][3][j];
                                                    allocation_final11[0][7]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                        }
                                        if(k>=3)
                                            break;
                                        
                                        for(int a=0;a<counttuesday1[i];a++)
                                        {
                                            if(allocation1[i][5][a].charAt(0)=='9')
                                            {
                                                if(allocation_final1[1][0]==null)
                                                {
                                                    allocation_final1[1][0]=allocation1[i][3][j];
                                                    allocation_final11[1][0]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final1[1][1]==null)
                                                {
                                                    allocation_final1[1][1]=allocation1[i][3][j];
                                                    allocation_final11[1][1]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][5][a].charAt(0)=='1' && allocation1[i][5][a].charAt(1)=='1')
                                            {
                                                if(allocation_final1[1][2]==null)
                                                {
                                                    allocation_final1[1][2]=allocation1[i][3][j];
                                                    allocation_final11[1][2]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final1[1][3]==null)
                                                {
                                                    allocation_final1[1][3]=allocation1[i][3][j];
                                                    allocation_final11[1][3]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][5][a].charAt(0)=='2')
                                            {
                                                if(allocation_final1[1][4]==null)
                                                {
                                                    allocation_final1[1][4]=allocation1[i][3][j];
                                                    allocation_final11[1][4]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final1[1][5]==null)
                                                {
                                                    allocation_final1[1][5]=allocation1[i][3][j];
                                                    allocation_final11[1][5]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][5][a].charAt(0)=='4')
                                            {
                                                if(allocation_final1[1][6]==null)
                                                {
                                                    allocation_final1[1][6]=allocation1[i][3][j];
                                                    allocation_final11[1][6]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final1[1][7]==null)
                                                {
                                                    allocation_final1[1][7]=allocation1[i][3][j];
                                                    allocation_final11[1][7]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                        }
                                        if(k>=3)
                                            break;
                                        for(int a=0;a<countwednesday1[i];a++)
                                        {
                                            if(allocation1[i][6][a].charAt(0)=='9')
                                            {
                                                if(allocation_final1[2][0]==null)
                                                {
                                                    allocation_final1[2][0]=allocation1[i][3][j];
                                                    allocation_final11[2][0]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final1[2][1]==null)
                                                {
                                                    allocation_final1[2][1]=allocation1[i][3][j];
                                                    allocation_final11[2][1]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][6][a].charAt(0)=='1' && allocation1[i][6][a].charAt(1)=='1')
                                            {
                                                if(allocation_final1[2][2]==null)
                                                {
                                                    allocation_final1[2][2]=allocation1[i][3][j];
                                                    allocation_final11[2][2]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final1[2][3]==null)
                                                {
                                                    allocation_final1[2][3]=allocation1[i][3][j];
                                                    allocation_final11[2][3]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][6][a].charAt(0)=='2')
                                            {
                                                if(allocation_final1[2][4]==null)
                                                {
                                                    allocation_final1[2][4]=allocation1[i][3][j];
                                                    allocation_final11[2][4]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final1[2][5]==null)
                                                {
                                                    allocation_final1[2][5]=allocation1[i][3][j];
                                                    allocation_final11[2][5]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][6][a].charAt(0)=='4')
                                            {
                                                if(allocation_final1[2][6]==null)
                                                {
                                                    allocation_final1[2][6]=allocation1[i][3][j];
                                                    allocation_final11[2][6]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final1[2][7]==null)
                                                {
                                                    allocation_final1[2][7]=allocation1[i][3][j];
                                                    allocation_final11[2][7]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                        }
                                        if(k>=3)
                                            break;
                                        for(int a=0;a<countthursday1[i];a++)
                                        {
                                            if(allocation1[i][7][a].charAt(0)=='9')
                                            {
                                                if(allocation_final1[3][0]==null)
                                                {
                                                    allocation_final1[3][0]=allocation1[i][3][j];
                                                    allocation_final11[3][0]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final1[3][1]==null)
                                                {
                                                    allocation_final1[3][1]=allocation1[i][3][j];
                                                    allocation_final11[3][1]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][7][a].charAt(0)=='1' && allocation1[i][7][a].charAt(1)=='1')
                                            {
                                                if(allocation_final1[3][2]==null)
                                                {
                                                    allocation_final1[3][2]=allocation1[i][3][j];
                                                    allocation_final11[3][2]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final1[3][3]==null)
                                                {
                                                    allocation_final1[3][3]=allocation1[i][3][j];
                                                    allocation_final11[3][3]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][7][a].charAt(0)=='2')
                                            {
                                                if(allocation_final1[3][4]==null)
                                                {
                                                    allocation_final1[3][4]=allocation1[i][3][j];
                                                    allocation_final11[3][4]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final1[3][5]==null)
                                                {
                                                    allocation_final1[3][5]=allocation1[i][3][j];
                                                    allocation_final11[3][5]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][7][a].charAt(0)=='4')
                                            {
                                                if(allocation_final1[3][6]==null)
                                                {
                                                    allocation_final1[3][6]=allocation1[i][3][j];
                                                    allocation_final11[3][6]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final1[3][7]==null)
                                                {
                                                    allocation_final1[3][7]=allocation1[i][3][j];
                                                    allocation_final11[3][7]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                        }
                                        if(k>=3)
                                            break;
                                        for(int a=0;a<countfriday1[i];a++)
                                        {
                                            if(allocation1[i][8][a].charAt(0)=='9')
                                            {
                                                if(allocation_final1[4][0]==null)
                                                {
                                                    allocation_final1[4][0]=allocation1[i][3][j];
                                                    allocation_final11[4][0]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final1[4][1]==null)
                                                {
                                                    allocation_final1[4][1]=allocation1[i][3][j];
                                                    allocation_final11[4][1]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][8][a].charAt(0)=='1' && allocation1[i][8][a].charAt(1)=='1')
                                            {
                                                if(allocation_final1[4][2]==null)
                                                {
                                                    allocation_final1[4][2]=allocation1[i][3][j];
                                                    allocation_final11[4][2]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final1[4][3]==null)
                                                {
                                                    allocation_final1[4][3]=allocation1[i][3][j];
                                                    allocation_final11[4][3]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][8][a].charAt(0)=='2')
                                            {
                                                if(allocation_final1[4][4]==null)
                                                {
                                                    allocation_final1[4][4]=allocation1[i][3][j];
                                                    allocation_final11[4][4]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final1[4][5]==null)
                                                {
                                                    allocation_final1[4][5]=allocation1[i][3][j];
                                                    allocation_final11[4][5]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][8][a].charAt(0)=='4')
                                            {
                                                if(allocation_final1[4][6]==null)
                                                {
                                                    allocation_final1[4][6]=allocation1[i][3][j];
                                                    allocation_final11[4][6]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final1[4][7]==null)
                                                {
                                                    allocation_final1[4][7]=allocation1[i][3][j];
                                                    allocation_final11[4][7]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                        }
                                            break;
                                    }
                                }
             
                    //EC
                    if(allocation1[i][0][0].charAt(0)=='E' && allocation1[i][0][0].charAt(1)=='C')         
                      if(allocation1[i][3][j].charAt(allocation1[i][3][j].length()-1)=='b' && allocation1[i][3][j].charAt(allocation1[i][3][j].length()-2)=='a' && allocation1[i][3][j].charAt(allocation1[i][3][j].length()-3)=='L')
                            {
                                int k=0;
                                while(k<1)
                                {
                                    for(int a=0;a<countmonday1[i];a++)
                                    {
                                        System.out.println(allocation1[i][4][a]);
                                        if(allocation1[i][4][a].charAt(0)=='9')
                                        {
                                            if(allocation_final3[0][0]==null)
                                            {
                                                allocation_final3[0][0]=allocation1[i][3][j];
                                                allocation_final3[0][1]=allocation1[i][3][j];
                                                allocation_final33[0][0]=allocation[i][1][0];
                                                allocation_final33[0][1]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            
                                        }
                                        if(allocation1[i][4][a].charAt(0)=='1' && allocation1[i][4][a].charAt(1)=='1')
                                        {
                                            if(allocation_final3[0][2]==null)
                                            {
                                                allocation_final3[0][2]=allocation1[i][3][j];
                                                allocation_final3[0][3]=allocation1[i][3][j];
                                                allocation_final33[0][2]=allocation[i][1][0];
                                                allocation_final33[0][3]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            
                                        }
                                        if(allocation1[i][4][a].charAt(0)=='2')
                                        {
                                            if(allocation_final3[0][4]==null)
                                            {
                                                allocation_final3[0][4]=allocation1[i][3][j];
                                                allocation_final3[0][5]=allocation1[i][3][j];
                                                allocation_final33[0][4]=allocation[i][1][0];
                                                allocation_final33[0][5]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            
                                        }
                                        if(allocation1[i][4][a].charAt(0)=='4')
                                        {
                                            if(allocation_final3[0][6]==null)
                                            {
                                                allocation_final3[0][6]=allocation1[i][3][j];
                                                allocation_final3[0][7]=allocation1[i][3][j];
                                                allocation_final33[0][6]=allocation[i][1][0];
                                                allocation_final33[0][7]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                    }
                                    if(k>=1)
                                        break;
                                    
                                    for(int a=0;a<counttuesday1[i];a++)
                                    {
                                        if(allocation1[i][5][a].charAt(0)=='9')
                                        {
                                            if(allocation_final3[1][0]==null)
                                            {
                                                allocation_final3[1][0]=allocation1[i][3][j];
                                                allocation_final3[1][1]=allocation1[i][3][j];
                                                allocation_final33[1][0]=allocation[i][1][0];
                                                allocation_final33[1][1]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            
                                        }
                                        if(allocation1[i][5][a].charAt(0)=='1' && allocation1[i][5][a].charAt(1)=='1')
                                        {
                                            if(allocation_final3[1][2]==null)
                                            {
                                                allocation_final3[1][2]=allocation1[i][3][j];
                                                allocation_final3[1][3]=allocation1[i][3][j];
                                                allocation_final33[1][2]=allocation[i][1][0];
                                                allocation_final33[1][3]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][5][a].charAt(0)=='2')
                                        {
                                            if(allocation_final3[1][4]==null)
                                            {
                                                allocation_final3[1][4]=allocation1[i][3][j];
                                                allocation_final3[1][5]=allocation1[i][3][j];
                                                allocation_final33[1][4]=allocation[i][1][0];
                                                allocation_final33[1][5]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            
                                        }
                                        if(allocation1[i][5][a].charAt(0)=='4')
                                        {
                                            if(allocation_final3[1][6]==null)
                                            {
                                                allocation_final3[1][6]=allocation1[i][3][j];
                                                allocation_final3[1][7]=allocation1[i][3][j];
                                                allocation_final33[1][6]=allocation[i][1][0];
                                                allocation_final33[1][7]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                    }
                                    if(k>=1)
                                        break;
                                    for(int a=0;a<countwednesday1[i];a++)
                                    {
                                        if(allocation1[i][6][a].charAt(0)=='9')
                                        {
                                            if(allocation_final3[2][0]==null)
                                            {
                                                allocation_final3[2][0]=allocation1[i][3][j];
                                                allocation_final3[2][1]=allocation1[i][3][j];
                                                allocation_final33[2][0]=allocation[i][1][0];
                                                allocation_final33[2][1]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][6][a].charAt(0)=='1' && allocation1[i][6][a].charAt(1)=='1')
                                        {
                                            if(allocation_final3[2][2]==null)
                                            {
                                                allocation_final3[2][2]=allocation1[i][3][j];
                                                allocation_final3[2][3]=allocation1[i][3][j];
                                                allocation_final33[2][2]=allocation[i][1][0];
                                                allocation_final33[2][3]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][6][a].charAt(0)=='2')
                                        {
                                            if(allocation_final3[2][4]==null)
                                            {
                                                allocation_final3[2][4]=allocation1[i][3][j];
                                                allocation_final3[2][5]=allocation1[i][3][j];
                                                allocation_final33[2][4]=allocation[i][1][0];
                                                allocation_final33[2][5]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][6][a].charAt(0)=='4')
                                        {
                                            if(allocation_final3[2][6]==null)
                                            {
                                                allocation_final3[2][6]=allocation1[i][3][j];
                                                allocation_final3[2][7]=allocation1[i][3][j];
                                                allocation_final33[2][6]=allocation[i][1][0];
                                                allocation_final33[2][7]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                    }
                                    if(k>=1)
                                        break;
                                    for(int a=0;a<countthursday1[i];a++)
                                    {
                                        if(allocation1[i][7][a].charAt(0)=='9')
                                        {
                                            if(allocation_final3[3][0]==null)
                                            {
                                                allocation_final3[3][0]=allocation1[i][3][j];
                                                allocation_final3[3][1]=allocation1[i][3][j];
                                                allocation_final33[3][0]=allocation[i][1][0];
                                                allocation_final33[3][1]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][7][a].charAt(0)=='1' && allocation1[i][7][a].charAt(1)=='1')
                                        {
                                            if(allocation_final3[3][2]==null)
                                            {
                                                allocation_final3[3][2]=allocation1[i][3][j];
                                                allocation_final3[3][3]=allocation1[i][3][j];
                                                allocation_final33[3][2]=allocation[i][1][0];
                                                allocation_final33[3][3]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][7][a].charAt(0)=='2')
                                        {
                                            if(allocation_final3[3][4]==null)
                                            {
                                                allocation_final3[3][4]=allocation1[i][3][j];
                                                allocation_final3[3][5]=allocation1[i][3][j];
                                                allocation_final33[3][4]=allocation[i][1][0];
                                                allocation_final33[3][5]=allocation[i][1][0];
                                                break;
                                            }
                                        }
                                        if(allocation1[i][7][a].charAt(0)=='4')
                                        {
                                            if(allocation_final3[3][6]==null)
                                            {
                                                allocation_final3[3][6]=allocation1[i][3][j];
                                                allocation_final3[3][7]=allocation1[i][3][j];
                                                allocation_final33[3][6]=allocation[i][1][0];
                                                allocation_final33[3][7]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                    }
                                    if(k>=1)
                                        break;
                                    for(int a=0;a<countfriday1[i];a++)
                                    {
                                        if(allocation1[i][8][a].charAt(0)=='9')
                                        {
                                            if(allocation_final3[4][0]==null)
                                            {
                                                allocation_final3[4][0]=allocation1[i][3][j];
                                                allocation_final3[4][1]=allocation1[i][3][j];
                                                allocation_final33[4][0]=allocation[i][1][0];
                                                allocation_final33[4][1]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][8][a].charAt(0)=='1' && allocation1[i][8][a].charAt(1)=='1')
                                        {
                                            if(allocation_final3[4][2]==null)
                                            {
                                                allocation_final3[4][2]=allocation1[i][3][j];
                                                allocation_final3[4][3]=allocation1[i][3][j];
                                                allocation_final33[4][2]=allocation[i][1][0];
                                                allocation_final33[4][3]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][8][a].charAt(0)=='2')
                                        {
                                            if(allocation_final3[4][4]==null)
                                            {
                                                allocation_final3[4][4]=allocation1[i][3][j];
                                                allocation_final3[4][5]=allocation1[i][3][j];
                                                allocation_final33[4][4]=allocation[i][1][0];
                                                allocation_final33[4][5]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][8][a].charAt(0)=='4')
                                        {
                                            if(allocation_final3[4][6]==null)
                                            {
                                                allocation_final3[4][6]=allocation1[i][3][j];
                                                allocation_final3[4][7]=allocation1[i][3][j];
                                                allocation_final33[4][6]=allocation[i][1][0];
                                                allocation_final33[4][7]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                    }
                                    
                                        break;
                                }
                                
                            }
                            else
                            {
                                int k=0;
                                while(k<3)
                                {
                                    for(int a=0;a<countmonday1[i];a++)
                                    {
                                        if(allocation1[i][4][a].charAt(0)=='9')
                                        {
                                            if(allocation_final3[0][0]==null)
                                            {
                                                allocation_final3[0][0]=allocation1[i][3][j];
                                                allocation_final33[0][0]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            else if(allocation_final3[0][1]==null)
                                            {
                                                allocation_final3[0][1]=allocation1[i][3][j];
                                                allocation_final33[0][1]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][4][a].charAt(0)=='1' && allocation1[i][4][a].charAt(1)=='1')
                                        {
                                            if(allocation_final3[0][2]==null)
                                            {
                                                allocation_final3[0][2]=allocation1[i][3][j];
                                                allocation_final33[0][2]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            else if(allocation_final3[0][3]==null)
                                            {
                                                allocation_final3[0][3]=allocation1[i][3][j];
                                                allocation_final33[0][3]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][4][a].charAt(0)=='2')
                                        {
                                            if(allocation_final3[0][4]==null)
                                            {
                                                allocation_final3[0][4]=allocation1[i][3][j];
                                                allocation_final33[0][4]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            else if(allocation_final3[0][5]==null)
                                            {
                                                allocation_final3[0][5]=allocation1[i][3][j];
                                                allocation_final33[0][5]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][4][a].charAt(0)=='4')
                                        {
                                            if(allocation_final3[0][6]==null)
                                            {
                                                allocation_final3[0][6]=allocation1[i][3][j];
                                                allocation_final33[0][6]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            else if(allocation_final3[0][7]==null)
                                            {
                                                allocation_final3[0][7]=allocation1[i][3][j];
                                                allocation_final33[0][7]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                    }
                                    if(k>=3)
                                        break;
                                    
                                    for(int a=0;a<counttuesday1[i];a++)
                                    {
                                        if(allocation1[i][5][a].charAt(0)=='9')
                                        {
                                            if(allocation_final3[1][0]==null)
                                            {
                                                allocation_final3[1][0]=allocation1[i][3][j];
                                                allocation_final33[1][0]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            else if(allocation_final3[1][1]==null)
                                            {
                                                allocation_final3[1][1]=allocation1[i][3][j];
                                                allocation_final33[1][1]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][5][a].charAt(0)=='1' && allocation1[i][5][a].charAt(1)=='1')
                                        {
                                            if(allocation_final3[1][2]==null)
                                            {
                                                allocation_final3[1][2]=allocation1[i][3][j];
                                                allocation_final33[1][2]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            else if(allocation_final3[1][3]==null)
                                            {
                                                allocation_final3[1][3]=allocation1[i][3][j];
                                                allocation_final33[1][3]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][5][a].charAt(0)=='2')
                                        {
                                            if(allocation_final3[1][4]==null)
                                            {
                                                allocation_final3[1][4]=allocation1[i][3][j];
                                                allocation_final33[1][4]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            else if(allocation_final3[1][5]==null)
                                            {
                                                allocation_final3[1][5]=allocation1[i][3][j];
                                                allocation_final33[1][5]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][5][a].charAt(0)=='4')
                                        {
                                            if(allocation_final3[1][6]==null)
                                            {
                                                allocation_final3[1][6]=allocation1[i][3][j];
                                                allocation_final33[1][6]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            else if(allocation_final3[1][7]==null)
                                            {
                                                allocation_final3[1][7]=allocation1[i][3][j];
                                                allocation_final33[1][7]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                    }
                                    if(k>=3)
                                        break;
                                    for(int a=0;a<countwednesday1[i];a++)
                                    {
                                        if(allocation1[i][6][a].charAt(0)=='9')
                                        {
                                            if(allocation_final3[2][0]==null)
                                            {
                                                allocation_final3[2][0]=allocation1[i][3][j];
                                                allocation_final33[2][0]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            else if(allocation_final3[2][1]==null)
                                            {
                                                allocation_final3[2][1]=allocation1[i][3][j];
                                                allocation_final33[2][1]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][6][a].charAt(0)=='1' && allocation1[i][6][a].charAt(1)=='1')
                                        {
                                            if(allocation_final3[2][2]==null)
                                            {
                                                allocation_final3[2][2]=allocation1[i][3][j];
                                                allocation_final33[2][2]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            else if(allocation_final3[2][3]==null)
                                            {
                                                allocation_final3[2][3]=allocation1[i][3][j];
                                                allocation_final33[2][3]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][6][a].charAt(0)=='2')
                                        {
                                            if(allocation_final3[2][4]==null)
                                            {
                                                allocation_final3[2][4]=allocation1[i][3][j];
                                                allocation_final33[2][4]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            else if(allocation_final3[2][5]==null)
                                            {
                                                allocation_final3[2][5]=allocation1[i][3][j];
                                                allocation_final33[2][5]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][6][a].charAt(0)=='4')
                                        {
                                            if(allocation_final3[2][6]==null)
                                            {
                                                allocation_final3[2][6]=allocation1[i][3][j];
                                                allocation_final33[2][6]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            else if(allocation_final3[2][7]==null)
                                            {
                                                allocation_final3[2][7]=allocation1[i][3][j];
                                                allocation_final33[2][7]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                    }
                                    if(k>=3)
                                        break;
                                    for(int a=0;a<countthursday1[i];a++)
                                    {
                                        if(allocation1[i][7][a].charAt(0)=='9')
                                        {
                                            if(allocation_final3[3][0]==null)
                                            {
                                                allocation_final3[3][0]=allocation1[i][3][j];
                                                allocation_final33[3][0]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            else if(allocation_final3[3][1]==null)
                                            {
                                                allocation_final3[3][1]=allocation1[i][3][j];
                                                allocation_final33[3][1]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][7][a].charAt(0)=='1' && allocation1[i][7][a].charAt(1)=='1')
                                        {
                                            if(allocation_final3[3][2]==null)
                                            {
                                                allocation_final3[3][2]=allocation1[i][3][j];
                                                allocation_final33[3][2]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            else if(allocation_final3[3][3]==null)
                                            {
                                                allocation_final3[3][3]=allocation1[i][3][j];
                                                allocation_final33[3][3]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][7][a].charAt(0)=='2')
                                        {
                                            if(allocation_final3[3][4]==null)
                                            {
                                                allocation_final3[3][4]=allocation1[i][3][j];
                                                allocation_final33[3][4]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            else if(allocation_final3[3][5]==null)
                                            {
                                                allocation_final3[3][5]=allocation1[i][3][j];
                                                allocation_final33[3][5]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][7][a].charAt(0)=='4')
                                        {
                                            if(allocation_final3[3][6]==null)
                                            {
                                                allocation_final3[3][6]=allocation1[i][3][j];
                                                allocation_final33[3][6]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            else if(allocation_final3[3][7]==null)
                                            {
                                                allocation_final3[3][7]=allocation1[i][3][j];
                                                allocation_final33[3][7]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                    }
                                    if(k>=3)
                                        break;
                                    for(int a=0;a<countfriday1[i];a++)
                                    {
                                        if(allocation1[i][8][a].charAt(0)=='9')
                                        {
                                            if(allocation_final3[4][0]==null)
                                            {
                                                allocation_final3[4][0]=allocation1[i][3][j];
                                                allocation_final33[4][0]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            else if(allocation_final3[4][1]==null)
                                            {
                                                allocation_final3[4][1]=allocation1[i][3][j];
                                                allocation_final33[4][1]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][8][a].charAt(0)=='1' && allocation1[i][8][a].charAt(1)=='1')
                                        {
                                            if(allocation_final3[4][2]==null)
                                            {
                                                allocation_final3[4][2]=allocation1[i][3][j];
                                                allocation_final33[4][2]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            else if(allocation_final3[4][3]==null)
                                            {
                                                allocation_final3[4][3]=allocation1[i][3][j];
                                                allocation_final33[4][3]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][8][a].charAt(0)=='2')
                                        {
                                            if(allocation_final3[4][4]==null)
                                            {
                                                allocation_final3[4][4]=allocation1[i][3][j];
                                                allocation_final33[4][4]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            else if(allocation_final3[4][5]==null)
                                            {
                                                allocation_final3[4][5]=allocation1[i][3][j];
                                                allocation_final33[4][5]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                        if(allocation1[i][8][a].charAt(0)=='4')
                                        {
                                            if(allocation_final3[4][6]==null)
                                            {
                                                allocation_final3[4][6]=allocation1[i][3][j];
                                                allocation_final33[4][6]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                            else if(allocation_final3[4][7]==null)
                                            {
                                                allocation_final3[4][7]=allocation1[i][3][j];
                                                allocation_final33[4][7]=allocation[i][1][0];
                                                k++;
                                                break;
                                            }
                                        }
                                    }
                                        break;
                                }
                            }
                    
                    
                    //ME
                    if(allocation1[i][0][0].charAt(0)=='M' && allocation1[i][0][0].charAt(1)=='E')         
                          if(allocation1[i][3][j].charAt(allocation1[i][3][j].length()-1)=='b' && allocation1[i][3][j].charAt(allocation1[i][3][j].length()-2)=='a' && allocation1[i][3][j].charAt(allocation1[i][3][j].length()-3)=='L')
                                {
                                    int k=0;
                                    while(k<1)
                                    {
                                        for(int a=0;a<countmonday1[i];a++)
                                        {
                                            System.out.println(allocation1[i][4][a]);
                                            if(allocation1[i][4][a].charAt(0)=='9')
                                            {
                                                if(allocation_final4[0][0]==null)
                                                {
                                                    allocation_final4[0][0]=allocation1[i][3][j];
                                                    allocation_final4[0][1]=allocation1[i][3][j];
                                                    allocation_final44[0][0]=allocation[i][1][0];
                                                    allocation_final44[0][1]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                
                                            }
                                            if(allocation1[i][4][a].charAt(0)=='1' && allocation1[i][4][a].charAt(1)=='1')
                                            {
                                                if(allocation_final4[0][2]==null)
                                                {
                                                    allocation_final4[0][2]=allocation1[i][3][j];
                                                    allocation_final4[0][3]=allocation1[i][3][j];
                                                    allocation_final44[0][2]=allocation[i][1][0];
                                                    allocation_final44[0][3]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                
                                            }
                                            if(allocation1[i][4][a].charAt(0)=='2')
                                            {
                                                if(allocation_final4[0][4]==null)
                                                {
                                                    allocation_final4[0][4]=allocation1[i][3][j];
                                                    allocation_final4[0][5]=allocation1[i][3][j];
                                                    allocation_final44[0][4]=allocation[i][1][0];
                                                    allocation_final44[0][5]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                
                                            }
                                            if(allocation1[i][4][a].charAt(0)=='4')
                                            {
                                                if(allocation_final4[0][6]==null)
                                                {
                                                    allocation_final4[0][6]=allocation1[i][3][j];
                                                    allocation_final4[0][7]=allocation1[i][3][j];
                                                    allocation_final44[0][6]=allocation[i][1][0];
                                                    allocation_final44[0][7]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                        }
                                        if(k>=1)
                                            break;
                                        
                                        for(int a=0;a<counttuesday1[i];a++)
                                        {
                                            if(allocation1[i][5][a].charAt(0)=='9')
                                            {
                                                if(allocation_final4[1][0]==null)
                                                {
                                                    allocation_final4[1][0]=allocation1[i][3][j];
                                                    allocation_final4[1][1]=allocation1[i][3][j];
                                                    allocation_final44[1][0]=allocation[i][1][0];
                                                    allocation_final44[1][1]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                
                                            }
                                            if(allocation1[i][5][a].charAt(0)=='1' && allocation1[i][5][a].charAt(1)=='1')
                                            {
                                                if(allocation_final4[1][2]==null)
                                                {
                                                    allocation_final4[1][2]=allocation1[i][3][j];
                                                    allocation_final4[1][3]=allocation1[i][3][j];
                                                    allocation_final44[1][2]=allocation[i][1][0];
                                                    allocation_final44[1][3]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][5][a].charAt(0)=='2')
                                            {
                                                if(allocation_final4[1][4]==null)
                                                {
                                                    allocation_final4[1][4]=allocation1[i][3][j];
                                                    allocation_final4[1][5]=allocation1[i][3][j];
                                                    allocation_final44[1][4]=allocation[i][1][0];
                                                    allocation_final44[1][5]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                
                                            }
                                            if(allocation1[i][5][a].charAt(0)=='4')
                                            {
                                                if(allocation_final4[1][6]==null)
                                                {
                                                    allocation_final4[1][6]=allocation1[i][3][j];
                                                    allocation_final4[1][7]=allocation1[i][3][j];
                                                    allocation_final44[1][6]=allocation[i][1][0];
                                                    allocation_final44[1][7]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                        }
                                        if(k>=1)
                                            break;
                                        for(int a=0;a<countwednesday1[i];a++)
                                        {
                                            if(allocation1[i][6][a].charAt(0)=='9')
                                            {
                                                if(allocation_final4[2][0]==null)
                                                {
                                                    allocation_final4[2][0]=allocation1[i][3][j];
                                                    allocation_final4[2][1]=allocation1[i][3][j];
                                                    allocation_final44[2][0]=allocation[i][1][0];
                                                    allocation_final44[2][1]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][6][a].charAt(0)=='1' && allocation1[i][6][a].charAt(1)=='1')
                                            {
                                                if(allocation_final4[2][2]==null)
                                                {
                                                    allocation_final4[2][2]=allocation1[i][3][j];
                                                    allocation_final4[2][3]=allocation1[i][3][j];
                                                    allocation_final44[2][2]=allocation[i][1][0];
                                                    allocation_final44[2][3]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][6][a].charAt(0)=='2')
                                            {
                                                if(allocation_final4[2][4]==null)
                                                {
                                                    allocation_final4[2][4]=allocation1[i][3][j];
                                                    allocation_final4[2][5]=allocation1[i][3][j];
                                                    allocation_final44[2][4]=allocation[i][1][0];
                                                    allocation_final44[2][5]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][6][a].charAt(0)=='4')
                                            {
                                                if(allocation_final4[2][6]==null)
                                                {
                                                    allocation_final4[2][6]=allocation1[i][3][j];
                                                    allocation_final4[2][7]=allocation1[i][3][j];
                                                    allocation_final44[2][6]=allocation[i][1][0];
                                                    allocation_final44[2][7]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                        }
                                        if(k>=1)
                                            break;
                                        for(int a=0;a<countthursday1[i];a++)
                                        {
                                            if(allocation1[i][7][a].charAt(0)=='9')
                                            {
                                                if(allocation_final4[3][0]==null)
                                                {
                                                    allocation_final4[3][0]=allocation1[i][3][j];
                                                    allocation_final4[3][1]=allocation1[i][3][j];
                                                    allocation_final44[3][0]=allocation[i][1][0];
                                                    allocation_final44[3][1]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][7][a].charAt(0)=='1' && allocation1[i][7][a].charAt(1)=='1')
                                            {
                                                if(allocation_final4[3][2]==null)
                                                {
                                                    allocation_final4[3][2]=allocation1[i][3][j];
                                                    allocation_final4[3][3]=allocation1[i][3][j];
                                                    allocation_final44[3][2]=allocation[i][1][0];
                                                    allocation_final44[3][3]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][7][a].charAt(0)=='2')
                                            {
                                                if(allocation_final4[3][4]==null)
                                                {
                                                    allocation_final4[3][4]=allocation1[i][3][j];
                                                    allocation_final4[3][5]=allocation1[i][3][j];
                                                    allocation_final44[3][4]=allocation[i][1][0];
                                                    allocation_final44[3][5]=allocation[i][1][0];
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][7][a].charAt(0)=='4')
                                            {
                                                if(allocation_final4[3][6]==null)
                                                {
                                                    allocation_final4[3][6]=allocation1[i][3][j];
                                                    allocation_final4[3][7]=allocation1[i][3][j];
                                                    allocation_final44[3][6]=allocation[i][1][0];
                                                    allocation_final44[3][7]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                        }
                                        if(k>=1)
                                            break;
                                        for(int a=0;a<countfriday1[i];a++)
                                        {
                                            if(allocation1[i][8][a].charAt(0)=='9')
                                            {
                                                if(allocation_final4[4][0]==null)
                                                {
                                                    allocation_final4[4][0]=allocation1[i][3][j];
                                                    allocation_final4[4][1]=allocation1[i][3][j];
                                                    allocation_final44[4][0]=allocation[i][1][0];
                                                    allocation_final44[4][1]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][8][a].charAt(0)=='1' && allocation1[i][8][a].charAt(1)=='1')
                                            {
                                                if(allocation_final4[4][2]==null)
                                                {
                                                    allocation_final4[4][2]=allocation1[i][3][j];
                                                    allocation_final4[4][3]=allocation1[i][3][j];
                                                    allocation_final44[4][2]=allocation[i][1][0];
                                                    allocation_final44[4][3]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][8][a].charAt(0)=='2')
                                            {
                                                if(allocation_final4[4][4]==null)
                                                {
                                                    allocation_final4[4][4]=allocation1[i][3][j];
                                                    allocation_final4[4][5]=allocation1[i][3][j];
                                                    allocation_final44[4][4]=allocation[i][1][0];
                                                    allocation_final44[4][5]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][8][a].charAt(0)=='4')
                                            {
                                                if(allocation_final4[4][6]==null)
                                                {
                                                    allocation_final4[4][6]=allocation1[i][3][j];
                                                    allocation_final4[4][7]=allocation1[i][3][j];
                                                    allocation_final44[4][6]=allocation[i][1][0];
                                                    allocation_final44[4][7]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                        }
                                        
                                            break;
                                    }
                                    
                                }
                                else
                                {
                                    int k=0;
                                    while(k<3)
                                    {
                                        for(int a=0;a<countmonday1[i];a++)
                                        {
                                            if(allocation1[i][4][a].charAt(0)=='9')
                                            {
                                                if(allocation_final4[0][0]==null)
                                                {
                                                    allocation_final4[0][0]=allocation1[i][3][j];
                                                    allocation_final44[0][0]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final4[0][1]==null)
                                                {
                                                    allocation_final4[0][1]=allocation1[i][3][j];
                                                    allocation_final44[0][1]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][4][a].charAt(0)=='1' && allocation1[i][4][a].charAt(1)=='1')
                                            {
                                                if(allocation_final4[0][2]==null)
                                                {
                                                    allocation_final4[0][2]=allocation1[i][3][j];
                                                    allocation_final44[0][2]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final4[0][3]==null)
                                                {
                                                    allocation_final4[0][3]=allocation1[i][3][j];
                                                    allocation_final44[0][3]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][4][a].charAt(0)=='2')
                                            {
                                                if(allocation_final4[0][4]==null)
                                                {
                                                    allocation_final4[0][4]=allocation1[i][3][j];
                                                    allocation_final44[0][4]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final4[0][5]==null)
                                                {
                                                    allocation_final4[0][5]=allocation1[i][3][j];
                                                    allocation_final44[0][5]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][4][a].charAt(0)=='4')
                                            {
                                                if(allocation_final4[0][6]==null)
                                                {
                                                    allocation_final4[0][6]=allocation1[i][3][j];
                                                    allocation_final44[0][6]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final4[0][7]==null)
                                                {
                                                    allocation_final4[0][7]=allocation1[i][3][j];
                                                    allocation_final44[0][7]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                        }
                                        if(k>=3)
                                            break;
                                        
                                        for(int a=0;a<counttuesday1[i];a++)
                                        {
                                            if(allocation1[i][5][a].charAt(0)=='9')
                                            {
                                                if(allocation_final4[1][0]==null)
                                                {
                                                    allocation_final4[1][0]=allocation1[i][3][j];
                                                    allocation_final44[1][0]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final4[1][1]==null)
                                                {
                                                    allocation_final4[1][1]=allocation1[i][3][j];
                                                    allocation_final44[1][1]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][5][a].charAt(0)=='1' && allocation1[i][5][a].charAt(1)=='1')
                                            {
                                                if(allocation_final4[1][2]==null)
                                                {
                                                    allocation_final4[1][2]=allocation1[i][3][j];
                                                    allocation_final44[1][2]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final4[1][3]==null)
                                                {
                                                    allocation_final4[1][3]=allocation1[i][3][j];
                                                    allocation_final44[1][3]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][5][a].charAt(0)=='2')
                                            {
                                                if(allocation_final4[1][4]==null)
                                                {
                                                    allocation_final4[1][4]=allocation1[i][3][j];
                                                    allocation_final44[1][4]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final4[1][5]==null)
                                                {
                                                    allocation_final4[1][5]=allocation1[i][3][j];
                                                    allocation_final44[1][5]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][5][a].charAt(0)=='4')
                                            {
                                                if(allocation_final4[1][6]==null)
                                                {
                                                    allocation_final4[1][6]=allocation1[i][3][j];
                                                    allocation_final44[1][6]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final4[1][7]==null)
                                                {
                                                    allocation_final4[1][7]=allocation1[i][3][j];
                                                    allocation_final44[1][7]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                        }
                                        if(k>=3)
                                            break;
                                        for(int a=0;a<countwednesday1[i];a++)
                                        {
                                            if(allocation1[i][6][a].charAt(0)=='9')
                                            {
                                                if(allocation_final4[2][0]==null)
                                                {
                                                    allocation_final4[2][0]=allocation1[i][3][j];
                                                    allocation_final44[2][0]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final4[2][1]==null)
                                                {
                                                    allocation_final4[2][1]=allocation1[i][3][j];
                                                    allocation_final44[2][1]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][6][a].charAt(0)=='1' && allocation1[i][6][a].charAt(1)=='1')
                                            {
                                                if(allocation_final4[2][2]==null)
                                                {
                                                    allocation_final4[2][2]=allocation1[i][3][j];
                                                    allocation_final44[2][2]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final4[2][3]==null)
                                                {
                                                    allocation_final4[2][3]=allocation1[i][3][j];
                                                    allocation_final44[2][3]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][6][a].charAt(0)=='2')
                                            {
                                                if(allocation_final4[2][4]==null)
                                                {
                                                    allocation_final4[2][4]=allocation1[i][3][j];
                                                    allocation_final44[2][4]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final4[2][5]==null)
                                                {
                                                    allocation_final4[2][5]=allocation1[i][3][j];
                                                    allocation_final44[2][5]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][6][a].charAt(0)=='4')
                                            {
                                                if(allocation_final4[2][6]==null)
                                                {
                                                    allocation_final4[2][6]=allocation1[i][3][j];
                                                    allocation_final44[2][6]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final4[2][7]==null)
                                                {
                                                    allocation_final4[2][7]=allocation1[i][3][j];
                                                    allocation_final44[2][7]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                        }
                                        if(k>=3)
                                            break;
                                        for(int a=0;a<countthursday1[i];a++)
                                        {
                                            if(allocation1[i][7][a].charAt(0)=='9')
                                            {
                                                if(allocation_final4[3][0]==null)
                                                {
                                                    allocation_final4[3][0]=allocation1[i][3][j];
                                                    allocation_final44[3][0]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final4[3][1]==null)
                                                {
                                                    allocation_final4[3][1]=allocation1[i][3][j];
                                                    allocation_final44[3][1]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][7][a].charAt(0)=='1' && allocation1[i][7][a].charAt(1)=='1')
                                            {
                                                if(allocation_final4[3][2]==null)
                                                {
                                                    allocation_final4[3][2]=allocation1[i][3][j];
                                                    allocation_final44[3][2]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final4[3][3]==null)
                                                {
                                                    allocation_final4[3][3]=allocation1[i][3][j];
                                                    allocation_final44[3][3]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][7][a].charAt(0)=='2')
                                            {
                                                if(allocation_final4[3][4]==null)
                                                {
                                                    allocation_final4[3][4]=allocation1[i][3][j];
                                                    allocation_final44[3][4]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final4[3][5]==null)
                                                {
                                                    allocation_final4[3][5]=allocation1[i][3][j];
                                                    allocation_final44[3][5]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][7][a].charAt(0)=='4')
                                            {
                                                if(allocation_final4[3][6]==null)
                                                {
                                                    allocation_final4[3][6]=allocation1[i][3][j];
                                                    allocation_final44[3][6]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final4[3][7]==null)
                                                {
                                                    allocation_final4[3][7]=allocation1[i][3][j];
                                                    allocation_final44[3][7]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                        }
                                        if(k>=3)
                                            break;
                                        for(int a=0;a<countfriday1[i];a++)
                                        {
                                            if(allocation1[i][8][a].charAt(0)=='9')
                                            {
                                                if(allocation_final4[4][0]==null)
                                                {
                                                    allocation_final4[4][0]=allocation1[i][3][j];
                                                    allocation_final44[4][0]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final4[4][1]==null)
                                                {
                                                    allocation_final4[4][1]=allocation1[i][3][j];
                                                    allocation_final44[4][1]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][8][a].charAt(0)=='1' && allocation1[i][8][a].charAt(1)=='1')
                                            {
                                                if(allocation_final4[4][2]==null)
                                                {
                                                    allocation_final4[4][2]=allocation1[i][3][j];
                                                    allocation_final44[4][2]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final4[4][3]==null)
                                                {
                                                    allocation_final4[4][3]=allocation1[i][3][j];
                                                    allocation_final44[4][3]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][8][a].charAt(0)=='2')
                                            {
                                                if(allocation_final4[4][4]==null)
                                                {
                                                    allocation_final4[4][4]=allocation1[i][3][j];
                                                    allocation_final44[4][4]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final4[4][5]==null)
                                                {
                                                    allocation_final4[4][5]=allocation1[i][3][j];
                                                    allocation_final44[4][5]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                            if(allocation1[i][8][a].charAt(0)=='4')
                                            {
                                                if(allocation_final4[4][6]==null)
                                                {
                                                    allocation_final4[4][6]=allocation1[i][3][j];
                                                    allocation_final44[4][6]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                                else if(allocation_final4[4][7]==null)
                                                {
                                                    allocation_final4[4][7]=allocation1[i][3][j];
                                                    allocation_final44[4][7]=allocation[i][1][0];
                                                    k++;
                                                    break;
                                                }
                                            }
                                        }
                                            break;
                                    }
                                }
                }
            }
            
            hello15 = new Label("            " + "            " + "9:00 to 10:00"+  "           " + "10:00 to 10:50" + "           " + "11:15 to 12:15" + "           " + "12:15 to 1:15" + "           " + "2:00 to 3:00" + "           "  + "3:00 to 4:00" + "           " +  "4:15 to 5:15" + "           "  + "5:15 to 6:15");
            hello10 = new Label(" Monday     " + "            " + allocation_final[0][0] + "                           "  + allocation_final[0][1] + "                            "  + allocation_final[0][2] + "                         "  + allocation_final[0][3] + "                     "  + allocation_final[0][4] + "                      "  + allocation_final[0][5] + "                    "  + allocation_final[0][6] +"              " + allocation_final[0][7]);
            hello11 = new Label(" Tuesday    " + "            " + allocation_final[1][0] + "                         "  + allocation_final[1][1] + "                            "  + allocation_final[1][2] + "                            "  + allocation_final[1][3] + "                         "  + allocation_final[1][4] + "                         "  + allocation_final[1][5] + "                         "  + allocation_final[1][6] + "                       "  + allocation_final[1][7]); 
            hello12 = new Label(" Wednesday  " + "         " + allocation_final[2][0] + "                              "  + allocation_final[2][1] + "                              "  + allocation_final[2][2] + "                            "  + allocation_final[2][3] + "                         "  + allocation_final[2][4] +"                         "  + allocation_final[2][5] + "                        "  + allocation_final[2][6] + "                  " + allocation_final[2][7]);
            hello13 = new Label(" Thursday   " + "            " + allocation_final[3][0] + "                         "  + allocation_final[3][1] + "                            "  + allocation_final[3][2] + "                                "  + allocation_final[3][3] + "                       "  + allocation_final[3][4] + "                     "  + allocation_final[3][5] + "                       "  + allocation_final[3][6] + "                        "  + allocation_final[3][7]);
            hello14 = new Label(" Friday     " + "               " + allocation_final[4][0] + "                               "  + allocation_final[4][1] + "                               "  + allocation_final[4][2] + "                       "  + allocation_final[4][3] + "                     "  + allocation_final[4][4] + "                         "  + allocation_final[4][5] + "                           "  + allocation_final[4][6] + "                       "  + allocation_final[4][7]);
            
            Label hello16 = new Label("            " + "                    " + allocation_final22[0][0] + "                            "  + allocation_final22[0][1] + "                              "  + allocation_final22[0][2] + "                                  "  + allocation_final22[0][3] + "                           "  + allocation_final22[0][4] + "                          "  + allocation_final22[0][5] + "                            "  + allocation_final22[0][6] + "                         " + allocation_final22[0][7]);
            Label hello17 = new Label("            " + "                    " + allocation_final22[1][0] + "                               "  + allocation_final22[1][1] + "                              "  + allocation_final22[1][2] + "                                "  + allocation_final22[1][3] + "                           "  + allocation_final22[1][4] + "                          "  + allocation_final22[1][5] + "                          "  + allocation_final22[1][6] + "                           "  + allocation_final22[1][7]);
            Label hello18 = new Label("            " + "                    " + allocation_final22[2][0] + "                              "  + allocation_final22[2][1] + "                               "  + allocation_final22[2][2] + "                                "  + allocation_final22[2][3] + "                           "  + allocation_final22[2][4] + "                          "  + allocation_final22[2][5] + "                           "  + allocation_final22[2][6] + "                          " + allocation_final22[2][7]);
            Label hello19 = new Label("            " + "                    " + allocation_final22[3][0] + "                              "  + allocation_final22[3][1] + "                                 "  + allocation_final22[3][2] + "                                "  + allocation_final22[3][3] + "                         "  + allocation_final22[3][4] + "                           "  + allocation_final22[3][5] + "                            "  + allocation_final22[3][6] + "                        "  + allocation_final22[3][7]);
            Label hello20 = new Label("            " + "                    " + allocation_final22[4][0] + "                              "  + allocation_final22[4][1] + "                               "  + allocation_final22[4][2] + "                                "  + allocation_final22[4][3] + "                         "  + allocation_final22[4][4] + "                         "  + allocation_final22[4][5] + "                            "  + allocation_final22[4][6] + "                       "  + allocation_final22[4][7]);
            
            
            Label sub1 = new Label("PSNA - Probability Statistics and Numerical Analysis");
            Label sub2 = new Label("DS - Data Structures");
            Label sub3 = new Label("CO - Computer organisation");
            Label sub4 = new Label("CE - Communication Engineering");
            Label sub5 = new Label("ECO - Economics");
            Label sub6 = new Label("SEM - Seminar");
            Label sub7 = new Label("MP-1 - Mini Project-1");
            Label sub8 = new Label("CPW - Computer Peripherals Workshop");
            
            Label extra = new Label("");
            Label lec1 = new Label("         " + alloc_lecs[1][0] + " - " + alloc_lec[1][0]);
            Label extra1 = new Label("					");	
            Label lec2 = new Label("        " + alloc_lecs[1][1] + " - " + alloc_lec[1][1]);
            Label extra2 = new Label("					");
            Label lec3 = new Label(alloc_lecs[1][2] + " - " + alloc_lec[1][2]);
            Label extra3 = new Label("					");
            
            Label dash01 = new Label("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            Label dash02 = new Label("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            Label dash03 = new Label("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            Label dash04 = new Label("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            Label dash05 = new Label("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            Label dash06 = new Label("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            
            
            HBox sub9  = new HBox(15);
            HBox sub10 = new HBox(15);
            HBox sub11 = new HBox(15);
            sub9.getChildren().addAll(sub1,sub2);
            sub10.getChildren().addAll(sub3,sub4,sub5);
            sub11.getChildren().addAll(sub6,sub7,sub8);
        Button exit2 = new Button("Exit");
        exit2.setOnAction(e ->{
            window.setScene(scene6);
        });
        Image image6 = new Image("file:IT.jpg");
        ImageView iv6 = new ImageView();
        iv6.setImage(image6);
        iv6.setFitWidth(1360);
        iv6.setFitHeight(750);
        StackPane root6 = new StackPane();
        
        
        
        allocate.getChildren().addAll(hello15,dash01,hello10,hello16,dash02,hello11,hello17,dash03,hello12,hello18,dash04,hello13,hello19,dash05,hello14,hello20,dash06,extra,sub9,sub10,sub11,exit2);
        root6.getChildren().addAll(iv6,allocate);
        scene7=new Scene(root6,1360,750);
        scene7.getStylesheets().add("effect4.css");
        
        
        //scene 8
        
        VBox CEallocate=new VBox(15);
        hello15 = new Label("            " + "            " + "9:00 to 10:00"+  "           " + "10:00 to 10:50" + "           " + "11:15 to 12:15" + "           " + "12:15 to 1:15" + "           " + "2:00 to 3:00" + "           "  + "3:00 to 4:00" + "           " +  "4:15 to 5:15" + "           "  + "5:15 to 6:15");
        hello10 = new Label(" Monday     " + "             " + allocation_final1[0][0] + "     	                 "  + allocation_final1[0][1] + "                         "  + allocation_final1[0][2] + "                       "  + allocation_final1[0][3] + "                      "  + allocation_final1[0][4] + "                      "  + allocation_final1[0][5] + "                     "  + allocation_final1[0][6] +"              " + allocation_final1[0][7]);
        hello11 = new Label(" Tuesday    " + "            " + allocation_final1[1][0] + "            	         "  + allocation_final1[1][1] + "                              "  + allocation_final1[1][2] + "                              "  + allocation_final1[1][3] + "                          "  + allocation_final1[1][4] + "                         "  + allocation_final1[1][5] + "                        "  + allocation_final1[1][6] + "                        "  + allocation_final1[1][7]);
        hello12 = new Label(" Wednesday  " + "           " + allocation_final1[2][0] + "            	         "  + allocation_final1[2][1] + "                              "  + allocation_final1[2][2] + "                              "  + allocation_final1[2][3] + "                       "  + allocation_final1[2][4] +"                          "  + allocation_final1[2][5] + "                       "  + allocation_final1[2][6] + "                     " + allocation_final1[2][7]);
        hello13 = new Label(" Thursday   " + "              " + allocation_final1[3][0] + "              	          "  + allocation_final1[3][1] + "                              "  + allocation_final1[3][2] + "                              "  + allocation_final1[3][3] + "                       "  + allocation_final1[3][4] + "                  "  + allocation_final1[3][5] + "                    "  + allocation_final1[3][6] + "                   "  + allocation_final1[3][7]);
        hello14 = new Label(" Friday     " + "               " + allocation_final1[4][0] + "                    "  + allocation_final1[4][1] + "                          "  + allocation_final1[4][2] + "                               "  + allocation_final1[4][3] + "                          "  + allocation_final1[4][4] + "                        "  + allocation_final1[4][5] + "                         "  + allocation_final1[4][6] + "                          "  + allocation_final1[4][7]);
        
        hello16 = new Label("            " + "                     " + allocation_final11[0][0] + "                            "  + allocation_final11[0][1] + "                               "  + allocation_final11[0][2] + "                    	         "  + allocation_final11[0][3] + "   	  	          "  + allocation_final11[0][4] + "         	                 "  + allocation_final11[0][5] + "       	                 "  + allocation_final11[0][6] +"                         " + allocation_final11[0][7]);
        hello17 = new Label("            " + "                     " + allocation_final11[1][0] + "                            "  + allocation_final11[1][1] + "                                "  + allocation_final11[1][2] + "                               "  + allocation_final11[1][3] + "                           "  + allocation_final11[1][4] + "                          "  + allocation_final11[1][5] + "                           "  + allocation_final11[1][6] +"                         "  + allocation_final11[1][7]);
        hello18 = new Label("            " + "                      " + allocation_final11[2][0] + "                            "  + allocation_final11[2][1] + "                               "  + allocation_final11[2][2] + "                               "  + allocation_final11[2][3] + "                           "  + allocation_final11[2][4] +"                          "  + allocation_final11[2][5] + "                          "  + allocation_final11[2][6] + "                            " + allocation_final11[2][7]);
        hello19 = new Label("            " + "                      " + allocation_final11[3][0] + "                            "  + allocation_final11[3][1] + "                               "  + allocation_final11[3][2] + "                                "  + allocation_final11[3][3] + "                            "  + allocation_final11[3][4] + "                          "  + allocation_final11[3][5] + "                          "  + allocation_final11[3][6] + "                           "  + allocation_final11[3][7]);
        hello20 = new Label("            " + "                       " + allocation_final11[4][0] + "                           "  + allocation_final11[4][1] + "                              "  + allocation_final11[4][2] + "                               "  + allocation_final11[4][3] + "                          "  + allocation_final11[4][4] + "                         "  + allocation_final11[4][5] + "                        "  + allocation_final11[4][6] + "                          "  + allocation_final11[4][7]);
        
        
        sub1 = new Label("PSNA - Probability Statistics and Numerical Analysis");
        sub2 = new Label("DS - Data Structures");
        sub3 = new Label("CO - Computer organisation");
        sub4 = new Label("DC - Data Communication");
        sub5 = new Label("ECO - Economics");
        sub6 = new Label("SEM - Seminar");
        sub7 = new Label("MP-1 - Mini Project-1");
        sub8 = new Label("CPW - Computer Peripherals Workshop");
        extra = new Label("");
        lec1 = new Label("         " + alloc_lecs[0][0] + " - " + alloc_lec[0][0]);
        extra1 = new Label("					");	
        lec2 = new Label(alloc_lecs[0][1] + " - " + alloc_lec[0][1]);
        extra2 = new Label("		");
        lec3 = new Label("        " + alloc_lecs[0][2] + " - " +  alloc_lec[0][2]);
        extra3 = new Label("					");
        Label lec4 = new Label(alloc_lecs[0][3] + " - " + alloc_lec[0][3]);
        Label extra4 = new Label("					");
        
        Label dash11 = new Label("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        Label dash21 = new Label("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        Label dash31 = new Label("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        Label dash41 = new Label("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        Label dash51 = new Label("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        Label dash61 = new Label("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
        
        
        sub9  = new HBox(15);
        sub10 = new HBox(15);
        sub11 = new HBox(15);
        HBox sub12 = new HBox(15);
        sub9.getChildren().addAll(sub1,sub2,extra1,lec1,extra2,lec2);
        sub10.getChildren().addAll(sub3,sub4,sub5,extra3,lec3);
        sub11.getChildren().addAll(sub6,sub7,sub8,extra4,lec4);
        
        Button exit1 = new Button("Exit");
        exit1.setOnAction(e ->{
            window.setScene(scene6);
        });
        
        Image image3 = new Image("file:ce.jpg");
        ImageView iv3 = new ImageView();
        iv3.setImage(image3);
        iv3.setFitWidth(1360);
        iv3.setFitHeight(750);
        StackPane root3 = new StackPane();
        
        CEallocate.getChildren().addAll(hello15,dash11,hello10,hello16,dash21,hello11,hello17,dash31,hello12,hello18,dash41,hello13,hello19,dash51,hello14,hello20,dash61,extra,sub9,sub10,sub11,exit1);
        root3.getChildren().addAll(iv3,CEallocate);
        scene8 = new Scene(root3,1360,750);
        scene8.getStylesheets().add("effect4.css");
        
        
        
        
        //scene 9
        VBox ECallocate=new VBox(15);
        
        hello15 = new Label("            " + "            " + "9:00 to 10:00"+  "           " + "10:00 to 10:50" + "           " + "11:15 to 12:15" + "           " + "12:15 to 1:15" + "           " + "2:00 to 3:00" + "           "  + "3:00 to 4:00" + "           " +  "4:15 to 5:15" + "           "  + "5:15 to 6:15");
        hello10 = new Label(" Monday     " + "             " + allocation_final3[0][0] + "           "  + allocation_final3[0][1] + "           "  + allocation_final3[0][2] + "           "  + allocation_final3[0][3] + "           "  + allocation_final3[0][4] + "           "  + allocation_final3[0][5] + "           "  + allocation_final3[0][6] +"           " + allocation_final3[0][7]);
        hello11 = new Label(" Tuesday    " + "             " + allocation_final3[1][0] + "           "  + allocation_final3[1][1] + "           "  + allocation_final3[1][2] + "           "  + allocation_final3[1][3] + "           "  + allocation_final3[1][4] + "           "  + allocation_final3[1][5] + "           "  + allocation_final3[1][6] + "           "  + allocation_final3[1][7]);
        hello12 = new Label(" Wednesday  " + "             " + allocation_final3[2][0] + "           "  + allocation_final3[2][1] + "           "  + allocation_final3[2][2] + "           "  + allocation_final3[2][3] + "           "  + allocation_final3[2][4] +"           "  + allocation_final3[2][5] + "           "  + allocation_final3[2][6] + "           " + allocation_final3[2][7]);
        hello13 = new Label(" Thursday   " + "             " + allocation_final3[3][0] + "           "  + allocation_final3[3][1] + "           "  + allocation_final3[3][2] + "           "  + allocation_final3[3][3] + "           "  + allocation_final3[3][4] + "           "  + allocation_final3[3][5] + "           "  + allocation_final3[3][6] + "           "  + allocation_final3[3][7]);
        hello14 = new Label(" Friday     " + "             " + allocation_final3[4][0] + "           "  + allocation_final3[4][1] + "           "  + allocation_final3[4][2] + "           "  + allocation_final3[4][3] + "           "  + allocation_final3[4][4] + "           "  + allocation_final3[4][5] + "           "  + allocation_final3[4][6] + "           "  + allocation_final3[4][7]);
        
        hello16 = new Label("            " + "             " + allocation_final33[0][0] + "           "  + allocation_final33[0][1] + "           "  + allocation_final33[0][2] + "           "  + allocation_final33[0][3] + "           "  + allocation_final33[0][4] + "           "  + allocation_final33[0][5] + "           "  + allocation_final33[0][6] +"           " + allocation_final33[0][7]);
        hello17 = new Label("            " + "             " + allocation_final33[1][0] + "           "  + allocation_final33[1][1] + "           "  + allocation_final33[1][2] + "           "  + allocation_final33[1][3] + "           "  + allocation_final33[1][4] + "           "  + allocation_final33[1][5] + "           "  + allocation_final33[1][6] + "           "  + allocation_final33[1][7]);
        hello18 = new Label("            " + "             " + allocation_final33[2][0] + "           "  + allocation_final33[2][1] + "           "  + allocation_final33[2][2] + "           "  + allocation_final33[2][3] + "           "  + allocation_final33[2][4] +"           "  + allocation_final33[2][5] + "           "  + allocation_final33[2][6] + "           " + allocation_final33[2][7]);
        hello19 = new Label("            " + "             " + allocation_final33[3][0] + "           "  + allocation_final33[3][1] + "           "  + allocation_final33[3][2] + "           "  + allocation_final33[3][3] + "           "  + allocation_final33[3][4] + "           "  + allocation_final33[3][5] + "           "  + allocation_final33[3][6] + "           "  + allocation_final33[3][7]);
        hello20 = new Label("            " + "             " + allocation_final33[4][0] + "           "  + allocation_final33[4][1] + "           "  + allocation_final33[4][2] + "           "  + allocation_final33[4][3] + "           "  + allocation_final33[4][4] + "           "  + allocation_final33[4][5] + "           "  + allocation_final33[4][6] + "           "  + allocation_final33[4][7]);
        
        
        sub1 = new Label("PDNM - Probability Distributions and Numerical Methods");
        sub2 = new Label("SS - Signals and Systems");
        sub3 = new Label("EDC - Electronic devices and circuits-2");
        sub4 = new Label("EMD - Electrical Machines and Drives");
        sub5 = new Label("CS - Communication Systems");
        sub6 = new Label("EDTP - Electronic Design,tools and packages");
        sub7 = new Label("SEM - Seminar");
        sub8 = new Label("ICT - ICT tools and packages");
        extra = new Label("");
        
        sub9  = new HBox(15);
        sub10 = new HBox(15);
        sub11 = new HBox(15);
        sub9.getChildren().addAll(sub1,sub2);
        sub10.getChildren().addAll(sub3,sub4,sub5);
        sub11.getChildren().addAll(sub6,sub7,sub8);
        
        Image image4 = new Image("file:mechanicalbulb.jpg");
        ImageView iv4 = new ImageView();
        iv4.setImage(image4);
        iv4.setFitWidth(1360);
        iv4.setFitHeight(750);
        StackPane root4 = new StackPane();
        
        Button exit3 = new Button("Exit");
        exit3.setOnAction(e ->{
            window.setScene(scene6);
        });
        ECallocate.getChildren().addAll(hello15,hello10,hello16,hello11,hello17,hello12,hello18,hello13,hello19,hello14,hello20,extra,sub9,sub10,sub11,exit3);
        root4.getChildren().addAll(iv4,ECallocate);
        scene9 = new Scene(root4,1360,750);
        scene9.getStylesheets().add("effect.css");
        
        
        //scene 10
        
        VBox MEallocate=new VBox(5);
        hello15 = new Label("            " + "            " +    "9:00 to 10:00"      + "           "  +    "10:00 to 10:50"     + "           "  +    "11:15 to 12:15"     + "           "  +     "12:15 to 1:15"     + "           "  +     "2:00 to 3:00"      + "           "  +     "3:00 to 4:00"      + "           " +      "4:15 to 5:15"      + "           " +     "5:15 to 6:15"     );
        hello10 = new Label(" Monday     " + "             " + "     " + allocation_final4[0][0] + "     " + "           "  + "     " + allocation_final4[0][1] + "     " + "           "  + "     " + allocation_final4[0][2] + "     " + "           "  + "     " + allocation_final4[0][3] + "           "  + allocation_final4[0][4] + "           "  + allocation_final4[0][5] + "           "  + allocation_final4[0][6] + "           " + allocation_final4[0][7]);
        hello11 = new Label(" Tuesday    " + "             " + "     " + allocation_final4[1][0] + "     " + "           "  + "     " + allocation_final4[1][1] + "     " + "           "  + "     " + allocation_final4[1][2] + "     " + "           "  + "     " + allocation_final4[1][3] + "           "  + allocation_final4[1][4] + "           "  + allocation_final4[1][5] + "           "  + allocation_final4[1][6] + "           " + allocation_final4[1][7]);
        hello12 = new Label(" Wednesday  " + "             " + "     " + allocation_final4[2][0] + "     " + "           "  + "     " + allocation_final4[2][1] + "     " + "           "  + "     " + allocation_final4[2][2] + "     " + "           "  + "     " + allocation_final4[2][3] + "           "  + allocation_final4[2][4] +"           "  + allocation_final4[2][5] + "           "  + allocation_final4[2][6] + "           " + allocation_final4[2][7]);
        hello13 = new Label(" Thursday   " + "             " + "     " + allocation_final4[3][0] + "     " + "           "  + "     " + allocation_final4[3][1] + "     " + "           "  + "     " + allocation_final4[3][2] + "     " + "           "  + "     " + allocation_final4[3][3] + "           "  + allocation_final4[3][4] + "           "  + allocation_final4[3][5] + "           "  + allocation_final4[3][6] + "           " + allocation_final4[3][7]);
        hello14 = new Label(" Friday     " + "             " + "     " + allocation_final4[4][0] + "     " + "           "  + "     " + allocation_final4[4][1] + "     " + "           "  + "     " + allocation_final4[4][2] + "     " + "           "  + "     " + allocation_final4[4][3] + "           "  + allocation_final4[4][4] + "           "  + allocation_final4[4][5] + "           "  + allocation_final4[4][6] + "           " + allocation_final4[4][7]);
        
        hello16 = new Label("            " + "             " + allocation_final44[0][0] + "           "  + allocation_final44[0][1] + "           "  + allocation_final44[0][2] + "           "  + allocation_final44[0][3] + "           "  + allocation_final44[0][4] + "           "  + allocation_final44[0][5] + "           "  + allocation_final44[0][6] +"           " + allocation_final44[0][7]);
        hello17 = new Label("            " + "             " + allocation_final44[1][0] + "           "  + allocation_final44[1][1] + "           "  + allocation_final44[1][2] + "           "  + allocation_final44[1][3] + "           "  + allocation_final44[1][4] + "           "  + allocation_final44[1][5] + "           "  + allocation_final44[1][6] + "           "  + allocation_final44[1][7]);
        hello18 = new Label("            " + "             " + allocation_final44[2][0] + "           "  + allocation_final44[2][1] + "           "  + allocation_final44[2][2] + "           "  + allocation_final44[2][3] + "           "  + allocation_final44[2][4] +"           "  + allocation_final44[2][5] + "           "  + allocation_final44[2][6] + "           " + allocation_final44[2][7]);
        hello19 = new Label("            " + "             " + allocation_final44[3][0] + "           "  + allocation_final44[3][1] + "           "  + allocation_final44[3][2] + "           "  + allocation_final44[3][3] + "           "  + allocation_final44[3][4] + "           "  + allocation_final44[3][5] + "           "  + allocation_final44[3][6] + "           "  + allocation_final44[3][7]);
        hello20 = new Label("            " + "             " + allocation_final44[4][0] + "           "  + allocation_final44[4][1] + "           "  + allocation_final44[4][2] + "           "  + allocation_final44[4][3] + "           "  + allocation_final44[4][4] + "           "  + allocation_final44[4][5] + "           "  + allocation_final44[4][6] + "           "  + allocation_final44[4][7]);
        
        
        sub1 = new Label("DM - Dynamics of Machinery");
        sub2 = new Label("MI - Metrology and Instrumentation");
        sub3 = new Label("MME - Mathemetics of Mechanical Engineering");
        sub4 = new Label("MP - Manufacturing Processes");
        sub5 = new Label("FM - Fluid Mechanics");
        sub6 = new Label("SEM - Seminar");
        sub7 = new Label("ICT - ICT tools & Security");
        extra = new Label("");
        
        sub9  = new HBox(15);
        sub10 = new HBox(15);
        sub11 = new HBox(15);
        sub9.getChildren().addAll(sub1,sub2);
        sub10.getChildren().addAll(sub3,sub4);
        sub11.getChildren().addAll(sub5,sub6,sub7);
        
        Image image5 = new Image("file:ME.jpg");
        ImageView iv5 = new ImageView();
        iv5.setImage(image5);
        iv5.setFitWidth(1360);
        iv5.setFitHeight(750);
        StackPane root5 = new StackPane();
        
        Button exit4 = new Button("Exit");
        exit4.setOnAction(e ->{
            window.setScene(scene6);
        });
        MEallocate.getChildren().addAll(hello15,hello10,hello16,hello11,hello17,hello12,hello18,hello13,hello19,hello14,hello20,extra,sub9,sub10,sub11,exit4);
        root5.getChildren().addAll(iv5,MEallocate);
        scene10 = new Scene(root5,1360,750);
        scene10.getStylesheets().add("effect3.css");
        
        //layout3 scene3
        
        Label label3=new Label("Select Course type : ");
        ChoiceBox<String> choicecourse = new ChoiceBox<>();
        choicecourse.getItems().add("IT");
        choicecourse.getItems().add("CE");
        choicecourse.getItems().add("ME");
        choicecourse.getItems().add("EC");
        choicecourse.setValue("EC");
        
        
        Label label4 = new Label("No. of Subjects : ");
        ChoiceBox<Integer> choicesubject = new ChoiceBox<>();
        choicesubject.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        choicesubject.setValue(5);
        
        coursesubmit =new Button("Submit");
        coursesubmit.setOnAction(e -> {
            getChoiceCourse(choicecourse,s2);
            getChoiceSubject(choicesubject);
            window.setScene(scene4);
        });
        
        VBox courselayout = new VBox(20);
        Home = new Button("Go to Main time table page");
        Home.setOnAction(e -> window.setScene(scene1));
        courselayout.getChildren().addAll(Home,label3,choicecourse,label4,choicesubject,coursesubmit);
        scene3=new Scene(courselayout,600,400);
        
        
        //window setup
        
        window.setScene(scene1);
        window.setTitle("Time Table Generator");
        window.show();
    }
    
    public ObservableList<lecinfo> getLecinfo(){
        ObservableList<lecinfo> lecinfos = FXCollections.observableArrayList();
        return lecinfos;
    }
    
    public void addinfoClicked(ChoiceBox<String> choicedepartment) {
        lecinfo addlec = new lecinfo();
        
        addlec.setlecname(lecinput.getText());
        addlec.setleclname(leclinput.getText());
        
        
         s = choicedepartment.getValue();
        addlec.setDepartment(s);
        
        
        if(s=="IT")
        {
            lecturername_it[j1] = lecinput.getText();
            lecturerdepartment_it[j1] = s;
            
            s1 = s + "" + i1;
            lecturerid_it[j1] = s1;
            i1++;
            j1++;
        }
        if(s=="CE")
        {

            lecturername_ce[j2] = lecinput.getText();
            lecturerdepartment_ce[j2] = s;
            s1 = s + "" + i2;
            lecturerid_ce[j2] = s1;
            i2++;
            j2++;
        }
        if(s=="ME")
        {
            lecturername_me[j3] = lecinput.getText();
            lecturerdepartment_me[j3] = s;
            s1 = s + "" + i3;
            lecturerid_me[j3] = s1;
            i3++;
            j3++;
        }
        if(s=="EC")
        {
            lecturername_ec[j4] = lecinput.getText();
            lecturerdepartment_ec[j4] = s;
            s1 = s + "" + i4;
            lecturerid_ec[j4] = s1;
            i4++;
            j4++;
        }
        
        addlec.setlecid(s1);
        table.getItems().add(addlec);
        
        try
        {
            //"Select department, name from timetable where department = "+varDeptName; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/timetable","root","");
            System.out.println("VALID");
             name=lecinput.getText();
             lname=leclinput.getText();
             depar=choicedepartment.getValue().toString();
            Statement stmt=(Statement) con.createStatement();
            stmt.executeUpdate("INSERT INTO lecturer(id,FirstName,LastName,Department) VALUES('" +s1+ "','" + name + "','" + lname + "','" + depar + "')");
            
            con.close(); 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage() + "INVALID");
        }
        
        
        lecinput.clear();
        leclinput.clear();
        listview.getItems().clear();
        listmonday.getItems().clear();
        listtuesday.getItems().clear();
        listwednesday.getItems().clear();
        listthursday.getItems().clear();
        listfriday.getItems().clear();
        choice_department();
        
    }
    public void addlist_info()
    {
        
        courses = listview.getSelectionModel().getSelectedItems();
        monday = listmonday.getSelectionModel().getSelectedItems();
        tuesday = listtuesday.getSelectionModel().getSelectedItems();
        wednesday = listwednesday.getSelectionModel().getSelectedItems();
        thursday = listthursday.getSelectionModel().getSelectedItems();
        friday = listfriday.getSelectionModel().getSelectedItems();
        
        
        
        
        for(String s : courses)
        {
            course+= s + "\n";
        }
        
        System.out.println(course);
        
        
       
        for(String s : monday)
        {
            monday1+= s + "\n";
        }
        
        
       
        for(String s : tuesday)
        {
            tuesday1+= s + "\n";
        }
       
        for(String s : wednesday)
        {
            wednesday1+= s + "\n";
        }
      
        for(String s : thursday)
        {
            thursday1+= s + "\n";
        }
        System.out.println(thursday1 + " hello world");
       
        for(String s : friday)
        {
            friday1+= s + "\n";
        }
      
        try
        {
            //"Select department, name from timetable where department = "+varDeptName; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/timetable","root","");
            System.out.println("VALID");
            Statement stmt=(Statement) con.createStatement();
            stmt.executeUpdate("INSERT INTO courses(department,firstname,lastname,courses,monday,tuesday,wednesday,thursday,friday) VALUES('" +s1+ "','" + name + "','" + lname + "','" + courses + "','" + monday + "','" + tuesday + "','" + wednesday + "','" + thursday + "','" + friday + "')");
            con.close(); 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage() + "INVALID");
        }
        
        
        
    }
    public void choice_department() {
        if(choicedepartment.getValue().toString()=="IT")
        {
            listview.getItems().addAll("Data Structures","DS Lab","Probability Statistics and numerical Analysis","PSNA Lab","Computer Organisations","CO Lab","Communication Engineering","CE Lab","Computer Peripherals Workshop","Economics","Seminar","Mini Project-1");
            listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            
            listmonday.getItems().addAll("9:00a.m. to 11:00a.m.","11:00a.m. to 1:15p.m.","2:00p.m. to 4:00p.m.","4:00p.m. to 6:00p.m.");
            listmonday.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            listtuesday.getItems().addAll("9:00a.m. to 11:00a.m.","11:00a.m. to 1:15p.m.","2:00p.m. to 4:00p.m.","4:00p.m. to 6:00p.m.");
            listtuesday.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            listwednesday.getItems().addAll("9:00a.m. to 11:00a.m.","11:00a.m. to 1:15p.m.","2:00p.m. to 4:00p.m.","4:00p.m. to 6:00p.m.");
            listwednesday.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            listthursday.getItems().addAll("9:00a.m. to 11:00a.m.","11:00a.m. to 1:15p.m.","2:00p.m. to 4:00p.m.","4:00p.m. to 6:00p.m.");
            listthursday.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            listfriday.getItems().addAll("9:00a.m. to 11:00a.m.","11:00a.m. to 1:15p.m.","2:00p.m. to 4:00p.m.","4:00p.m. to 6:00p.m.");
            listfriday.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        }
        if(choicedepartment.getValue().toString()=="CE")
        {
            listview.getItems().addAll("Data Structures","DS Lab","Probability Statistics and numerical Analysis","PSNA Lab","Computer Organisations","CO Lab","Data Communications","DC Lab","Computer Peripherals Workshop","Economics","Seminar","Mini Project-1");
            listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

            listmonday.getItems().addAll("9:00a.m. to 11:00a.m.","11:00a.m. to 1:15p.m.","2:00p.m. to 4:00p.m.","4:00p.m. to 6:00p.m.");
            listmonday.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            listtuesday.getItems().addAll("9:00a.m. to 11:00a.m.","11:00a.m. to 1:15p.m.","2:00p.m. to 4:00p.m.","4:00p.m. to 6:00p.m.");
            listtuesday.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            listwednesday.getItems().addAll("9:00a.m. to 11:00a.m.","11:00a.m. to 1:15p.m.","2:00p.m. to 4:00p.m.","4:00p.m. to 6:00p.m.");
            listwednesday.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            listthursday.getItems().addAll("9:00a.m. to 11:00a.m.","11:00a.m. to 1:15p.m.","2:00p.m. to 4:00p.m.","4:00p.m. to 6:00p.m.");
            listthursday.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            listfriday.getItems().addAll("9:00a.m. to 11:00a.m.","11:00a.m. to 1:15p.m.","2:00p.m. to 4:00p.m.","4:00p.m. to 6:00p.m.");
            listfriday.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        }
        if(choicedepartment.getValue().toString()=="EC")
        {
            listview.getItems().addAll("Probability Distributions and Numerical Methods","Signals and Systems","Signals and Systems Lab","Electronic Devices and Circuits-2","EDC Lab","Electrical Machines and Drives ","EMD Lab","Communication Systems","Communication Systems Lab","Electronic Design Tools and Packages","Seminar","ICT Tools and Packages");
            listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

            listmonday.getItems().addAll("9:00a.m. to 11:00a.m.","11:00a.m. to 1:15p.m.","2:00p.m. to 4:00p.m.","4:00p.m. to 6:00p.m.");
            listmonday.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            listtuesday.getItems().addAll("9:00a.m. to 11:00a.m.","11:00a.m. to 1:15p.m.","2:00p.m. to 4:00p.m.","4:00p.m. to 6:00p.m.");
            listtuesday.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            listwednesday.getItems().addAll("9:00a.m. to 11:00a.m.","11:00a.m. to 1:15p.m.","2:00p.m. to 4:00p.m.","4:00p.m. to 6:00p.m.");
            listwednesday.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            listthursday.getItems().addAll("9:00a.m. to 11:00a.m.","11:00a.m. to 1:15p.m.","2:00p.m. to 4:00p.m.","4:00p.m. to 6:00p.m.");
            listthursday.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            listfriday.getItems().addAll("9:00a.m. to 11:00a.m.","11:00a.m. to 1:15p.m.","2:00p.m. to 4:00p.m.","4:00p.m. to 6:00p.m.");
            listfriday.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        }
        if(choicedepartment.getValue().toString()=="ME")
        {
            listview.getItems().addAll("Dynamics of Machinery","Dynamics of Machinery Lab","Metrology and Instrumentation","Metrology and Instrumentation Lab","Mathematics of Mechanical Engineering","Mathematics of Mechanical Engineering Lab","Manufacturing Processes","Manufacturing Processes Lab","Fluid mechanics","ICT Tools & Security","Seminar");
            listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

            listmonday.getItems().addAll("9:00a.m. to 11:00a.m.","11:00a.m. to 1:15p.m.","2:00p.m. to 4:00p.m.","4:00p.m. to 6:00p.m.");
            listmonday.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            listtuesday.getItems().addAll("9:00a.m. to 11:00a.m.","11:00a.m. to 1:15p.m.","2:00p.m. to 4:00p.m.","4:00p.m. to 6:00p.m.");
            listtuesday.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            listwednesday.getItems().addAll("9:00a.m. to 11:00a.m.","11:00a.m. to 1:15p.m.","2:00p.m. to 4:00p.m.","4:00p.m. to 6:00p.m.");
            listwednesday.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            listthursday.getItems().addAll("9:00a.m. to 11:00a.m.","11:00a.m. to 1:15p.m.","2:00p.m. to 4:00p.m.","4:00p.m. to 6:00p.m.");
            listthursday.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            listfriday.getItems().addAll("9:00a.m. to 11:00a.m.","11:00a.m. to 1:15p.m.","2:00p.m. to 4:00p.m.","4:00p.m. to 6:00p.m.");
            listfriday.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        }
        
        }
    
    public void addsubmit_info()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/timetable","root","");
            System.out.println("VALID");
            Statement stmt = (Statement)con.createStatement();
            
            String sql = "SELECT id, FirstName, LastName, Department FROM lecturer";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                //Retrieve by column name
                
                firstname = rs.getString("FirstName");
                
                
                //Display values
                
                System.out.print("  " + firstname);
                
                
            }
            rs.close();
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage() + "INVALID");
            }
        
    }
    public Pair addsubmit1_info()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/timetable","root","");
            System.out.println("VALID");
            Statement stmt = (Statement)con.createStatement();
            
            String sql = "SELECT department, firstname, lastname, courses, monday, tuesday, wednesday, thursday, friday FROM courses";
            ResultSet rs = stmt.executeQuery(sql);
            iterator =0;
            int count=0;
            
            
            while(rs.next()) {
                //Retrieve by column name
                
                allocation[iterator][0][0] = rs.getString("department");
                allocation[iterator][1][0] = rs.getString("firstname");
                allocation[iterator][2][0] = rs.getString("lastname");
                allocation[iterator][3][0] = rs.getString("courses");
                allocation[iterator][4][0] = rs.getString("monday");
                allocation[iterator][5][0] = rs.getString("tuesday");
                allocation[iterator][6][0] = rs.getString("wednesday");
                allocation[iterator][7][0] = rs.getString("thursday");
                allocation[iterator][8][0] = rs.getString("friday");
                
                
                int k=1,l=0;
                temp=allocation[iterator][3][0];
                allocation[iterator][3][0]="";
                while(temp.charAt(k)!=']')
                {
                    if(temp.charAt(k)==',')
                    {
                        l++;
                        allocation[iterator][3][l]="";
                        k++;
                        k++;
                    }
                    allocation[iterator][3][l]+=Character.toString(temp.charAt(k));
                    k++;
                }
                countcourses[iterator]=l+1;
                 k=1;
                 l=0;
                temp=allocation[iterator][4][0];
                allocation[iterator][4][0]="";
                while(temp.charAt(k)!=']')
                {
                    if(temp.charAt(k)==',' || temp.charAt(k)==']')
                    {
                        l++;
                        allocation[iterator][4][l]="";
                        k++;
                        k++;
                    }
                    allocation[iterator][4][l]+=Character.toString(temp.charAt(k));
                    k++;
                }
                countmonday[iterator]=l+1;
                
                k=1;
                l=0;
               temp=allocation[iterator][5][0];
               allocation[iterator][5][0]="";
               while(temp.charAt(k)!=']')
               {
                   if(temp.charAt(k)==',' || temp.charAt(k)==']')
                   {
                       l++;
                       allocation[iterator][5][l]="";
                       k++;
                       k++;
                   }
                   allocation[iterator][5][l]+=Character.toString(temp.charAt(k));
                   k++;
               }
               counttuesday[iterator]=l+1;
               k=1;
               l=0;
              temp=allocation[iterator][6][0];
              allocation[iterator][6][0]="";
              while(temp.charAt(k)!=']')
              {
                  if(temp.charAt(k)==',' || temp.charAt(k)==']')
                  {
                      l++;
                      allocation[iterator][6][l]="";
                      k++;
                      k++;
                  }
                  allocation[iterator][6][l]+=Character.toString(temp.charAt(k));
                  k++;
              }
              countwednesday[iterator]=l+1;
              k=1;
              l=0;
             temp=allocation[iterator][7][0];
             allocation[iterator][7][0]="";
             while(temp.charAt(k)!=']')
             {
                 if(temp.charAt(k)==',' || temp.charAt(k)==']')
                 {
                     l++;
                     allocation[iterator][7][l]="";
                     k++;
                     k++;
                     
                 }
                 allocation[iterator][7][l]+=Character.toString(temp.charAt(k));
                 k++;
             }
             countthursday[iterator]=l+1;
             k=1;
             l=0;
            temp=allocation[iterator][8][0];
            allocation[iterator][8][0]="";
            while(temp.charAt(k)!=']')
            {
                if(temp.charAt(k)==',' || temp.charAt(k)==']')
                {
                    l++;
                    allocation[iterator][8][l]="";
                    k++;
                    k++;
                }
                allocation[iterator][8][l]+=Character.toString(temp.charAt(k));
                k++;
            }
            countfriday[iterator]=l+1;
                System.out.println(temp + "hello");
                System.out.println("hello" + allocation[iterator][3][0]);
                System.out.println("hello" + allocation[iterator][3][1]);               
                //Display values
                
                System.out.print("  " + allocation[iterator][0][0]);
                System.out.print("  " + allocation[iterator][1][0]);
                System.out.print("  " + allocation[iterator][2][0]);
                System.out.print("  " + allocation[iterator][3][0]);
                System.out.print("  " + allocation[iterator][4][0]);
                System.out.print("  " + allocation[iterator][5][0]);
                System.out.print("  " + allocation[iterator][6][0]);
                System.out.print(" " + allocation[iterator][7][0]);
                System.out.println();
                
                iterator++;
            }
            rs.close();
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage() + "INoVALID");
            }
        
        return new Pair(allocation, countcourses,countmonday,counttuesday,countwednesday,countthursday,countfriday,iterator);
        
    }
    public void deleteinfoClicked() {
        ObservableList<lecinfo> deleteselected,deleteall;
        deleteall = table.getItems();
        
        deleteselected = table.getSelectionModel().getSelectedItems();
        deleteselected.forEach(deleteall::remove);
    }
    
    public void getChoiceCourse(ChoiceBox<String> choicecourse,String s2) {
         s2 = choicecourse.getValue();
         System.out.println(s2);
    }
    
    
    private void getChoiceSubject(ChoiceBox<Integer> choicesubject) {
        Integer a = choicesubject.getValue();
        System.out.println(a);
    }
    @Override
    public void handle(ActionEvent arg0) {
        // TODO Auto-generated method stub
        
    }    
}
