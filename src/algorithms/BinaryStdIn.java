package algorithms;
/**
 * 该文件参考自Robert Sedgewick大师的代码
 */
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

public final class BinaryStdIn {
    private static BufferedInputStream in = new BufferedInputStream(System.in);
    //文件结束符
    private static final int EOF = -1;

    private static int buffer;            //一个字节的缓存
    private static int n;                 //缓存中剩余的二进制位数

    //静态初始化代码块
    static {
        fillBuffer();
    }

    // 不能通过外部实例化
    private BinaryStdIn() { }

    private static void fillBuffer() {
        try {
            buffer = in.read();
            n = 8;
        }
        catch (IOException e) {
            System.out.println("EOF");
            buffer = EOF;
            n = -1;
        }
    }

   /**
     * 关闭这个输入流并且释放与之相关的所有系统资源
     */
    public static void close() {
        try {
            in.close();
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Could not close BinaryStdIn", ioe);
        }
    }

   /**
     * 如果标准输入为空则返回true
     * @return true 当且只当标准输入流为空
     */
    public static boolean isEmpty() {
        return buffer == EOF;
    }

   /**
     * 读取标准输入流中的下一个二进制位并返回为一个boolean值
     *
     * @return 以 {@code boolean} 值的方式返回下一个二进制位
     * @throws NoSuchElementException if standard input is empty
     */
    public static boolean readBoolean() {
        if (isEmpty()) throw new NoSuchElementException("Reading from empty input stream");
        n--;
        boolean bit = ((buffer >> n) & 1) == 1;
        if (n == 0) fillBuffer();
        return bit;
    }

   /**
     * 从标准输入流读取下一个8位二进制数并返回为字符
     *
     * @return 以8-bits表示的 {@code char} 字符数据
     * @throws NoSuchElementException if there are fewer than 8 bits available on standard input
     */
    public static char readChar() {
        if (isEmpty()) throw new NoSuchElementException("Reading from empty input stream");

        // 特殊情况
        if (n == 8) {
            int x = buffer;
            fillBuffer();
            return (char) (x & 0xff);
        }

        // 合并当前缓存中的后n位和下一个缓存中的前8-n位
        int x = buffer;
        x <<= (8 - n);
        int oldN = n;
        fillBuffer();
        if (isEmpty()) throw new NoSuchElementException("Reading from empty input stream");
        n = oldN;
        x |= (buffer >>> n);
        return (char) (x & 0xff);
        //以上代码对最后一个字符不适用，因为最后一个字符的n为-1
    }

    public static char readChar(int r) {
        if (r < 1 || r > 16) throw new IllegalArgumentException("Illegal value of r = " + r);

        // optimize r = 8 case
        if (r == 8) return readChar();

        char x = 0;
        for (int i = 0; i < r; i++) {
            x <<= 1;
            boolean bit = readBoolean();
            if (bit) x |= 1;
        }
        return x;
    }

    public static String readString() {
        if (isEmpty()) throw new NoSuchElementException("Reading from empty input stream");

        StringBuilder sb = new StringBuilder();
        while (!isEmpty()) {
            char c = readChar();
            sb.append(c);
        }
        return sb.toString();
    }


    public static short readShort() {
        short x = 0;
        for (int i = 0; i < 2; i++) {
            char c = readChar();
            x <<= 8;
            x |= c;
        }
        return x;
    }

    public static int readInt() {
        int x = 0;
        for (int i = 0; i < 4; i++) {
            char c = readChar();
            x <<= 8;
            x |= c;
        }
        return x;
    }

    public static int readInt(int r) {
        if (r < 1 || r > 32) throw new IllegalArgumentException("Illegal value of r = " + r);

        // optimize r = 32 case
        if (r == 32) return readInt();

        int x = 0;
        for (int i = 0; i < r; i++) {
            x <<= 1;
            boolean bit = readBoolean();
            if (bit) x |= 1;
        }
        return x;
    }

    public static long readLong() {
        long x = 0;
        for (int i = 0; i < 8; i++) {
            char c = readChar();
            x <<= 8;
            x |= c;
        }
        return x;
    }


    public static double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public static float readFloat() {
        return Float.intBitsToFloat(readInt());
    }


    public static byte readByte() {
        char c = readChar();
        return (byte) (c & 0xff);
    }
    
    public static void main(String[] args) {

    }
}