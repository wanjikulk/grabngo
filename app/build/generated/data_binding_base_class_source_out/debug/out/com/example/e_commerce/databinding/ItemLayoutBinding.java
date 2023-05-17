// Generated by view binder compiler. Do not edit!
package com.example.e_commerce.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.e_commerce.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemLayoutBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button mBtnBuy;

  @NonNull
  public final EditText mEdtQuantity;

  @NonNull
  public final ImageView mImgPic;

  @NonNull
  public final TextView mTvColor;

  @NonNull
  public final TextView mTvModel;

  @NonNull
  public final TextView mTvPrice;

  @NonNull
  public final TextView mTvRegNo;

  private ItemLayoutBinding(@NonNull LinearLayout rootView, @NonNull Button mBtnBuy,
      @NonNull EditText mEdtQuantity, @NonNull ImageView mImgPic, @NonNull TextView mTvColor,
      @NonNull TextView mTvModel, @NonNull TextView mTvPrice, @NonNull TextView mTvRegNo) {
    this.rootView = rootView;
    this.mBtnBuy = mBtnBuy;
    this.mEdtQuantity = mEdtQuantity;
    this.mImgPic = mImgPic;
    this.mTvColor = mTvColor;
    this.mTvModel = mTvModel;
    this.mTvPrice = mTvPrice;
    this.mTvRegNo = mTvRegNo;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.mBtnBuy;
      Button mBtnBuy = ViewBindings.findChildViewById(rootView, id);
      if (mBtnBuy == null) {
        break missingId;
      }

      id = R.id.mEdtQuantity;
      EditText mEdtQuantity = ViewBindings.findChildViewById(rootView, id);
      if (mEdtQuantity == null) {
        break missingId;
      }

      id = R.id.mImgPic;
      ImageView mImgPic = ViewBindings.findChildViewById(rootView, id);
      if (mImgPic == null) {
        break missingId;
      }

      id = R.id.mTvColor;
      TextView mTvColor = ViewBindings.findChildViewById(rootView, id);
      if (mTvColor == null) {
        break missingId;
      }

      id = R.id.mTvModel;
      TextView mTvModel = ViewBindings.findChildViewById(rootView, id);
      if (mTvModel == null) {
        break missingId;
      }

      id = R.id.mTvPrice;
      TextView mTvPrice = ViewBindings.findChildViewById(rootView, id);
      if (mTvPrice == null) {
        break missingId;
      }

      id = R.id.mTvRegNo;
      TextView mTvRegNo = ViewBindings.findChildViewById(rootView, id);
      if (mTvRegNo == null) {
        break missingId;
      }

      return new ItemLayoutBinding((LinearLayout) rootView, mBtnBuy, mEdtQuantity, mImgPic,
          mTvColor, mTvModel, mTvPrice, mTvRegNo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
