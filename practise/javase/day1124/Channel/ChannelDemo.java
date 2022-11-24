package javase.day1124.Channel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelDemo {
    public static void main(String[] args) {
        //创建缓冲区
        String str = "hello world";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //将字符串写到缓冲区；
        buffer.put(str.getBytes());
        //交换位置
        buffer.flip();
        //创建FileChannel对象；

        try
                ( FileChannel fileChannel = new FileOutputStream("channel.txt").getChannel();)
        {
            fileChannel.write(buffer);
            System.out.println("写出成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
