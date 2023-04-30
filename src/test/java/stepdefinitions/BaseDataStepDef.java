package stepdefinitions;

import io.cucumber.java.en.Given;
import utilities.ConfigReader;
import utilities.Driver;

import java.sql.*;

public class BaseDataStepDef {
    @Given("ogretmenin olustugu dogrular")
    public void ogretmeninOlustuguDogrular() throws SQLException {
     // Connection con= DriverManager.getConnection("jdbc:postgresql://164.92.252.42:5432/school_management","select_user","43w5ijfso");
     // Statement st= con.createStatement();
     // ResultSet resultSet=st.executeQuery("select * from where ssn=\"242-14-6446\"");
     // resultSet.next();
     // System.out.println(resultSet.getString(0));

    }
}
