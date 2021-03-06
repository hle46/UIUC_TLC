package uiuc.bioassay.tlc;

import android.app.Activity;
import android.app.Application;
import android.os.Environment;
import android.provider.Settings;
import android.view.inputmethod.InputMethodManager;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by meowle on 7/1/15.
 */
public class TLCApplication extends Application {
    static {
        System.loadLibrary("tlc");
    }
    public static final String AUTO_FOCUS = "AUTO_FOCUS";
    public static final String FOLDER_EXTRA = "FOLDER_EXTRA";
    public static final String PARENT_FOLDER_EXTRA = "PARENT_FOLDER_EXTRA";
    public static final String ROOT_FOLDER = Environment.getExternalStorageDirectory() + "/Android/data/uiuc.bioassay.tlc";
    public static final String CURRENT_IDX = "CURRENT_IDX";
    public static final String NUM_CONCS = "NUM_CONCS";
    public static final String DATA = "DATA";

    public static final String LOG_FILE = "result.txt";


    /*----------------------------------------------------------------------------*/
    // If you change the following constants, remmember to change in tlc.h as well
    public static final String AVG_FILE_NAME = "avg.jpg";
    public static final String BG_FOLDER = "bg/";
    public static final String SAMPLE_FOLDER = "sample/";
    public static final int MAX_PICTURE = 8;
    /*----------------------------------------------------------------------------*/

    public static final String PILLS_FOLDER = "pills";

    /* Some helper functions */
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /* Native signatures */
    public native static void cleanFolder(String folder);
    public native static double[] processTLC(String folder);
}
