import dto.PhotoDTO;
import helpers.NasaRestResponseHelper;
import helpers.ReceiveNasaPhotosHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PhotosFromCuriosityTest {
    ReceiveNasaPhotosHelper receiveNasaPhotosHelper = new ReceiveNasaPhotosHelper();
    NasaRestResponseHelper nasaRestResponseHelper = new NasaRestResponseHelper();

    private String normalizePathToProjectRootDir() {
        String path = System.getProperty("user.dir");
        return path.replace("\\","/");
    }

    @Test
    public void receivePhotosFromCuriosity() {
        String photosBySolDateResponse = receiveNasaPhotosHelper.getCuriosityPhotosAtSpecifiedSol("1000");
        List<PhotoDTO> photosBySolDateInfo = nasaRestResponseHelper.handleResponseWithPhotos(photosBySolDateResponse);
        String photosByEarthDateResponse = receiveNasaPhotosHelper.getCuriosityPhotosAtSpecifiedEarthDateBySol("1000");
        List<PhotoDTO> photosByEarthDateInfo = nasaRestResponseHelper.handleResponseWithPhotos(photosByEarthDateResponse);
    }

}
