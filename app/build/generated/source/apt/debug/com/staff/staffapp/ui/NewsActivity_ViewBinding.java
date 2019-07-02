// Generated code from Butter Knife. Do not modify!
package com.staff.staffapp.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.staff.staffapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NewsActivity_ViewBinding implements Unbinder {
  private NewsActivity target;

  @UiThread
  public NewsActivity_ViewBinding(NewsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NewsActivity_ViewBinding(NewsActivity target, View source) {
    this.target = target;

    target.mAllGeneralNews = Utils.findRequiredViewAsType(source, R.id.allGeneralNews, "field 'mAllGeneralNews'", TextView.class);
    target.mDepartmentNewsButton = Utils.findRequiredViewAsType(source, R.id.departmentNewsButton, "field 'mDepartmentNewsButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NewsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mAllGeneralNews = null;
    target.mDepartmentNewsButton = null;
  }
}
