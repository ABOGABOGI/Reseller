package com.sell.reseller.server;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;

/**
 * Created by Gerbage on 8/31/2016.
 */
public class JSONParser {
    static InputStream is = null;
    static JSONObject jObj = null;

    private static String server = "http://192.168.100.92:8069";
    private static String serverURL = server + "/";

    public JSONParser (){
    }

    public JSONObject getJSONFromUrl (JSONObject object, String PathUrl){
        Log.d("JSONServer","json req : " + object.toString());
        Log.d("JSONServer","server : " + serverURL + PathUrl);

        try {
            HttpPost httpPost = new HttpPost(serverURL + PathUrl);
            HttpParams httpParams = new BasicHttpParams();
            int timeOutConnection = 60000;
            HttpConnectionParams.setConnectionTimeout(httpParams, timeOutConnection);

            int timeOutSocket = 90000;
            HttpConnectionParams.setSoTimeout(httpParams,timeOutSocket);

            DefaultHttpClient httpClient = new DefaultHttpClient(httpParams);

            StringEntity se = new StringEntity(object.toString());
            httpPost.setEntity(se);

            httpPost.setHeader("Accept", "Application/json");
            httpPost.setHeader("Count-type", "Application/json");

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"ISO-8859-1"),8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null){
                sb.append(line + "\n");
            }
            is.close();
            Log.e("JSONParser", "json hasil: " + sb.toString());
            jObj = new JSONObject(sb.toString());

        }catch (UnknownHostException e){
            return setMessage(e.getMessage().toString());
        }catch (JSONException e) {
            return setMessage(e.getMessage().toString());
        }catch (ClientProtocolException e) {
            return setMessage(e.getMessage().toString());
        }catch (UnsupportedEncodingException e) {
            return setMessage(e.getMessage().toString());
        }catch (IOException e) {
            return setMessage(e.getMessage().toString());
        }catch (NullPointerException e){
            return setMessage(e.getMessage().toString());
        }catch (Exception e){
            return setMessage(e.getMessage().toString());
        }
        return jObj;
    }

    private JSONObject setMessage (String msg){
        JSONObject object = new JSONObject();
        try{
            object.put("rc","ERROR");
            object.put("txndesc" ,msg.replaceFirst(server,"server"));
        }catch (JSONException e){
            Log.d("txnrc",msg);
        }
        return object;
    }
}
