package myapps.wycoco.com.howareyoutoday;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;

/**
 * Created by dell on 3/13/2017.
 */

public class FragmentDialog  extends DialogFragment {


    ImageView happy, sad, tired, angry, confused, disappointed;
    private OnCompleteListener mListener;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feeling,container,false);
        Window window = getDialog().getWindow();
        Point size = new Point();

        Display display = window.getWindowManager().getDefaultDisplay();
        display.getSize(size);

        int width = size.x;

        window.setLayout((int) (width * 2), WindowManager.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);

        if(window == null) dismiss();
//        window.setStatusBarColor("red");
//        WindowManager.LayoutParams params = window.getAttributes();
//        params.width = 4000;
//        params.height = 1500;
//        window.setAttributes(params);

        sad = (ImageView)view.findViewById(R.id.sadImage);
        happy = (ImageView)view.findViewById(R.id.happyImage);
        tired = (ImageView)view.findViewById(R.id.tiredImage);
        angry = (ImageView)view.findViewById(R.id.angryImage);
        confused = (ImageView)view.findViewById(R.id.confusedImage);
        disappointed = (ImageView)view.findViewById(R.id.disappointedImage);

        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onComplete("sad");
                mListener.onCompletePhoto(0);
                dismiss();
            }
        });

        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onComplete("happy");
                mListener.onCompletePhoto(1);
                dismiss();

            }
        });

        tired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onComplete("tired");
                mListener.onCompletePhoto(2);
                dismiss();
            }
        });

        angry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onComplete("angry");
                mListener.onCompletePhoto(3);
                dismiss();
            }
        });

        confused.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onComplete("confused");
                mListener.onCompletePhoto(4);
                dismiss();
            }
        });

        disappointed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onComplete("disappointed");
                mListener.onCompletePhoto(5);
                dismiss();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            this.mListener = (OnCompleteListener)context;

        }catch (final ClassCastException e ){

        }
    }

    public static interface OnCompleteListener{
        public void onComplete(String feeling);
        public void onCompletePhoto(int feeling);
    }


}
