package kata4.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import kata4.model.Mail;


public class MailListReader {

    public MailListReader() {
    }

    public List<Mail> read(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        List mails = new ArrayList();
        
        while (reader.hasNextLine()){
            String line = reader.nextLine();

            if (line.contains("@")) {
                mails.add(new Mail(line));
            }
        }
        reader.close();
        return mails;
    }
}
