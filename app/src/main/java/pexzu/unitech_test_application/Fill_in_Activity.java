package pexzu.unitech_test_application;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import pexzu.unitech_test_application.utilitty.AsyncHttpClient;
import pexzu.unitech_test_application.utilitty.ResponseData;

public class Fill_in_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_in);

        initialize();

    }

    public void initialize()
    {

        EditText firstName = (EditText) findViewById(R.id.firstName);
        EditText lastName = (EditText) findViewById(R.id.lastName);
        EditText dob = (EditText) findViewById(R.id.dob);
        EditText email = (EditText) findViewById(R.id.email);
        EditText mobNum = (EditText) findViewById(R.id.mobNum);
        EditText emergencyNum = (EditText) findViewById(R.id.emergencyNum);
        EditText address = (EditText) findViewById(R.id.address);

        // focus color change start
        firstName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    v.setBackgroundResource(R.drawable.focus);
                } else {
                    v.setBackgroundResource(R.drawable.nofocus);
                }
            }

        });
        lastName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    v.setBackgroundResource(R.drawable.focus);
                } else {
                    v.setBackgroundResource(R.drawable.nofocus);
                }
            }

        });
        dob.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    v.setBackgroundResource(R.drawable.focus);
                } else {
                    v.setBackgroundResource(R.drawable.nofocus);
                }
            }

        });
        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    v.setBackgroundResource(R.drawable.focus);
                } else {
                    v.setBackgroundResource(R.drawable.nofocus);
                }
            }

        });
        mobNum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    v.setBackgroundResource(R.drawable.focus);
                } else {
                    v.setBackgroundResource(R.drawable.nofocus);
                }
            }

        });
        emergencyNum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    v.setBackgroundResource(R.drawable.focus);
                } else {
                    v.setBackgroundResource(R.drawable.nofocus);
                }
            }

        });
        address.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    v.setBackgroundResource(R.drawable.focus);
                } else {
                    v.setBackgroundResource(R.drawable.nofocus);
                }
            }

        });        // focus color change - end
    }


    public void addClick(View v)
    {


        EditText firstName = (EditText) findViewById(R.id.firstName);
        EditText lastName = (EditText) findViewById(R.id.lastName);
        EditText dob = (EditText) findViewById(R.id.dob);
        EditText email = (EditText) findViewById(R.id.email);
        EditText mobNum = (EditText) findViewById(R.id.mobNum);
        EditText emergencyNum = (EditText) findViewById(R.id.emergencyNum);
        EditText address = (EditText) findViewById(R.id.address);
        if(firstName.getText().toString().trim().equalsIgnoreCase("")){
            firstName.setError("Enter First Name");}
        else if(lastName.getText().toString().trim().equalsIgnoreCase("")){
            lastName.setError("Enter last Name");
        }
        else if(dob.getText().toString().trim().equalsIgnoreCase("")){
            dob.setError("Enter date of birth");
        }
        else if(email.getText().toString().trim().equalsIgnoreCase("")){
            email.setError("Enter Email");}

        else if(emergencyNum.getText().toString().trim().equalsIgnoreCase("")){
            emergencyNum.setError("Please enter emergency number");

        }
        else if(address.getText().toString().trim().equalsIgnoreCase("")){
            address.setError("Please enter address");
        }

        else if(mobNum.getText().toString().trim().equalsIgnoreCase("")){
            mobNum.setError("Enter Mobile Number");
        }

        else{

            String emailID = email.getText().toString();
            String fname = firstName.getText().toString();
            String lname = lastName.getText().toString();
            String mobile = mobNum.getText().toString();
            String eNumber = emergencyNum.getText().toString();
            String addr = address.getText().toString();



        JSONObject jsonData = new JSONObject();

            try {
                jsonData.put("emailId",emailID);
                jsonData.put("firstName",fname);
                jsonData.put("lastName",lname);
                jsonData.put("mobileNumber",mobile);
                jsonData.put("emergencyContact",eNumber);
                jsonData.put("address",addr);
                RadioGroup rg = (RadioGroup) findViewById(R.id.radioSex);
                int selectedId = rg.getCheckedRadioButtonId();
                if(selectedId == R.id.radioMale)
                {jsonData.put("gender", "male");}
                else
                {jsonData.put("gender", "female");}



            } catch (JSONException e) {
                e.printStackTrace();
            }

            Toast.makeText(getApplicationContext(),jsonData.toString(),
                    Toast.LENGTH_SHORT).show();
            new AsyncHttpClient(Fill_in_Activity.this, "user", jsonData.toString(), "json").execute();

        }


    }

    }

