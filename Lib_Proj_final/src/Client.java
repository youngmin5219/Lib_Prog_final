
public class Client {
	public String name;
	public String id;
	public int statusflag;		//�������� �л����� Ȯ���ϴ� flag  0�̸� �л�, 1�̸� ����
	
	
	Client(){
	}
	Client(String name, String studentid, int statusflag){
		this.name=name;
		this.id=studentid;
		this.statusflag=statusflag;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setStudnetid(String studentid) {
		this.id=studentid;
	}
	public String getStudentid() {
		return id;
	}
	public void setStatusFlag(int statusflag) {
		this.statusflag=statusflag;
	}
	public int getStatusFlag() {
		return statusflag;
	}
	
}
