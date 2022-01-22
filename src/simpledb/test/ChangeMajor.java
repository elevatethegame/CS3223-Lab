package simpledb.test;

import simpledb.plan.Planner;
import simpledb.server.SimpleDB;
import simpledb.tx.Transaction;

public class ChangeMajor {
   public static void main(String[] args) {
	   // analogous to the driver
	   SimpleDB db = new SimpleDB("studentdb");
	
	   // analogous to the connection
	   Transaction tx  = db.newTx();
	   Planner planner = db.planner();

	   String cmd = "update STUDENT "
               + "set MajorId=30 "
               + "where SName = 'amy'";
	   
	   planner.executeUpdate(cmd, tx);
	   System.out.println("Amy is now a drama major.");
	   
	   tx.commit();
      
   }
}
