package com.example.lib;
/*


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.Insets;
import  javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.dialog.Wizard;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Dictionary;
import java.util.Hashtable;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {




        Label l=new Label("email");
        MenuBar bar =new MenuBar();
        Menu file=new Menu("File");
        Menu edit=new Menu("edit");
        MenuItem open=new MenuItem("open");
        MenuItem save=new MenuItem("save");
        MenuItem cut=new MenuItem("open");
        MenuItem copy=new MenuItem("save");
        file.getItems().addAll(open,save);
        edit.getItems().addAll(cut,copy);
        bar.getMenus().addAll(file,edit);
        GridPane r1=new GridPane();
        GridPane r2=new GridPane();
        GridPane r3=new GridPane();
        GridPane ro=new GridPane();
        ComboBox<String> com=new ComboBox<>();
        com.setPromptText("mycity");
        ObservableList<String> lst=com.getItems();
        lst.add("new city");
        lst.add("free city");
        ro.setAlignment(Pos.CENTER);
        ro.setPadding(new Insets(20,0,0,0));
        ro.setHgap(10);
        ro.setVgap(10);
        GridPane g1=new GridPane();
        r1.setHgap(10);
        r1.setVgap(10);
        r2.setHgap(10);
        r2.setVgap(10);
        r3.setHgap(0);
        r3.setVgap(10);
        RadioButton ne=new RadioButton("select");
        RadioButton ne2=new RadioButton("select");
        RadioButton ne3=new RadioButton("select");
        ToggleGroup ne1=new ToggleGroup();
        ne.setToggleGroup(ne1);
        ne2.setToggleGroup(ne1);
        ne3.setToggleGroup(ne1);

        ToggleButton tog=new ToggleButton("press");
        tog.setOnAction(e -> {
/*
            Dbconnection connect=new Dbconnection();
            Connection ConnectDB =connect.getConnection();
            String connectQuery="SELECT idbookdetails FROM bookdetails";
            try{
                Statement statement=ConnectDB.createStatement();
                ResultSet queryOutput=statement.executeQuery(connectQuery);
                while(queryOutput.next()){
                    l.setText(queryOutput.getString("idbookdetails"));
                }
            }catch(Exception j){
                j.printStackTrace();
            }




                DBObject obj = new BasicDBObject();
                obj.put( "foo", "bar" );
                MongoCollection<Document> collection = database.getCollection("BookAdmin");
                Document doc = collection.find(eq("author", "xyz")).first();

                if (doc != null) {
                    l.setText(doc.get("name").toString());
                } else {
                    System.out.println("No matching documents found.");
                }

        });


        Label l1=new Label("username");
        Label l2=new Label("password");
        Label l3=new Label("destination");
        Button bb=new Button("submit");
        CheckBox c1=new CheckBox("username");
        CheckBox c2=new CheckBox("username");
        CheckBox c3=new CheckBox("username");
        TextArea tx1=new TextArea();
        TextField t1=new TextField();
        TextField t2=new TextField();
        TextField t3=new TextField();
        ToggleButton b=new ToggleButton("login");
        b.setPadding(new Insets(10,20,10,20));
        r2.addRow(2,l3,com);
        r2.addRow(1,bar);

        r2.addRow(3,l,t1);
        r2.addRow(4,l1,t2);

        r2.addRow(5,l2,t3);
        r2.addRow(7,tog);
        r1.addRow(2,tx1);
        r3.addRow(9,c1,c2,c3);
        ro.addColumn(1,r2);
        ro.addColumn(1,r3,r1);

        Label ll=new Label("label");

        Scene scene = new Scene(ro, 500, 600);



        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
*/

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import javafx.event.EventType;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.*;
import org.bson.Document;

import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;    



import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.*;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Collections;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
/**
 * Sample application that shows how the sized of controls can be managed.
 * Sample is for demonstration purposes only, most controls are inactive.
 */
public class HelloApplication extends Application{

    ConnectionString connectionString = new ConnectionString("mongodb+srv://kalai_DB:D14m4y2004@bookdetails.j40qdvi.mongodb.net/?retryWrites=true&w=majority");
    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();

    MongoClient mongoClient = MongoClients.create(settings);
    MongoDatabase database = mongoClient.getDatabase("Bookdetails");

    MongoCollection<Document> collection = database.getCollection("BookAdmin");

    MongoCollection<Document> collect = database.getCollection("Bookers");

    // Define buttons here for access by multiple methods
    private final Button btnApply = new Button("Apply");
    private final Button btnContinue = new Button("Continue");
    private final Button btnExit = new Button("Exit");

     ArrayList<FileData> ele=new ArrayList<FileData>();
    ObservableList<String> items;


    ListView<String> lvList = new ListView<String>();


//
    public void findWarlord(MongoCollection<Document> coll) throws NullPointerException{
        lvList.setItems(items);

        FindIterable<Document> iterable = coll.find(); // (1)

        MongoCursor<Document> cursor = iterable.iterator(); // (2)
        try {
            cursor.next();
            while(cursor.hasNext()) {
                Document f=cursor.next();
                String n=f.get("_id").toString();
                String v=f.get("name").toString();
                String s=f.get("author").toString();
                String m=f.get("count").toString();
                String b=f.get("catagory").toString();

                FileData c=new FileData(n,v,s,m,b);

                ele.add(c);
                }

        } finally {
            cursor.close();
        }

    }
    public static void main(String[] args) {

        Application.launch();

    }

    public static void showStage1() {
        HelloApplication obj =new HelloApplication();
        Stage newStage = new Stage();
        VBox comp = new VBox();
        comp.setSpacing(20);
        GridPane r1 = new GridPane();
        GridPane r2 = new GridPane();

        TextField nameField = new TextField("");

        Text v = new Text("Book Id*");

        r1.addColumn(1, v);
        r1.addColumn(2, nameField);
        r1.setVgap(20);
        r1.setHgap(10);

        Button ff=new Button("delete");
        Button tt=new Button("clear");
        ff.setOnAction(e->{

            if(!nameField.getText().equals("")
                    ){
                obj.collection.deleteOne(eq("_id", Integer.parseInt(nameField.getText())));
                Document myDoc = obj.collection.find(eq("_id", 0)).first();
                System.out.println(myDoc);
                int c= Integer.parseInt(myDoc.get("counts").toString());

                c--;
                System.out.println(c);

                nameField.setText("");

                obj.collection.updateOne(Filters.eq("_id", 0), Updates.set("counts", c));
            }
        });
        tt.setOnAction(e->{
            nameField.setText("");
        });
        r2.addRow(1,ff,tt);
        r2.setHgap(10);
        Insets x=new Insets(10);
        VBox.setMargin(r2,new Insets(20,20,0,5));
        comp.getChildren().addAll(r1,r2);

        comp.setSpacing(10);
        Scene stageScene = new Scene(comp, 300, 200);
        newStage.setTitle("Delete a book");
        newStage.setScene(stageScene);
        newStage.show();


    }

    public static void showStage4() {
        HelloApplication obj =new HelloApplication();
        Stage newStage = new Stage();
        VBox comp = new VBox();
        comp.setSpacing(20);
        GridPane r1 = new GridPane();
        GridPane r2 = new GridPane();

        TextField nameField = new TextField("");
        TextField author = new TextField("");
        Text v = new Text("Book Name*");
        Text t = new Text("Author*");
        TextField count = new TextField("");
        TextField catagory = new TextField("");
        Text m = new Text("count*");
        Text k= new Text("category*");
        Text tt = new Text("Author*");
        TextField countt = new TextField("");
        r1.addColumn(1, v, t,m,k,tt);
        r1.addColumn(2, nameField, author,count,catagory,countt);
        r1.setVgap(20);
        r1.setHgap(10);

        Button ff=new Button("Submit");
        Button ttt=new Button("clear");
        ff.setOnAction(e->{

            if(!nameField.getText().equals("")&&!author.getText().equals("")&&!count.getText().equals("")
                    &&!catagory.getText().equals("")&&tt.getText().equals("")){











                obj.collection.updateOne(Filters.eq("_id", Integer.parseInt(countt.getText())), Updates.set("count", Integer.parseInt(count.getText())));
                obj.collection.updateOne(Filters.eq("_id", Integer.parseInt(countt.getText())), Updates.set("name",nameField.getText()));
                obj.collection.updateOne(Filters.eq("_id", Integer.parseInt(countt.getText())), Updates.set("author",author.getText()));
                obj.collection.updateOne(Filters.eq("_id", Integer.parseInt(countt.getText())), Updates.set("catagory",catagory.getText()));


                nameField.setText("");
                author.setText("");
                count.setText("");
                catagory.setText("");
            }
        });
        ttt.setOnAction(e->{
            nameField.setText("");
            author.setText("");
            count.setText("");
            catagory.setText("");

        });
        r2.addRow(1,ff,ttt);
        r2.setHgap(10);
        Insets x=new Insets(10);
        VBox.setMargin(r2,new Insets(20,20,0,5));
        comp.getChildren().addAll(r1,r2);

        comp.setSpacing(10);
        Scene stageScene = new Scene(comp, 300, 300);
        newStage.setScene(stageScene);

        newStage.setTitle("Update a book");
        newStage.show();


    }
    public static void showStage() {
        HelloApplication obj =new HelloApplication();
        Stage newStage = new Stage();
        VBox comp = new VBox();
        comp.setSpacing(20);
        GridPane r1 = new GridPane();
        GridPane r2 = new GridPane();

        TextField nameField = new TextField("");
        TextField author = new TextField("");
        Text v = new Text("Book Name*");
        Text t = new Text("Author*");
        TextField count = new TextField("");
        TextField catagory = new TextField("");
        Text m = new Text("count*");
        Text k= new Text("category*");
        r1.addColumn(1, v, t,m,k);
        r1.addColumn(2, nameField, author,count,catagory);
        r1.setVgap(20);
        r1.setHgap(10);

        Button ff=new Button("Submit");
        Button tt=new Button("clear");
        ff.setOnAction(e->{

            if(!nameField.getText().equals("")&&!author.getText().equals("")&&!count.getText().equals("")
            &&!catagory.getText().equals("")){

                Document myDoc = obj.collection.find(eq("_id", 0)).first();

                int c= Integer.parseInt(myDoc.get("count").toString());

                c++;
                int d= Integer.parseInt(myDoc.get("count").toString());

                d++;

                Document document = new Document();
                document.append("_id",c);
            document.append("name",nameField.getText());
            document.append("author", author.getText());
            document.append("count", Integer.parseInt(count.getText()));
            document.append("catagory", catagory.getText());
            document.append("issued",new ArrayList<String>());
                nameField.setText("");
                author.setText("");
                count.setText("");
                catagory.setText("");
            obj.collection.insertOne(document);





                obj.collection.updateOne(Filters.eq("_id", 0), Updates.set("count", c));
                obj.collection.updateOne(Filters.eq("_id", 0), Updates.set("counts", d));

            }
        });
        tt.setOnAction(e->{
            nameField.setText("");
            author.setText("");
            count.setText("");
            catagory.setText("");

        });
        r2.addRow(1,ff,tt);
        r2.setHgap(10);
        Insets x=new Insets(10);
        VBox.setMargin(r2,new Insets(20,20,0,5));
        comp.getChildren().addAll(r1,r2);

        comp.setSpacing(10);
        Scene stageScene = new Scene(comp, 300, 300);
        newStage.setScene(stageScene);

        newStage.setTitle("Add a book");
        newStage.show();


    }


    public static void showStage2(String x) {
        HelloApplication obj =new HelloApplication();
        Stage newStage = new Stage();
        VBox comp = new VBox();
        comp.setSpacing(20);
        GridPane r1 = new GridPane();
        GridPane r2 = new GridPane();
        Label xx=new Label("");
        TextField nameField = new TextField("");

        Text v = new Text("Roll No*");


        r1.addColumn(1, v);
        r1.addColumn(2, nameField);
        r1.setVgap(20);
        r1.setHgap(10);

        Button ff=new Button("Issue");
        Button tt=new Button("clear");
        ff.setOnAction(e->{

            if(!nameField.getText().equals("")){

                Document myDo = obj.collect.find(eq("_id", nameField.getText())).first();


                if(myDo!=null){

                Document myDoc = obj.collection.find(eq("_id", Integer.parseInt(x))).first();
                    Object iss= myDoc.get("issued");
                    int ind=0;
                    ListIterator<Object> topics = ((ArrayList) iss).listIterator();

                    while(topics.hasNext()){
                        if(topics.next().equals(nameField.getText()))
                        {
                            ind=1;
                            break;}
                    }
                    if(ind==0){
                        ((ArrayList<String>) iss).add(nameField.getText());

                int c= Integer.parseInt(myDoc.get("count").toString());

                c--;
                xx.setText("Book issued for "+nameField.getText()+"...");
            nameField.setText("");
            obj.collection.updateOne(Filters.eq("_id", Integer.parseInt(x)), Updates.set("count", c));
            obj.collection.updateOne(Filters.eq("_id", Integer.parseInt(x)), Updates.set("issued", iss));

                    }
                    else{

                        xx.setText("This book is already issued for "+nameField.getText()+"!...");
                    }








            }else{
                  xx.setText("No user under this Id!");
                }
            }
        });
        tt.setOnAction(e->{
            nameField.setText("");


        });
        r2.addRow(1,ff,tt);
        r2.setHgap(10);

        VBox.setMargin(r2,new Insets(20,20,0,5));
        comp.getChildren().addAll(r1,r2,xx);

        comp.setSpacing(10);
        Scene stageScene = new Scene(comp, 300, 300);
        newStage.setScene(stageScene);

        newStage.setTitle("Issue");
        newStage.show();


    }

    public static void showStage3(String x) {
        HelloApplication obj =new HelloApplication();
        Stage newStage = new Stage();
        VBox comp = new VBox();
        comp.setSpacing(20);
        GridPane r1 = new GridPane();
        GridPane r2 = new GridPane();
        Label xx=new Label("Students who where issued this book..");
        ObservableList<String> b=FXCollections.observableArrayList();
        Document myDoc = obj.collection.find(eq("_id", Integer.parseInt(x))).first();
        Object iss= myDoc.get("issued");
        int ind=0;
        ListIterator<Object> topics = ((ArrayList) iss).listIterator();

        while(topics.hasNext()){
            b.add(topics.next().toString());

        }
        ListView<String> v=new ListView<String>(b);






        VBox.setMargin(v,new Insets(30,30,30,30));
        comp.getChildren().addAll(r1,r2,xx,v);

        comp.setSpacing(10);
        Scene stageScene = new Scene(comp, 300, 300);
        newStage.setScene(stageScene);

        newStage.setTitle("Issue");
        newStage.show();


    }

    //@Override
    public void start(Stage primaryStage)
    {
        findWarlord(collection);
        VBox comp = new VBox();
        comp.setSpacing(10);
        GridPane r2 = new GridPane();
        GridPane r1=new GridPane();
        TextField nameField = new TextField("");
        TextField author = new TextField("");
        Text v = new Text("Mail*");
        Text t = new Text("Password*");

        r1.addColumn(1, v, t);
        r1.addColumn(2, nameField, author);
        r1.setVgap(10);
        r1.setHgap(10);

        Button ff=new Button("Submit");
        Button tt=new Button("clear");
        r2.addRow(1,ff,tt);
        r2.setHgap(10);

        VBox.setMargin(r2,new Insets(50,100,100,100));
        VBox.setMargin(r1,new Insets(0,0,100,0));
        comp.getChildren().addAll(r1,r2);


        // Manage scene size
        Scene scene = new Scene(sizingSample());

        primaryStage.setTitle("Admin login and user issue");
        ff.setOnAction(e->{
            if(nameField.getText().equals("kalaikgm18@gmail.com")&&author.getText().equals("D14m4y2004@"))
                primaryStage.setScene(scene);
            primaryStage.setTitle("details of the library");

        });

        // Make Exit button bigger by using larger font for label
        //btnExit.setStyle("-fx-font-size: 12pt;");

        // Use tab pane with one tab for sizing UI and one tab for alignment UI
        TabPane tabs = new TabPane();
        Tab tabSize = new Tab();
        tabSize.setText("Admin login");
        tabSize.setContent(comp);

        Tab tabAlign = new Tab();
        tabAlign.setText("User issue");
        tabAlign.setContent(alignmentSample());

        tabs.getTabs().addAll(tabSize, tabAlign);



        Scene cc=new Scene(tabs);
        primaryStage.setScene(cc);
        primaryStage.fullScreenProperty();
        primaryStage.show();



    }

    /*
     * Creates the UI for the sizing sample, which demonstrates ways to manage
     * the size of controls when you don't want the default sizes.
     */
    private Pane sizingSample() {

        BorderPane border = new BorderPane();
        border.setPadding(new Insets(20, 0, 20, 20));
        /*items = FXCollections.observableArrayList (
                ele);

        lvList.setItems(items);
        lvList.setMaxHeight(Control.USE_PREF_SIZE);
        lvList.setPrefWidth(300);*/

        border.setRight(createButtonColumn());
        border.setBottom(createButtonRow());  // Uses a tile pane for sizing
//        border.setBottom(createButtonBox());  // Uses an HBox, no sizing

        Label label = new Label("File Data:");
        Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
        label.setFont(font);
        //Creating a table view
        TableView<FileData> table = new TableView<FileData>();
        final ObservableList<FileData> data = FXCollections.observableArrayList(
                ele
        );

        //Creating columnskala
        TableColumn Id = new TableColumn("Id");
        Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn fileNameCol = new TableColumn("Book Name");
        fileNameCol.setCellValueFactory(new PropertyValueFactory<>("fileName"));
        TableColumn pathCol = new TableColumn("Author");
        pathCol.setCellValueFactory(new PropertyValueFactory("path"));
        TableColumn sizeCol = new TableColumn("Count");
        sizeCol.setCellValueFactory(new PropertyValueFactory("size"));
        TableColumn dateCol = new TableColumn("Catagory");
        dateCol.setCellValueFactory(new PropertyValueFactory("dateModified"));
        dateCol.setPrefWidth(100);
        //Adding data to the table
        ObservableList<String> list = FXCollections.observableArrayList();
        table.setItems(data);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getColumns().addAll(Id,fileNameCol, pathCol, sizeCol, dateCol);
        //Setting the size of the table
        table.setMaxSize(350, 200);
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            showStage3(newSelection.getId());
        });

        border.setLeft(table);

        return border;



    }

    /*
     * Creates the UI for the alignment sample, which demonstrates ways to manage
     * the alignment of controls when you don't want the default alignment.
     */
    private Pane alignmentSample() {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);  // Override default
        grid.setHgap(10);
        grid.setVgap(12);

        // Use column constraints to set properties for columns in the grid
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.RIGHT);  // Override default
        grid.getColumnConstraints().add(column1);

        TableView<FileData> table = new TableView<FileData>();
        final ObservableList<FileData> data = FXCollections.observableArrayList(
                ele
        );

        //Creating columnskala
        TableColumn Id = new TableColumn("Id");
        Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn fileNameCol = new TableColumn("Book Name");
        fileNameCol.setCellValueFactory(new PropertyValueFactory<>("fileName"));
        TableColumn pathCol = new TableColumn("Author");
        pathCol.setCellValueFactory(new PropertyValueFactory("path"));
        TableColumn sizeCol = new TableColumn("Count");
        sizeCol.setCellValueFactory(new PropertyValueFactory("size"));
        TableColumn dateCol = new TableColumn("Catagory");
        dateCol.setCellValueFactory(new PropertyValueFactory("dateModified"));
        dateCol.setPrefWidth(100);
        Label s=new Label("Click the book below to issue the book");
        Label t=new Label("");
        //Adding data to the table
        ObservableList<String> list = FXCollections.observableArrayList();
        table.setItems(data);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getColumns().addAll(Id,fileNameCol, pathCol, sizeCol, dateCol);
        //Setting the size of the table
        table.setMaxSize(350, 200);
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

            if(Integer.parseInt(newSelection.getSize())==0){
                t.setText("There is no stock for this book!");

            }
            else {
                t.setText("");
                showStage2(newSelection.getId());

            }
        });
        grid.addColumn(1,s,table,t);

        /* Uncomment the following statements to bottom-align the buttons */
//        hbButtons.setAlignment(Pos.BOTTOM_CENTER);
//        GridPane innergrid = new GridPane();
//        innergrid.setAlignment(Pos.CENTER);
//        innergrid.add(hbButtons, 0, 0);
//        grid.add(innergrid, 0, 2, 2, 1);

        return grid;
    }

    /*
     * Creates a column of buttons and makes them all the same width as the
     * largest button.
     */
    private VBox createButtonColumn() {


        Button btnAdd = new Button("Add");
        btnAdd.setOnAction(e->{showStage();

            lvList.refresh();

        });
        Button btnDelete = new Button("Delete");
        btnDelete.setOnAction(e->{
            try{
            showStage1();
            findWarlord(collection);
            lvList.refresh();}finally{}
        });
        Button btnMoveUp = new Button("Update");
        btnMoveUp.setOnMouseClicked(event->{
            showStage4();
        });

        // Comment out the following statements to see the default button sizes
        btnAdd.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnDelete.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnMoveUp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);


        /*btnAdd.setOnAction(new EventHandler<ActionEvent>() {

            //@Override
            public void handle(ActionEvent event) {
                Scanner scan = new Scanner(System.in);
                String s = scan.next();

            }
        });*/

        VBox vbButtons = new VBox();
        vbButtons.setSpacing(10);
        vbButtons.setPadding(new Insets(0, 20, 10, 20));

        vbButtons.getChildren().addAll(
                btnAdd, btnDelete, btnMoveUp);

        return vbButtons;
    }

    /*
     * Creates a row of buttons and makes them all the same size.
     */
    private TilePane createButtonRow() {

        // Let buttons grow, otherwise they will be different sizes based
        // on the length of the label
        btnApply.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnContinue.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnExit.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnExit.setOnAction(new EventHandler<ActionEvent>() {

            //@Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        TilePane tileButtons = new TilePane(Orientation.HORIZONTAL);
        tileButtons.setPadding(new Insets(20, 10, 20, 0));
        tileButtons.setHgap(10.0);
        tileButtons.setVgap(8.0); // In case window is reduced and buttons
        // require another row
        tileButtons.getChildren().addAll(btnApply, btnContinue, btnExit);

        return tileButtons;
    }

    /*
     * Creates a row of buttons with the default sizes.
     */
    private HBox createButtonBox() {

        HBox hbButtons = new HBox();
        hbButtons.setSpacing(10);
        hbButtons.setPadding(new Insets(20, 10, 20, 0));
        hbButtons.getChildren().addAll(btnApply, btnContinue, btnExit);

        return hbButtons;
    }

    public class FileData {
        SimpleStringProperty Id;
        SimpleStringProperty fileName;
        SimpleStringProperty path;
        SimpleStringProperty size;
        SimpleStringProperty dateModified;

        FileData(String Id,String fileName, String path, String size, String dateModified) {
            this.Id = new SimpleStringProperty(Id);
            this.fileName = new SimpleStringProperty(fileName);
            this.path = new SimpleStringProperty(path);
            this.size = new SimpleStringProperty(size);
            this.dateModified = new SimpleStringProperty(dateModified);
        }

        public String getId(){
            return Id.get();
        }
        public void setId(String fname){
            Id.set(fname);
        }
        public String getFileName(){
            return fileName.get();
        }
        public void setFileName(String fname){
            fileName.set(fname);
        }
        public String getPath(){
            return path.get();
        }
        public void setPath(String fpath){
            path.set(fpath);
        }
        public String getSize(){
            return size.get();
        }
        public void setSize(String fsize){
            size.set(fsize);
        }
        public String getDateModified(){
            return dateModified.get();
        }
        public void setModified(String fmodified){
            dateModified.set(fmodified);
        }
    }
}
