package employeetrack.beit.employeetrack;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.client.Firebase;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Date;

public class HomeActivity extends AppCompatActivity {
    String dburl="https://employeetracking-1caec.firebaseio.com/";
    Button btnTrackVeh, btnTrackEmp,btnProfile,btnAttendance,btnAddEmp,btnAddVeh,btnHelp,btnSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

      //  Snackbar.make(findViewById(android.R.id.content),"Login Successful !",Snackbar.LENGTH_LONG).show();

        btnTrackEmp=(Button)findViewById(R.id.btnTrackEmp);
        btnTrackVeh=(Button)findViewById(R.id.btnTrackVeh);
        btnProfile=findViewById(R.id.btnProfile);
        btnAttendance=findViewById(R.id.btnAttnd);
        btnAddEmp=findViewById(R.id.btnAddEmp);
        btnAddVeh=findViewById(R.id.btnAddVeh);
        btnHelp=findViewById(R.id.btnHelp);
        btnSettings=findViewById(R.id.btnSettings);

        if(employeetrack.beit.employeetrack.Settings.i==1){
            btnProfile.setTextSize(15);
            btnAttendance.setTextSize(15);
            btnTrackEmp.setTextSize(15);
            btnTrackVeh.setTextSize(15);
            btnHelp.setTextSize(15);
            btnSettings.setTextSize(15);
            btnAddEmp.setTextSize(15);
            btnAddVeh.setTextSize(15);
        }

        if(employeetrack.beit.employeetrack.Settings.i==3){
            btnProfile.setTextSize(20);
            btnAttendance.setTextSize(20);
            btnTrackEmp.setTextSize(20);
            btnTrackVeh.setTextSize(20);
            btnHelp.setTextSize(20);
            btnSettings.setTextSize(20);
            btnAddEmp.setTextSize(20);
            btnAddVeh.setTextSize(20);
        }

       btnTrackEmp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(HomeActivity.this,EmployeeList.class));
           }
       });
       btnTrackVeh.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(HomeActivity.this,VehicleList.class));
           }
       });
       btnProfile.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(HomeActivity.this,Profile.class));
           }
       });
       btnAttendance.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(HomeActivity.this,Attendance.class));
           }
       });
       btnAddEmp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(HomeActivity.this,AddEmployee.class));
           }
       });

       btnAddVeh.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(HomeActivity.this,AddVehicle.class));
           }
       });
       btnHelp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(HomeActivity.this,Help.class));
           }
       });
       btnSettings.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
               startActivity(new Intent(HomeActivity.this, employeetrack.beit.employeetrack.Settings.class));
           }
       });

        Firebase.setAndroidContext(this);
        final Firebase fbref=new Firebase(dburl);
        final fbase obj=new fbase();

        //obj.setName("");
        obj.settime(DateFormat.getDateTimeInstance().format(new Date()));
        obj.setlat("dd");
        obj.setlon("k");
        //fbref.child("Employee").child("emp1").setValue(obj);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setTitle("Exit ?")
                .setMessage("Are you sure, you want to exit ?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).show();
    }
}
