package com.example.nataliia.finalproject_deshkonataliia;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Activity5 extends AppCompatActivity {

    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        title = getString(R.string.caption5);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_act5);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle(R.string.caption5);
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
        EditText editText = (EditText)findViewById(R.id.emailEditText);
        String email = editText.getText().toString();
        if (email.equals("")) return;
        String message = "Hello! I want to get more information about "+title + "\n" +
                "My email is: " + email;
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:natalyadesh9@gmail.com"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, title);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(emailIntent);
    }
}
