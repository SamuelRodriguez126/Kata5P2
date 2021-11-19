package kata5p2.main;

import java.sql.SQLException;
import java.util.List;
import kata5p2.model.Histogram;
import kata5p2.model.Mail;
import kata5p2.view.HistogramDisplay;
import kata5p2.view.MailHistogramBuilder;
import kata5p2.view.MailListReaderDB;

public class Kata5P2 {
    
    static String fileName;
    static List<Mail> mailList;
    static Histogram<String> histogram;
    
    public static void main(String[] args) throws SQLException {
        fileName = "email.txt";
        execute();
    }
    
    private static void execute() throws SQLException {
        input();
        process();
        output();
    }
    
    private static void input() throws SQLException{
        MailListReaderDB reader = new MailListReaderDB();
        mailList = reader.read();
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
