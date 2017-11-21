/**
 * ���ļ��ο���Robert Sedgewick��ʦ�Ĵ���
 */
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

public final class BinaryStdIn {
    private static BufferedInputStream in = new BufferedInputStream(System.in);
    //�ļ�������
    private static final int EOF = -1;

    private static int buffer;            //һ���ֽڵĻ���
    private static int n;                 //������ʣ��Ķ�����λ��

    //��̬��ʼ�������
    static {
        fillBuffer();
    }

    // ����ͨ���ⲿʵ����
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
     * �ر���������������ͷ���֮��ص�����ϵͳ��Դ
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
     * �����׼����Ϊ���򷵻�true
     * @return true ����ֻ����׼������Ϊ��
     */
    public static boolean isEmpty() {
        return buffer == EOF;
    }

   /**
     * ��ȡ��׼�������е���һ��������λ������Ϊһ��booleanֵ
     *
     * @return �� {@code boolean} ֵ�ķ�ʽ������һ��������λ
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
     * �ӱ�׼��������ȡ��һ��8λ��������������Ϊ�ַ�
     *
     * @return ��8-bits��ʾ�� {@code char} �ַ�����
     * @throws NoSuchElementException if there are fewer than 8 bits available on standard input
     */
    public static char readChar() {
        if (isEmpty()) throw new NoSuchElementException("Reading from empty input stream");

        // �������
        if (n == 8) {
            int x = buffer;
            fillBuffer();
            return (char) (x & 0xff);
        }

        // �ϲ���ǰ�����еĺ�nλ����һ�������е�ǰ8-nλ
        int x = buffer;
        x <<= (8 - n);
        int oldN = n;
        fillBuffer();
        if (isEmpty()) throw new NoSuchElementException("Reading from empty input stream");
        n = oldN;
        x |= (buffer >>> n);
        return (char) (x & 0xff);
        //���ϴ�������һ���ַ������ã���Ϊ���һ���ַ���nΪ-1
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
