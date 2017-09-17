import dto.PhotoDTO;
import helpers.NasaRestResponeHelper;
import helpers.ReceiveNasaPhotosHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PhotosFromCuriosityTest {
    WebDriver driver;
    ReceiveNasaPhotosHelper receiveNasaPhotosHelper = new ReceiveNasaPhotosHelper();
    NasaRestResponeHelper nasaRestResponeHelper = new NasaRestResponeHelper();

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
        String response = receiveNasaPhotosHelper.getCuriosityPhotosAtSpecifiedSolResponse("1000");
        System.out.println(response);
        List<PhotoDTO> photosInfo = nasaRestResponeHelper.handleResponseWithPhotoes(response);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
