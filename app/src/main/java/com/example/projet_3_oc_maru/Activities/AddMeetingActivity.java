package com.example.projet_3_oc_maru.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import com.example.projet_3_oc_maru.DI.DI;
import com.example.projet_3_oc_maru.Fragments.MainFragment;
import com.example.projet_3_oc_maru.Models.Meeting;
import com.example.projet_3_oc_maru.Models.RoomMeeting;
import com.example.projet_3_oc_maru.R;
import com.google.android.material.textfield.TextInputLayout;


import java.util.Calendar;
import java.util.Objects;

public class AddMeetingActivity extends AppCompatActivity  {

    TextInputLayout idMeeting;
    TextInputLayout subjectMeeting;
    TextInputLayout timeBegin;
    TextInputLayout timeEnd;
    TextInputLayout participantsMeeting;
    EditText timeBeginMeeting;
    Button btnTimePicker;

    private int  mHour, mMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        idMeeting = findViewById(R.id.idMeetingLyt);
        subjectMeeting = findViewById(R.id.subjectMeetingLyt);
        timeBegin = findViewById(R.id.timeBeginMeetingLyt);
        timeEnd = findViewById(R.id.timeEndLyt);
        participantsMeeting = findViewById(R.id.participantsMeetingLyt);
        Button createNewRoomMeetingButton = findViewById(R.id.create);


         btnTimePicker= findViewById(R.id.btn_time_begin);
        timeBeginMeeting = findViewById(R.id.timeBeginMeeting);



        NumberPicker numberRoomMeeting = findViewById(R.id.numberRoomMeeting);
        numberRoomMeeting.setMinValue(1);
        numberRoomMeeting.setMaxValue(10);
        numberRoomMeeting.setWrapSelectorWheel(true);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        createNewRoomMeetingButton.setOnClickListener(v -> {
            Meeting meeting = new Meeting(
                    Objects.requireNonNull(idMeeting.getEditText()).getText().toString(),
                    Objects.requireNonNull(subjectMeeting.getEditText()).getText().toString(),
                    Objects.requireNonNull(timeBegin.getEditText()).getText().toString(),
                    Objects.requireNonNull(timeEnd.getEditText()).getText().toString(),
                    Objects.requireNonNull(participantsMeeting.getEditText()).getText().toString(),
                    RoomMeeting.getRoomMeetingById(numberRoomMeeting.getValue())
            );
            DI.getMeetingApiService().createMeeting(meeting);
            finish();
        });

        btnTimePicker.setOnClickListener(v -> {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    (view, hourOfDay, minute) -> {

                timeBeginMeeting.setText(hourOfDay + ":" + minute);



                    }, mHour, mMinute, false);
            timePickerDialog.show();

        });









    }






}