package com.proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proj.model.BookInfo;
import com.proj.model.IssusedBookInfo;
import com.proj.model.LibarianInfo;

public class DBLogic {
	
	public boolean LibarianInfoStoreInDB(LibarianInfo lobj)
	{
		Connection conobj=null;
		PreparedStatement pst=null;
		boolean f=false;
		try
		{
			conobj=DBConnect.getDBConnection();
			pst=conobj.prepareStatement("insert into libarian values(?,?,?,?)");
			
			pst.setString(1, lobj.getName());
			pst.setString(2, lobj.getEmail());
			pst.setString(3, lobj.getPassword());
			pst.setString(4, lobj.getMobileno());
			
			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}
		catch(SQLException e) {System.out.println(e.toString());}
		return f;
	}
	
	public LibarianInfo LibarianLogin(String email,String password)
	{
		Connection conobj=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		LibarianInfo lobj=null;
		try
		{
			conobj=DBConnect.getDBConnection();
			pst=conobj.prepareStatement("select * from libarian where email=? and password=?");
			pst.setString(1, email);
			pst.setString(2, password);
			rs=pst.executeQuery();
			if(rs.next())
			{
				lobj=new LibarianInfo();
				
				lobj.setName(rs.getString(1));
				lobj.setEmail(rs.getString(2));
				lobj.setPassword(rs.getString(3));
				lobj.setMobileno(rs.getString(4));
			}
		}
		catch(SQLException e) {System.out.println(e.toString());}
		
		
		return lobj;
	}
	
	public List<LibarianInfo> fetchLibarians()
	{
		Connection conobj=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<LibarianInfo> liblist=new ArrayList<LibarianInfo>();
		
		try
		{
			conobj=DBConnect.getDBConnection();
			pst=conobj.prepareStatement("select * from libarian");
			rs=pst.executeQuery();
			while(rs.next())
			{
				LibarianInfo lobj=new LibarianInfo();
				lobj.setName(rs.getString(1));
				lobj.setEmail(rs.getString(2));
				lobj.setPassword(rs.getString(3));
				lobj.setMobileno(rs.getString(4));
				
				liblist.add(lobj);
			}
		}
		catch(SQLException e) {System.out.println(e.toString());};
		
		return liblist;
	}
	
	
	
	public boolean SaveBook(BookInfo bobj)
	{
		Connection conobj=null;
		PreparedStatement pst=null;
		boolean f=false;
		
		try
		{
			conobj=DBConnect.getDBConnection();
			pst=conobj.prepareStatement("insert into book values(?,?,?,?,?,?)");
			
			pst.setString(1, bobj.getCallno());
			pst.setString(2, bobj.getName());
			pst.setString(3, bobj.getAuthor());
			pst.setString(4, bobj.getPublisher());
			pst.setInt(5, bobj.getQuantity());
			pst.setInt(6, 0);
			
			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}
		catch(SQLException e) {System.out.println(e.toString());}
		
		return f;
	}
	
	
	public static int getIssued(String callno){
		int issued=0;
		Connection conobj=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
				
		try{
			conobj=DBConnect.getDBConnection();
			pst=conobj.prepareStatement("select * from book where callno=?");
			pst.setString(1,callno);
			rs=pst.executeQuery();
			if(rs.next()){
				issued=rs.getInt("issued");
			}
			
		}catch(Exception e){System.out.println(e);}
		
		return issued;
	}
	
	public static boolean checkIssue(String callno){
		boolean status=false;
		Connection conobj=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			conobj=DBConnect.getDBConnection();
			pst=conobj.prepareStatement("select * from book where callno=? and quantity>issued");
			pst.setString(1,callno);
			rs=pst.executeQuery();
			if(rs.next()){
				status=true;
			}
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	
	}
	
	
	public int issueBook(IssusedBookInfo ibobj){
		String callno=ibobj.getCallno();
		boolean checkstatus=checkIssue(callno);
		System.out.println("Check status: "+checkstatus);
		if(checkstatus){
			int status=0;
			try{
				Connection conobj=DBConnect.getDBConnection();
				PreparedStatement pst=conobj.prepareStatement("insert into issuebook values(?,?,?,?,?,?)");
				pst.setString(1,ibobj.getCallno());
				pst.setString(2,ibobj.getStudentid());
				pst.setString(3,ibobj.getStudentname());
				pst.setLong(4,ibobj.getStudentphno());
				java.sql.Date currentDate=new java.sql.Date(System.currentTimeMillis());
				pst.setDate(5,currentDate);
				pst.setString(6,"no");
				
				status=pst.executeUpdate();
				if(status>0){
					PreparedStatement pst2=conobj.prepareStatement("update book set issued=? where callno=?");
					pst2.setInt(1,getIssued(callno)+1);
					pst2.setString(2,callno);
					status=pst2.executeUpdate();
				}
				
			}catch(Exception e){System.out.println(e);}
			
			return status;
		}
		else
		{
			return 0;
		}
	}
	
	
	public int returnBook(String callno,String studentid){
		int status=0;
			try{
				Connection conobj=DBConnect.getDBConnection();
				PreparedStatement pst=conobj.prepareStatement("update issuebook set returnstatus='yes' where callno=? and studentid=?");
				pst.setString(1,callno);
				pst.setString(2,studentid);
				
				status=pst.executeUpdate();
				if(status>0){
					PreparedStatement pst2=conobj.prepareStatement("update book set issued=? where callno=?");
					pst2.setInt(1,getIssued(callno)-1);
					pst2.setString(2,callno);
					status=pst2.executeUpdate();
				}
				
			}catch(Exception e){System.out.println(e);}
			
			return status;
	}
	
	
	public List<BookInfo> fetchBooks()
	{
		Connection conobj=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<BookInfo> blist=new ArrayList<BookInfo>();
		
		try
		{
			conobj=DBConnect.getDBConnection();
			pst=conobj.prepareStatement("select * from book");
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				BookInfo bobj=new BookInfo();
				
				bobj.setCallno(rs.getString(1));
				bobj.setName(rs.getString(2));
				bobj.setAuthor(rs.getString(3));
				bobj.setPublisher(rs.getString(4));
				bobj.setQuantity(rs.getInt(5));
				bobj.setIssued(rs.getInt(6));
				
				blist.add(bobj);
			}
		}
		catch(SQLException e) {System.out.println(e.toString());}
		
		return blist;
	}
	
	
	public List<IssusedBookInfo> fetchIssusedBook()
	{
		Connection conobj=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<IssusedBookInfo> iblist=new ArrayList<IssusedBookInfo>();
		
		try
		{
			conobj=DBConnect.getDBConnection();
			pst=conobj.prepareStatement("select * from issuebook");
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				IssusedBookInfo ibobj=new IssusedBookInfo();
				
				ibobj.setCallno(rs.getString(1));
				ibobj.setStudentid(rs.getString(2));
				ibobj.setStudentname(rs.getString(3));
				ibobj.setStudentphno(rs.getLong(4));
				ibobj.setIssueddate(rs.getDate(5));
				ibobj.setReturnstatus(rs.getString(6));
				
				iblist.add(ibobj);
			}
		}
		catch(SQLException e) {System.out.println(e.toString());}
		
		return iblist;
	}
	
	
	public boolean deleteBook(String callno)
	{
		Connection conobj=null;
		PreparedStatement pst=null;
		boolean f=false;
		
		try
		{
			conobj=DBConnect.getDBConnection();
			pst=conobj.prepareStatement("delete from book where callno=?");
			pst.setString(1, callno);
			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}
		catch(SQLException e) {System.out.println(e.toString());}
		
		return f;
		
	}
	
	public boolean BookUpdate(BookInfo bobj)
	{
		Connection conobj=null;
		PreparedStatement pst=null;
		boolean f=false;
		try
		{
			conobj=DBConnect.getDBConnection();
			pst=conobj.prepareStatement("update book set quantity=? where callno=?");
			
			pst.setInt(1,bobj.getQuantity());
			pst.setString(2,bobj.getCallno());
			
			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}catch(SQLException e) {System.out.println(e.toString());}	
		return f;
	}
	
	public boolean deleteLibarian(String email)
	{
		Connection conobj=null;
		PreparedStatement pst=null;
		boolean f=false;
		try
		{
			conobj=DBConnect.getDBConnection();
			pst=conobj.prepareStatement("delete from libarian where email=?");
			pst.setString(1, email);
			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}
		catch(SQLException e) {System.out.println(e.toString());}
		
		return f;
	}
	
	
	
	public List<BookInfo> fetchBooksByCallno(String callno)
	{
		Connection conobj=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<BookInfo> blist=new ArrayList<BookInfo>();
		
		try
		{
			conobj=DBConnect.getDBConnection();
			pst=conobj.prepareStatement("select * from book where callno=?");
			pst.setString(1, callno);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				BookInfo bobj=new BookInfo();
				
				bobj.setCallno(rs.getString(1));
				bobj.setName(rs.getString(2));
				bobj.setAuthor(rs.getString(3));
				bobj.setPublisher(rs.getString(4));
				bobj.setQuantity(rs.getInt(5));
				bobj.setIssued(rs.getInt(6));
				
				blist.add(bobj);
			}
		}
		catch(SQLException e) {System.out.println(e.toString());}
		
		return blist;
	}
	
	public boolean LibarianUpdate(LibarianInfo lobj)
	{
		Connection conobj=null;
		PreparedStatement pst=null;
		boolean f=false;
		try
		{
			conobj=DBConnect.getDBConnection();
			pst=conobj.prepareStatement("update libarian set name=?,password=?,mobileno=? where email=?");
			
			pst.setString(1,lobj.getName());
			pst.setString(2,lobj.getPassword());
			pst.setString(3, lobj.getMobileno());
			pst.setString(4, lobj.getEmail());
			
			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}catch(SQLException e) {System.out.println(e.toString());}	
		return f;
	}
	

}
