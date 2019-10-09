package com.MuhammadUmarch321.dialogimageselector;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.muhammadumarch321.dialogimagesselector.callback.DialogAttachentCallback;
import com.muhammadumarch321.dialogimagesselector.selector.DialogImageSelector;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private DialogImageSelector dialogImageSelector;
    private ImageView originalIv, compressedIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        originalIv = findViewById(R.id.originalIv);
        compressedIv = findViewById(R.id.compressedIv);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(v -> {
            dialogImageSelector = DialogImageSelector.make(this).setCallback(new DialogAttachentCallback() {
                @Override
                public void onSuccess(File originalFile, File compressedFile) {

                }

                @Override
                public void onSuccess(Bitmap originalFileBitmap, Bitmap compressedFileBitmap) {
                    if (originalFileBitmap != null) {
                        originalIv.setImageBitmap(originalFileBitmap);
                    }
                    if (compressedFileBitmap != null) {
                        compressedIv.setImageBitmap(compressedFileBitmap);
                    }

                }

                @Override
                public void onFailure(String error) {
                    Toast.makeText(MainActivity.this,error,Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onClick(Intent intent, int id) {
                    startActivityForResult(intent, id);
                }
            }).show();
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        dialogImageSelector.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        dialogImageSelector.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
