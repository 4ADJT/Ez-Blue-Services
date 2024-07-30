package br.com.ezblue.ezblueservices.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@FeignClient(name = "BoundaryService")
public interface EzBoundaryServiceOpenFeign {

    @PostMapping("/notification")
    Map<String, Object> createNotification(Object notificationDTO);

    @PostMapping("/payment")
    Map<String, Object> createPayment(Object paymentDTO);

}
