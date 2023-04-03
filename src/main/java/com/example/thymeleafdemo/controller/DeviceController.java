package com.example.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.thymeleafdemo.mapper.DeviceMapper;
import com.example.thymeleafdemo.model.Devices;
import com.example.thymeleafdemo.model.MyModel;

@Controller
public class DeviceController {

    private DeviceMapper deviceMapper;

    public DeviceController(DeviceMapper deviceMapper) {
        this.deviceMapper = deviceMapper;
    }
    @GetMapping("/index")
    public String getPage(Model model) {
        //String message = "Hello, Thymeleaf!";
        model.addAttribute("message", "Data");
        Devices device1 = new Devices();
        device1 = deviceMapper.findLatestByStation("Station 1");
        model.addAttribute("Station1Name",device1.getStation());
        model.addAttribute("Station1Status",device1.getStatus());
        model.addAttribute("Station1Inlet",device1.getInletpressure());
        model.addAttribute("Station1Outlet",device1.getOutletpressure());


        Devices device2 = new Devices();
        device2 = deviceMapper.findLatestByStation("Station 2");
        model.addAttribute("Station2Name",device2.getStation());
        model.addAttribute("Station2Status",device2.getStatus());
        model.addAttribute("Station2Inlet",device2.getInletpressure());
        model.addAttribute("Station2Outlet",device2.getOutletpressure());

        Devices device3 = new Devices();
        device3 = deviceMapper.findLatestByStation("Station 3");
        model.addAttribute("Station3Name",device3.getStation());
        model.addAttribute("Station3Status",device3.getStatus());
        model.addAttribute("Station3Inlet",device3.getInletpressure());
        model.addAttribute("Station3Outlet",device3.getOutletpressure());
        
        
        MyModel myModel1 = new MyModel();
        MyModel myModel2 = new MyModel();
        MyModel myModel3 = new MyModel();
        if(device1.getStatus().equals("Ok")){
            myModel1.setImagePath("https://thumbs.dreamstime.com/b/water-pump-26951272.jpg");
            model.addAttribute("myModel1", myModel1);
        } else{
            myModel1.setImagePath("https://cloudfront-us-east-1.images.arcpublishing.com/gmg/GNIEBDJNFVEZBFZTUQ6ZLBAFSA.jpg");
            model.addAttribute("myModel1", myModel1);
        }

        if(device2.getStatus().equals("Ok")){
            myModel2.setImagePath("https://thumbs.dreamstime.com/b/water-pump-26951272.jpg");
            model.addAttribute("myModel2", myModel2);
        } else{
            myModel2.setImagePath("https://cloudfront-us-east-1.images.arcpublishing.com/gmg/GNIEBDJNFVEZBFZTUQ6ZLBAFSA.jpg");
            model.addAttribute("myModel2", myModel2);
        }

        if(device3.getStatus().equals("Ok")){
            myModel3.setImagePath("https://thumbs.dreamstime.com/b/water-pump-26951272.jpg");
            model.addAttribute("myModel3", myModel3);
        } else{
            myModel3.setImagePath("https://cloudfront-us-east-1.images.arcpublishing.com/gmg/GNIEBDJNFVEZBFZTUQ6ZLBAFSA.jpg");
            model.addAttribute("myModel3", myModel3);
        }

        return "index";
    }
    
}
