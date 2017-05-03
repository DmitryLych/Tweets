package com.company;

import com.company.inputOutput.InputFile;
import com.company.threads.FirstThread;
import com.company.threads.SecondThread;
import com.company.threads.ThirdThread;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args)  {
     int startLineTweets=Integer.parseInt(args[0]);
     int endLineTweets=Integer.parseInt(args[1]);
     int startLineSent=Integer.parseInt(args[2]);
     int endLineSent=Integer.parseInt(args[3]);
     int startLineState=Integer.parseInt(args[4]);
     int endLineState=Integer.parseInt(args[5]);
     int numberOfReport=Integer.parseInt(args[6]);
     boolean firstReport=false;
     boolean secondReport=false;
     boolean thirdReport=false;
     if(numberOfReport==1) firstReport=true;
     else if(numberOfReport==2)secondReport=true;
     else if(numberOfReport==3)thirdReport=true;
        FirstThread firstThread=new FirstThread(startLineTweets,endLineTweets,firstReport);
        firstThread.start();
        SecondThread secondThread=new SecondThread(startLineSent,endLineSent,secondReport);
        secondThread.start();
        ThirdThread thirdThread=new ThirdThread(startLineState,endLineState,thirdReport);
        thirdThread.start();


    }
}
