package com.koushikdutta.ion.builder;

import android.app.ProgressDialog;
import android.os.Handler;
import android.widget.ProgressBar;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.ion.ProgressCallback;

/**
* Created by koush on 5/30/13.
*/ // set parameters
public interface RequestBuilder<F, R extends RequestBuilder, M extends MultipartBodyBuilder, U extends UrlEncodedBuilder> extends MultipartBodyBuilder<M>, UrlEncodedBuilder<U> {
    /**
     * Enable logging for this request
     * @param tag LOGTAG to use
     * @param level Log level of messages to display
     * @return
     */
    public R setLogging(String tag, int level);

    /**
     * Route the request through the given proxy server.
     * @param host
     * @param port
     */
    public R proxy(String host, int port);

    /**
     * Specify a callback that is invoked on download progress. This will not be invoked
     * on the UI thread.
     * @param callback
     * @return
     */
    public R progress(ProgressCallback callback);

    /**
     * Specify a callback that is invoked on download progress. This will be invoked
     * on the UI thread.
     * @param callback
     * @return
     */
    public R progressHandler(ProgressCallback callback);

    /**
     * Specify a ProgressBar to update during the request
     * @param progressBar
     * @return
     */
    public R progressBar(ProgressBar progressBar);

    /**
     * Specify a ProgressDialog to update during the request
     * @param progressDialog
     * @return
     */
    public R progressDialog(ProgressDialog progressDialog);

    /**
     * Post the Future callback onto the given handler. Not specifying this explicitly
     * results in the default handle of Thread.currentThread to be used, if one exists.
     * @param handler Handler to use or null
     * @return
     */
    public R setHandler(Handler handler);

    /**
     * Set a HTTP header
     * @param name Header name
     * @param value Header value
     * @return
     */
    public R setHeader(String name, String value);

    /**
     * Add an HTTP header
     * @param name Header name
     * @param value Header value
     * @return
     */
    public R addHeader(String name, String value);

    /**
     * Specify the timeout in milliseconds before the request will cancel.
     * A CancellationException will be returned as the result.
     * @param timeoutMilliseconds Timeout in milliseconds
     * @return
     */
    public R setTimeout(int timeoutMilliseconds);

    /**
     * Provide Basic authentication credentials to be sent with the request.
     * @param username
     * @param password
     * @return
     */
    public R basicAuthentication(String username, String password);

    /**
     * Specify a JsonObject to send to the HTTP server. If no HTTP method was explicitly
     * provided in the load call, the default HTTP method, POST, is used.
     * @param jsonObject JsonObject to send with the request
     * @return
     */
    public F setJsonObjectBody(JsonObject jsonObject);

    /**
     * Specify a JsonObject to send to the HTTP server. If no HTTP method was explicitly
     * provided in the load call, the default HTTP method, POST, is used.
     * @param object Object to serialize with Json and send with the request
     * @param token Type token to assist with generic type serialization
     * @return
     */
    public <T> F setJsonObjectBody(T object, TypeToken<T> token);

    /**
     * Specify a JsonObject to send to the HTTP server. If no HTTP method was explicitly
     * provided in the load call, the default HTTP method, POST, is used.
     * @param object Object to serialize with Json and send with the request
     * @return
     */
    public <T> F setJsonObjectBody(T object);

    /**
     * Specify a JsonArray to send to the HTTP server. If no HTTP method was explicitly
     * provided in the load call, the default HTTP method, POST, is used.
     * @param jsonArray JsonObject to send with the request
     * @return
     */
    public F setJsonArrayBody(JsonArray jsonArray);

    /**
     * Specify a String to send to the HTTP server. If no HTTP method was explicitly
     * provided in the load call, the default HTTP method, POST, is used.
     * @param string String to send with the request
     * @return
     */
    public F setStringBody(String string);
}
