package com.rp.sec03;

import com.rp.courseutil.DefaultSubscriber;
import com.rp.sec03.asignment.FileReaderService;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Lec09FileReaderServiceAssignment {
    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderService();
        Path path = Paths.get("src\\main\\resources\\assigment\\sec03\\file01.txt");
        fileReaderService.read(path)
                .subscribe(DefaultSubscriber.subscriber());
    }
}
