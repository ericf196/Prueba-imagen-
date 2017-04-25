package com.rm.Sign;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Eric Freitez on 21/04/2017.
 */

public class Save {

    private Context TheThis;
    private String NameOfFolder = "/prueba";
    private String NameOfFile   = "APaintImage";

    public Save(Context context,Bitmap ImageToSave){

        context =this.TheThis;
        String file_path = Environment.getExternalStorageDirectory().getAbsolutePath()+NameOfFolder;
        Log.i("pintando",file_path);
        String CurrentDateAndTime= getCurrentDateAndTime();
        File dir = new File(file_path);

        if(!dir.exists()){
            dir.mkdirs();

        }

        File file = new File(dir, NameOfFile +CurrentDateAndTime+ ".jpg");

        try {
            FileOutputStream fOut = new FileOutputStream(file);

            addDigitalSign(ImageToSave);

            ImageToSave.compress(Bitmap.CompressFormat.JPEG, 50, fOut);
            fOut.flush();
            fOut.close();
            //MakeSureFileWasCreatedThenMakeAvabile(file);
            //AbleToSave();

        }
        catch (FileNotFoundException e) {
            Log.i("pintando","existe 12");
            //UnableToSave();
        }
        catch (IOException e){
            Log.i("pintando","existe 13");
            //UnableToSave();
        }

    }


    private void addDigitalSign(Bitmap ImageToSave) { //Agregue yo
        Canvas c = new Canvas(ImageToSave);
        Paint p = new Paint();
        //p.setColor(TheThis.getResources().getColor(R.color.colorPrimaryDark));
        p.setTextSize(25);
        //c.drawTextRun("Firma Digital", 1, 7, 2, 8, 10, 80, false, p);
        c.drawText("Firma Digital " + getCurrentDateAndTime(), 0, 70, p);

    }


    private void MakeSureFileWasCreatedThenMakeAvabile(File file) {
        MediaScannerConnection.scanFile(TheThis,
                new String[] { file.toString() }, null,
                new MediaScannerConnection.OnScanCompletedListener() {
                    public void onScanCompleted(String path, Uri uri) {
                        Log.e("ExternalStorage", "Scanned " + path + ":");
                        Log.e("ExternalStorage", "-> uri=" + uri);

                    }
                });

    }

    private String getCurrentDateAndTime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }


    private void UnableToSave() {
        Toast.makeText(TheThis, "Picture cannot to gallery", Toast.LENGTH_SHORT).show();

    }

    private void AbleToSave() {
        Toast.makeText(TheThis, "Picture saved be saved", Toast.LENGTH_SHORT).show();

    }
}

