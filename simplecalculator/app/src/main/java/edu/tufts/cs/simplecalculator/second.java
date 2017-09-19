package edu.tufts.cs.simplecalculator;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class second extends AppCompatActivity implements View.OnClickListener{

    public Button butadd,butsub,butmul,butdiv;
    public TextView cresult;
    public EditText etfirstnumber,etsecondnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        calculate();
    }

    void calculate(){
        butadd = (Button) findViewById(R.id.butadd);
        butsub = (Button)findViewById(R.id.butsubtract);
        butmul = (Button)findViewById(R.id.butmultiply);
        butdiv = (Button)findViewById(R.id.butdivide);
        etfirstnumber = (EditText)findViewById(R.id.etfirstnumber);
        etsecondnumber = (EditText)findViewById(R.id.etsecondnumber);
        cresult = (TextView)findViewById(R.id.cresult);
        butadd.setOnClickListener(this);
        butsub.setOnClickListener(this);
        butmul.setOnClickListener(this);
        butdiv.setOnClickListener(this);
    }

    public void onClick(View view){
        String num1 = etfirstnumber.getText().toString();
        String num2 = etsecondnumber.getText().toString();
        int r;
        switch(view.getId()){
            case R.id.butadd:
                r = Integer.parseInt(num1) + Integer.parseInt(num2);
                cresult.setText(String.valueOf(r));
                break;
            case R.id.butsubtract:
                r = Integer.parseInt(num1) - Integer.parseInt(num2);
                cresult.setText(String.valueOf(r));
                break;
            case R.id.butmultiply:
                r = Integer.parseInt(num1) * Integer.parseInt(num2);
                cresult.setText(String.valueOf(r));
                break;
            case R.id.butdivide:
                try{
                    r = Integer.parseInt(num1) / Integer.parseInt(num2);
                    cresult.setText(String.valueOf(r));
                }catch(Exception e){
                    cresult.setText("Cant divide");
                }
                break;
        }
    }

    public void clickexit(View view){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
