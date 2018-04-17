// DataOutputStream 구현 - 전체 bytestream을 써낸다.
package step1;

import java.io.FileOutputStream;

public class DataOutputStream extends FileOutputStream {
    public DataOutputStream(String filename) throws Exception {
        super(filename);
    }
    
    public void writeUTF(String str) throws Exception {
        byte[] bytes = str.getBytes("UTF-8");
        this.write(bytes.length);
        this.write(bytes);
    }
    
    public void writeInt(int value) throws Exception {
        this.write(value >> 24);
        this.write(value >> 16);
        this.write(value >> 8);
        this.write(value); 
    }
    
    public void writeLong(long value) throws Exception {
        this.write((int)value >> 56);
        this.write((int)value >> 48);
        this.write((int)value >> 40);
        this.write((int)value >> 32);
        this.write((int)value >> 24);
        this.write((int)value >> 16);
        this.write((int)value >> 8);
        this.write((int)value);
    }
    
    public void writeBoolean(boolean value) throws Exception {
        if (value)
            this.write(1);
        else
            this.write(0);
    }
}
