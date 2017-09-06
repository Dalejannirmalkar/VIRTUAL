package neelima.sonal.prajapati.virtual;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
    String header;
    Button sem1, sem2, sem3, sem4, sem5, sem6, sem7, sem8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent i1 = getIntent();
        header = i1.getStringExtra("header");
        setTitle(header);
        sem1 = (Button) findViewById(R.id.sem1);
        sem2 = (Button) findViewById(R.id.sem2);
        sem3 = (Button) findViewById(R.id.sem3);
        sem4 = (Button) findViewById(R.id.sem4);
        sem5 = (Button) findViewById(R.id.sem5);
        sem6 = (Button) findViewById(R.id.sem6);
        sem7 = (Button) findViewById(R.id.sem7);
        sem8 = (Button) findViewById(R.id.sem8);
        sem1.setOnClickListener(this);
        sem2.setOnClickListener(this);
        sem3.setOnClickListener(this);
        sem4.setOnClickListener(this);
        sem5.setOnClickListener(this);
        sem6.setOnClickListener(this);
        sem7.setOnClickListener(this);
        sem8.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sem1:
                Intent i1=new Intent(Main3Activity.this,Working.class);
                i1.putExtra("sem","1");
                i1.putExtra("header",header);
                startActivity(i1);
                break;
            case R.id.sem2:
                Intent i2=new Intent(Main3Activity.this,Working.class);
                i2.putExtra("sem","2");
                i2.putExtra("header",header);
                startActivity(i2);

                break;
            case R.id.sem3:
                Intent i3=new Intent(Main3Activity.this,Working.class);
                i3.putExtra("sem","3");
                i3.putExtra("header",header);
                startActivity(i3);

                break;
            case R.id.sem4:
                Intent i4=new Intent(Main3Activity.this,Working.class);
                i4.putExtra("sem","4");
                i4.putExtra("header",header);
                startActivity(i4);

                break;
            case R.id.sem5:
                Intent i5=new Intent(Main3Activity.this,Working.class);
                i5.putExtra("sem","5");
                i5.putExtra("header",header);
                startActivity(i5);

                break;
            case R.id.sem6:
                Intent i6=new Intent(Main3Activity.this,Working.class);
                i6.putExtra("sem","6");
                i6.putExtra("header",header);
                startActivity(i6);

                break;
            case R.id.sem7:
                Intent i7=new Intent(Main3Activity.this,Working.class);
                i7.putExtra("sem","7");
                i7.putExtra("header",header);
                startActivity(i7);

                break;
            case R.id.sem8:
                Intent i8=new Intent(Main3Activity.this,Working.class);
                i8.putExtra("sem","8");
                i8.putExtra("header",header);
                startActivity(i8);

                break;
        }

    }
}
