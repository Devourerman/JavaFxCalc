package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label_field;

    @FXML
    private Button divide_btn;

    @FXML
    private Button mult_btn;

    @FXML
    private Button minus_btn;

    @FXML
    private Button clear_btn;

    @FXML
    private Button plus_minus_btn;

    @FXML
    private Button percent_btn;

    @FXML
    private Button btn_7;

    @FXML
    private Button btn_8;

    @FXML
    private Button btn_9;

    @FXML
    private Button btn_4;

    @FXML
    private Button btn_5;

    @FXML
    private Button btn_6;

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    @FXML
    private Button plus_btn;

    @FXML
    private Button btn_0;

    @FXML
    private Button equal_btn;

    @FXML
    private Button comma_btn;

    private String str_num = "";
    private float firstNum = 0;
    private char operation;

    @FXML
    void initialize() {
        btn_0.setOnAction(actionEvent ->{
            addNumber(0);
        });
        btn_1.setOnAction(actionEvent ->{
            addNumber(1);
        });
        btn_2.setOnAction(actionEvent ->{
            addNumber(2);
        });
        btn_3.setOnAction(actionEvent ->{
            addNumber(3);
        });
        btn_4.setOnAction(actionEvent ->{
            addNumber(4);
        });
        btn_5.setOnAction(actionEvent ->{
            addNumber(5);
        });
        btn_6.setOnAction(actionEvent ->{
            addNumber(6);
        });
        btn_7.setOnAction(actionEvent ->{
            addNumber(7);
        });
        btn_8.setOnAction(actionEvent ->{
            addNumber(8);
        });
        btn_9.setOnAction(actionEvent ->{
            addNumber(9);
        });
        plus_btn.setOnAction(actionEvent -> {
            mathAction('+');
        });
        minus_btn.setOnAction(actionEvent -> {
            mathAction('-');
        });
        mult_btn.setOnAction(actionEvent -> {
            mathAction('*');
        });
        divide_btn.setOnAction(actionEvent -> {
            mathAction('/');
        });
        equal_btn.setOnAction(actionEvent -> {
            if(this.operation == '+' || this.operation == '-' ||
                    this.operation == '*' || this.operation == '/')
                equalMethod();
        });
        comma_btn.setOnAction(actionEvent -> {
            if(!this.str_num.contains(",")){
                this.str_num += '.';
                label_field.setText(str_num);
            }
        });
        percent_btn.setOnAction(actionEvent -> {
            if(this.str_num != ""){
                float num = Float.parseFloat(this.str_num) * 0.1f;
                this.str_num = Float.toString(num);
                label_field.setText(str_num);
            }
        });
        plus_minus_btn.setOnAction(actionEvent -> {
            if(this.str_num != ""){
                float num = Float.parseFloat(this.str_num) * -1;
                this.str_num = Float.toString(num);
                label_field.setText(str_num);
            }
        });
        clear_btn.setOnAction(actionEvent -> {
            label_field.setText("0");
            this.str_num = "";
            this.firstNum = 0;
            this.operation = 'A';
        });
    }

    void equalMethod() {
        float res = 0;
        switch (this.operation){
            case '+':
                res = this.firstNum + Float.parseFloat(this.str_num);
                break;
            case '-':
                res = this.firstNum - Float.parseFloat(this.str_num);
                break;
            case '*':
                res = this.firstNum * Float.parseFloat(this.str_num);
                break;
            case '/':
                if(Float.parseFloat(this.str_num) != 0)
                    res = this.firstNum / Float.parseFloat(this.str_num);
                else
                    res = 0;
                break;
        }
        label_field.setText(Float.toString(res));
        this.str_num = "";
        this.operation = 'A';
        this.firstNum = 0;
    }

    private void mathAction(char operation) {
        if(this.operation != '+' && this.operation != '-' &&
                this.operation != '*' && this.operation != '/') {
            this.firstNum = Float.parseFloat(this.str_num);
            label_field.setText(String.valueOf(operation));
            this.str_num = "";
            this.operation = operation;
        }
    }

    private void addNumber(int num){
        this.str_num += Integer.toString(num);
        label_field.setText(str_num);
    }
}