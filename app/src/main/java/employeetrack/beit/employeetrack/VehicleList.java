package employeetrack.beit.employeetrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VehicleList extends AppCompatActivity {

    ListView lvVehicle;
    String vehiclelist[]={"Vehicle1","Vehicle2","Vehicle3","Vehicle4","Vehicle5","Vehicle6","Vehicle7","Vehicle8","Vehicle9"};
    ArrayAdapter<String> adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_list);

        lvVehicle=(ListView)findViewById(R.id.lvVehicle);
        adp=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,vehiclelist);
        lvVehicle.setAdapter(adp);

        lvVehicle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MapsActivity.Name=String.valueOf(parent.getItemAtPosition(position));
                startActivity(new Intent(getApplicationContext(),MapsActivity.class));
                //Toast.makeText(EmployeeList.this, "test"+parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
