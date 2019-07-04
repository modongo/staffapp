// Generated code from Butter Knife. Do not modify!
package com.staff.staffapp.ui;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.staff.staffapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.mNewsActivityButton = Utils.findRequiredViewAsType(source, R.id.newsActivityButton, "field 'mNewsActivityButton'", CardView.class);
    target.profile_image = Utils.findRequiredViewAsType(source, R.id.profile_image, "field 'profile_image'", ImageView.class);
    target.staffName = Utils.findRequiredViewAsType(source, R.id.staff_name, "field 'staffName'", TextView.class);
    target.jobdescription = Utils.findRequiredViewAsType(source, R.id.jobDescription, "field 'jobdescription'", TextView.class);
    target.signout = Utils.findRequiredViewAsType(source, R.id.clearCache, "field 'signout'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mNewsActivityButton = null;
    target.profile_image = null;
    target.staffName = null;
    target.jobdescription = null;
    target.signout = null;
  }
}
