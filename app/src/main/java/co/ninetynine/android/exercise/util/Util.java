package co.ninetynine.android.exercise.util;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import co.ninetynine.android.exercise.model.Page;

/**
 * Created by suresh on 5/2/16.
 */
public class Util {

    public static Page getSampleForm(Context context) {
        String jsonString = loadStringFromFile(context, "form.json");
        return new Gson().fromJson(jsonString, Page.class);
    }

    /**
     * Helper method to load a string from a file
     *
     * @param context
     * @param filepath Path to the file
     * @return
     */
    private static String loadStringFromFile(Context context, String filepath) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(filepath);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
