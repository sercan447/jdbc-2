
package jdbc.pkg2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JDBC2 {

    static Connection con = null;
    public static void main(String[] args) {
       
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/depotakipvt","root","199144");
            
            if(!con.isClosed())
                System.out.println("VT Başarılı Açılış");
            else
                System.out.println("VT Sorun..");
            
            String sorgu = "SELECT * FROM personel WHERE personelid = ?";
            String[] obje = new String[]{"personelid","personeladi","personeleposta"};
            
            PreparedStatement statement = con.prepareStatement(sorgu, obje);
                              statement.setInt(1, 8);
            ResultSet resulset = statement.executeQuery();
            
                while(resulset.next()){
                    System.out.println(resulset.getString(1) + " - "+resulset.getString(2)+" - "+resulset.getString(3));
                }
                
                resulset.close();
                statement.close();
                con.close();
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        
        }finally{}
        
        
        
        
    }
    
}
