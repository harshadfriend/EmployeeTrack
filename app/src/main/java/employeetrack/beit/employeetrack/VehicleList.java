package employeetrack.beit.employeetrack;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

public class VehicleList extends AppCompatActivity {

    ListView lvVehicle;
  //  String vehiclelist[]={"Vehicle1","Vehicle2","Vehicle3","Vehicle4","Vehicle5","Vehicle6","Vehicle7","Vehicle8","Vehicle9"};
    ArrayAdapter<String> adp;
    Firebase firebase;
    String dburl="https://employeetracking-1caec.firebaseio.com/";
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_list);

        Firebase.setAndroidContext(this);
        firebase=new Firebase(dburl);

        dbRef = FirebaseDatabase.getInstance().getReference();


        lvVehicle=(ListView)findViewById(R.id.lvVehicle);
        adp=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view =super.getView(position, convertView, parent);
                TextView textView=(TextView) view.findViewById(android.R.id.text1);
                if(Settings.i==1){
                    textView.setTextSize(15);
                }
                else if(Settings.i==2){
                    textView.setTextSize(18);
                }
                else
                    textView.setTextSize(20);
            /*YOUR CHOICE OF COLOR*/
                //              textView.setTextColor(Color.WHITE);
//                textView.setTypeface(null, Typeface.BOLD);

                return view;

            }
        };

        adp.setNotifyOnChange(true);
        lvVehicle.setAdapter(adp);

        Query q=dbRef.child("vehicle").child("profile");
        q.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data:dataSnapshot.getChildren()){
                    fbase f=data.getValue(fbase.class);
                    adp.add(f.getName()+" "+f.getAddress()+"\n"+f.getMobile());
                }
                lvVehicle.setAdapter(adp);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        lvVehicle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MapsActivity.Name=String.valueOf(parent.getItemAtPosition(position));
                Intent i=new Intent(VehicleList.this,MapsActivity.class);
                i.putExtra("type","veh");
//                startActivity(new Intent(getApplicationContext(),MapsActivity.class));
                startActivity(i);
//                startActivity(new Intent(getApplicationContext(),MapsActivity.class));
                //Toast.makeText(EmployeeList.this, "test"+parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
