package employeetrack.beit.employeetrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class AddVehicle extends AppCompatActivity {

    EditText etVehName,etVehAddress,etVehMobile,etVehIMEI;
    Button btnAddVeh;

    Firebase firebase;
    String dburl="https://employeetracking-1caec.firebaseio.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);

        Firebase.setAndroidContext(this);
        firebase=new Firebase(dburl);

        etVehName=findViewById(R.id.etVehName);
        etVehMobile=findViewById(R.id.etVehMobile);
        etVehAddress=findViewById(R.id.etVehAddress);
        etVehIMEI=findViewById(R.id.etVehIMEI);
        btnAddVeh=findViewById(R.id.btnAddVeh);

        btnAddVeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etVehName.getText().toString().isEmpty()) etVehName.setError("Name");
                if(etVehMobile.getText().toString().isEmpty()) etVehMobile.setError("Mobile");
                if(etVehAddress.getText().toString().isEmpty()) etVehAddress.setError("Address");
                if(etVehIMEI.getText().toString().isEmpty()) etVehIMEI.setError("IMEI");

                if(!etVehName.getText().toString().isEmpty() && !etVehMobile.getText().toString().isEmpty()
                        && !etVehAddress.getText().toString().isEmpty() && !etVehIMEI.getText().toString().isEmpty()) {
                    fbase fb=new fbase();
                    fb.setName(etVehName.getText().toString());
                    fb.setAddress(etVehAddress.getText().toString());
                    fb.setMobile(etVehMobile.getText().toString());
                    fb.setImei(etVehIMEI.getText().toString());
                    firebase.child("vehicle").child("profile").child(etVehIMEI.getText().toString()).setValue(fb);
                    Toast.makeText(AddVehicle.this, "Success", Toast.LENGTH_SHORT).show();
                    onBackPressed();

                }

            }
        });
    }
}
