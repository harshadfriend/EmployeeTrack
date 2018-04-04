package employeetrack.beit.employeetrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class AddEmployee extends AppCompatActivity {

    EditText etEmpName,etEmpAddress,etEmpMobile,etEmpIMEI;
    Button btnAddEmp;

    Firebase firebase;
    String dburl="https://employeetracking-1caec.firebaseio.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        Firebase.setAndroidContext(this);
        firebase=new Firebase(dburl);

        etEmpName=findViewById(R.id.etEmpName);
        etEmpMobile=findViewById(R.id.etEmpMobile);
        etEmpAddress=findViewById(R.id.etEmpAddress);
        etEmpIMEI=findViewById(R.id.etEmpIMEI);
        btnAddEmp=findViewById(R.id.btnAddEmp);

        btnAddEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etEmpName.getText().toString().isEmpty()) etEmpName.setError("Name");
                if(etEmpMobile.getText().toString().isEmpty()) etEmpMobile.setError("Mobile");
                if(etEmpAddress.getText().toString().isEmpty()) etEmpAddress.setError("Address");
                if(etEmpIMEI.getText().toString().isEmpty()) etEmpIMEI.setError("IMEI");

                if(!etEmpName.getText().toString().isEmpty() && !etEmpMobile.getText().toString().isEmpty()
                        && !etEmpAddress.getText().toString().isEmpty() && !etEmpIMEI.getText().toString().isEmpty()) {
                    fbase fb=new fbase();
                    fb.setName(etEmpName.getText().toString());
                    fb.setAddress(etEmpAddress.getText().toString());
                    fb.setMobile(etEmpMobile.getText().toString());
                    fb.setImei(etEmpIMEI.getText().toString());
                    firebase.child("employee").push().setValue(fb);
                    Toast.makeText(AddEmployee.this, "Success", Toast.LENGTH_SHORT).show();
                    onBackPressed();

                }

            }
        });


    }
}
