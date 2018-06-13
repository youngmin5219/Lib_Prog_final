import java.io.*;
import java.util.*;

public class Reader1 {//사용자 정보 읽어옴
	ArrayList<Client> clientobj = new ArrayList<Client>();//사용자 목록

	public ArrayList<Client> read() throws IOException{//csv파일로부터 사용자 정보 받아옴
		java.io.Reader isr;
		BufferedReader br = null;
		InputStream fis;
		try {
			fis = new FileInputStream ("Client.csv");
			isr = new InputStreamReader (fis);
			br =  new BufferedReader (isr);
			
			String data;
			while ((data = br.readLine()) !=null) {
				String[] a = data.split(",");
				if(a[2].matches("학생")) {//학생 교수 구분에서 학생인경우
					Client client = new Client(a[0],a[1],0);//이름,id, 학생인경우 statusflag=0
					clientobj.add(client);
				}
				else {
					Client client = new Client(a[0],a[1],1);//이름,id,교수인경우 statusflag=1
					clientobj.add(client);
				}
			}
	}catch (FileNotFoundException e) {
        e.printStackTrace ();
     }	catch (IOException e) {
	         e.printStackTrace ();
	  } 
     finally {
   	  br.close();
     }
     return clientobj;
}
}