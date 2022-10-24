import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
public class MyDate
{
    //default constructor
    public MyDate ()
    {

    }

    //metod that returns current date/time in a String
    public String getDate ()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
