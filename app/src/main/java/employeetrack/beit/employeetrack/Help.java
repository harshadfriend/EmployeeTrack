package employeetrack.beit.employeetrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Help extends AppCompatActivity {

    TextView tvProfile,tvTrack,tvAdd,tvSettings,tvAttend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        tvProfile=findViewById(R.id.tvProfile);
        tvTrack=findViewById(R.id.tvTrack);
        tvAdd=findViewById(R.id.tvAdd);
        tvSettings=findViewById(R.id.tvSettings);
        tvAttend=findViewById(R.id.tvAtt);

        if(Settings.i==1){
            tvProfile.setTextSize(15);
            tvAttend.setTextSize(15);
            tvTrack.setTextSize(15);
            tvAdd.setTextSize(15);
            tvSettings.setTextSize(15);
        }
        if(Settings.i==2){
            tvProfile.setTextSize(18);
            tvAttend.setTextSize(18);
            tvAdd.setTextSize(18);
            tvTrack.setTextSize(18);
            tvSettings.setTextSize(18);
        }
        if(Settings.i==3){
            tvProfile.setTextSize(20);
            tvAttend.setTextSize(20);
            tvAdd.setTextSize(20);
            tvTrack.setTextSize(20);
            tvSettings.setTextSize(20);
        }
    }
}
