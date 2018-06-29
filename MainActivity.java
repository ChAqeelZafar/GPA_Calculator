package com.example.johnwick.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String data[][] = new String[7][3] ;
    Button done, exit ;
    TextView gpa ;
    EditText info[][] = new EditText[7][3];
    int totalCredit = 0;
    double earnedCredit = 0;
    double g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        done = findViewById(R.id.main_btn_done);
        exit = findViewById(R.id.main_btn_exit) ;

        gpa = findViewById(R.id.main_text_gpa) ;

        info[0][0] = findViewById(R.id.main_edit_text_s1) ;
        info[1][0] = findViewById(R.id.main_edit_text_s2) ;
        info[2][0] = findViewById(R.id.main_edit_text_s3) ;
        info[3][0] = findViewById(R.id.main_edit_text_s4) ;
        info[4][0] = findViewById(R.id.main_edit_text_s5) ;
        info[5][0] = findViewById(R.id.main_edit_text_s6) ;
        info[6][0] = findViewById(R.id.main_edit_text_s7) ;


        info[0][1] = findViewById(R.id.main_edit_c1);
        info[1][1] = findViewById(R.id.main_edit_c2);
        info[2][1] = findViewById(R.id.main_edit_c3);
        info[3][1] = findViewById(R.id.main_edit_c4);
        info[4][1] = findViewById(R.id.main_edit_c5);
        info[5][1] = findViewById(R.id.main_edit_c6);
        info[6][1] = findViewById(R.id.main_edit_c7);


        info[0][2] = findViewById(R.id.main_edit_g1);
        info[1][2] = findViewById(R.id.main_edit_g2);
        info[2][2] = findViewById(R.id.main_edit_g3);
        info[3][2] = findViewById(R.id.main_edit_g4);
        info[4][2] = findViewById(R.id.main_edit_g5);
        info[5][2] = findViewById(R.id.main_edit_g6);
        info[6][2] = findViewById(R.id.main_edit_g7);


        done.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {


        if(view == done){
            g=0 ;
            earnedCredit=0 ;
            totalCredit=0 ;



            earnedCredit = 0 ;
            for(int i=0 ; i<7 ; i++){
                for(int j=0 ; j<3 ; j++){
                    data[i][j] = info[i][j].getText().toString();

                }
            }

            for(int i=0 ; i<7 ; i++){
            if(!(data[i][1].equals(""))) {
                totalCredit += Integer.parseInt(data[i][1]);
            }
            }


            for(int i=0 ; i<7 ; i++){
                if(data[i][2].equals("A") || data[i][2].equals("a") || data[i][2].equals("a+") || data[i][2].equals("A+")) {
                   earnedCredit += (4.0 * Integer.parseInt(data[i][1])) ;
                }
                else if(data[i][2].equals("A-") || data[i][2].equals("a-")) {
                    earnedCredit += (3.67 * Integer.parseInt(data[i][1])) ;
                }
                else if(data[i][2].equals("B+") || data[i][2].equals("b+")) {
                    earnedCredit += (3.33 * Integer.parseInt(data[i][1])) ;
                }
                else if(data[i][2].equals("B") || data[i][2].equals("b")) {
                    earnedCredit += (3.0 * Integer.parseInt(data[i][1])) ;
                }
                else if(data[i][2].equals("B-") || data[i][2].equals("B-")) {
                    earnedCredit += (2.67 * Integer.parseInt(data[i][1])) ;
                }
                else if(data[i][2].equals("C+") || data[i][2].equals("c+")) {
                    earnedCredit += (2.33 * Integer.parseInt(data[i][1])) ;
                }
                else if(data[i][2].equals("C") || data[i][2].equals("c")) {
                    earnedCredit += (2.0 * Integer.parseInt(data[i][1])) ;
                }
                else if(data[i][2].equals("C-") || data[i][2].equals("C-")) {
                    earnedCredit += (1.67 * Integer.parseInt(data[i][1])) ;
                }
                else if(data[i][2].equals("D+") || data[i][2].equals("d+")) {
                    earnedCredit += (1.33 * Integer.parseInt(data[i][1])) ;
                }
                else if(data[i][2].equals("D") || data[i][2].equals("d")) {
                    earnedCredit += (1.0 * Integer.parseInt(data[i][1])) ;
                }
                else if(data[i][2].equals("F") || data[i][2].equals("f")) {
                    earnedCredit += (0.0 * Integer.parseInt(data[i][1])) ;
                }

            }
            DecimalFormat df2 = new DecimalFormat(".##");
            g=0 ;
            g = (earnedCredit/totalCredit);
           // earnedCredit=0 ;
            gpa.setText("GPA : " + df2.format(g));





        }


    }
    public void clickexit(View v){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
