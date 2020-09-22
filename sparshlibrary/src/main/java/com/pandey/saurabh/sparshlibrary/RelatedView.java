package com.pandey.saurabh.sparshlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public  class RelatedView extends FrameLayout {
    private TextView valueText;
    private ImageView link;


    private int textColorRes;
    String moduleName;

    onLinkClickEventListener onLinkClickEventListener;

    public RelatedView(@NonNull Context context) {
        super(context);

        init();
    }

    public RelatedView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

        obtainStyledAttributes(context, attrs, 0);
    }

    public RelatedView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
        obtainStyledAttributes(context, attrs, defStyleAttr);


    }


    private void init() {

       inflate(getContext(),R.layout.layout_related_view,this);
       valueText = findViewById(R.id.testTextView);
        link = findViewById(R.id.testImageView);

        setLinkClickListener(onLinkClickEventListener);

        link.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                onLinkClickEventListener.onLinkItemClick(moduleName);

            }
        });


        //  setupView();


    }


    private void obtainStyledAttributes(Context context, AttributeSet attrs, int defStyleAttr) {
        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.RelatedView, defStyleAttr, 0);

            textColorRes = typedArray.getResourceId(R.styleable.RelatedView_colorOfText, R.color.div2);

            //  Toast.makeText(context, "" + typedArray.getText(R.styleable.RelatedView_moduleName), Toast.LENGTH_SHORT).show();


            moduleName = String.valueOf(typedArray.getText(R.styleable.RelatedView_moduleName));



            return;
        }

        textColorRes = R.color.div2;
    }


    private void setupView() {
        int textColor = ContextCompat.getColor(getContext(), textColorRes);
        if (textColor != ContextCompat.getColor(getContext(), R.color.div2)) {
            valueText.setTextColor(textColor);
        }
    }


    public interface onLinkClickEventListener {
        void onLinkItemClick(String moduleName);
    }

    public void setLinkClickListener(onLinkClickEventListener onLinkClickEventListener) {
        this.onLinkClickEventListener = onLinkClickEventListener;
    }



    public  void setResultText(String text){

        valueText.setText(text);
    }


}
