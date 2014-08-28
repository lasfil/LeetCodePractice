import java.util.Scanner;
public class StringReverseProcessor {
	private String orgString;
	private String revString;
	
	public String getOrgString() {
		return orgString;
	}
	public void setOrgString(String s) {
		this.orgString =s;
	}
	
	public String getRevString() {
		if(null != orgString && null == revString)
			this.process();
		
		return revString;
	}
	
	public String process() {
		if(null == orgString)
			return null;
		
		Scanner scan = new Scanner(orgString);
		scan.useDelimiter(" ");
		String sb = "";
		
		sb = scan.next();
		while(scan.hasNext()) {
			sb = scan.next() + " "  + sb;
		}
		
		revString = sb;
		scan.close();
		return revString;
		
	}
	
	public static void main(String[] args) {
		StringReverseProcessor srp = new StringReverseProcessor();
		srp.setOrgString("This processor will reverse  * a string");
		srp.process();
		System.out.println("Org String: " + srp.getOrgString());
		System.out.println("reversed String: " + srp.getRevString());
	}
}
