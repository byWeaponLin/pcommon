package com.github.weaponlin.encode;

/**
 * TODO
 */
public class ZigZag {

    public static int encode(int num) {
        return (num << 1) ^ (num >> 31);
    }

    public static long encode(long num) {
        return (num << 1) ^ (num >> 63);
    }
}
