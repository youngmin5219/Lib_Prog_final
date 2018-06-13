import java.io.*;
import java.util.*;

public class Reader1 {//����� ���� �о��
	ArrayList<Client> clientobj = new ArrayList<Client>();//����� ���

	public ArrayList<Client> read() throws IOException{//csv���Ϸκ��� ����� ���� �޾ƿ�
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
				if(a[2].matches("�л�")) {//�л� ���� ���п��� �л��ΰ��
					Client client = new Client(a[0],a[1],0);//�̸�,id, �л��ΰ�� statusflag=0
					clientobj.add(client);
				}
				else {
					Client client = new Client(a[0],a[1],1);//�̸�,id,�����ΰ�� statusflag=1
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