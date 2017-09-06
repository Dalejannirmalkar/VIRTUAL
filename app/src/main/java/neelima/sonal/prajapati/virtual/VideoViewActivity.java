package neelima.sonal.prajapati.virtual;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;

/**
 * Created by DALEJAN1 on 3/3/2017.
 */

public class VideoViewActivity extends AppCompatActivity {
 WebView webView;
  //  ProgressDialog pDialog;
    String VideoURL,header;
    Uri video;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoview);
        Intent i1=getIntent();
        header=i1.getStringExtra("header");
        VideoURL="http://www.sonalneelima.esy.es/"+header.toLowerCase()+"/"+i1.getStringExtra("value");
        webView = (WebView) findViewById(R.id.webview);

       /* // Execute StreamVideo AsyncTask

        // Create a progressbar
        pDialog = new ProgressDialog(VideoViewActivity.this);
        // Set progressbar title
        pDialog.setTitle("Android Video Streaming Tutorial");
        // Set progressbar message
        pDialog.setMessage("Buffering...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        // Show progressbar
        pDialog.show();
*/     if(header.equalsIgnoreCase("video")){
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(VideoURL));
            startActivity(browserIntent);
        }
        if(header.equalsIgnoreCase("pdf")||header.equalsIgnoreCase("document")||header.equalsIgnoreCase("others")){
            WebView view = (WebView) findViewById(R.id.webview);
            view.getSettings().setJavaScriptEnabled(true);
            view.getSettings().setPluginState(WebSettings.PluginState.ON);
            view.loadUrl("http://docs.google.com/gview?embedded=true&url="
                    +VideoURL);
        }

        /*      video = Uri.parse(VideoURL);
            videoview.setVideoURI(video);
            // Start the MediaController
            MediaController mediacontroller = new MediaController(this);
            mediacontroller.setAnchorView(videoview);
        mediacontroller.setMediaPlayer(videoview);
            // Get the URL from String VideoURL
            videoview.setMediaController(mediacontroller);
            videoview.start();
*/
        ///videoview.requestFocus();
       /* videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            // Close the progress bar and play the video
            public void onPrepared(MediaPlayer mp) {
                pDialog.dismiss();
                videoview.start();
            }
        });*/
    }
}
