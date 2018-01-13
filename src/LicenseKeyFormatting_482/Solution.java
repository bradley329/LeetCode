package LicenseKeyFormatting_482;

public class Solution {
	public static String licenseKeyFormatting(String s, int k) {
		StringBuilder sb = new StringBuilder();
		int index = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != '-') {
				index ++;
				if (index > k) {
					System.out.println("awa");
					index = 1;
					sb.append('-');
				}
				sb.append(s.charAt(i));
			}  
		}   
        return sb.reverse().toString().toUpperCase();
	}
	
	public static void main(String[] args) {
		String teString = "2-5g-3-J";
		System.out.print(licenseKeyFormatting(teString, 2));
	}
}
