package id.sch.smktelkom_mlg.privateassignment.xirpl518.updatingmovie.NewestDB;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by yanda on 15/05/2017.
 */

public class NewestDBItem extends SugarRecord implements Serializable  {
    public String imageUrl;
    public String title;
    public String year;

    public NewestDBItem() {
    }

    public NewestDBItem(String imageUrl, String title, String year) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.year = year;
    }
}