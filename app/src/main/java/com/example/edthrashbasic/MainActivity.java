package com.example.edthrashbasic;

import android.annotation.SuppressLint;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText avgFirstNote;
    private EditText avgSecondNote;
    private EditText avgThirdNote;
    private TextView avgResult;
    String textResult = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        avgFirstNote = (EditText)findViewById(R.id.avg_noteFirst);
        avgSecondNote = (EditText)findViewById(R.id.avg_noteSecond);
        avgThirdNote = (EditText)findViewById(R.id.avg_noteThird);
        avgResult = (TextView)findViewById(R.id.avg_lblResult);
    }

    //Este metodo realiza la suma
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void EvaluateAverage(View view){
        double firstNote = Double.parseDouble(avgFirstNote.getText().toString());
        double secondNote = Double.parseDouble(avgSecondNote.getText().toString());
        double thirdNote = Double.parseDouble(avgThirdNote.getText().toString());

        DecimalFormat df = new DecimalFormat("#.##");
        double averageNote = Double.valueOf(df.format((firstNote+secondNote+thirdNote)/3));

        if(averageNote >= 3) textResult = "Approved with note: " + averageNote;
        else textResult = "Failed with note: " + averageNote;

        avgResult.setText(textResult);
    }

}