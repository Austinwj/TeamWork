package test;

public class test {
	public  static void  st(String str){
		    System.out.println(str.hashCode());
		    str = str.replace("1","2");
		    System.out.println(str.hashCode());
		}
		public static void st1(StringBuffer stringBuffer){
//		    stringBuffer.append("S");
		    stringBuffer = new StringBuffer("567");
		    stringBuffer.append("890");
		}
		public static void main(String...args){
		    String s = "112";
		    st(s);
		    System.out.println(s);
		    System.out.println(s.hashCode());
		    StringBuffer str1 = new StringBuffer("sss");
		    System.out.println(str1);
		    st1(str1);
		    System.out.println(str1);
		}



}
