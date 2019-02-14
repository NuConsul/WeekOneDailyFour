package com.chemwater.newproject;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView ;
import android.text.TextWatcher ;
import android.widget.Toast;

public class MainActivity extends Activity implements TextWatcher, View.OnClickListener, View.OnLongClickListener {

    public static final String CLEAR_STRING = "" ;

    TextView tvFirstName ;
    TextView tvLastName ;
    EditText etFirstName ;
    EditText etLastName ;
    Button btnDisplayName ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFirstName = (TextView) findViewById(R.id.tvFirstNameDisplay) ;
        tvLastName = (TextView) findViewById(R.id.tvSecondNameDisplay) ;
        etFirstName = (EditText) findViewById(R.id.etFirstNameInput) ;
        etLastName = (EditText) findViewById(R.id.etSecondNameInput) ;
        btnDisplayName = findViewById(R.id.btnSendName) ;

        etFirstName.addTextChangedListener(this) ;
        btnDisplayName.setOnLongClickListener(this) ;

        //btnDisplayName.setOnClickListener(this) ;

    }

    public void onClickSendName(View view) {

        switch(view.getId()) {
            case R.id.btnSendName:

                String firstName = etFirstName.getText() != null ? etFirstName.getText().toString() : CLEAR_STRING ;
                String lastName = etLastName.getText() != null ? etLastName.getText().toString() : CLEAR_STRING ;
                tvFirstName.setText(firstName) ;
                tvLastName.setText(lastName) ;

                break ;

            case R.id.btnClearName:

                tvFirstName.setText(CLEAR_STRING) ;
                tvLastName.setText(CLEAR_STRING) ;

                break ;
        }

    }

   /* @Override
    public void onClick(View v) {

    }*/


    @Override
    public void onClick(View view) {

    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        Toast.makeText(this, "String Length = " + s.toString().length(), Toast.LENGTH_LONG).show() ;
    }

    @Override
    public boolean onLongClick(View view) {
        Toast.makeText(this, "LONG CLICK", Toast.LENGTH_SHORT).show() ;
        return false;
    }
}
