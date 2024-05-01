import java.nio.ByteBuffer;

public class SquareRoot {
// Using Mathisen & Tarolli's (Quake III) algorithm and Chris Lomond's magic 
// number, as found in his paper: https://www.lomont.org/papers/2003/InvSqrt.pdf
    public int squareRoot(int radicand) {
        ByteBuffer buf = ByteBuffer.allocateDirect(4);
        float num = (float) radicand;
        float half = 0.5f * num;
        int bit = buf.putFloat(0, num).getInt(0);
        bit = 0x5F375A86 - (bit >> 1);
        num = buf.putInt(0, bit).getFloat(0);
        float inverseSqRoot = num * (1.5f - half * num * num);
        return (int) (1 / inverseSqRoot);
    }
}
