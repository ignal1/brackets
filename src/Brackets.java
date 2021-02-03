import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* На диске С: нужно создать файл 'text.txt' и поместить в него
* строку, которую нужно проверить на корректность скобок, после
* чего запустить программу. Ответ будет выведен на консоль.
* */

public class Brackets {
    private static List<Character> charArray;
    private static Stack<Character> stack;
    public static void main(String[] args) {
        new Brackets();
        System.out.println(Brackets.check());
    }

    private Brackets() {
        try(FileReader fr = new FileReader("C://text.txt")){
            charArray = new ArrayList<>();
            int n;
            while((n = fr.read()) != -1){
                charArray.add((char)n);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static boolean check(){
        stack = new Stack<>();
        for (char item : charArray) {
            if(item == '(' || item == '[' || item == '{'){
                stack.push(item);
            }
            if(item == ')'){
                if(stack.empty()){
                    return false;
                }
                char tmp = stack.pop();
                if(tmp != '('){
                    return false;
                }
            }
            if(item == ']'){
                if(stack.empty()){
                    return false;
                }
                char tmp = stack.pop();
                if(tmp != '['){
                    return false;
                }
            }
            if(item == '}'){
                if(stack.empty()){
                    return false;
                }
                char tmp = stack.pop();
                if(tmp != '{'){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
