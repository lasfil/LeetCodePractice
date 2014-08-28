import java.util.Scanner;
import java.util.Stack;
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
		
		if(null == orgString || orgString.matches("\\s*")){
			revString = orgString;			
		} else {
			Scanner scan = new Scanner(orgString);
			scan.useDelimiter("\\s+");
			
			revString = scan.next();
			while(scan.hasNext())
				revString = scan.next() + " " + revString;
			scan.close();
		}
		
		revString = revString.trim();
		
		return revString;
		
	}
	
	public static void main(String[] args) {
		StringReverseProcessor srp = new StringReverseProcessor();
		srp.setOrgString(" ");
		srp.process();
		System.out.println("Org String:" + srp.getOrgString() + ".");
		System.out.println("reversed String:" + srp.getRevString() + ".");
	}
}
