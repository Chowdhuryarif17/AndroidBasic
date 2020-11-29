package com.ariful.androidbasic;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    Button buttonTutorial, toastButton, editTextButton;
    Button textViewButton, snackBarButton, progressButton;
    ConstraintLayout constraintLayout;
    ProgressBar progressBar;
    Button alertButton;
    RadioButton radioButton;
    CheckBox checkBox;
    Switch mySwitch;
    Spinner mySpinner;
    Button listViewButton;
    Button webViewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        final ArrayAdapter<CharSequence>myAdapter = ArrayAdapter.createFromResource(this,R.array.countryName,android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        webViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity4.class);
                startActivity(intent);
            }
        });


        listViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity3.class);
                startActivity(intent);
            }
        });

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String countyName = myAdapter.getItem(position).toString();
                Toast.makeText(MainActivity.this, countyName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Toast.makeText(MainActivity.this, "ON", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "OFF", Toast.LENGTH_SHORT).show();
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Toast.makeText(MainActivity.this, "Checked", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Not Checked", Toast.LENGTH_SHORT).show();
            }
        });

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Toast.makeText(MainActivity.this, "Checked", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Not Checked", Toast.LENGTH_SHORT).show();
            }
        });

        alertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Warning")
                        .setMessage("This is An Alert")
                        .setCancelable(false)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }
        });

        editTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        buttonTutorial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonTutorial.setText("Mutton");
                }
        });

        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Toast Button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        textViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("INTENT_VALUE","TEXT_VIEW");
                startActivity(intent);
            }
        });

        snackBarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackBar = Snackbar.make(constraintLayout,"This is a Snack",Snackbar.LENGTH_LONG);
                snackBar.show();
            }
        });

        progressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    private void initialize(){
        buttonTutorial = findViewById(R.id.buttonTutorialId);
        toastButton = findViewById(R.id.toastButtonId);
        editTextButton = findViewById(R.id.editTextButtonId);
        textViewButton = findViewById(R.id.textViewButtonId);
        snackBarButton = findViewById(R.id.snackBarButtonId);
        constraintLayout = findViewById(R.id.constraintLayoutId);
        progressButton = findViewById(R.id.progressButtonId);
        progressBar = findViewById(R.id.progressBarId);
        alertButton = findViewById(R.id.alertButtonId);
        radioButton = findViewById(R.id.radioButtonId);
        checkBox = findViewById(R.id.checkboxId);
        mySwitch = findViewById(R.id.mySwitchId);
        mySpinner = findViewById(R.id.mySpinnerId);
        listViewButton = findViewById(R.id.listViewButtonId);
        webViewButton = findViewById(R.id.webViewButtonId);
    }

}