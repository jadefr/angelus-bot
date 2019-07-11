import org.apache.commons.io.IOUtils;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static java.lang.Math.toIntExact;

// Arrumar o dia em que se deseja iniciar o disparo de msgs nos metodos setSchedulerAtSix e setSchedulerAtNoon


public class AngelusBot extends TelegramLongPollingBot {

    public void onUpdateReceived(final Update update) {

        String command = update.getMessage().getText();

        SendMessage message = new SendMessage();

        long chat_id = update.getMessage().getChatId();

        if (command.equals("/start")) {

            String angeluspt = "src/files/angeluspt.txt";

            TimerTask taskSixPT = setAngelus(update, angeluspt);
            setSchedulerAtSix(taskSixPT);

            TimerTask taskNoonPT = setAngelus(update, angeluspt);
            setSchedulerAtNoon(taskNoonPT);


            String angeluslt = "src/files/angeluslt.txt";

            TimerTask taskSixLT = setAngelus(update, angeluslt);
            setSchedulerAtSix(taskSixLT);

            TimerTask taskNoonLT = setAngelus(update, angeluslt);
            setSchedulerAtNoon(taskNoonLT);


        }


        if (command.equals("/portugues")) {

            String portugues = "src/files/angeluspt.txt";
            setTextFromFile(message, portugues);
        }

        if (command.equals("/latim")) {

            String latim = "src/files/angeluslt.txt";
            setTextFromFile(message, latim);
        }

        if (command.equals("/avemaria")) {
            String avemaria = "src/files/avemaria.txt";
            setTextFromFile(message, avemaria);
        }

        if (command.equals("/avemariapt")) {
            String avemariapt = "src/files/avemariapt.txt";
            setTextFromFile(message, avemariapt);
        }

        if (command.equals("/paternoster")) {
            String paternoster = "src/files/painosso.txt";
            setTextFromFile(message, paternoster);
        }

        if (command.equals("/painosso")) {
            String painosso = "src/files/painossopt.txt";
            setTextFromFile(message, painosso);
        }

        if (command.equals("/gloria")) {
            String gloria = "src/files/gloria.txt";
            setTextFromFile(message, gloria);
        }

        if (command.equals("/gloriapt")) {
            String gloriapt = "src/files/gloriapt.txt";
            setTextFromFile(message, gloriapt);
        }

        if (command.equals("/salveregina")) {
            String salveregina = "src/files/salveregina.txt";
            setTextFromFile(message, salveregina);
        }

        if (command.equals("/salverainha")) {
            String salverainha = "src/files/salverainha.txt";
            setTextFromFile(message, salverainha);
        }

        if (command.equals("/credo")) {
            String credo = "src/files/credolatim.txt";
            setTextFromFile(message, credo);
        }

        if (command.equals("/credopt")) {
            String credopt = "src/files/credopt.txt";
            setTextFromFile(message, credopt);
        }

        if (command.equals("/credoapost")) {
            String credoapost = "src/files/credoapostolicolatim.txt";
            setTextFromFile(message, credoapost);
        }

        if (command.equals("/credoapostpt")) {
            String credoapostp = "src/files/credoapostolicopt.txt";
            setTextFromFile(message, credoapostp);
        }

        if (command.equals("/angeledei")) {
            String angeledei = "src/files/angeledei.txt";
            setTextFromFile(message, angeledei);
        }

        if (command.equals("/santoanjo")) {
            String santoanjo = "src/files/santoanjo.txt";
            setTextFromFile(message, santoanjo);
        }

        if (command.equals("/venisancte")) {
            String venisancte = "src/files/venisanctespiritus.txt";
            setTextFromFile(message, venisancte);
        }

        if (command.equals("/vindeespirito")) {
            String vindeespirito = "src/files/vindeespiritosanto.txt";
            setTextFromFile(message, vindeespirito);
        }

        if (command.equals("/venicreator")) {
            String venicreator = "src/files/venicreator.txt";
            setTextFromFile(message, venicreator);
        }

        if (command.equals("/anjodeportugal")) {
            String anjodeportugal = "src/files/anjodeportugal.txt";
            setTextFromFile(message, anjodeportugal);
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

                setTextFromFile(message, angelusFile);

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

    private void setSchedulerAtNoon(TimerTask timerTask) {
        Timer timer = new Timer("Timer");

        Date current = new Date();
        System.out.println("current: " + current);

        Calendar noonCalendar = new GregorianCalendar(2019, 6, 12, 12, 0, 0);
        Date noon = noonCalendar.getTime();
        System.out.println("noon: " + noon);

        long delayTillNoon = noon.getTime() - current.getTime();
        System.out.println("delayTillNoon: " + delayTillNoon);
        long noonPeriod = 1000L * 60L * 60L * 24L;

        timer.scheduleAtFixedRate(timerTask, delayTillNoon, noonPeriod); // schedules the message to 12pm everyday

    }

    private void setSchedulerAtSix(TimerTask timerTask) {
        Timer timer = new Timer("Timer");

        Date current = new Date();
        System.out.println("current: " + current);

        Calendar sixCalendar = new GregorianCalendar(2019, 6, 12, 6, 0, 0);
        Date six = sixCalendar.getTime();
        System.out.println("six: " + six);

        long delayTillSix = six.getTime() - current.getTime();
        System.out.println("delayTillSix: " + delayTillSix);
        long sixPeriod = 1000L * 60L * 60L * 12L;

        timer.scheduleAtFixedRate(timerTask, delayTillSix, sixPeriod); // schedules the message to 6am and 6pm everyday
    }

}
