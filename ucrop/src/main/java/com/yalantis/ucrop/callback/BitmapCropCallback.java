package com.yalantis.ucrop.callback;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.yalantis.ucrop.model.ImageState;

public interface BitmapCropCallback {

    void onBitmapCropped(@NonNull Uri resultUri, @NonNull ImageState imageState, int offsetX, int offsetY, int imageWidth, int imageHeight);

    void onCropFailure(@NonNull Throwable t);

}