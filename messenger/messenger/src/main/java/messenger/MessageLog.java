package messenger;

import messenger.interfaces.ChatLog;

import java.io.FileReader;
import java.io.FileWriter;

public class MessageLog implements ChatLog {
    private String logPath;

    public MessageLog(String logPath) {
        this.logPath = logPath;
    }

    @Override
    public void writeLog(String text) {
        try (FileWriter writer = new FileWriter(logPath, true)) {
            writer.write(text);
            writer.write("\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    }

    @Override
    public String readLog() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(logPath);) {
            int c;
            while ((c = reader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
            return "Сообщения сохраняются!";
        }
    }

}
