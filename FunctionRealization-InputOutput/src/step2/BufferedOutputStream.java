// BufferOutputStream 구현
package step2;

import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStream extends FileOutputStream {
    byte[] buf = new byte[8196];
    int cursor;
    
    public BufferedOutputStream(String filename) throws Exception {
        super(filename);
    }
    
    @Override
    public void write(int b) throws IOException {
        if (cursor == buf.length) {
            // 버퍼를 다 채우게 돼면 버퍼에 들어있는 데이터를 한 번에 출력한다.
            this.write(buf);
            cursor = 0;
        }
        
        buf[cursor++] = (byte) b;
    }
    
    @Override
    public void close() throws IOException {
        this.flush();
        super.close();
    }
    
    @Override
    public void flush() throws IOException {
        if (cursor > 0) {
            this.write(buf, 0, cursor);
            cursor = 0;
        }
    }
}
