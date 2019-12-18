package com.yxd.leetcode.nb;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author yuxudong
 * @date 2019/10/28 11:03
 */
public class MyDatagramSocketReceive implements Runnable {

    private DatagramSocket ds;
    private DatagramPacket dp;
    private byte[] buf;
    MyDatagramSocketReceive(DatagramSocket ds) {
        try
        {
            this.ds = ds;
        }
        catch (Exception e)
        {
            throw new RuntimeException("Receive DatagramSocket");
        }
        buf=new byte[1024*4];
    }
    public void close()
    {
        ds.close();
    }


    @Override
    public void run() {
        while(true)
        {
            try
            {
                dp=new DatagramPacket(buf,buf.length);
                ds.receive(dp);
                System.out.println(dp.getAddress().getHostName()+":"+(new String(dp.getData(),0,dp.getLength())));
            }
            catch (Exception e)
            {
                throw new RuntimeException("Receive");
            }
        }
    }
}
