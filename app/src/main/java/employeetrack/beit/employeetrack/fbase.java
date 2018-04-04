package employeetrack.beit.employeetrack;

/**
 * Created by Dell on 22-Jan-18.
 */

public class fbase {
    private String name;
    private String lat, lon, time;

    public fbase(){
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getlat(){
        return lat;
    }

    public String getlon(){
        return lon;
    }
    public String gettime(){
        return time;
    }


    public void setlat(String lat){ this.lat=lat;   }
    public void setlon(String lon){
        this.lon=lon;
    }
    public void settime(String time){ this.time=time; }

}
