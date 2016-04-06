package com.example.nataliia.finalproject_deshkonataliia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.EditText;

public class Functions {
    public void createEmail(Activity activity, String title){
        EditText editText = (EditText) activity.findViewById(R.id.emailEditText);
        String email = editText.getText().toString();
        if (email.equals("")) return;
        String message = "Hello! I want to get more information about " + title + "\n" +
                "My email is: " + email;
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:natalyadesh9@gmail.com"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, title);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        activity.startActivity(emailIntent);
    }
}
