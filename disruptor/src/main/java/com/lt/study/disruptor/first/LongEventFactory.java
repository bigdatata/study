package com.lt.study.disruptor.first;

/**
 * Created by luotao on 2015/2/5.
 */
import com.lmax.disruptor.EventFactory;

public class LongEventFactory implements EventFactory<LongEvent>
{
    public LongEvent newInstance()
    {
        return new LongEvent();
    }
}