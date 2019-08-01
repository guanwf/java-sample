package com.github.java;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    private String getnumber(int number) {
        if (number >= 1000000) {
            return "" + number;
        } else if (number >= 100000) {
            return "0" + number;
        } else if (number >= 10000) {
            return "00" + number;
        } else if (number >= 1000) {
            return "000" + number;
        } else if (number >= 100) {
            return "0000" + number;
        } else if (number >= 10) {
            return "00000" + number;
        }
        return "000000" + number;
    }

    private String getnumber2(int number) {
        if (number>=100){
            return ""+number;
        }else if (number>=10) {
            return "0"+number;
        }
        return "00"+number;
    }

    public synchronized String getVoucher(){
        return "";
    }

    private String getnumber3(int number) {
        if (number < 10) {
            return "0" + number;
        }
        return ""+number;
    }

    @Test
    public void Test01(){
        String prefix="0001";
        int max=100;
        int number=0;
        String month="201906";
        String[] codes = new String[max];
        Set<String> hashSetVoucher=new HashSet<>();
        for (int i = 0; i < max; i++) {
            number++;
            int roundKey=new Random().nextInt(1000);

                System.out.println(getnumber2(roundKey));

            String voucher = prefix + month + getnumber(number) + getnumber2(roundKey);
            hashSetVoucher.add(voucher);
            System.out.println(voucher);
        }
    }

    @Test
    public void Test02(){
        int i=new Random().nextInt(100);
        System.out.println(i);

        System.out.println(getnumber(1));
        System.out.println(getnumber(11));

    }
}
