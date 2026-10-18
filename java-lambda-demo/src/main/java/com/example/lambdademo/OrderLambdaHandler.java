
package com.example.lambdademo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.util.Map;

public class OrderLambdaHandler
        implements RequestHandler<Map<String, Object>, String> {

    @Override
    public String handleRequest(
            Map<String, Object> event,
            Context context) {

        Object orderId = event.get("orderId");
        Object status = event.get("status");

        String message = "Order " + orderId
                + " received with status " + status;

        context.getLogger().log(message);

        return message;
    }
}
