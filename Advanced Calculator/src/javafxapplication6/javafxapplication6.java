package javafxapplication6;

import java.lang.Math;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class javafxapplication6 extends Application {
    int base = 10;

    @Override
    public void start(Stage primaryStage) {
       
        TextField txt_x = new TextField();
        txt_x .setMinSize(50,50); 
        TextField txt_y = new TextField();
         txt_y .setMinSize(50,50); 
       
         
        Button btn = new Button("Check validation");
        btn.setMinSize(100, 50);
        Button btn_add = new Button("+");
        btn_add.setMinSize(40, 60);
        Button btn_sub = new Button("-");
        btn_sub.setMinSize(40, 60);
        Button btn_multi = new Button("*");
        btn_multi.setMinSize(40, 60);
        Button btn_div = new Button("/");
        btn_div.setMinSize(40, 60);
        Button btn_int_div = new Button("//");
        btn_int_div.setMinSize(60, 56);
        Button btn_modul = new Button("%");
        btn_modul.setMinSize(40, 50);
        Button btn_power = new Button("^");
        btn_power.setMinSize(40, 50);
        Button btn_log = new Button("log");
        btn_log.setMinSize(40, 50);
        Button btn_fact = new Button("x!");
        btn_fact.setMinSize(40, 50);
        Button btn_clear = new Button("C");
        btn_clear.setMinSize(110,60);

        Label lbl_res = new Label(null);
        lbl_res.setMinSize(35,35); 
        
        ComboBox combo = new ComboBox(); 
        combo.getItems().addAll("DEC","HEX","OCT","BIN");
        combo.setValue("DEC");
        combo.setMinSize(100,40);
        combo.valueProperty().addListener(new ChangeListener<String>(){
        @Override 
        public void changed(ObservableValue ov ,String x,String y ){
            
            if(y.equals("DEC"))
                base=10;
            else if(y.equals("Hex"))
                base = 16;
            else if (y.equals("OCT"))
                base = 8 ;
            else 
                base = 2 ;
        }
          });
        
             EventHandler<ActionEvent> event =  new EventHandler<ActionEvent>() { 
           
             @Override public void handle(ActionEvent e) 
            { 
                if(combo.getValue() == "HEX"){
                   
                  int a = (int) Double.parseDouble(lbl_res.getText());
                            
               lbl_res.setText(Integer.toString(a,16)); 
                }
                else if(combo.getValue() == "OCT")
                {      
                    int a = (int) Double.parseDouble(lbl_res.getText());
                            
               lbl_res.setText(Integer.toString(a,8)); 
                }
                else if(combo.getValue()== "BIN"){
                     int a = (int) Double.parseDouble(lbl_res.getText());
                            
               lbl_res.setText(Integer.toString(a,2));
                }
                else if(combo.getValue()== "DEC"){
                    
                     int a = (int) Double.parseDouble(lbl_res.getText());
                            
               lbl_res.setText(Integer.toString(a,10));
                }   
            } 
            };  combo.setOnAction(event); 
         
       
            btn_add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                double x = Double.parseDouble(txt_x.getText());
                double y = Double.parseDouble(txt_y.getText());
                lbl_res.setText(Double.toString(x + y));
                
            }
        });
        btn_sub.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                double x = Double.parseDouble(txt_x.getText());
                double y = Double.parseDouble(txt_y.getText());
                lbl_res.setText(Double.toString(x - y));
            }
            

        });
        btn_multi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                double x = Double.parseDouble(txt_x.getText());
                double y = Double.parseDouble(txt_y.getText());
                lbl_res.setText(Double.toString(x * y));
            }

        });
        btn_div.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                double x = Double.parseDouble(txt_x.getText());
                double y = Double.parseDouble(txt_y.getText());
                lbl_res.setText(Double.toString(x / y));
            }

        });
        btn_int_div.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                int x = (int) Double.parseDouble(txt_x.getText());
                int y = (int) Double.parseDouble(txt_y.getText());
                lbl_res.setText(Integer.toString(x / y));
            }

        });
        btn_modul.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                double x = Double.parseDouble(txt_x.getText()); 
                double y = Double.parseDouble(txt_y.getText());
                lbl_res.setText(Double.toString(x % y));
            }

        });
        btn_power.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                double x = Double.parseDouble(txt_x.getText());
                double y = Double.parseDouble(txt_y.getText());
                lbl_res.setText(Double.toString(Math.pow(x, y)));
            }

        });
        btn_log.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) 
            {
                double x = Double.parseDouble(txt_x.getText());
                double y = Double.parseDouble(txt_y.getText());
                lbl_res.setText(Double.toString(Math.log(x) / Math.log(y)));
            }});
        btn_fact.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                int i, fact = 1;
                double x = Double.parseDouble(txt_x.getText());
                double number = x;
                for (i = 1; i <= number; i++) {
                    fact = fact * i;
                }
                lbl_res.setText(Double.toString(fact));
            }

        });
        btn_clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                double x = Double.parseDouble(txt_x.getText());
                double y = Double.parseDouble(txt_y.getText());
                lbl_res.setText(null);
            }

        });
        
     
        GridPane grid = new GridPane();
        grid.add(txt_x, 4, 0);
        grid.add(txt_y,4,1);
        grid.add(lbl_res, 0, 0);
        grid.add(btn_clear, 0,1 );
        grid.add(btn_add, 1, 1);
        grid.add(btn_sub, 2, 1);
        grid.add(btn_multi, 1, 4);
        grid.add(btn_div, 3, 4);
        grid.add(btn_int_div, 3, 1);
        grid.add(btn_modul , 3, 2);
        grid.add(btn_power, 2, 4);
        grid.add(btn_log, 2, 2);
        grid.add(btn_fact, 1, 2);   
        grid.add(combo,0,3);
       // grid.add(btn,4,5);
        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
