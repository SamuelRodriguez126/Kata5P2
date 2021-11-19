package kata5p2.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata5p2.model.Mail;


public class MailListReaderDB {

    public MailListReaderDB() {
    }

    public List<Mail> read() throws SQLException{
        List mails = this.selectAll();
        return mails;
    }
    
    private Connection connect() throws SQLException{
        String url = "jdbc:sqlite:KATA5.db";
        
        Connection con = null;
        con = DriverManager.getConnection(url);
        
        return con;
    }
    
    private List<Mail> selectAll() throws SQLException{
        String sql = "SELECT * FROM MAIL";
        Connection con = this.connect();
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        List mail = new ArrayList<Mail>();
        
        while (rs.next()){
            mail.add(new Mail(rs.getString("Mail")));
            System.out.println(rs.getInt("Id") + "\t" +
                               rs.getString("Mail") + "\t");
        } 
        return mail;
    }
}
