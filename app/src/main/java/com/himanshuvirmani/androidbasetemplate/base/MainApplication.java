package com.himanshuvirmani.androidbasetemplate.base;

import android.app.Application;
import com.himanshuvirmani.androidbasetemplate.BuildConfig;
import com.himanshuvirmani.androidbasetemplate.base.dependencyinjection.components.ApplicationComponent;
import com.himanshuvirmani.androidbasetemplate.base.dependencyinjection.components.DaggerApplicationComponent;
import com.himanshuvirmani.androidbasetemplate.base.dependencyinjection.modules.MainApplicationModule;
import com.himanshuvirmani.androidbasetemplate.base.dependencyinjection.modules.SystemServiceModule;
import com.himanshuvirmani.androidbasetemplate.logger.FileLog;
import com.himanshuvirmani.androidbasetemplate.logger.Log;
import java.io.File;

/**
 * Created by himanshu.virmani on 08/05/15.
 */
public class MainApplication extends Application {

  private ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    applicationComponent = DaggerApplicationComponent.builder()
        .mainApplicationModule(new MainApplicationModule(this))
        .systemServiceModule(new SystemServiceModule(this))
        .build();
    applicationComponent.inject(this);
  }

  public ApplicationComponent component() {
    return applicationComponent;
  }

  private void assignLogger() {
    final int LOG_FILE_SIZE = 1000000; //1mb
    if (BuildConfig.BUILD_TYPE.equals("debug")) {
      FileLog.open("sdcard/" + File.separator + BuildConfig.APPLICATION_ID + ".log"
          , android.util.Log.VERBOSE, LOG_FILE_SIZE); Log.plant(new Log.DebugTree());
    } else if (BuildConfig.BUILD_TYPE.equals("preRelease")) {
      Log.plant(new Log.ErrorWarningTree());
    } else {
      Log.plant(new CrashReportingTree());
    }
  }

  /**
   * A tree which logs important information for crash reporting.
   */
  private static class CrashReportingTree extends Log.HollowTree {
    @Override
    public void i(String message, Object... args) {
      // TODO e.g., Crashlytics.log(String.format(message, args));
    }

    @Override
    public void i(Throwable t, String message, Object... args) {
      i(message, args); // Just add to the log.
    }

    @Override
    public void e(String message, Object... args) {
      i("ERROR: " + message, args); // Just add to the log.
    }

    @Override
    public void e(Throwable t, String message, Object... args) {
      e(message, args);

      // TODO e.g., Crashlytics.logException(t);
    }
  }
}