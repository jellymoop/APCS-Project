package src.alarm;

/**
 * Name: Alarm Clock
 * Coders: dwatch and jellyschmoop (David and Emily)
 * Function: You can set a single event and its due date in the future. On the minute it is due, the program will print out a notification and it will
 * 			 begin to ring.
 */

import java.util.*;
import java.applet.*;
import java.io.File;
import java.io.IOException;
import java.net.*;
import javax.sound.sampled.*;

public class Alarm {
	private static Scanner scan;
	private static String event;
	private static int hour;
	private static int minute;
	private static int month;
	private static int day; 
	private static boolean occur = true;
	
	public static void setVar(){
		System.out.println("What is the event?");
		event = scan.nextLine();
		System.out.println("What hour is it due? (0-24)");
		hour = scan.nextInt();
		System.out.println("What minute is it due? (0-60)");
		minute = scan.nextInt();
		System.out.println("What month is it due? (1-12)");
		month = scan.nextInt();
		System.out.println("What day is it due? (1-31)");
		day = scan.nextInt();
		System.out.println("You will be notified when the 
	}
	
	public static void compareTime(){
		Calendar cal = Calendar.getInstance();
		int monthN = cal.get(Calendar.MONTH) + 1;
	    int dayN = cal.get(Calendar.DAY_OF_MONTH);
	    int hourN = cal.get(Calendar.HOUR_OF_DAY);
	    int minuteN = cal.get(Calendar.MINUTE);
	    
	    if(monthN == month && dayN == day && hourN == hour && minuteN == minute){
	    	System.out.println("It's time to do: " + event + "!!!!!!!!!!!!!!!!");
			File sound = new File("Alarm clock.wav");
			try{
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(sound));
				clip.start();
				
				Thread.sleep(50000);
				
			} catch (Exception e){
				
			}
			occur = false;
	    }
	}
	
	public static void main(String args[]){
		Thread thread = new Thread();
		thread.start();
		scan = new Scanner(System.in);
		setVar();
		while(occur){
			try {
				thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			compareTime();
		}

	}
	
}
