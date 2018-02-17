package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import dto.PhotoDTO;
import helpers.ImagesHelper;
import helpers.NasaRestResponseHelper;
import helpers.PhotosDataComparisionHelper;
import helpers.ReceiveNasaPhotosHelper;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class CuriosityStepDefs {

    private List<PhotoDTO> firstPhotosList;
    private List<PhotoDTO> secondPhotosList;

    private PhotosDataComparisionHelper photosDataComparisionHelper;
    private ReceiveNasaPhotosHelper receiveNasaPhotosHelper;
    private NasaRestResponseHelper nasaRestResponseHelper;
    private ImagesHelper imagesHelper;

    public CuriosityStepDefs(){
        photosDataComparisionHelper = new PhotosDataComparisionHelper();
        receiveNasaPhotosHelper = new ReceiveNasaPhotosHelper();
        nasaRestResponseHelper = new NasaRestResponseHelper();
        imagesHelper = new ImagesHelper();
    }

    @Given("^I want to receive photos from Curiosity by sol date$")
    public void iWantToReceivePhotosFromCuriosityBySolDate(){
        String responseBySolDate = receiveNasaPhotosHelper.getCuriosityPhotosAtSpecifiedSol("1000");
        List<PhotoDTO> photosBySolDateInfo = nasaRestResponseHelper
                .handleRangeOfPhotosFromResponse(responseBySolDate, 0, 10);
        imagesHelper.handleImagesFromList(photosBySolDateInfo);
        this.firstPhotosList = photosBySolDateInfo;
    }

    @And("^I want to receive photos from Curiosity by Earth date$")
    public void iWantToReceivePhotosFromCuriosityByEarthDate(){
        String responseByEarthDate = receiveNasaPhotosHelper.getCuriosityPhotosAtSpecifiedEarthDateBySol("1000");
        List<PhotoDTO> photosByEarthDateInfo = nasaRestResponseHelper
                .handleRangeOfPhotosFromResponse(responseByEarthDate, 0, 10);
        imagesHelper.handleImagesFromList(photosByEarthDateInfo);
        this.secondPhotosList = photosByEarthDateInfo;
    }

    @Then("^I want to compare received photos$")
    public void iWantToCompareReceivedPhotos() {
        assertTrue("Photos in the lists are not equal",
                photosDataComparisionHelper.arePhotosDataFromListsEqual(firstPhotosList, secondPhotosList));
    }

}
