public class MyFirstProgram{
    public static void main(String args[]){
        String name = "Obinna";
        String greeting = String.format("Hello {0}", name);
        System.out.println(greeting);
    }
}