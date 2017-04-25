package myapps.wycoco.com.howareyoutoday;


import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.firebase.client.Firebase;
import com.google.firebase.database.Query;


public class MainActivity extends AppCompatActivity {


    Query query;
    Firebase firebaseHappy;
    Firebase firebaseSad;

    EditText inputDepartment;
    Spinner inputAge;
    RadioGroup inputGender;
    RadioButton inputMale, inputFemale;
    FrameLayout fm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_activity);
        Firebase.setAndroidContext(this);

        firebaseHappy = new Firebase("https://metrosurveyapp.firebaseio.com/Happy");
        firebaseSad = new Firebase("https://metrosurveyapp.firebaseio.com/Sad");


        inputDepartment = (EditText)findViewById(R.id.inputDepartment);
        inputAge = (Spinner)findViewById(R.id.inputAge);
        inputGender = (RadioGroup)findViewById(R.id.radioGroup);
        inputMale = (RadioButton)findViewById(R.id.inputMale);
        inputFemale = (RadioButton)findViewById(R.id.inputFemale);
        fm = (FrameLayout)findViewById(R.id.frame1);


        fm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentDialog fd = new FragmentDialog();
                fd.show(fragmentManager, "wasa");
            }
        });

//        sad.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentManager fm = getFragmentManager();
//                FragmentDialog dialog = new FragmentDialog();
//                dialog.show(fm,"asds");
//                firebaseSad.push().setValue("Kobe");
//            }
//        });
//        happy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentManager fm = getFragmentManager();
//                FragmentDialog dialog = new FragmentDialog();
//                dialog.show(fm,"asds");
//                //firebaseHappy.push().setValue("Anton");
//            }
//        });




    }
}
