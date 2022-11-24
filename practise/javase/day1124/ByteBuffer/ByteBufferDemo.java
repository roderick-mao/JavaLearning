package javase.day1124.ByteBuffer;

import java.nio.ByteBuffer;

public class ByteBufferDemo {
    public static void main(String[] args) {
        //创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(5);
        System.out.println(buffer);

        //往缓冲区写入元素
        for (int i = 1; i <= 5; i++) {
            buffer.put((byte) (i * 2));
        }
            //交换方向   Limit = position  position = 0
            buffer.flip();
            //设置position的值
            /*buffer.position(2);*/
            //设置limit的值
           /* buffer.limit(3);*/

            // 从缓冲区中“取”元素  position<limit 返回 true
            /*while (buffer.hasRemaining()){
                System.out.println(buffer.get());
            }*/
        for (int i = 0; i <= 4; i++) {
            System.out.println(buffer.get(i));
        }
        }
    }

