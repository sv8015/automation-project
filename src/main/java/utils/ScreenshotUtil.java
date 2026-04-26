package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static String capture(String testName) {
        try {
            File src = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            String path = "test-output/screenshots/" + testName + ".png";

            FileUtils.copyFile(src, new File(path));
            return path;

        } catch (Exception e) {
            return null;
        }
    }
}
