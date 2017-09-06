package neelima.sonal.prajapati.virtual;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by RACHOLSAN  NIRMAL on 04-12-2016.
 */

public class MySingleton {
    private static MySingleton myinstance;
    private static Context mCtx;
    private RequestQueue requestQueue;

    private MySingleton(Context context) {

        mCtx = context;
        requestQueue = getRequestQueue();
    }

    private RequestQueue getRequestQueue() {

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized MySingleton getMyinstance(Context context) {
        if (myinstance == null) {
            myinstance = new MySingleton(context);
        }
        return myinstance;
    }
public<T> void addTORequestque(Request<T> request){
    getRequestQueue().add(request);
}
}
