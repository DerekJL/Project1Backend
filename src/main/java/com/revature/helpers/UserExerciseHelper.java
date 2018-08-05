
package com.revature.helpers;

import com.revature.beans.UserExercise;
// Install the Java helper library from twilio.com/docs/libraries/java
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class UserExerciseHelper {
	
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "AC58ca35336b20365de50415a4f9f85d69";
    public static final String AUTH_TOKEN =
            "f14ee4416c222230d4005618b145f5c1";

    public static void sendMessage(UserExercise userExercise) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Phone number to send message to
        String number = userExercise.getUserPhone();
        
        String exercise = userExercise.getExercise_name();
        String description = userExercise.getExercise_description();
        String duration = userExercise.getExercise_duration();
        String reps = userExercise.getExercise_reps();
        String sets = userExercise.getExercise_sets();
        
        // Message to be sent to user
        String text = "Begin " + exercise + ": " + description + ". Reps: " + reps + ", Sets: " + sets + ","
        		+ " Duration: " + duration; 
        
        // phone number must start with '+1'
        Message message = Message
                .creator(new PhoneNumber("+1" + number), // to
                        new PhoneNumber("+12487100996"), // from
                        text)
                .create();

        System.out.println(message.getSid());
    }
    
    

    public static void sendRest(UserExercise userExercise) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Phone number to send message to
        String number = userExercise.getUserPhone();
        
       String rest = userExercise.getExercise_rest();
        
        // Message to be sent to user
        String text = "Rest for " + rest + " seconds."; 
        
        // phone number must start with '+1'
        Message message = Message
                .creator(new PhoneNumber("+1" + number), // to
                        new PhoneNumber("+12487100996"), // from
                        text)
                .create();

        System.out.println(message.getSid());
    }
    
    
    
}