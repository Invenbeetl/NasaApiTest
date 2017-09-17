import dto.PhotoDTO;
import helpers.ImagesHelper;
import helpers.NasaRestResponseHelper;
import helpers.PhotosDataComparisionHelper;
import helpers.ReceiveNasaPhotosHelper;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class PhotosFromCuriosityTest {

    ReceiveNasaPhotosHelper receiveNasaPhotosHelper = new ReceiveNasaPhotosHelper();
    NasaRestResponseHelper nasaRestResponseHelper = new NasaRestResponseHelper();
    ImagesHelper imagesHelper = new ImagesHelper();
    PhotosDataComparisionHelper photosDataComparisionHelper = new PhotosDataComparisionHelper();

    @Test
    public void photosFromTwoApiCallsShouldBeEqual() {
        List<PhotoDTO> photosBySolDateInfo = getPhotosWithInfoBySolDate();
        List<PhotoDTO> photosByEarthDateInfo = getPhotosWithInfoByEarthDate();
        assertTrue("Photos in the lists are not equal",
                photosDataComparisionHelper.arePhotosDataFromListsEqual(photosBySolDateInfo, photosByEarthDateInfo));
    }

    private List<PhotoDTO> getPhotosWithInfoByEarthDate() {
        String responseByEarthDate = receiveNasaPhotosHelper.getCuriosityPhotosAtSpecifiedEarthDateBySol("1000");
        List<PhotoDTO> photosByEarthDateInfo = nasaRestResponseHelper
                .handleRangeOfPhotosFromResponse(responseByEarthDate, 0, 10);
        imagesHelper.handleImagesFromList(photosByEarthDateInfo);
        return photosByEarthDateInfo;
    }

    private List<PhotoDTO> getPhotosWithInfoBySolDate() {
        String responseBySolDate = receiveNasaPhotosHelper.getCuriosityPhotosAtSpecifiedSol("1000");
        List<PhotoDTO> photosBySolDateInfo = nasaRestResponseHelper
                .handleRangeOfPhotosFromResponse(responseBySolDate, 0, 10);
        imagesHelper.handleImagesFromList(photosBySolDateInfo);
        return photosBySolDateInfo;
    }

}
