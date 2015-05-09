package com.himanshuvirmani.androidbasetemplate.data.api;

import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.himanshuvirmani.androidbasetemplate.data.entity.Post;

/**
 * Created by himanshu.virmani on 09/05/15.
 */
public class ApiManager {

  private RequestQueue mRequestQueue;
  private RequestQueue mImageLoaderQueue;
  private ImageLoader mImageLoader;

  public ApiManager(Context context) {
    mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
    mImageLoaderQueue = Volley.newRequestQueue(context.getApplicationContext()); //not used as of now
  }

  public void getPostById(Response.Listener<Post> listener, Response.ErrorListener errorListener,
      int id) {
    mRequestQueue.add(new GetPostsById(listener,errorListener,id));
  }
}
