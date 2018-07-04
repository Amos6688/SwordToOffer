package com.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * 生产者
 * @author Chuan
 */
public class Producer
{
    private final RingBuffer<PCData> ringBuffer;

    public Producer(RingBuffer<PCData> ringBuffer)
    {
        this.ringBuffer = ringBuffer;
    }

    public void pushData(ByteBuffer bb)
    {
        long sequence = ringBuffer.next();  //得到下一个可用的序列号

        try
        {
            /*
            *通过序列号取得下一个空闲可用的PCData，并且将PCData的数据设为期望值
            * 这个值最终会传递给消费者
             */
            PCData event = ringBuffer.get(sequence);
            event.setValue(bb.getLong(0));
        }
        finally
        {
            //进行数据发布，只有发布后的数据才会真正被消费者看见
            ringBuffer.publish(sequence);
        }
    }
}
