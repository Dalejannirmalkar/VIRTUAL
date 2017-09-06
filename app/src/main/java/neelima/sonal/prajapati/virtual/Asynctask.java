package neelima.sonal.prajapati.virtual;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by DALEJAN1 on 3/3/2017.
 */

public class Asynctask extends AsyncTask<String, String, String> {
    URLConnection conn;
    BufferedReader bufferedReader;
    String data;
    static String header;
    String result;
    static String sem;

    @Override
    protected String doInBackground(String... params) {
        try {
            data = URLEncoder.encode("header", "UTF-8")
                    + "=" + URLEncoder.encode(header.toLowerCase(), "UTF-8");
            data += "&" + URLEncoder.encode("sem", "UTF-8") + "="
                    + URLEncoder.encode(sem, "UTF-8");
            URL url = new URL(params[0]);
            conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();
            bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
            }

            result = sb.toString();

        } catch (Exception e) {
        }
        return result;
    }
}
