
public class Book {
	boolean borrowable;	//대여 가능 여부
	String title;		//제목
	String author;		//저자
	String publisher;	//출판사
	String location; 	//청구기호
	String lender;		//대여자
	String lenderid;	//대여자id
	
	public Book() {
	}
	public Book(String title, String author, String publisher, String location, String lender, String lenderid) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.location = location;
		this.lender = lender;
		this.lenderid = lenderid;
	}
	public void setBorrowable(boolean borrowable) {
		this.borrowable = borrowable;
	}
	public boolean getBorrowalbe() {
		return borrowable;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}
	public void setPublisher(String publisher) {
		this.publisher=publisher;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setLocation(String location) {
		this.location=location;
	}
	public String getLocation() {
		return location;
	}
	public void setLender(String lender) {
		this.lender = lender;
	}
	public String getLender() {
		return lender;
	}
	public void setLenderId(String lenderid) {
		this.lenderid = lenderid;
	}
	public String getLenderId() {
		return lenderid;
	}
}
