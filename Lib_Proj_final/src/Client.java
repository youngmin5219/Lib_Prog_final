
public class Client {
	public String name;
	public String id;
	public int statusflag;		//교수인지 학생인지 확인하는 flag  0이면 학생, 1이면 교수
	
	
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
