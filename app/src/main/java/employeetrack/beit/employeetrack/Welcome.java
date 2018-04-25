package employeetrack.beit.employeetrack;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Snackbar.make(findViewById(android.R.id.content),"Login Successful !",Snackbar.LENGTH_LONG).show();
        new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                finish();
                Intent i=new Intent(Welcome.this,HomeActivity.class);
          /*      i.putExtra("name",name);
                i.putExtra("mobile",mobile);
                i.putExtra("address",address);
                i.putExtra("imei",imei);*/
                startActivity(i);
            }
        }.start();
    }
}
