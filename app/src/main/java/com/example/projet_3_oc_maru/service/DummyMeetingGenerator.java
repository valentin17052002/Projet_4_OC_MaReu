package com.example.projet_3_oc_maru.service;


import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.example.projet_3_oc_maru.Models.Meeting;
import com.example.projet_3_oc_maru.Models.RoomMeeting;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.O)
public abstract class DummyMeetingGenerator {
    public static List<Meeting> DUMMY_ROOM_MEETS = Arrays.asList(
            new Meeting("1","Logistique", LocalDate.of(2021,02,14),LocalTime.of(14,00),LocalTime.of(15,00) ,"maxime@lamzone.com,alex@lamzone.com",RoomMeeting.getRoomMeetingById(7)),
            new Meeting("2","Qualité",LocalDate.of(2021,02,15),LocalTime.of(15,00),LocalTime.of(16,00),"paul@lamzone.com,viviane@lamzone.com",RoomMeeting.getRoomMeetingById(6)),
            new Meeting("3","Reception",LocalDate.of(2021,02,16),LocalTime.of(19,00),LocalTime.of(20,00),"amandine@lamzone.com,luc@lamzone.com",RoomMeeting.getRoomMeetingById(5))

    );





    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_ROOM_MEETS);
    }

}
