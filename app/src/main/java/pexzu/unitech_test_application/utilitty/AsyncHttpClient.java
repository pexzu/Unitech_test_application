package pexzu.unitech_test_application.utilitty;

import android.content.Context;
import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by Vish on 22/3/2017.
 */
public class AsyncHttpClient extends AsyncTask<Void,Void,String> {
    public ResponseData response;
    private final String urlEndpoint="http://10.1.13.159:9000/";
    private String request;
    private String data;
    private String type;
    public AsyncHttpClient(Context context, String request, String data, String type){

        response = (ResponseData)context;
        this.request = request;
        this.data = data;
        this.type = type;

    }
    @Override
    protected String doInBackground(Void... params) {

        HttpClient getClient = new DefaultHttpClient();
        HttpPost request = new HttpPost(this.urlEndpoint + this.request);
        StringEntity se = null;
        switch (this.type) {

            case "json":
                try {
                    se = new StringEntity(data);
                    request.setEntity(se);
                    request.setHeader("Accept", "application/json");
                    request.setHeader("Content-Type","application/json");
                }
                catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
        }

        String json = null;
        HttpResponse response;
        try {
            response = getClient.execute(request);

            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
            json = reader.readLine();
            //Log.d("HttpTry",json);
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return json;
    }


    @Override
    protected void onPostExecute(String s) {
        response.processRequest(s);
        super.onPostExecute(s);
    }
}