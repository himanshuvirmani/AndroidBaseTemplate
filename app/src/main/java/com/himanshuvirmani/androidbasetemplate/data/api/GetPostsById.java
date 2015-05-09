package com.himanshuvirmani.androidbasetemplate.data.api;

import com.android.volley.GsonRequest;
import com.android.volley.Response;
import com.himanshuvirmani.androidbasetemplate.data.Config;
import com.himanshuvirmani.androidbasetemplate.data.entity.Post;

/**
 * Created by himanshu.virmani on 09/05/15.
 */
public class GetPostsById extends GsonRequest<Post> {

  public GetPostsById(Response.Listener<Post> listener, Response.ErrorListener errorListener,
      int id) {
    super(Method.GET, Config.BASE_URL + Config.GET_POST_BY_ID.replace("<ID>", String.valueOf(id)),
        Post.class, listener, errorListener);
  }
}
