package javase.day1124.Selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class SelServer {

    public static void main(String[] args) {
        try (
                //创建服务器套接字
                ServerSocketChannel ssc = ServerSocketChannel.open();
                //创建选择器
                Selector selector = Selector.open();
                ){
            System.out.println("服务器已经启动");

            //服务器绑定端口号
            ssc.bind(new InetSocketAddress(8899));
            //服务器套接字端口非阻塞，可以同时接受多个客户端，而不会卡在一个客户端等待回应
            ssc.configureBlocking(false);

            //将服务端注册在选择器上，注册的事件是接入事件
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            Set<SelectionKey> selectionKeys = null;
            while(true){

                // 模拟不停地轮询
                while (selector.select(1000)<=0){
                    /*System.out.println("pending");*/
                }
                selectionKeys = null;
                selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();

                    //是不是发生接入事件
                    if (key.isAcceptable()){
                        SocketChannel sc = ssc.accept();
                        System.out.println("客户端成功接入");
                        sc.configureBlocking(false);
                        sc.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    }

                    if (key.isReadable()){
                        SelectableChannel channel = key.channel();
                        ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
                        int len = ((SocketChannel)channel).read(byteBuffer);
                        System.out.println(new String(byteBuffer.array(),0,len));
                    }
                    iterator.remove();
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
