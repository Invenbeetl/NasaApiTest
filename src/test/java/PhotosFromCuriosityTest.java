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
    public void receivePhotosFromCuriosity() {
        String photosBySolDateResponse = receiveNasaPhotosHelper.getCuriosityPhotosAtSpecifiedSol("1000");
        List<PhotoDTO> photosBySolDateInfo = nasaRestResponseHelper.handleResponseWithPhotos(photosBySolDateResponse);
        imagesHelper.handleImagesFromList(photosBySolDateInfo);
        String photosByEarthDateResponse = receiveNasaPhotosHelper.getCuriosityPhotosAtSpecifiedEarthDateBySol("1000");
        List<PhotoDTO> photosByEarthDateInfo = nasaRestResponseHelper.handleResponseWithPhotos(photosByEarthDateResponse);
        imagesHelper.handleImagesFromList(photosByEarthDateInfo);
        assertTrue("Photos in the lists are not equal",
                photosDataComparisionHelper.arePhotosDataFromListsEqual(photosBySolDateInfo, photosByEarthDateInfo));
    }

}
