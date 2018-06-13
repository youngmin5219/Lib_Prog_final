import java.io.*;
import java.util.*;

public class Reader {
	 ArrayList<Book> bookobj = new ArrayList<Book>();
	 
	public ArrayList<Book> read() throws IOException{//csv파일로 부터 책의 이름, 저자, 출판사, 청구기호, 대여자, 대여자 id를 읽어온다.
		java.io.Reader isr;
		BufferedReader br = null;
	    InputStream fis;
	    try {
	         fis = new FileInputStream ("Data.csv");
	         isr = new InputStreamReader (fis);
	         br  = new BufferedReader (isr);

	         String data;
	         while ((data = br.readLine()) != null) {
	                // use comma as separator
	                String[] a = data.split(",");
	                Book book = new Book(a[2],a[3],a[4],a[5],a[6],a[7]);//책의 이름, 저자, 출판사, 청구기호, 대여자, 대여자id
	                bookobj.add(book);
	            }

	      } catch (FileNotFoundException e) {
	         e.printStackTrace ();
	      }	catch (IOException e) {
		         e.printStackTrace ();
		  } 
	      finally {
	    	  br.close();
	      }
	      return bookobj;
	}
}