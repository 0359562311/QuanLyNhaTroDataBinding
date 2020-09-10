package com.example.quanlynhatrodatabinding.databinding;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

public class BindingAdaptersClass {
    private static final String TAG = "TanKiem";

    @BindingAdapter("enable")
    public static void setEnabled(View v, boolean b){
        v.setEnabled(b);
    }



    @BindingAdapter("customText")
    public static void setCustomText(EditText view, String newV){
        view.setText(newV);
        view.setSelection(newV.length());
    }

    @InverseBindingAdapter(attribute = "customText")
    public static String getCustomText(EditText v){
//        Log.d(TAG, "getCustomText: " + v.getText().toString());
        return  v.getText().toString();
    }

    @BindingAdapter("customTextAttrChanged")
    public static void onCustomTextListener(EditText view, final InverseBindingListener listener){
        view.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                listener.onChange();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        view.setOnFocusChangeListener((v, hasFocus) -> {
            TextView textView = (TextView) v;
            if(hasFocus) textView.setText("");
            else listener.onChange();
        });
    }

    @BindingAdapter("hideKeyboardWhenInputDone")
    public static void hideKeyboardWhenInputDone(final EditText view, boolean b){
        if(!b) return;

        TextView.OnEditorActionListener listener = new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    view.clearFocus();
                    InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(),0);
                }
                return false;
            }
        };

        view.setOnEditorActionListener(listener);
    }

}
