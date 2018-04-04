package employeetrack.beit.employeetrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
        public void btnLogin_click(View v){
            startActivity(new Intent(this,HomeActivity.class));
            finish();
//            startActivity(new Intent(this,MapsActivity.class));
        }

    }