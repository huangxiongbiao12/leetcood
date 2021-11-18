package com.hxb;

public class Arithmetic {


    public static void main(String[] args) {
        System.out.println(add(11, 11));
        System.out.println(multi1(11, 11));
        System.out.println(mutil2(9, 9));
        System.out.println(div(7, 5));
        System.out.println(div(6, 2));
    }

    /**
     * 加法
     *
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        // 无进位相加
        int sum = a ^ b;
        // 进位数
        int carry = (a & b) << 1;
        if (carry != 0) {
            sum = add(sum, carry);
        }
        return sum;
    }

    /**
     * 减法  取补码相加
     *
     * @param a
     * @param b
     * @return
     */
    public static int sub(int a, int b) {
        return add(a, add(~b, 1));
    }

    /**
     * 乘法  左移n位，相当于乘以 2的n次方
     * 第x位为1 左移x位及为乘法，
     * 把乘数拆分成每一位为1 的相加 (b1 b2 b3 为某一位为1的数字)
     * a*b=a*(b1+b2+b3)
     *
     * @param a
     * @param b
     * @return
     */
    public static int multi1(int a, int b) {
        if (b == 0 || a == 0) return 0;
        //  a小于b 则两数交互，用小的数做乘数
        if (a < b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        int r = 0;
        while (b != 0) {
            if ((b & 1) == 1) {
                r = add(r, a);
            }
            a = a << 1;
            b = b >> 1;
        }
        return r;
    }

    /**
     * a*b 本质上是 b个a相加
     *
     * @param a
     * @param b
     * @return
     */
    public static int mutil2(int a, int b) {
        if (a == 0 || b == 0) return 0;
        //  两数交换让b 为小的数
        if (a < b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        int r = 0;
        for (int i = 0; i < b; i = add(i, 1)) {
            r = add(r, a);
        }
        return r;
    }

    /**
     * 除法 本质是 a含有几个b相加
     *
     * @param a
     * @param b
     * @return
     */
    public static int div(int a, int b) {
        if (a < b) return 0;
        int r = 0;
        while (a >= b) {
            a = sub(a, b);
            r = add(r, 1);
        }
        return r;
    }


    /**
     * 阶乘
     *
     * @param n
     * @return
     */
    public static int multipleN(int n) {
        if (n == 0) return 1;
        return n * multipleN(n - 1);
    }


}
