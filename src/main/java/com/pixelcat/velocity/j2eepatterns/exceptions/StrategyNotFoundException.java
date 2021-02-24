package com.pixelcat.velocity.j2eepatterns.exceptions;

/**This exception is thrown when the application requests a strategy to resolve a given problem 
 * but the matching strategy is not discovered inside the application.
 */
public class StrategyNotFoundException extends RuntimeException{
    public StrategyNotFoundException(){
        super("The application requested a Strategy interface which could not be found.");
    }

    public StrategyNotFoundException(String message){
        super(message);
    }
}
