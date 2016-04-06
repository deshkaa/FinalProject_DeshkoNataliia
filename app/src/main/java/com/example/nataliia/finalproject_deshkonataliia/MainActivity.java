package com.example.nataliia.finalproject_deshkonataliia;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Setting local time to dateTimeTextView
         */
        TextView dateTimeTextView = (TextView) findViewById(R.id.dateTimeTextView);
        dateTimeTextView.setText(getCurrentDateTime());

        /**
         * Providing onClickListener for moving to other activities
         */
        View.OnClickListener[] onClickListener;
        onClickListener = new View.OnClickListener[5];

        onClickListener[0] = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Activity1.class);
                startActivityForResult(intent, 0);
            }
        };
        onClickListener[1] = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Activity2.class);
                startActivityForResult(intent, 0);
            }
        };
        onClickListener[2] = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Activity3.class);
                startActivityForResult(intent, 0);
            }
        };
        onClickListener[3] = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Activity4.class);
                startActivityForResult(intent, 0);
            }
        };
        onClickListener[4] = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Activity5.class);
                startActivityForResult(intent, 0);
            }
        };

        /**
         * RecyclerView creating
         */
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        int[] imageSet = new int[]{R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5};
        int[] captionSet = new int[]{R.string.caption1, R.string.caption2, R.string.caption3, R.string.caption4, R.string.caption5};

        RecyclerView.Adapter adapter = new RecyclerViewAdapter(imageSet, captionSet, onClickListener);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    /**
     * Returns current time for GMT-07:00
     */
    private String getCurrentDateTime() {
        TimeZone timeZone = TimeZone.getTimeZone("GMT-07:00");
        Calendar calendar = Calendar.getInstance(timeZone, Locale.ENGLISH);
        int monthNumber = calendar.get(Calendar.MONTH);
        String month = "";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (monthNumber >= 0 && monthNumber <= 11) {
            month = months[monthNumber];
        }
        String time = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH)) + " " +
                month.toUpperCase() + ", " +
                String.format("%02d", calendar.get(Calendar.HOUR)) + ":" +
                String.format("%02d", calendar.get(Calendar.MINUTE)) + " " +
                ((calendar.get(Calendar.AM_PM) == 0) ? "AM" : "PM");

        return time;
    }

    public void open_map_click(View view) {
        String mapLink = "https://www.google.com.ua/maps/@37.757815,-122.5076405,12z";//http://maps.google.com/maps?saddr=20.344,34.34&daddr=20.5666,45.345";
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse(mapLink));
        startActivity(intent);
    }

    public void open_weather_website_click(View view) {
        String weatherLink = "https://weather.com/weather/today/l/37.77,-122.42";
        Intent weatherIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(weatherLink));
        startActivity(weatherIntent);
    }

    public void open_livecamera_website_click(View view) {
        String cameraLink = "https://wwww.earthcam.com/usa/california/sanfrancisco/?cam=sanfranciscoskyline";
        Intent cameraIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(cameraLink));
        startActivity(cameraIntent);
    }
}
