package employeetrack.beit.employeetrack;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);
    }

    public void btnLogin_click(View v) {

        if (etUsername.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin")) {
            startActivity(new Intent(this, Welcome.class));
            finish();
//            startActivity(new Intent(this,MapsActivity.class));
        }
        else
            Snackbar.make(getCurrentFocus(),"Username/Password incorrect !",Snackbar.LENGTH_LONG).show();
    }
}