import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

//JDBC Driver - .jar

//https://gist.github.com/ProgDan/929108
//https://www.caelum.com.br/apostila-java-web/bancos-de-dados-e-jdbc/#fazendo-pesquisas-no-banco-de-dados

public class DBTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Vai Corinthians!");

		try {
			//https://docs.microsoft.com/pt-br/sql/connect/jdbc/microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15
			
			       //jdbc:sqlserver://localhost;user=MyUserName;password=*****;
			Connection conexao = DriverManager.getConnection(
			        "jdbc:mysql://localhost/ftt?serverTimezone=GMT-3",
			        "ftt","ftt@2020");
			
			PreparedStatement stmt = conexao.
                    prepareStatement("select now() agora from dual;");
            
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
                String agora = rs.getString("agora");
                System.out.println("Data do banco de dados: " + agora);
			} //while
			
			stmt = conexao.
                    prepareStatement("select * from ftt.person;");
            
			rs = stmt.executeQuery();
			
			while (rs.next()) {
                String name = rs.getString("name");
                System.out.println("Person name: " + name);
			} //while
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Ops!! " + new Date());
			e.printStackTrace();
		}
		
        System.out.println("Testando!!");
	}

}
