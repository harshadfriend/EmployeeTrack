package employeetrack.beit.employeetrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class EmployeeList extends AppCompatActivity {

    ListView lvEmployee;
    String emplist[]={"Emp1","Emp2","Emp3","Emp4","Emp5","Emp6","Emp7","Emp8","Emp9"};
    ArrayAdapter<String> adp;
    Firebase firebase;
    String dburl="https://employeetracking-1caec.firebaseio.com/";
    DatabaseReference dbRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        Firebase.setAndroidContext(this);
        firebase=new Firebase(dburl);

        dbRef = FirebaseDatabase.getInstance().getReference();

        lvEmployee=(ListView)findViewById(R.id.lvEmployee);
        adp=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adp.setNotifyOnChange(true);
        lvEmployee.setAdapter(adp);

        Query q=dbRef.child("employee");
        q.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data:dataSnapshot.getChildren()){
                    fbase f=data.getValue(fbase.class);
                    adp.add(f.getName()+"\n"+f.getAddress()+"\n"+f.getMobile());
                }
                lvEmployee.setAdapter(adp);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        lvEmployee.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MapsActivity.Name=String.valueOf(parent.getItemAtPosition(position));
                startActivity(new Intent(getApplicationContext(),MapsActivity.class));
                //Toast.makeText(EmployeeList.this, "test"+parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
