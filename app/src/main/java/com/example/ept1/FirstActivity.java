package com.example.ept1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Stack;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{
    private Button b1;
    private EditText result;
    //创建布局中的所有按钮
    private Button btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_dot,btn_sum,
            btn_sub, btn_mult,btn_div,btn_equ,btn_mod,btn_opp,btn_ac,btn_sqrt,btn_del;
    //包含所有按钮的数组
    private Button[] btns = { btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9, btn_sum,
            btn_sub, btn_mult,btn_div,btn_dot,btn_ac,btn_mod,btn_opp,btn_equ,btn_sqrt,btn_del};
    //包含所有按钮ID的数组
    private int[] btns_id = {R.id.btn_0,R.id.btn_1,R.id.btn_2,R.id.btn_3,R.id.btn_4,R.id.btn_5, R.id.btn_6,
            R.id.btn_7,R.id.btn_8,R.id.btn_9,R.id.btn_sum,R.id.btn_sub,R.id.btn_mult, R.id.btn_div,R.id.btn_dot
            ,R.id.btn_ac,R.id.btn_mod,R.id.btn_opp,R.id.btn_equ,R.id.btn_sqrt,R.id.btn_del};
    private boolean isClickequ = false;
    Stack stk;
    private double result_,num1,num2;
    private String strnum1,strnum2;
    private String op = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        b1 = (Button) findViewById(R.id.btn_greet);
        result = (EditText) findViewById(R.id.text_result);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FirstActivity.this, "欢迎使用wzy计算器", Toast.LENGTH_SHORT).show();
            }
        });
        //每一个按钮创建一个监听器
        for (int i = 0; i < btns.length; i++) {
            btns[i] = (Button) findViewById(btns_id[i]);
            btns[i].setOnClickListener(this);
        }
    }


    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.btn_0) {
            if (isClickequ) {
                result.setText("");
                isClickequ = false;
            }
            result.setText(result.getText().toString() + "0");
        } else if (i == R.id.btn_1) {
            if (isClickequ) {
                result.setText("");
                isClickequ = false;
            }
            result.setText(result.getText().toString() + "1");
        } else if (i == R.id.btn_2) {
            if (isClickequ) {
                result.setText("");
                isClickequ = false;
            }
            result.setText(result.getText().toString() + "2");
        } else if (i == R.id.btn_3) {
            if (isClickequ) {
                result.setText("");
                isClickequ = false;
            }
            result.setText(result.getText().toString() + "3");
        } else if (i == R.id.btn_4) {
            if (isClickequ) {
                result.setText("");
                isClickequ = false;
            }
            result.setText(result.getText().toString() + "4");
        } else if (i == R.id.btn_5) {
            if (isClickequ) {
                result.setText("");
                isClickequ = false;
            }
            result.setText(result.getText().toString() + "5");
        } else if (i == R.id.btn_6) {
            if (isClickequ) {
                result.setText("");
                isClickequ = false;
            }
            result.setText(result.getText().toString() + "6");
        } else if (i == R.id.btn_7) {
            if (isClickequ) {
                result.setText("");
                isClickequ = false;
            }
            result.setText(result.getText().toString() + "7");
        } else if (i == R.id.btn_8) {
            if (isClickequ) {
                result.setText("");
                isClickequ = false;
            }
            result.setText(result.getText().toString() + "8");
        } else if (i == R.id.btn_9) {
            if (isClickequ) {
                result.setText("");
                isClickequ = false;
            }
            result.setText(result.getText().toString() + "9");
        } else if (i == R.id.btn_sum) {
            strnum1 = result.getText().toString();
            if (strnum1.equals("")) {
                return;
            }
            num1 = Double.parseDouble(strnum1);
            result.setText("");
            op = "+";
            isClickequ = false;
        } else if (i == R.id.btn_sub) {
            strnum1 = result.getText().toString();
            if (strnum1.equals("")) {
                return;
            }
            num1 = Double.parseDouble(strnum1);
            result.setText("");
            op = "-";
            isClickequ = false;
        } else if (i == R.id.btn_mult) {
            strnum1 = result.getText().toString();
            if (strnum1.equals("")) {
                return;
            }
            num1 = Double.parseDouble(strnum1);
            result.setText("");
            op = "*";
            isClickequ = false;
        } else if (i == R.id.btn_div) {
            strnum1 = result.getText().toString();
            if (strnum1.equals("")) {
                return;
            }
            num1 = Double.parseDouble(strnum1);
            result.setText("");
            op = "/";
            isClickequ = false;
        } else if (i == R.id.btn_dot) {
            if (isClickequ) {
                result.setText("");
                isClickequ = false;
            }
            if(result.getText().toString().contains(".")){
                return;
            }
            result.setText(result.getText().toString() + ".");
        } else if (i == R.id.btn_mod) {
            strnum1 = result.getText().toString();
            if (strnum1.equals("")) {
                return;
            }
            num1 = Double.parseDouble(strnum1);
            result.setText("");
            op = "%";
            isClickequ = false;
        } else if (i == R.id.btn_equ) {
            strnum2 = result.getText().toString();
            if (strnum2.equals("")) {
                return;
            }
            num2 = Double.parseDouble(strnum2);
            switch (op) {
                case "+":
                    result_ = num1 + num2;
                    break;
                case "-":
                    result_ = num1 - num2;
                    break;
                case "*":
                    result_ = num1 * num2;
                    break;
                case "/":
                    result_ = num1 / num2;
                    break;
                case "%":
                    result_ = num1 % num2;
                    break;
                default:
                    result_ = num2;
            }

            result.setText("" + result_);
            num1 = 0;
            num2 = 0;
            result_ = 0;
            isClickequ = true;
        } else if (i == R.id.btn_opp) {
            strnum1 = result.getText().toString();
            if (strnum1.equals("")) {
                return;
            }
            num1 = Double.parseDouble(strnum1);
            num1 = -num1;
            result.setText("" + num1);
            isClickequ = false;
        } else if (i == R.id.btn_ac) {
            result.setText("");
            num1 = 0;
            num2 = 0;
            result_ = 0;
            isClickequ = false;
        } else if (i == R.id.btn_sqrt) {
            strnum1 = result.getText().toString();
            if (strnum1.equals("")) {
                return;
            }
            num1 = Double.parseDouble(strnum1);
            num1 = Math.sqrt(num1);
            result.setText("" + num1);
            isClickequ = false;
        } else if (i == R.id.btn_del) {
            strnum1 = result.getText().toString();
            if (strnum1.equals("")) {
                return;
            }
            result.setText(strnum1.substring(0,strnum1.length()-1));
            isClickequ = false;
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.setting_item) {
            Toast.makeText(FirstActivity.this, "你点击了设置", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.quit_item) {
            Toast.makeText(FirstActivity.this, "你点击了退出", Toast.LENGTH_SHORT).show();
            finish();
        }
        return true;
    }
}