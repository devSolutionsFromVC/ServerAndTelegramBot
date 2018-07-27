package bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TelegramBot extends TelegramLongPollingBot{

    private static HashMap<String, String> val = new HashMap<String, String>();

    static public void getData(HashMap<String, String> values){
        val = values;
    }

    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        /*if(update.getMessage().getText().equals("weather")){
            getWeather(val);
            sendMessage.setText("Weather is " );
        } else*/
        if (update.getMessage().getText().equals("data")){
            sendMessage.setText("Okay....." + val);
        } else if (update.getMessage().getText().equals("temperature")){
            sendMessage.setText("Okay....." + val.get(" Temperature "));
        }else if (update.getMessage().getText().equals("humidity")){
            sendMessage.setText("Okay....." + val.get(" Humudity "));
        } else if (update.getMessage().getText().equals("pressure")){
            sendMessage.setText("Okay....." + val.get(" Pressure "));
       }  else {
            sendMessage.setText("No no no...");
        }

        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    private void getWeather(HashMap<String, String> val) {
        Set<Map.Entry<String, String>> entries = val.entrySet();
    }

    public String getBotUsername() {
        return null;
    }

    public String getBotToken() {
        return "444242431:AAFxwK2EHTjBqr4nRVQ0S0oUbWQPb-a8M0s";
    }
}
