package com.apptcom.athletes.Model.Data;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Athlete implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("brief")
    @Expose
    private String brief;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }


    protected Athlete(Parcel in) {
        name = in.readString();
        image = in.readString();
    }

    public static final Creator<Athlete> CREATOR = new Creator<Athlete>() {
        @Override
        public Athlete createFromParcel(Parcel in) {
            return new Athlete(in);
        }

        @Override
        public Athlete[] newArray(int size) {
            return new Athlete[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(name);
        out.writeString(image);
    }

}