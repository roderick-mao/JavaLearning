package javase.day1124.Channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelDemo2 {
    public static void main(String[] args) {
        File file = new File("channel.txt");
        try (
                //创建FileChannel通道对象
                FileChannel fileChannel = new FileInputStream(file).getChannel();
                ){
            //创建ByteBuffer缓冲区
            ByteBuffer buffer = ByteBuffer.allocate((int)file.length());
            //通道中读数据，到缓冲区
            fileChannel.read(buffer);
            //输出到控制台
            System.out.println(new String(buffer.array()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
