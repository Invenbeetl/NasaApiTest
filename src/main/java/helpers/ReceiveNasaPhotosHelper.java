package helpers;

import util.NasaRestUtil;

public class ReceiveNasaPhotosHelper {

    private static final String CURIOSITY_ROVER_NAME = "curiosity";

    public String getCuriosityPhotosAtSpecifiedSolResponse(String sol) {
        return NasaRestUtil.getPhotosFromSpesifiedRoverBySolDate(CURIOSITY_ROVER_NAME, sol);
    }
}
