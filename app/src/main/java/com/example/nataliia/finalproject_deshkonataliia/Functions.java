package com.example.nataliia.finalproject_deshkonataliia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
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

    public void setOnClickListeners(View.OnClickListener[] onClickListener, final Activity activity){
        onClickListener[0] = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Activity1.class);
                activity.startActivityForResult(intent, 0);
            }
        };
        onClickListener[1] = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Activity2.class);
                activity.startActivityForResult(intent, 0);
            }
        };
        onClickListener[2] = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Activity3.class);
                activity.startActivityForResult(intent, 0);
            }
        };
        onClickListener[3] = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Activity4.class);
                activity.startActivityForResult(intent, 0);
            }
        };
        onClickListener[4] = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Activity5.class);
                activity.startActivityForResult(intent, 0);
            }
        };
    }
}
