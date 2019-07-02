// Generated code from Butter Knife. Do not modify!
package com.staff.staffapp.faq;

import android.view.View;
import android.widget.ExpandableListView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.staff.staffapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PersonalProductsActivity_ViewBinding implements Unbinder {
  private PersonalProductsActivity target;

  @UiThread
  public PersonalProductsActivity_ViewBinding(PersonalProductsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PersonalProductsActivity_ViewBinding(PersonalProductsActivity target, View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.lvExpandable, "field 'listView'", ExpandableListView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PersonalProductsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
    target.toolbar = null;
  }
}
