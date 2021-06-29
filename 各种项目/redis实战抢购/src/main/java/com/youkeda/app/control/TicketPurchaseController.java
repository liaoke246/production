package com.youkeda.app.control;

import com.youkeda.app.model.Result;
import com.youkeda.app.service.TicketPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.redis.core.RedisTemplate;
import java.util.concurrent.TimeUnit;

@Controller
public class TicketPurchaseController {
    @Autowired
    private TicketPurchaseService ticketPurchaseService;

    @Autowired
    private RedisTemplate redisTemplate;


    @GetMapping("/test")
    @ResponseBody
    public Result<String> init() {
        Result<String> result = new Result<>();

        redisTemplate.opsForValue().set("book","book",1000,TimeUnit.MILLISECONDS);

  try {
        Thread.sleep(2000);
  }catch (InterruptedException e){
      e.printStackTrace();
  }
String code = (String)redisTemplate.opsForValue().get("book");
System.out.println(code);
result.setMessage(code);
        return result;

    }
    /**
     * 抢票
     *
     * @return Result
     */
    @GetMapping("/ticketpurchase")
    @ResponseBody
    public Result<Boolean> ticketPurchase(Long id) {



    for(int i=0;i<20;i++){
        new Thread(new Runnable() {
            @Override
            public void run() {
                ticketPurchaseService.ticketPurchase(id);
            }
        }).start();



    }



        Result result = new Result();
        result.setSuccess(true);
        return result;
    }
}
