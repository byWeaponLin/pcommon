package com.github.weaponlin.encode;

/**
 * ZigZag encoding
 */
public class ZigZag {

    /**
     * encode byte with zigzag
     * @param num
     * @return
     */
    public static byte encode(byte num) {
        return (byte) ((num << 1) ^ (num >> 7));
    }

    /**
     * encode short with zigzag
     * @param num
     * @return
     */
    public static short encode(short num) {
        return (short) ((num << 1) ^ (num >> 15));
    }

    /**
     * encode int with zigzag
     * @param num
     * @return
     */
    public static int encode(int num) {
        return (num << 1) ^ (num >> 31);
    }

    /**
     * encode long with zigzag
     * @param num
     * @return
     */
    public static long encode(long num) {
        return (num << 1) ^ (num >> 63);
    }

    /**
     * decode byte with zigzag
     * @param num
     * @return
     */
    public static byte decode(byte num) {
        return (byte) (((num & 1) << 7) | (num >> 7));
    }

    /**
     * decode short with zigzag
     * @param num
     * @return
     */
    public static short decode(short num) {
        return (short) (((num & 1) << 15) | (num >> 15));
    }

    /**
     * decode int with zigzag
     * @param num
     * @return
     */
    public static int decode(int num) {
        return ((num & 1) << 31) | (num >> 31);
    }

    /**
     * decode long with zigzag
     * @param num
     * @return
     */
    public static long decode(long num) {
        return ((num & 1) << 63) | (num >> 63);
    }
}
