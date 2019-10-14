import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;



public class AngelusBot extends TelegramLongPollingBot {

    public void onUpdateReceived(final Update update) {

        String command = update.getMessage().getText();

        SendMessage message = new SendMessage();

        long chat_id = update.getMessage().getChatId();


        /*if (command.equals("/start")) {
            // sets the Angelus in Portuguese
            String angeluspt = "src/main/resources/files/angeluspt.txt";
            TimerTask taskPT = setAngelus(update, angeluspt);
            setScheduler(taskPT);
            System.out.println("Setting the Angelus in Portuguese");

            // sets the Angelus in Latin
            String angeluslt = "src/main/resources/files/angeluslt.txt";
            TimerTask taskLT = setAngelus(update, angeluslt);
            setScheduler(taskLT);
            System.out.println("Setting the Angelus in Latin");
        }*/


        if (command.equals("/start")) {

            // sets the Angelus in Portuguese
            System.out.println("Setting the Angelus in Portuguese\n");

            //String angeluspt = "src/main/resources/files/angeluspt.txt";
            String angeluspt = "ANGELUSPT";
            System.out.println("Angelus String ANGELUSPT: " + angeluspt);

            TimerTask taskPT = setAngelus(update, angeluspt);
            setScheduler(taskPT);
            System.out.println("\n");


            // sets the Angelus in Latin
            System.out.println("Setting the Angelus in Latin\n");

            //String angeluslt = "src/main/resources/files/angeluslt.txt";
            String angeluslt = "ANGELUSLT";

            TimerTask taskLT = setAngelus(update, angeluslt);
            setScheduler(taskLT);
            System.out.println("\n");
        }

        if (command.equals("/portugues")) {

            message.setText(TextFiles.ANGELUSPT);

            //String portugues = "src/main/resources/files/angeluspt.txt";
            //setTextFromFile(message, portugues);
        }

        if (command.equals("/latim")) {

            message.setText(TextFiles.ANGELUSLT);

            //String latim = "src/main/resources/files/angeluslt.txt";
            //setTextFromFile(message, latim);
        }

        if (command.equals("/avemaria")) {

            message.setText(TextFiles.AVEMARIA);

            //String avemaria = "src/main/resources/files/avemariapt.txt";
            //setTextFromFile(message, avemaria);
        }

        if (command.equals("/avemariapt")) {

            message.setText(TextFiles.AVEMARIAPT);

            //String avemariapt = "src/main/resources/files/avemariapt.txt";
            //setTextFromFile(message, avemariapt);
        }

        if (command.equals("/paternoster")) {

            message.setText(TextFiles.PAINOSSO);
            System.out.println(message.toString());

            //String paternoster = "src/main/resources/files/painosso.txt";
            //setTextFromFile(message, paternoster);
        }

        if (command.equals("/painosso")) {

            message.setText(TextFiles.PAINOSSOPT);
            //String painosso = "src/main/resources/files/painossopt.txt";
            //setTextFromFile(message, painosso);
        }

        if (command.equals("/gloria")) {

            message.setText(TextFiles.GLORIA);
            //String gloria = "src/main/resources/files/gloria.txt";
            //setTextFromFile(message, gloria);
        }

        if (command.equals("/gloriapt")) {

            message.setText(TextFiles.GLORIAPT);
            //String gloriapt = "src/main/resources/files/gloriapt.txt";
            //setTextFromFile(message, gloriapt);
        }

        if (command.equals("/salveregina")) {

            message.setText(TextFiles.SALVEREGINA);
            //String salveregina = "src/main/resources/files/salveregina.txt";
            //setTextFromFile(message, salveregina);
        }

        if (command.equals("/salverainha")) {

            message.setText(TextFiles.SALVERAINHA);
            //String salverainha = "src/main/resources/files/salverainha.txt";
            //setTextFromFile(message, salverainha);
        }

        if (command.equals("/credo")) {

            message.setText(TextFiles.CREDOLATIM);
            //String credo = "src/main/resources/files/credolatim.txt";
            //setTextFromFile(message, credo);
        }

        if (command.equals("/credopt")) {

            message.setText(TextFiles.CREDOPT);
            //String credopt = "src/main/resources/files/credopt.txt";
            //setTextFromFile(message, credopt);
        }

        if (command.equals("/credoapost")) {

            message.setText(TextFiles.CREDOAPOSTOLICOLATIM);
            //String credoapost = "src/main/resources/files/credoapostolicolatim.txt";
            //setTextFromFile(message, credoapost);
        }

        if (command.equals("/credoapostpt")) {

            message.setText(TextFiles.CREDOAPOSTOLICOPT);
            //String credoapostp = "src/main/resources/files/credoapostolicopt.txt";
            //setTextFromFile(message, credoapostp);
        }

        if (command.equals("/angeledei")) {

            message.setText(TextFiles.ANGELEDEI);
            //String angeledei = "src/main/resources/files/angeledei.txt";
            //setTextFromFile(message, angeledei);
        }

        if (command.equals("/santoanjo")) {

            message.setText(TextFiles.SANTOANJO);
            //String santoanjo = "src/main/resources/files/santoanjo.txt";
            //setTextFromFile(message, santoanjo);
        }

        if (command.equals("/venisancte")) {

            message.setText(TextFiles.VENISANCTESPIRITUS);
            //String venisancte = "src/main/resources/files/venisanctespiritus.txt";
            //setTextFromFile(message, venisancte);
        }

        if (command.equals("/vindeespirito")) {

            message.setText(TextFiles.VINDEESPIRITOSANTO);
            //String vindeespirito = "src/main/resources/files/vindeespiritosanto.txt";
            //setTextFromFile(message, vindeespirito);
        }

        if (command.equals("/venicreator")) {

            message.setText(TextFiles.VENICREATOR);
            //String venicreator = "src/main/resources/files/venicreator.txt";
            //setTextFromFile(message, venicreator);
        }

        if (command.equals("/anjodeportugal")) {

            message.setText(TextFiles.ANJODEPORTUGAL);
            //String anjodeportugal = "src/main/resources/files/anjodeportugal.txt";
            //setTextFromFile(message, anjodeportugal);
        }


        /*if (command.equals("/setAngelusPTText")) { //comando do desenvolvedor, indisponivel ao usuario
            String angeluspt = "src/files/angeluspt.txt";

            TimerTask taskSix = setAngelus(update, angeluspt);
            setSchedulerAtSix(taskSix);

            TimerTask taskNoon = setAngelus(update, angeluspt);
            setSchedulerAtNoon(taskNoon);
        }


        if (command.equals("/setAngelusLTText")) { //comando do desenvolvedor, indisponivel ao usuario
            String angeluslt = "src/files/angeluslt.txt";

            TimerTask taskSix = setAngelus(update, angeluslt);
            setSchedulerAtSix(taskSix);

            TimerTask taskNoon = setAngelus(update, angeluslt);
            setSchedulerAtNoon(taskNoon);

        }*/




        message.setChatId(update.getMessage().getChatId());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }


    public String getBotUsername() {
        return "angelus_domini_bot";
    }

    public String getBotToken() {
        return "";
    }

    private void setTextFromFile(SendMessage message, String fileName) {

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String text = IOUtils.toString(inputStream);

            System.out.println(text);

            message.setText(text);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    private TimerTask setAngelus(final Update update, final String angelusFile) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                SendMessage message = new SendMessage();

                //setTextFromFile(message, angelusFile);

                System.out.println("angelusFile (setAngelus): " + angelusFile);

                if (angelusFile.equals("ANGELUSPT")){
                    message.setText(TextFiles.ANGELUSPT);
                    System.out.println(message.toString());
                    System.out.println("\n");
                }
                else if (angelusFile.equals("ANGELUSLT")){
                    message.setText(TextFiles.ANGELUSLT);
                    System.out.println(message.toString());
                    System.out.println("\n");
                }

                message.setChatId(update.getMessage().getChatId());

                try {

                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }
        };

        return timerTask;
    }




    public void setScheduler(TimerTask timerTask){
        Timer timer = new Timer("Timer");

        DateTime now = new DateTime();

        int hourNow = now.getHourOfDay();
        int dayNow = now.getDayOfMonth();
        int monthNow = now.getMonthOfYear();
        int yearNow = now.getYear();


        if ((hourNow < 6) || ((hourNow > 12) && (hourNow < 18))){ // sets the Angelus of 6am (and of 6pm)

            //DateTime sixAM = new DateTime(yearNow, monthNow, dayNow, 6, 0, 0);
            DateTime sixAM = new DateTime(yearNow, monthNow, dayNow, 12, 45, 0);

            Interval interval = new Interval(now, sixAM);

            System.out.println("Start    = " + interval.getStart());
            System.out.println("End      = " + interval.getEnd());
            System.out.println("interval: " + interval);
            System.out.println("Days     = " + interval.toDuration().getStandardDays());
            System.out.println("Hours    = " + interval.toDuration().getStandardHours());
            System.out.println("Minutes  = " + interval.toDuration().getStandardMinutes());
            System.out.println("Seconds  = " + interval.toDuration().getStandardSeconds());

            long delayTillSixAM = interval.toDuration().getStandardSeconds();

            //long sixPeriod = 1000L * 60L * 60L * 12L; // period of repetition
            long sixPeriod = 1000L * 60L * 3L; // period of repetition

            timer.scheduleAtFixedRate(timerTask, delayTillSixAM, sixPeriod); // schedules the message to 6am and 6pm everyday

        } else if ((hourNow > 6) && (hourNow < 12)){ // sets the Angelus of 12pm

            DateTime noon = new DateTime(yearNow, monthNow, dayNow, 12, 0, 0);
            //DateTime noon = new DateTime(yearNow, monthNow, dayNow, 11, 58, 0);

            Interval tillNoon = new Interval(now, noon);
            long delayTillNoon = tillNoon.toDuration().getStandardSeconds();

            long noonPeriod = 1000L * 60L * 60L * 24L;
            //long noonPeriod = 1000L * 60L * 3L; // period of repetition

            timer.scheduleAtFixedRate(timerTask, delayTillNoon, noonPeriod); // schedules the message to 12pm everyday

        } else { // sets the Angelus of 6am of the next day

            DateTime tomorrowSixAM = new DateTime(yearNow, monthNow, (dayNow + 1), 6, 0, 0);
            System.out.println("time of the task: " + tomorrowSixAM);

            Interval interval = new Interval(now, tomorrowSixAM);

            System.out.println("Start    = " + interval.getStart());
            System.out.println("End      = " + interval.getEnd());
            System.out.println("interval: " + interval);
            System.out.println("Days     = " + interval.toDuration().getStandardDays());
            System.out.println("Hours    = " + interval.toDuration().getStandardHours());
            System.out.println("Minutes  = " + interval.toDuration().getStandardMinutes());
            System.out.println("Seconds  = " + interval.toDuration().getStandardSeconds());

            long delayTillSixAM = interval.toDuration().getStandardSeconds();


            long sixPeriod = 1000L * 60L * 60L * 12L; // period of repetition
            //long sixPeriod = 1000L * 60L * 5L; // period of repetition

            timer.scheduleAtFixedRate(timerTask, delayTillSixAM, sixPeriod); // schedules the message to 6am and 6pm everyday

            System.out.println("delayTillSixAM: " +  delayTillSixAM);
            System.out.println("sixPeriod: " +  sixPeriod);
            System.out.println("hourNow: " + hourNow);
        }
    }

}
