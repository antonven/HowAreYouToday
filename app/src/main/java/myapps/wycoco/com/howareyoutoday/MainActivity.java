package myapps.wycoco.com.howareyoutoday;


import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.firebase.client.Firebase;
import com.google.firebase.database.Query;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements FragmentDialog.OnCompleteListener{


    Query query;
    Firebase AddtoDatabase;

    EditText inputDepartment;
    EditText inputAge;
    RadioGroup inputGender;
    RadioButton inputMale, inputFemale;
    FrameLayout fm;
    Button button;
    String date;
    String department, age, gender, feeling;
    private RadioButton radioButton;
    ImageView image;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_activity);
        Firebase.setAndroidContext(this);

        AddtoDatabase = new Firebase ("https://metrosurveyapp.firebaseio.com/Date");



        image = (ImageView)findViewById(R.id.feelingImage);
        inputDepartment = (EditText)findViewById(R.id.inputDepartment);
        inputAge = (EditText) findViewById(R.id.inputAge);
        inputGender = (RadioGroup)findViewById(R.id.radioGroup);
        inputMale = (RadioButton)findViewById(R.id.inputMale);
        inputFemale = (RadioButton)findViewById(R.id.inputFemale);
        fm = (FrameLayout)findViewById(R.id.frame1);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                department = inputDepartment.getText().toString();
                age = inputAge.getText().toString();
                int selectedGender = inputGender.getCheckedRadioButtonId();
                radioButton = (RadioButton)findViewById(selectedGender);
                gender = radioButton.getText().toString();

                date = getDate();


                InputModel inputModel = new InputModel(age,department,feeling,gender);

                AddtoDatabase.child(date).push().setValue(inputModel);

            }
        });


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

    @Override
    public void onComplete(String feeling) {
        this.feeling = feeling;
    }

    @Override
    public void onCompletePhoto(int feeling) {
        int images[] = {
                R.drawable.sad,
                R.drawable.happy,
                R.drawable.tired,
                R.drawable.angry,
                R.drawable.confused,
                R.drawable.dissapointed,

        };
      image.setImageResource(images[feeling]);

    }

    public String getDate(){
        Calendar calendar = Calendar.getInstance();
        int m = calendar.get(Calendar.MONTH);
        int d = calendar.get(Calendar.DAY_OF_MONTH);
        int y = calendar.get(Calendar.YEAR);

        String [] dates = {
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        };

        String month = dates[m];
        String fullDate = month + "-" + d + "-" + y;

        return fullDate;
    }
}
