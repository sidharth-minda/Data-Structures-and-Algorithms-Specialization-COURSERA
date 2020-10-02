import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtils {
    public static void main(String args[]) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        String dateString = localDateTime.format(formatter);
        System.out.println(dateString);
        LocalDateTime time = LocalDateTime.parse(dateString, formatter);
        System.out.println(time);
        System.out.println(new Date(System.currentTimeMillis()));
    }
}
