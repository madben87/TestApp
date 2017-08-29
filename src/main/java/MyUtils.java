import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class MyUtils {

    public static final String MORNING = "morning";
    public static final String DAY = "day";
    public static final String EVENING = "evening";
    public static final String NIGHT = "night";

    public static String getCityLocale(String input) {

        String cityName = formatInput(input);

        String[] arr = TimeZone.getAvailableIDs();

        for (String str : arr) {
            if (str.toLowerCase().contains(cityName.toLowerCase())) {
                return str;
            }
        }

        return "UTC";
    }

    private static String formatInput(String input) {

        char[] arr = input.toCharArray();

        for (int x = 0; x <= input.length()-1; x++) {
            if (arr[x] == ' ') {
                arr[x] = '_';
            }
        }
        return new String(arr);
    }

    public static String sayHello(int time) {

        ResourceBundle bundle = ResourceBundle.getBundle("hello", new Locale(Locale.getDefault().getLanguage()));

        if (time >= 6 && time < 9) {
            return bundle.getString(MORNING);
        }else if (time >= 9 && time < 19) {
            return bundle.getString(DAY);
        }else if (time >= 19 && time < 23) {
            return bundle.getString(EVENING);
        }
        return bundle.getString(NIGHT);
    }

    public static String formatCityName(String input) {

        char[] arr = input.toCharArray();

        arr[0] = Character.toUpperCase(arr[0]);

        for (int x = 0; x <= input.length()-1; x++) {
            if (x > 0 && arr[x-1] == ' ') {
                arr[x] = Character.toUpperCase(arr[x]);
            }
        }
        return new String(arr);
    }
}
