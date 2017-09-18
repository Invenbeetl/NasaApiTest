package helpers;

import dto.PhotoDTO;

import java.util.List;

public class PhotosDataComparisionHelper {

    public boolean arePhotosDataFromListsEqual (List<PhotoDTO> firstList, List<PhotoDTO> secondList) {
        for (int i = 0; i < firstList.size(); i++) {
            if (!firstList.get(i).equals(secondList.get(i))) {
                return false;
            }
        }
        return true;
    }
}
