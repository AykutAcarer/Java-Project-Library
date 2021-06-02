package code.Tablo;
/**
 * @author Aykut Acarer
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Link {

	static Connection con;
	static Statement stmt;

	static ResultSet baglan() {
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme", "root", "your_password");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from buecher");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	// Creat
	static void add(String sql) {
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update
	static void update(String sql) {

		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// Delete
	static void del(String sql) {
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Search
	static ResultSet search(String sql) {
		ResultSet rs = null;

		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;
	}

}
