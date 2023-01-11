package com.github.vkvish19.corejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

public class JtdsConnectionTest
{
    public static void main(String[] args)
    {
        System.out.println("Test to see if jtds connection possible");
        String query = "select 1 from zzone";
        String user = "zenwrkswin";
        String pass = "novell@123";
        String domain = "WIN-25AO1147UC8";
        Properties properties = new Properties();
        properties.put("user", user);
        properties.put("password", pass);
        String url = "jdbc:jtds:sqlserver://10.71.66.207:1433/zenworks_smk_mssql_winauth;tds=8.0;user=" + user +";domain=WIN-25AO1147UC8";
        ResultSet resultSet;
        try(Connection connection = DriverManager.getConnection(url, properties))
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            resultSet = connection.createStatement().executeQuery(query);
            
            while(resultSet.next())
            {
                System.out.println("name=" + resultSet.getString(1));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("END");
    }
}
