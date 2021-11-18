package kata4.main;

import java.io.FileNotFoundException;
import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

public class Kata4 {
    
    static String fileName;
    static List<Mail> mailList;
    static Histogram<String> histogram;
    
    public static void main(String[] args) throws FileNotFoundException {
        fileName = "email.txt";
        execute();
    }
    
    private static void execute() throws FileNotFoundException{
        input();
        process();
        output();
    }
    
    private static void input() throws FileNotFoundException{
        MailListReader reader = new MailListReader();
        mailList = reader.read(fileName);
    }
    
    private static void process(){
        MailHistogramBuilder builder = new MailHistogramBuilder();        
        histogram = builder.build(mailList);
    }
    
    private static void output(){
        HistogramDisplay display = new HistogramDisplay(histogram);
        display.execute();
    }
 
}
