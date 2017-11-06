package com.yalantis.ucrop.model;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Oleksii Shliama [https://github.com/shliama] on 6/21/16.
 */
public class ImageState implements Parcelable {

    private RectF mCropRect;
    private RectF mCurrentImageRect;

    private float mCurrentScale, mCurrentAngle;

    public ImageState(RectF cropRect, RectF currentImageRect, float currentScale, float currentAngle) {
        mCropRect = cropRect;
        mCurrentImageRect = currentImageRect;
        mCurrentScale = currentScale;
        mCurrentAngle = currentAngle;
    }

    private ImageState(Parcel in) {

        float[] cropRect = new float[4];
        float[] currentImageRect = new float[4];
        in.readFloatArray(cropRect);
        in.readFloatArray(currentImageRect);

        mCropRect = new RectF(cropRect[0], cropRect[1], cropRect[2], cropRect[3]);
        mCurrentImageRect = new RectF(currentImageRect[0], currentImageRect[1], currentImageRect[2], currentImageRect[3]);
        mCurrentScale = in.readFloat();
        mCurrentAngle = in.readFloat();

    }

    public RectF getCropRect() {
        return mCropRect;
    }

    public RectF getCurrentImageRect() {
        return mCurrentImageRect;
    }

    public float getCurrentScale() {
        return mCurrentScale;
    }

    public float getCurrentAngle() {
        return mCurrentAngle;
    }

    @Override
    public String toString() {
        return String.format("mCropRect=%s\nmCurrentImageRect=%s\nmCurrentScale=%s\nmCurrentAngle=%s\n",
            mCropRect, mCurrentImageRect, mCurrentScale, mCurrentAngle);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        float[] cropRect = { mCropRect.left, mCropRect.top, mCropRect.right, mCropRect.bottom };
        float[] currentImageRect = { mCurrentImageRect.left, mCurrentImageRect.top, mCurrentImageRect.right, mCurrentImageRect.bottom };
        parcel.writeFloatArray(cropRect);
        parcel.writeFloatArray(currentImageRect);
        parcel.writeFloat(mCurrentScale);
        parcel.writeFloat(mCurrentAngle);
    }

    public static final Parcelable.Creator<ImageState> CREATOR =
        new Parcelable.Creator<ImageState>() {
            public ImageState createFromParcel(Parcel in) {
                return new ImageState(in);
            }

            public ImageState[] newArray(int size) {
                return new ImageState[size];
            }
        };

}
