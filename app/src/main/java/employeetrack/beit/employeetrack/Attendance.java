package employeetrack.beit.employeetrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Attendance extends AppCompatActivity {
    ListView lvAttend;
    ArrayAdapter<String> adp,keyadp;
    Firebase firebase;
    String dburl="https://employeetracking-1caec.firebaseio.com/";
    DatabaseReference dbRef;
    String type="emp";
    Button btnVehAtt,btnEmpAtt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        Firebase.setAndroidContext(this);
        firebase=new Firebase(dburl);

        dbRef = FirebaseDatabase.getInstance().getReference();

        btnVehAtt=findViewById(R.id.btnVehAtt);
        btnEmpAtt=findViewById(R.id.btnEmpAtt);

        lvAttend=(ListView)findViewById(R.id.lvAttend);
        adp=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        keyadp=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adp.setNotifyOnChange(true);
        lvAttend.setAdapter(adp);

        Query q=dbRef.child("employee").child("profile");
        q.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data:dataSnapshot.getChildren()){

                        fbase f=data.getValue(fbase.class);
                        adp.add(f.getName()+" "+f.getAddress()+"\n"+f.getMobile());
                        keyadp.add(f.getImei());
                    Log.d("studio",data.getKey());
                }
                lvAttend.setAdapter(adp);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        lvAttend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                MapsActivity.Name=String.valueOf(parent.getItemAtPosition(position));
                Intent i=new Intent(Attendance.this,AttendanceDetails.class);
                i.putExtra("imei",keyadp.getItem(position));
                i.putExtra("title",parent.getItemAtPosition(position).toString().split(" ")[0]);
                i.putExtra("type",type);
                startActivity(i);
                //Toast.makeText(EmployeeList.this, "test"+parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });

        btnEmpAtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adp.clear();
                type="emp";
                Query q=dbRef.child("employee").child("profile");
                q.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot data:dataSnapshot.getChildren()){

                            fbase f=data.getValue(fbase.class);
                            adp.add(f.getName()+" "+f.getAddress()+"\n"+f.getMobile());
                            keyadp.add(f.getImei());
                            Log.d("studio",data.getKey());
                        }
                        lvAttend.setAdapter(adp);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        btnVehAtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adp.clear();
                type="veh";
                Query q=dbRef.child("vehicle").child("profile");
                q.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot data:dataSnapshot.getChildren()){

                            fbase f=data.getValue(fbase.class);
                            adp.add(f.getName()+" "+f.getAddress()+"\n"+f.getMobile());
                            keyadp.add(f.getImei());
                            Log.d("studio",data.getKey());
                        }
                        lvAttend.setAdapter(adp);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
