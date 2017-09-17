import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PhotosFromCuriosityTest {
    WebDriver driver;

    @Before
    public void setUp() {
        String pathToProjectRootDir = normalizePathToProjectRootDir();
        System.setProperty("webdriver.chrome.driver", pathToProjectRootDir + "/src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    private String normalizePathToProjectRootDir() {
        String path = System.getProperty("user.dir");
        return path.replace("\\","/");
    }

    @Test
    public void receivePhotosFromCuriosity() {
        driver.get("https://sites.google.com/a/chromium.org/chromedriver/getting-started");

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
