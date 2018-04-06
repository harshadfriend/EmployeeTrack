package employeetrack.beit.employeetrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class AttendanceDetails extends AppCompatActivity {
    ListView lvAttDet;
    ArrayAdapter<String> adp;
    Firebase firebase;
    DatabaseReference dbref;
    String dburl="https://employeetracking-1caec.firebaseio.com/";
    String str="";
    String imei,strTitle,type;
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_details);

        Bundle extras=getIntent().getExtras();
        imei=extras.getString("imei");
        strTitle=extras.getString("title");
        type=extras.getString("type");


        Firebase.setAndroidContext(this);
        dbref= FirebaseDatabase.getInstance().getReference();
        firebase=new Firebase(dburl);

        lvAttDet=findViewById(R.id.lvAttDet);
        adp=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adp.setNotifyOnChange(true);
        lvAttDet.setAdapter(adp);

        tvTitle=findViewById(R.id.tvTitle);
        tvTitle.setText(strTitle);

        if(type.equals("emp")) {
            Query q = dbref.child("employee").child("attendance");
            q.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    adp.clear();
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        if (data.getKey().equals(imei)) {
                            for (DataSnapshot d : data.getChildren()) {
                                str = "";
                                str += "Date: " + d.getKey() + "\n" + "------------------------------";
                                for (DataSnapshot e : d.getChildren()) {
                                    str += "\n" + e.getKey();
                                }
                                str += "\n";
                                adp.add(str);
                            }

                        }
                    }
                    Log.d("studio", str);
                    lvAttDet.setAdapter(adp);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

        if(type.equals("veh")) {
            Query q = dbref.child("vehicle").child("attendance");
            q.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    adp.clear();
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        if (data.getKey().equals(imei)) {
                            for (DataSnapshot d : data.getChildren()) {
                                str = "";
                                str += "Date: " + d.getKey() + "\n" + "------------------------------";
                                for (DataSnapshot e : d.getChildren()) {
                                    str += "\n" + e.getKey();
                                }
                                str += "\n";
                                adp.add(str);
                            }

                        }
                    }
                    Log.d("studio", str);
                    lvAttDet.setAdapter(adp);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}
