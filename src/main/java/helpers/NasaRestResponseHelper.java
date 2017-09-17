package helpers;

import dto.PhotoDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static util.ParseJsonUtil.getJsonArray;

public class NasaRestResponseHelper {

    public static final String PHOTOS_NODE = "photos";

    public List<PhotoDTO> handleResponseWithPhotos(String response) {
        List<PhotoDTO> photosList = new ArrayList<>();
        JSONArray photosInfoArray = getJsonArray(new JSONObject(response), PHOTOS_NODE);
        for (int i = 0; i < 10; i++) {
            PhotoDTO photoDTO = new PhotoDTO();
            JSONObject innerJson = new JSONObject(photosInfoArray.get(i).toString());
            photoDTO.setId(innerJson.get("id").toString());
            photoDTO.setEarthDate(innerJson.get("earth_date").toString());
            photoDTO.setPhotoUri(innerJson.get("img_src").toString());
            photosList.add(photoDTO);
        }
        return photosList;
    }
}
