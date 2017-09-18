package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoDTO extends BaseDTO{

    private String id;
    private String photoUri;
    private String earthDate;
    private long photoSize;

}
