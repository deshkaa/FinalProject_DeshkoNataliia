package com.example.nataliia.finalproject_deshkonataliia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    private String title;
    private Functions functions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        title = getString(R.string.caption2);
        functions = new Functions();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_act2);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle(R.string.caption2);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void submitCheckBoxClicked(View view) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.subscribeCheckBox);
        EditText editText = (EditText) findViewById((R.id.emailEditText));
        Button button = (Button) findViewById(R.id.subscribeButton);
        boolean checked = checkBox.isChecked();
        editText.setEnabled(checked);
        button.setEnabled(checked);
    }

    public void submitButtonClicked(View view) {
        functions.createEmail(this, title);
    }
}
