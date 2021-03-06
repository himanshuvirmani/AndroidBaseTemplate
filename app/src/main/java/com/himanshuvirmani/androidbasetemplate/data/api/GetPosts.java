package com.himanshuvirmani.androidbasetemplate.data.api;

import com.android.volley.GsonRequest;
import com.android.volley.Response;
import com.himanshuvirmani.androidbasetemplate.data.ApiConfig;
import com.himanshuvirmani.androidbasetemplate.data.entity.Post;
import java.util.List;

/**
 * Created by himanshu.virmani on 09/05/15.
 */
public class GetPosts extends GsonRequest<Void, List<Post>> {

  public GetPosts(Response.Listener<List<Post>> listener, Response.ErrorListener errorListener) {
    super(Method.GET,
        ApiConfig.BASE_URL + ApiConfig.GET_POSTS, listener,
        errorListener);
  }
}
