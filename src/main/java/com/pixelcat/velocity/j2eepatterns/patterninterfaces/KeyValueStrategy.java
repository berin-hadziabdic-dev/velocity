package com.pixelcat.velocity.j2eepatterns.patterninterfaces;

import com.pixelcat.velocity.j2eepatterns.exceptions.StrategyNotFoundException;

/**
 * The KeyValueStrategy is a strategy interface that is able to produce a V
 * value based upon the information provided by the type K.
 */
public interface KeyValueStrategy<K,R,J>  {
    public String doStrategy(J type,R restrictions) throws StrategyNotFoundException, Exception;
}
