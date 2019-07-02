// Generated code from Butter Knife. Do not modify!
package com.staff.staffapp.faq;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.staff.staffapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProductsActivity_ViewBinding implements Unbinder {
  private ProductsActivity target;

  @UiThread
  public ProductsActivity_ViewBinding(ProductsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProductsActivity_ViewBinding(ProductsActivity target, View source) {
    this.target = target;

    target.mProductsAppbar = Utils.findRequiredViewAsType(source, R.id.appbarId, "field 'mProductsAppbar'", AppBarLayout.class);
    target.mBusinessCv = Utils.findRequiredViewAsType(source, R.id.cardviewBusiness, "field 'mBusinessCv'", CardView.class);
    target.mPersonalCv = Utils.findRequiredViewAsType(source, R.id.cardviewPersonal, "field 'mPersonalCv'", CardView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ProductsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mProductsAppbar = null;
    target.mBusinessCv = null;
    target.mPersonalCv = null;
  }
}
