//Cole Teza
//cteza@ucsc.edu
//CMPS182
//Lab4
//DMVApplication.java


import java.sql.*;
import java.io.*;
import java.util.*;

/**
 * A class that connects to PostgreSQL and disconnects.
 * You will need to change your credentials below, to match the username and password of your account
 * in the PostgreSQL server.
 * The name of your database in the server is the same as your username.
 * You are asked to include code that tests the methods of the DMVApplication class
 * in a similar manner to the sample RunStoresApplication.java program.
*/


public class RunDMVApplication
{
	// You will need to fill in your real username
	// and password for your Postgres account
	public static String USERNAME = "cteza";
	public static String PASSWORD = "transformation91SQL";
	
    public static void main(String[] args) {
    	
    	Connection connection = null;
    	try {
    		//Register the driver
    		Class.forName("org.postgresql.Driver"); 
    		// Make the connection
            connection = DriverManager.getConnection(
					 "jdbc:postgresql://cmps182-db.lt.ucsc.edu/" + RunDMVApplication.USERNAME,
					 RunDMVApplication.USERNAME,
					 RunDMVApplication.PASSWORD);
            
            if (connection != null)
                System.out.println("Connected to the database!\n");

            /* Include your code below to test the methods of the DMVApplication class
             * The sample code in RunStoresApplication.java should be useful.
             * That code tests other methods for a different database schema. */
            //Your code below: 


            //TEST 1 tests getDriversWithManyVehicles
            DMVApplication dapp = new DMVApplication(connection);
            System.out.println("TEZATEST-1.0-(getDriversWithManyVehicles)"+ dapp.getDriversWithManyVehicles(3)+"\n");
            //TEST 2 tests setTicketedDriver and prints the value of the licenseid at the provided ticketid after the update
            DMVApplication dapp2 = new DMVApplication(connection);
            System.out.print("TEZATEST-2.0-(setTicketedDriver) **UPDATED**");
            dapp2.setTicketedDriver("Chao Xu", "1007 Broadway Ave", 3000011);
            System.out.println();
            //TEST 3.1 tests getSomeTicketFees for value 2300
            DMVApplication dapp3 = new DMVApplication(connection);
            System.out.println("TEZATEST-3.1-(getSomeTicketFees)(2300) "+ dapp3.getSomeTicketFees(2300)+"\n");
            //TEST 3.2 tests getSomeTicketFees for value -8
            DMVApplication dapp4 = new DMVApplication(connection);
            System.out.println("TEZATEST-3.2-(getSomeTicketFees)(-8) "+ dapp4.getSomeTicketFees(-8)+"\n");
            
            //Your code ends here
            
    	}
    	catch (SQLException | ClassNotFoundException e) {
    		System.out.println("Error while connecting to database: " + e);
    		e.printStackTrace();
    	}
    	finally {
    		if (connection != null) {
    			// Closing Connection
    			try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("Failed to close connection: " + e);
					e.printStackTrace();
				}
    		}
    	}
    }
}
