import java.text.SimpleDateFormat;
import java.util.*;

public class HelloCity {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat format = new SimpleDateFormat("HH");

        System.out.println("Enter your city name");

        String cityName = scanner.nextLine();

        String cityLocale = MyUtils.getCityLocale(cityName);

        format.setTimeZone(TimeZone.getTimeZone(cityLocale));

        System.out.println(MyUtils.sayHello(Integer.parseInt(format.format(Calendar.getInstance(TimeZone.getTimeZone(cityLocale)).getTime()))) + MyUtils.formatCityName(cityName) + "!");
    }
}
