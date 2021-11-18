package kata4.view;

import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;


public class MailHistogramBuilder {

    public Histogram<String> build(List<Mail> mails){
        Histogram<String> histogram = new Histogram();
        
        for (Mail mail : mails) {
            histogram.increment(mail.getDomain());
        }
        return histogram;
    }
}
