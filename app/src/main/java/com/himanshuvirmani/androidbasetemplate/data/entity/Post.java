package com.himanshuvirmani.androidbasetemplate.data.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by himanshu.virmani on 09/05/15.
 */
@Getter
@Setter
public class Post {

  @SerializedName("userId")
  private int userId;

  private int id;

  private String title;

  private String body;
}
