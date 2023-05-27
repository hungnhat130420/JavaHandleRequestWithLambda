package com.awsdevelop;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.JsonObject;

import java.util.Map;

public class GetUserHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {

        Map<String, String> pathParameters = input.getPathParameters();
        String userId = pathParameters.get("userId");

        JsonObject responseBody = new JsonObject();
        responseBody.addProperty("fistName", "Alex");
        responseBody.addProperty("lastName", "Guide");
        responseBody.addProperty("email", "alex@gmail.com");
        responseBody.addProperty("id", userId);

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.withStatusCode(200).withBody(responseBody.toString());

        return response;
    }
}
