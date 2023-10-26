package mpdam.p1.news;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

public class News implements Parcelable {
    private Integer image;
    private String title;

    public News(Integer image, String title) {
        this.image = image;
        this.title = title;
    }

    protected News(Parcel in) {
        image = in.readInt();
        title = in.readString();
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(title);
    }

    public Integer getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
