import org.apache.commons.io.IOUtils;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AngelusBot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {

        String command = update.getMessage().getText();

        SendMessage message = new SendMessage();

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

}
