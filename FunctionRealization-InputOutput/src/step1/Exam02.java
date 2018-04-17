package step1;

public class Exam02 {
    public static void main(String[] args) throws Exception {
        DataInputStream in = new DataInputStream("temp/test1.data");
        
        Member member = null;
        member = new Member();

        member.name = in.readUTF();
        member.age = in.readInt();
        member.gender = in.readBoolean();
        
        in.close();
        
        // member.toString()을 의미한다.
        System.out.printf("%s\n", member);
    }
}
