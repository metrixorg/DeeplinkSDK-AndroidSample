package ir.metrix.deeplink.sample;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import ir.metrix.deeplink.MetrixDeeplink;

public class MetrixApplication extends Application {

    private static final String TAG = "MetrixApplication";

    @Override
    public void onCreate() {
        super.onCreate();

        MetrixDeeplink.setUniversalDeeplinkListener("MetrixSampleCallback", deeplinkData -> {
            Toast.makeText(MetrixApplication.this, "Metrix Deeplink launched.", Toast.LENGTH_LONG).show();
        });

        MetrixDeeplink.setDeferredDeeplinkResponseListener( metrixDeeplinkModel -> {
            Log.d(TAG, "Deferred deeplink listener was called. target: " + metrixDeeplinkModel.getTarget());
            return true;
        });
    }
}
