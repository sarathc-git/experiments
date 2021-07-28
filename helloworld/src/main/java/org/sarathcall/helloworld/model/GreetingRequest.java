package org.sarathcall.helloworld.model;

import lombok.Builder;
import lombok.Value;

/**
 * A Greeting request captures the name of the requestor 
 * and the locale; 
 * 
 * A Greeting request/petition can be for self (for now), but may be extended to support
 * a requestor sending a greeting for another person. 
 * 
 * From a model naming perspective GreetingRequest is a more apt name, which 
 * represents a request for a greeting. But since Request is commonly used to
 * represent the HTTPRequest I wanted to avoid the confusion of whether this is 
 * a model or this is a Request object recieved by the controller. 
 * 
 * Alternatively could we have used GreetingRequest as the model and 
 * GreetingRequestDTO as the request object. 
 * 
 */

 @Value
 @Builder (toBuilder = true)
public class GreetingRequest {
    private String name; 
    private String locale; 
}
