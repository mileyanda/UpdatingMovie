package id.sch.smktelkom_mlg.privateassignment.xirpl518.updatingmovie;

import java.io.Serializable;

/**
 * Created by yanda on 14/05/2017.
 */

public class NewestAdapter implements Serializable {
    private String imageUrl;
    private String title;
    private String year;

    public NewestAdapter(String imageUrl, String title, String year) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.year = year;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }
}