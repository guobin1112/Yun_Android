package com.yuncool.yun_android.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Black on 2016/5/7.
 */
public class DocumentModel implements Parcelable {
    public int documentType;
    public String documentTitle;
    public String documentDetail;
    public String publicDate;
    public String publicMonth;

    public DocumentModel(int documentType, String documentTitle, String documentDetail, String publicDate, String publicMonth) {
        this.documentType = documentType;
        this.documentTitle = documentTitle;
        this.documentDetail = documentDetail;
        this.publicDate = publicDate;
        this.publicMonth = publicMonth;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.documentType);
        dest.writeString(this.documentTitle);
        dest.writeString(this.documentDetail);
        dest.writeString(this.publicDate);
        dest.writeString(this.publicMonth);
    }

    protected DocumentModel(Parcel in) {
        this.documentType = in.readInt();
        this.documentTitle = in.readString();
        this.documentDetail = in.readString();
        this.publicDate = in.readString();
        this.publicMonth = in.readString();
    }

    public static final Parcelable.Creator<DocumentModel> CREATOR = new Parcelable.Creator<DocumentModel>() {
        @Override
        public DocumentModel createFromParcel(Parcel source) {
            return new DocumentModel(source);
        }

        @Override
        public DocumentModel[] newArray(int size) {
            return new DocumentModel[size];
        }
    };
}
