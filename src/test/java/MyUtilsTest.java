import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class MyUtilsTest {

    private static final String NEW_YORK = "America/New_York";
    private static final String UTC = "UTC";
    private static final String MORNING = "morning";
    private static final String DAY = "day";
    private static final String EVENING = "evening";
    private static final String NIGHT = "night";

    final static Logger logger = Logger.getLogger(MyUtilsTest.class);

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        protected void failed(Throwable e, Description description) {
            logger.info("" + description.getDisplayName() + " failed " + e.getMessage());
            super.failed(e, description);
        }

    };

    @Test
    public void testToGetCityLocale() {

        final String actual = MyUtils.getCityLocale("New York");
        assertEquals(NEW_YORK, actual);

        final String actualError = MyUtils.getCityLocale("Dnipro");
        assertEquals(UTC, actualError);

        logger.info("TEST GetCityLocale() IS SUCCESSFUL !");
    }

    @Test
    public void testToFormatInput() {

        final String actual = MyUtils.getCityLocale("new york");
        assertEquals(NEW_YORK, actual);

        logger.info("TEST FormatInput() IS SUCCESSFUL !");
    }

    @Test
    public void testToSayHello() {

        ResourceBundle bundle = ResourceBundle.getBundle("hello", new Locale(Locale.getDefault().getLanguage()));

        assertEquals(bundle.getString(MORNING), MyUtils.sayHello(6));

        for (int time = 6; time < 9; time++) {
            assertEquals(bundle.getString(MORNING), MyUtils.sayHello(time));
        }

        for (int time = 9; time < 19; time++) {
            assertEquals(bundle.getString(DAY), MyUtils.sayHello(time));
        }

        for (int time = 19; time < 23; time++) {
            assertEquals(bundle.getString(EVENING), MyUtils.sayHello(time));
        }

        assertEquals(bundle.getString(NIGHT), MyUtils.sayHello(3));

        logger.info("TEST SayHello() IS SUCCESSFUL !");
    }

    @Test
    public void testToFormatCityName() {

        final String actual = MyUtils.formatCityName("new york");
        final String expected  = "New York";
        assertEquals(expected, actual);

        logger.info("TEST FormatCityName() IS SUCCESSFUL !");
    }
}
