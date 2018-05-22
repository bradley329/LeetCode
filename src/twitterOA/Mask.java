package twitterOA;

public class Mask {
	public static void main(String[] args) {
//      Scanner sc = new Scanner(System.in);
//      while(sc.hasNextLine()) {
//              String input = sc.nextLine();
//              String toMask = input.substring(2).trim();
//              if(input.startsWith("E:")) {
//                      System.out.println(maskEmail(toMask));
//              } else {
//                      System.out.println(maskPhone(toMask));
//              }
//      }
//      sc.close();
      System.out.println(maskEmail("jackAndJill@twitter.com"));
      System.out.println(maskPhone("+1333 444 5678"));
}

public static String maskEmail(String input) {
      int length = input.length();
      //Case when user did not enter email address
      if (length==0) {
              return "";
      }
      int at = input.indexOf('@');
      
      //Case when username is shorter than 3
      if (at < 2) {
              return input;
      }
      
      StringBuilder st = new StringBuilder();
      st.append(input.charAt(0));
      st.append("*****");
      st.append(input.charAt(at-1));
      st.append(input.substring(at));
      return st.toString();
}


public static String maskPhone(String input) {
      int length = input.length();
      int visibleNumbers = 4;
      int localCode  = 7;
      int totalNumber = 10;
      int numberHaveSeen = 0;
      StringBuilder st = new StringBuilder();
      for (int i=length-1; i>=0; i--) {
              char current = input.charAt(i);
              if(!Character.isDigit(current)) continue;
              
              if(numberHaveSeen == visibleNumbers || numberHaveSeen == localCode || numberHaveSeen == totalNumber) {
                      st.append("-");
              }
              if (numberHaveSeen < visibleNumbers) {
                      st.append(current);
              } else {
                      st.append("*");
              }
              numberHaveSeen++;
      }
      
      if (numberHaveSeen > totalNumber) {
              st.append("+");
      }
      return st.reverse().toString();
	}
}
