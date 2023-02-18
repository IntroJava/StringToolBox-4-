
public class StringToolBox {

	public String nameEcho(String s) { // Caps on lastname
		s = s.trim();
		int start = s.indexOf(" ");

		String lastName = s.substring(start);
		lastName = lastName.toUpperCase();

		s = s.substring(0, start);

		return s + lastName;
	}

	public boolean endsWithStar(String s) { // tests if end of a string has the char '*'
			return false;
	}

	public boolean endsWithTwoStars(String s) { // tests if end of a string has the string "**"
			return false;
	}

	public String last4(String s) { // returns last 4 chars of a string
		return "";
	}

	public String last5(String s) { // returns last 5 chars of a string
		return "";
	}

	public String scroll(String s) { // moves the first char of a string to the last char
		return "";
	}

	public String convertName(String s) { // moves lastname and firstname around, gets rid of ','
		return "";
	}

	public String delete2(String s) { // R&D, deletes first 2 chars, and turns it all to caps, as well as adding a '!'
		return "";
	}

	public String removeDashes(String s) // removes the dashes out of a string
	{
		return "";
	}

	public String dateStr(String s) { //removes '/' out of date
		return "";
	}

	public String negativeBits(String s) {//replaces '0' with '1' and '1' with '0'
		s = s.trim();
		s = s.replaceAll("0", "3");
		s = s.replaceAll("1", "0");
		s = s.replaceAll("3", "1");
		return s;
	}

	public boolean containsSameChar(String s) { //tests to see if all the chars are the same in a sequence

			int mid = s.length()/2;
			
			if ((s.substring(0, mid)).contentEquals(s.substring(mid-1, s.length()-1)))
				{
					return true;
				}
			
			else if ((s.substring(0, mid)).contentEquals(s.substring(mid, s.length()-1)) 
					&& s.charAt(mid) == s.charAt(0))
				{
					return true;
				}
			
			return false; //METHODS CAN ONLY RETURN ONE VALUE!
						 //WHEN THE IF STATEMENTS ARE TRUE, THEY RETURN A VALUE
						//REPLACE STRING WITH "" AT REOCCURENCE OF ALL SAME LETTERS
	}
	
	public String removeComments(String s)
	{
		String x;
		int firstCom;
		int lastCom;
		
		do {
			firstCom=0;
			lastCom=0;
			
				for(int i=0; i<=s.length()-2;i++)
				{
					x=s.substring(i, i+2);
					
					if(x.contentEquals("/*"))
					{
						firstCom=i;
					}
					else if(x.contentEquals("*/"))
					{
						lastCom = i+2;
						s=s.substring(0,firstCom)+s.substring(lastCom);
						break;
					}
				}
		}while(lastCom!=0);
		return s;
				
	}
	
	public String caesar(String s, int n) {
		
		String lower="abcdefghijklmnopqrstuvwxyz";
		String upper= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char oldChar;
		char newChar;
		String endString="";
		int index;
		
		
		for(int i=0;i<s.length();i++)
		{
			oldChar=s.charAt(i); //ONLY WANT TO REPLACE THE ONE AT THAT INDEX OTHERWISE IT'LL KEEP REPLACING WHAT YOU'VE DONE BEFORE
				
				if (Character.isUpperCase(oldChar)) //if an uppercase letter
				{
					index=upper.indexOf(oldChar); 
					
					if (index+n<=25 && index+n>=0)
					{
						newChar=upper.charAt(index+n);
						endString += newChar; //adding to create a new string with the new chars
					}
					else if (index+n<0)
					{
						index=index+n+26;
						newChar=upper.charAt(index);
						endString += newChar;
					}
					else if (index+n>25)
					{
						index= index+n-26;
						newChar=upper.charAt(index);
						endString += newChar;
					}
				}
				
				else if (Character.isLowerCase(oldChar)) //if a lowercase letter
				{
					index=lower.indexOf(oldChar);
					
					if (index+n<=25 && index+n>=0)
					{
						newChar=lower.charAt(index+n);
						endString += newChar;
					}
					
					else if (index+n<0)
					{
						index=index+n+26;
						newChar=lower.charAt(index);
						endString += newChar;
					}
					
					else if (index+n>25)
					{
						index= index+n-26;
						newChar=lower.charAt(index);
						endString += newChar;
					}
				}
				else //if not a letter
				{
					endString+=oldChar;
				}
			
		}
		return endString;
	}
	
	public boolean isPalindrome(String s)
	{	

		for (int i=0; i<=s.length()-1; i++)
		{
			if (!Character.isAlphabetic(s.charAt(i)))
				s=s.replace(s.charAt(i), ' ');
		}
		
		s=s.replaceAll(" ", "");
		
		String backwards= "";
	
		for(int lastIndex = s.length()-1; lastIndex>=0; lastIndex--)
			{
					backwards += s.charAt(lastIndex);
			}
		
		if (backwards.equalsIgnoreCase(s)) 
				return true;
		
		else
				return false;
	}
	
	public boolean validPassword(String s)
	{
		boolean space= false; //has space=false
		boolean upper= false; //no upper=false
		boolean lower= false; //no lower=false
		boolean num= false; //no num=false
		boolean length= false; //<7=false
		
		if (s.length()>=7) 
			length = true;
		
		for (int i=0; i<s.length(); i++)
		{
			if (Character.isWhitespace(s.charAt(i))) {
				space = false;   //Will exit if the char is a space, meaning space=false
				break; //Otherwise will continue loop, meaning space=true
			}
			else
				space = true;
		}
		
		for (int i=0; i<s.length(); i++)
		{
			if (!Character.isUpperCase(s.charAt(i))) {
				upper = true;
				//Will exit if the char is uppercase, meaning that upper=true
				break; //Otherwise will continue until finds an uppercase, meaning upper=false
			}
		}
		
		for (int i=0; i<s.length(); i++)
		{
			if (Character.isLowerCase(s.charAt(i))) {
				lower = true; //Will exit if the char is lowercase, meaning that lower=true
				break; //Otherwise will continue until finds a lowercase, meaning lower=false
			}	
		}
		
		for (int i=0; i<s.length(); i++)
		{
			if (Character.isDigit(s.charAt(i))) {
				num = true; //Will exit if the char is a num, meaning that num=true
				break; //Otherwise will continue until it finds a num, meaning num=false
			}
		}
		
		if (length && space && upper && lower && num) //if all conditions are true
			return true;
		else
			return false;

	}
}