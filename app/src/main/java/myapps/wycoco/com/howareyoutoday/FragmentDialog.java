package myapps.wycoco.com.howareyoutoday;

import android.app.DialogFragment;
import android.app.FragmentManager;
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

/**
 * Created by dell on 3/13/2017.
 */

public class FragmentDialog  extends DialogFragment {


    ImageView happy, sad, tired, angry, confused, disappointed;



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
                FragmentManager fm = getFragmentManager();
                Bundle args = new Bundle();

                dismiss();
            }
        });

        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        tired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        angry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dismiss();
            }
        });

        confused.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dismiss();
            }
        });


        disappointed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dismiss();
            }
        });



        return view;
    }


}
