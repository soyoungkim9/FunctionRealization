// BufferedInputStream을 사용 해 데이터 읽는데 걸리는 시간 측정
package step2;

public class Exam01 {
    public static void main(String[] args) throws Exception {
        BufferedInputStream in = new BufferedInputStream("temp/jls8.pdf");
        
        int b;
        
        long startTime = System.currentTimeMillis();
        
        int callCount = 0;
        while ((b = in.read()) != -1) callCount++;
        
        long endTime = System.currentTimeMillis();
        
        System.out.println(endTime - startTime);
        System.out.println(callCount);
        
        in.close();
    }
}
