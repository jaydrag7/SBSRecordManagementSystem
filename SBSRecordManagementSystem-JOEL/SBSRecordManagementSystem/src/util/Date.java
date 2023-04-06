package src.util;

public class Date {

    public String getTime(){
        String[] time=java.time.LocalDateTime.now().toString().split("-|\\:|\\.");
        String year=time[0];
        String month=time[1];
        String day= time[2].split("T")[0];
        String hour=time[2].split("T")[1];
        String minutes=time[3];
        return year+"/"+month+"/"+day+"- "+hour+":"+minutes;
    }
    
}
