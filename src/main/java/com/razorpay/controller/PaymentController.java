package com.razorpay.controller;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.payload.OrderDetailes;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/order")
public class PaymentController {

    // http://localhost:8080/api/order/createOrder

    @PostMapping("/createOrder")
    public String createOrder(@RequestBody OrderDetailes orderDetailes) throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient("rzp_test_Fcsc2H1fRnTz2Y", "JWUIEF9ULSnBMhCgbqWBEbJx");

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", orderDetailes.getAmount());
        orderRequest.put("currency", orderDetailes.getCurrency());
        orderRequest.put("receipt", UUID.randomUUID().toString());

        JSONObject notes = new JSONObject();
        notes.put(orderDetailes.getNoteSubject(), orderDetailes.getCurrency());
        orderRequest.put("notes", notes);

        try {
            Order order = razorpay.orders.create(orderRequest);
            return order.get("id").toString();
        } catch (RazorpayException e) {
            e.printStackTrace(); // Handle exception appropriately
            return null;
        }
    }
}
