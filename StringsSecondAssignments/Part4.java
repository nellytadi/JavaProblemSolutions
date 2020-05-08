
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {
    public void findAbc(String input) {
       int index = input.indexOf("abc");
       while (true){
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           System.out.println(index+1);
           System.out.println(index+4);
           System.out.println("index " + index);
           String found = input.substring(index+1, index+4);
           System.out.println(found);
           index = input.indexOf("abc",index+3);
           System.out.println("index after updating " + index);
       }
        
    }
    
    public void test() {
        //no code yet
        //findAbc("abcd");
        //findAbc("abcdefabcghi");
        //findAbc("abcdabc");
        //findAbc("aaaaabc");
        //findAbc("yabcyabc");
        //findAbc("woiehabchi");
        //findAbc("eusabce");
        //findAbc("abcbbbabcdddabc");
        //findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
        findAbc("abcabcabcabca");
     
    }
}
