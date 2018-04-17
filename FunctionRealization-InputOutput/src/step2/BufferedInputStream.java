// BufferedInputStream 구현
package step2;

import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStream extends FileInputStream {
    byte[] buf = new byte[8196];
    int size;
    int cursor;
    
    public BufferedInputStream(String filename) throws Exception {
        super(filename);
    }
    
    @Override
    public int read() throws IOException {
        if (cursor == size) {
            if ((size = this.read(buf)) == -1) { 
                // 읽어들인 데이터를 buf에 저장하고 크기를 리턴한다.
                // 읽어들일 데이터가 없으면 -1 리턴
                return -1;
            }
            // 버퍼에 존재하는 데이터만큼 다 읽었으면 cursor를 0으로 초기화하여
            // 다음 데이터를 받아들여 읽을 수 있는 준비를 한다.
            cursor = 0;
        }
        // 버퍼에 있는 데이터 출력
        // 외부에서 반복문 호출시 cursor를 통해 모든 데이터를 출력해 낼 수 있다.
        return buf[cursor++] & 0x000000ff;
    }
}
