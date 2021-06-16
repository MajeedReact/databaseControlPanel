import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

public class Connection2DB {
    ResultSet rs = null;
    public static Connection setConnection(){
        Connection conn = null;
        try {
            String driverName = "driverName";
            Class.forName(driverName);
            String serverName = "your serverName";
            String serverPort = "your port";
            String sid = "enter your SID";
            String url = "jdbc:oracle:thin:@" + serverName + ":" + serverPort + ":" + sid;
            String username = "scott";
            String password = "tiger";
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("succefully connected to the database");
        }
        catch (ClassNotFoundException e){
            System.out.println("could not find database driver" + e.getMessage());
        }
        catch (SQLException e){
            System.out.println("could not connect to database" + e.getMessage());
        }
        return conn;
    }
    
    public void view(JTable table, String sql){
        try {
            Connection con = setConnection();
            Statement st = con.createStatement();
           
            ResultSet rs = st.executeQuery(sql);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet check(String id){
            try {
            
        
  
           Connection con = setConnection();
            PreparedStatement ps = con.prepareStatement("select * from Coach where TeamID = ?");
           ps.setString(5, id);
            ResultSet rs = ps.executeQuery();
         
            } catch (Exception e) {
        }
           return rs; 
    }
            
}
