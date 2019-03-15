package app.tfkproject.objekwisatabatam.util.jarak;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by taufik on 22/04/18.
 */

public class OverviewPolyline {

    @SerializedName("points")
    @Expose
    private String points;

    /**
     *
     * @return
     * The points
     */
    public String getPoints() {
        return points;
    }

    /**
     *
     * @param points
     * The points
     */
    public void setPoints(String points) {
        this.points = points;
    }

}