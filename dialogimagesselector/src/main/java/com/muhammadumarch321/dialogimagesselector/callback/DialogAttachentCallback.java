package com.muhammadumarch321.dialogimagesselector.callback;

import android.content.Intent;
import android.graphics.Bitmap;

import java.io.File;

public interface DialogAttachentCallback {
    void onSuccess(File originalFile, File compressedFile);
    void onSuccess(Bitmap originalFileBitmap, Bitmap compressedFileBitmap);
    void onFailure(String error);
    void onClick(Intent intent, int id);

}
