package employeetrack.beit.employeetrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class EmployeeList extends AppCompatActivity {

    ListView lvEmployee;
    String emplist[]={"Emp1","Emp2","Emp3","Emp4","Emp5","Emp6","Emp7","Emp8","Emp9"};
    ArrayAdapter<String> adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        lvEmployee=(ListView)findViewById(R.id.lvEmployee);
        adp=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        lvEmployee.setAdapter(adp);

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
