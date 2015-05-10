package com.himanshuvirmani.androidbasetemplate.base.dependencyinjection.components;

/**
 * Created by himanshu.virmani on 09/05/15.
 */

import android.support.v4.app.Fragment;
import com.himanshuvirmani.androidbasetemplate.base.BaseFragment;
import com.himanshuvirmani.androidbasetemplate.base.dependencyinjection.modules.FragmentModule;
import com.himanshuvirmani.androidbasetemplate.base.dependencyinjection.qualifiers.PerFragment;
import dagger.Component;


@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
  void inject(BaseFragment baseFragment);
  //Exposed to sub-graphs.
  Fragment fragment();
}
