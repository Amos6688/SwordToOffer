package com.disruptor;


import com.lmax.disruptor.EventFactory;

/**
 * 产生PCData的工厂
 * @author Chuan
 */
public class PCDataFactory implements EventFactory<PCData>
{
    @Override
    public PCData newInstance()
    {
        return new PCData();
    }
}
