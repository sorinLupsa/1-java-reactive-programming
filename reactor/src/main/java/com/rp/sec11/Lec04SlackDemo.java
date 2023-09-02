package com.rp.sec11;

import com.rp.courseutil.Util;
import com.rp.sec11.assignment.SlackMember;
import com.rp.sec11.assignment.SlackRoom;

public class Lec04SlackDemo {
    public static void main(String[] args) {

        SlackRoom slackRoom = new SlackRoom("reactor");

        SlackMember sam = new SlackMember("sam");
        SlackMember jake = new SlackMember("jake");
        SlackMember mike = new SlackMember("mike");

        slackRoom.joinRoom(sam);
        slackRoom.joinRoom(jake);

        sam.says("Hi all ...");

        Util.sleepSeconds(4);

        jake.says("hey");
        sam.says("I simply wanted to say hi ...");

        Util.sleepSeconds(4);

        slackRoom.joinRoom(mike);
        mike.says("Glad to be here...");
    }
}
