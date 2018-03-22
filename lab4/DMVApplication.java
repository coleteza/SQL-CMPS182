//Cole Teza
//cteza@ucsc.edu
//CMPS182
//Lab4
//DMVApplication.java

import java.sql.*;
import java.util.*;

/**
 * The class implements methods of the DMV database interface.
 *
 * All methods of the class receive a Connection object through which all
 * communication to the database should be performed. Note: the
 * Connection object should not be closed by any method.
 *
 * Also, no method should throw any exceptions. In particular, in case
 * that an error occurs in the database, then the method should print an
 * error message and call System.exit(-1);
 */
public class DMVApplication {

    private Connection connection;
    
    /*
     * Constructor
     */
    public DMVApplication(Connection connection) {
        this.connection = connection;
    }
    
    public Connection getConnection()
    {
        return connection;
    }
    
     /**
     * Return list of DriverID values for drivers who own at least numberOfVehicles vehicles.
     */
    public List<Integer> getDriversWithManyVehicles(int numberOfVehicles){
      List<Integer> result = new ArrayList<Integer>();

      // your code here
      Statement st = null;
      ResultSet rs = null;
    
      try{

         //System.out.println("***CHECKPOINT 1");
         st = connection.createStatement();
         rs = st.executeQuery("SELECT OwnerLicenseID FROM Vehicles GROUP BY OwnerLicenseID HAVING COUNT (DISTINCT vin)>= " + numberOfVehicles);
         
         //System.out.println("***CHECKPOINT 2");
         while(rs.next()){
         //System.out.println("***CHECKPOINT 3");
         result.add(rs.getInt(1));
         //System.out.println("***CHECKPOINT 4");
      }
    
    
   } catch (SQLException e) {
        System.out.println("Exception: " + e);
        e.printStackTrace();
    } finally {
        if (st != null) try { st.close(); } catch (SQLException e) {}
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Exception closing ResultSet: " + e);
                e.printStackTrace();
              }
         }
    }

    return result;

// end of your code
}
    
    
    /**
     * Takes as input a name and address, and a TicketID, and changes the DriverID on the ticket to the DriverId 
     * of the driver who has the specified name and address.  Since (name, address) is UNIQUE in Drivers, 
     * there can’t be multiple Drivers with that name.  
     * If there are no people with that name and address,setTicketedDriver should do nothing. 
     * If there is no ticket with the specified TicketId, setTicketedDriver should also do nothing.
     * setTicketedDriver should be performed as a single SQL statement.
     */
    public void setTicketedDriver(String name, String address, int ticketID) {
        // your code here

        PreparedStatement st = null;
        int result;
    try{
        st = getConnection().prepareStatement("UPDATE Tickets SET licenseid = (SELECT licenseid FROM Drivers WHERE name = ? AND address = ? ) WHERE ticketid= ?");
        st.setString(1, name);
        st.setString(2, address);
        st.setInt(3, ticketID);
        result = st.executeUpdate();

        //TEST CODE----------------------------------------- 
        List<Integer> result2 = new ArrayList<Integer>();
        ResultSet rs = null;
        Statement st2 = null;
        st2 = connection.createStatement();

        rs = st2.executeQuery("SELECT licenseid FROM Tickets WHERE ticketid='"+ticketID+"'");

        while(rs.next()){ 
            result2.add(rs.getInt(1));   
        }

        System.out.println(" "+result2);
        //--------------------------------------------------

        //TEST CODE-----------------------------------------    
        //rs = st.executeQuery("SELECT licenseid FROM Tickets WHERE ticketid='"+ticketID+"'");
        
/*
        while(rs.next()){
        //System.out.println("***CHECKPOINT 3");
        testresults.add(rs.getInt(1));
        //System.out.println("***CHECKPOINT 4");
        System.out.println("TEZATEST-2.1 "+testresults);
      }

        //--------------------------------------------------
*/
    } catch (SQLException e) {
        System.out.println("Exception: " + e);
        e.printStackTrace();
    } finally {
        if (st != null) try { st.close(); } catch (SQLException e) {}
      
    }      

        // end of your code
    }
    
    
    /**
     * The getSomeTicketFees method takes as input an integer, stopTotal. getSomeTicketFees should
     * iterate through all the tickets whose Fee isn’t NULL in ascending TicketDate order, gathering their
     * TicketID.  getSomeTicketFees should total the fees on those tickets as it goes.  When
     * the total of the fees is more than stopTotal, then the method is finished; it should not 
     * look at or gather any more tickets.  If the total of the fees isn’t more than stopTotal 
     * but there are no more tickets to gather, then the method also should finish.
     * getSomeTicketFees should return all the TicketID values that it found,
     *
     * If stopTotal is not positive, then getSomeTicketFees should do nothing.  
     * Note that the Fee on a ticket can be NULL, but TicketDate can’t be NULL.
     */
    public List<Integer> getSomeTicketFees(int stopTotal){
    List<Integer> result = new ArrayList<Integer>();{
        // your code here
     List<Integer> preresult = new ArrayList<Integer>();
     List<Integer> midresult = new ArrayList<Integer>();
     Statement st = null;
     ResultSet rs = null;
     double dolcount = 0; 
     double maxValue = 0; 
     int count = 0;  
      try{
       //System.out.println("***CHECKPOINT 1");
      st = connection.createStatement();
      rs = st.executeQuery("SELECT fee FROM Tickets ORDER BY ticketdate ASC" );
        //System.out.println("***CHECKPOINT 2");

              while(rs.next()){
         //System.out.println("***CHECKPOINT 3");
         preresult.add(rs.getInt(1));
         maxValue = maxValue + rs.getInt(1);
         //System.out.println("***CHECKPOINT maxValue " +maxValue);
              }

         //System.out.println("***CHECKPOINT stopTotal " +stopTotal);
         while(dolcount<= stopTotal && dolcount<maxValue){

            if(preresult.get(count)!=null){
               //System.out.println("***CHECKPOINT DOLCOUNT= "+dolcount);
               midresult.add(preresult.get(count)); 
               //System.out.println("***CHECKPOINT Result= "+result);
               dolcount = dolcount + preresult.get(count);
               count++;  
               // end of your code 
            } 

          } 

        
        rs = st.executeQuery("SELECT ticketid FROM Tickets ORDER BY ticketdate ASC limit '"+(count)+"'");
        

         while(rs.next()){
            result.add(rs.getInt(1));
         }
         
      //System.out.println("***CHECKPOINT ResultLength " +count);
      } catch (SQLException e) {
        System.out.println("Exception: " + e);
        e.printStackTrace();
         } finally {
            if (st != null) try { st.close(); } catch (SQLException e) {}
            if (rs != null) {
               try {
                rs.close();
               } catch (SQLException e) {
                System.out.println("Exception closing ResultSet: " + e);
                e.printStackTrace();
              }
         }
    }
return result; 
}
}
}
