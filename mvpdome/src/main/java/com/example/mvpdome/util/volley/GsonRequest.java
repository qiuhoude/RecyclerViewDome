package com.example.mvpdome.util.volley;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2015/7/15.
 */
public class GsonRequest<T> extends Request<T> {

    private final Response.Listener<T> mListener;

    private static Gson mGson = new Gson();

    private Class<T> mClass;
    private TypeToken<T> mTypeToken;


    public GsonRequest(int method, String url, Class<T> clazz, Listener<T> listener,
                       ErrorListener errorListener) {
        super(method, url, errorListener);
        mClass = clazz;
        mListener = listener;
    }

    public GsonRequest(int method, String url, TypeToken<T> typeToken, Listener<T> listener,
                       ErrorListener errorListener) {
        super(method, url, errorListener);
        mTypeToken = typeToken;
        mListener = listener;
    }

    public GsonRequest(String url, Class<T> clazz, Listener<T> listener, ErrorListener errorListener) {
        this(Method.GET, url, clazz, listener, errorListener);
    }

    public GsonRequest(String url, TypeToken<T> typeToken, Listener<T> listener, ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        mTypeToken = typeToken;
        mListener = listener;
    }
    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            Log.d("qiu",jsonString);
            if (mTypeToken == null)
                return Response.success(mGson.fromJson(jsonString, mClass),
                        HttpHeaderParser.parseCacheHeaders(response));
            else
                return (Response<T>) Response.success(mGson.fromJson(jsonString, mTypeToken.getType()),
                        HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T t) {
            mListener.onResponse(t);
    }
}
