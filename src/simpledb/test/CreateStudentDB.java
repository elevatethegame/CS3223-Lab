package simpledb.test;
import simpledb.tx.Transaction;
import simpledb.plan.Planner;
import simpledb.server.SimpleDB;

public class CreateStudentDB {
   public static void main(String[] args) {
	  SimpleDB db = new SimpleDB("studentdb");
	  Transaction tx = db.newTx();
	  Planner planner = db.planner();
	  
	  // Create Student Table
	  String cmd = "create table STUDENT(SId int, SName varchar(10), MajorId int, GradYear int)";
	  planner.executeUpdate(cmd, tx);
	  System.out.println("Table STUDENT created.");
	  
	  // Insert Student records
      String[] studvals = {"(1, 'joe', 10, 2021)",
            "(2, 'amy', 20, 2020)",
            "(3, 'max', 10, 2022)",
            "(4, 'sue', 20, 2022)",
            "(5, 'bob', 30, 2020)",
            "(6, 'kim', 20, 2020)",
            "(7, 'art', 30, 2021)",
            "(8, 'pat', 20, 2019)",
      "(9, 'lee', 10, 2021)"};
      for (int i=0; i<studvals.length; i++) {
    	  cmd = "insert into STUDENT(SId, SName, MajorId, GradYear) values " + studvals[i];
    	  planner.executeUpdate(cmd, tx);
      }
      System.out.println("STUDENT records inserted.");
      
      // Create Department Table
      cmd = "create table DEPT(DId int, DName varchar(8))";
      planner.executeUpdate(cmd, tx);
      System.out.println("Table DEPT created.");
      
      // Insert Department Records
      String[] deptvals = {"(10, 'compsci')",
              "(20, 'math')",
              "(30, 'drama')"};
      for (int i=0; i<deptvals.length; i++) {
    	  cmd = "insert into DEPT(DId, DName) values " + deptvals[i];
    	  planner.executeUpdate(cmd, tx);	  
      }
	  System.out.println("DEPT records inserted.");
	
	  // Create Course Table
	  cmd = "create table COURSE(CId int, Title varchar(20), DeptId int)";
	  planner.executeUpdate(cmd, tx);
	  System.out.println("Table COURSE created.");
	
	  // Insert Course Records
	  String[] coursevals = {"(12, 'db systems', 10)",
	                        "(22, 'compilers', 10)",
	                        "(32, 'calculus', 20)",
	                        "(42, 'algebra', 20)",
	                        "(52, 'acting', 30)",
	                        "(62, 'elocution', 30)"};
	  for (int i=0; i<coursevals.length; i++) {
		  cmd = "insert into COURSE(CId, Title, DeptId) values " + coursevals[i];
    	  planner.executeUpdate(cmd, tx);	  
	  }
	  System.out.println("COURSE records inserted.");
	
	  // Create Section Table
 	  cmd = "create table SECTION(SectId int, CourseId int, Prof varchar(8), YearOffered int)";
 	  planner.executeUpdate(cmd, tx);
 	  System.out.println("Table SECTION created.");
	
 	  // Insert Section Records
	  String[] sectvals = {"(13, 12, 'turing', 2018)",
              "(23, 12, 'turing', 2019)",
              "(33, 32, 'newton', 2019)",
              "(43, 32, 'einstein', 2017)",
              "(53, 62, 'brando', 2018)"};
	  for (int i=0; i<sectvals.length; i++) {
		  cmd = "insert into SECTION(SectId, CourseId, Prof, YearOffered) values " + sectvals[i];
   	  	  planner.executeUpdate(cmd, tx);	  
	  }
	  System.out.println("SECTION records inserted.");
	
	  // Create Enrollment Table
	  cmd = "create table ENROLL(EId int, StudentId int, SectionId int, Grade varchar(2))";
	  planner.executeUpdate(cmd, tx);
	  System.out.println("Table ENROLL created.");
	 
	  //Insert Enrollment Records
	  String[] enrollvals = {"(14, 1, 13, 'A')",
              "(24, 1, 43, 'C' )",
              "(34, 2, 43, 'B+')",
              "(44, 4, 33, 'B' )",
              "(54, 4, 53, 'A' )",
              "(64, 6, 53, 'A' )"};
	  for (int i=0; i<enrollvals.length; i++) {
		  cmd = "insert into ENROLL(EId, StudentId, SectionId, Grade) values " + enrollvals[i];
   	  	  planner.executeUpdate(cmd, tx);	  
	  }
	  System.out.println("ENROLL records inserted.");
	  
	  tx.commit();

   }
}
