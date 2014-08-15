package com.eka.Bmi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MyActivity extends Activity {

 //   public String Boy , Kilo ;
    public TextView Vki , Siz, iKgMale , iKgFemale;
    public Button  Hesapla;
    public Double  cm , kg , bmi , idealM, idealF;
    public String index ;
    public ImageView Male , Female , Led;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    //    cm=0.0; kg= 0.0; bmi=0.0; idealM=0.0; idealF=0.0;

        Vki       =(TextView) findViewById(R.id.Vki);
        Siz       =(TextView) findViewById(R.id.Siz);
        iKgMale   =(TextView) findViewById(R.id.Male);
        iKgFemale =(TextView) findViewById(R.id.Female);

        Male      =(ImageView)findViewById(R.id.imgMale);
        Female    =(ImageView)findViewById(R.id.imgFemale);
        Led       =(ImageView)findViewById(R.id.imgLed);

        Hesapla   =(Button)   findViewById(R.id.btnCal);
        Hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Hesaplama();
            Tanimlar();
            Yazdir();
            }
        });

    }



    public void Hesaplama() {
    /*
        Boy  = ((EditText) findViewById(R.id.Boy)).getText().toString();
        Kilo = ((EditText) findViewById(R.id.Kilo)).getText().toString();
        */

        cm  = Double.parseDouble(((EditText) findViewById(R.id.Boy)).getText().toString());
        kg  = Double.parseDouble(((EditText) findViewById(R.id.Kilo)).getText().toString());

         bmi = kg /(Math.pow((cm/100) ,2));
      idealM = cm - 104.0 ;
      idealF = cm - 109.0 ;

    }

    public void Tanimlar() {
             if (bmi>40)   {  index=getText(R.string.siz5).toString() ;    Male.setImageResource(R.drawable.male4);     Female.setImageResource(R.drawable.female4);  Led.setBackgroundResource(R.drawable.red);}
        else if (bmi>30)   {  index=getText(R.string.siz4).toString() ;    Male.setImageResource(R.drawable.male4);     Female.setImageResource(R.drawable.female4);  Led.setBackgroundResource(R.drawable.red);}
        else if (bmi>25)   {  index=getText(R.string.siz3).toString() ;    Male.setImageResource(R.drawable.male3);     Female.setImageResource(R.drawable.female3);  Led.setBackgroundResource(R.drawable.yellow);}
        else if (bmi>18.5) {  index=getText(R.string.siz2).toString() ;    Male.setImageResource(R.drawable.male2);     Female.setImageResource(R.drawable.female2);  Led.setBackgroundResource(R.drawable.green);}
        else if (bmi<18.5) {  index=getText(R.string.siz1).toString() ;    Male.setImageResource(R.drawable.male1);     Female.setImageResource(R.drawable.female1);  Led.setBackgroundResource(R.drawable.yellow);}
    }

    public void Yazdir() {
             Vki.setText(String.valueOf(Double.toString(bmi)));
             Siz.setText(index);
         iKgMale.setText(String.valueOf(Double.toString(idealM)));
       iKgFemale.setText(String.valueOf(Double.toString(idealF)));
    }

}
