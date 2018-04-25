package employeetrack.beit.employeetrack;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.EditText;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    TextView tvImei;
    TelephonyManager telephonyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        telephonyManager=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        tvImei=(TextView)findViewById(R.id.tvImei);

        tvImei.setText(telephonyManager.getImei());
    }
}
