package exp.test.strings;

public class Test {

  public static String replaceLast(String text, String regex, String replacement) {
      return text.replaceFirst("(?s)(.*)" + regex, "$1" + replacement);
  }
  
  public static String replaceLast2(String text, String regex, String replacement) {
//    return text.replaceFirst("(?s)(.*)\"", "$1" + replacement);
  	 return text.replaceFirst("\"", "").replaceFirst("(?s)(.*)\"", "$1");
}
  
  public static String replaceAll(String text) {
//  	return text.replaceAll("\";\"", ";");
  	return text.replaceAll("\"\";\"\"", ";");
  }

  public static void main(String[] args) {
//      System.out.println(replaceLast2("\"aaabbb__\"", "\"", ""));
      
  	
  	String text2 = "\"\"PIA MAST FONDS TRAD \"\";\"\"90203,17\"\"";
  	
      String text = "\"\"---AAA__BBB---\"\"";
      System.out.println(text2);
      System.out.println(replaceAll(text2));
  }
}
