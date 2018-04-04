package employeetrack.beit.employeetrack;

/**
 * Created by Dell on 22-Jan-18.
 */

public class fbase {
    private String name,address,imei,mobile;
    private String lat, lon, time;

    public fbase(){
    }
    /*
    public String get(){
        return ;
    }
    public void set(String ){
        this.=;
    }

*/
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }

    public String getImei(){
        return imei;
    }
    public void setImei(String imei){
        this.imei=imei;
    }

    public String getMobile(){
        return mobile;
    }
    public void setMobile(String mobile){
        this.mobile=mobile;
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
