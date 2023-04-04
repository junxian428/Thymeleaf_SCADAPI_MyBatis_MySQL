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
        // Suction Tank
        // Service Tank
        // Pump 1
        // Pump 2
        // Pump 3
        // Pump 4
        //model.addAttribute("message", "Data");
        //device1 = deviceMapper.findLatestByStation("Station 1");
        // model.addAttribute("Station1Name",device1.getStation());
        //model.addAttribute("Station1Device",device1.getDevice());
        //model.addAttribute("Station1Status",device1.getStatus());
        //model.addAttribute("Station1Inlet",device1.getInletpressure());
        //model.addAttribute("Station1Outlet",device1.getOutletpressure());
        Devices Station1SuctionTank = new Devices();
        Station1SuctionTank = deviceMapper.findSuctionTank("Station 1");
        model.addAttribute("SuctionTank1Name", Station1SuctionTank.getStation());
        model.addAttribute("SuctionTank1Device", Station1SuctionTank.getDevice());
        model.addAttribute("SuctionTank1Status", Station1SuctionTank.getStatus());
        model.addAttribute("SuctionTank1Inlet", Station1SuctionTank.getInletpressure());
        model.addAttribute("SuctionTank1Outlet", Station1SuctionTank.getOutletpressure());

        // Service Tank
        Devices Station1ServiceTank = new Devices();
        Station1ServiceTank = deviceMapper.findServiceTank("Station 1");
        model.addAttribute("ServiceTank1Name",Station1ServiceTank.getStation());
        model.addAttribute("ServiceTank1Device",Station1ServiceTank.getDevice());
        model.addAttribute("ServiceTank1Status",Station1ServiceTank.getStatus());
        model.addAttribute("ServiceTank1Inlet",Station1ServiceTank.getInletpressure());
        model.addAttribute("ServiceTank1Outlet",Station1ServiceTank.getOutletpressure());

        Devices Station1Pump1 = new Devices();
        Station1Pump1 = deviceMapper.findPump1("Station 1");
        model.addAttribute("Station1Pump1Name",  Station1Pump1.getStation());
        model.addAttribute("Station1Pump1Device",  Station1Pump1.getDevice());
        model.addAttribute("Station1Pump1Status",  Station1Pump1.getStatus());
        model.addAttribute("Station1Pump1Inlet",  Station1Pump1.getInletpressure());
        model.addAttribute("Station1Pump1Outlet",  Station1Pump1.getOutletpressure());

        Devices Station1Pump2 = new Devices();
        Station1Pump2 = deviceMapper.findPump2("Station 1");
        model.addAttribute("Station1Pump2Name",Station1Pump2.getStation());
        model.addAttribute("Station1Pump2Device", Station1Pump2.getDevice());
        model.addAttribute("Station1Pump2Status", Station1Pump2.getStatus());
        model.addAttribute("Station1Pump2Inlet", Station1Pump2.getInletpressure());
        model.addAttribute("Station1Pump1Outlet", Station1Pump2.getOutletpressure());

        Devices Station1Pump3 = new Devices();
        Station1Pump3 = deviceMapper.findPump3("Station 1");
        model.addAttribute("Station1Pump3Name",Station1Pump3.getStation());
        model.addAttribute("Station1Pump3Device",Station1Pump3.getDevice());
        model.addAttribute("Station1Pump3Status",Station1Pump3.getStatus());
        model.addAttribute("Station1Pump3Inlet",Station1Pump3.getInletpressure());
        model.addAttribute("Station1Pump3Outlet",Station1Pump3.getOutletpressure());


        Devices Station1Pump4 = new Devices();
        Station1Pump4 = deviceMapper.findPump4("Station 1");
        model.addAttribute("Station1Pump4Name",Station1Pump4.getStation());
        model.addAttribute("Station1Pump4Device",Station1Pump4.getDevice());
        model.addAttribute("Station1Pump4Status",Station1Pump4.getStatus());
        model.addAttribute("Station1Pump4Inlet",Station1Pump4.getInletpressure());
        model.addAttribute("Station1Pump4Outlet",Station1Pump4.getOutletpressure());
        
        //Station 2
        Devices Station2SuctionTank = new Devices();
        Station2SuctionTank = deviceMapper.findSuctionTank("Station 2");
        model.addAttribute("SuctionTank2Name", Station2SuctionTank.getStation());
        model.addAttribute("SuctionTank2Device", Station2SuctionTank.getDevice());
        model.addAttribute("SuctionTank2Status", Station2SuctionTank.getStatus());
        model.addAttribute("SuctionTank2Inlet", Station2SuctionTank.getInletpressure());
        model.addAttribute("SuctionTank2Outlet", Station2SuctionTank.getOutletpressure());

          // Service Tank
          Devices Station2ServiceTank = new Devices();
          Station2ServiceTank = deviceMapper.findServiceTank("Station 2");
          model.addAttribute("ServiceTank2Name",Station2ServiceTank.getStation());
          model.addAttribute("ServiceTank2Device",Station2ServiceTank.getDevice());
          model.addAttribute("ServiceTank2Status",Station2ServiceTank.getStatus());
          model.addAttribute("ServiceTank2Inlet",Station2ServiceTank.getInletpressure());
          model.addAttribute("ServiceTank2Outlet",Station2ServiceTank.getOutletpressure());
  
          Devices Station2Pump1 = new Devices();
          Station2Pump1 = deviceMapper.findPump1("Station 2");
          model.addAttribute("Station2Pump1Name",  Station2Pump1.getStation());
          model.addAttribute("Station2Pump1Device",  Station2Pump1.getDevice());
          model.addAttribute("Station2Pump1Status",  Station2Pump1.getStatus());
          model.addAttribute("Station2Pump1Inlet",  Station2Pump1.getInletpressure());
          model.addAttribute("Station2Pump1Outlet",  Station2Pump1.getOutletpressure());
  
          Devices Station2Pump2 = new Devices();
          Station2Pump2 = deviceMapper.findPump2("Station 2");
          model.addAttribute("Station2Pump2Name",Station2Pump2.getStation());
          model.addAttribute("Station2Pump2Device", Station2Pump2.getDevice());
          model.addAttribute("Station2Pump2Status", Station2Pump2.getStatus());
          model.addAttribute("Station2Pump2Inlet", Station2Pump2.getInletpressure());
          model.addAttribute("Station2Pump1Outlet", Station2Pump2.getOutletpressure());
  
          Devices Station2Pump3 = new Devices();
          Station2Pump3 = deviceMapper.findPump3("Station 2");
          model.addAttribute("Station2Pump3Name",Station2Pump3.getStation());
          model.addAttribute("Station2Pump3Device",Station2Pump3.getDevice());
          model.addAttribute("Station2Pump3Status",Station2Pump3.getStatus());
          model.addAttribute("Station2Pump3Inlet",Station2Pump3.getInletpressure());
          model.addAttribute("Station2Pump3Outlet",Station2Pump3.getOutletpressure());
  
  
          Devices Station2Pump4 = new Devices();
          Station2Pump4 = deviceMapper.findPump4("Station 2");
          model.addAttribute("Station2Pump4Name",Station2Pump4.getStation());
          model.addAttribute("Station2Pump4Device",Station2Pump4.getDevice());
          model.addAttribute("Station2Pump4Status",Station2Pump4.getStatus());
          model.addAttribute("Station2Pump4Inlet",Station2Pump4.getInletpressure());
          model.addAttribute("Station2Pump4Outlet",Station2Pump4.getOutletpressure());

        //
        
        MyModel myModel1 = new MyModel();
        MyModel myModel2 = new MyModel();
        MyModel myModel3 = new MyModel();
        MyModel myModel4 = new MyModel();
        MyModel myModel5 = new MyModel();
        MyModel myModel6 = new MyModel();

        if(Station1SuctionTank.getStatus().equals("Ok")){
            myModel1.setImagePath("https://thumbs.dreamstime.com/b/water-pump-26951272.jpg");
            model.addAttribute("myModel1", myModel1);
        } else{
            myModel1.setImagePath("https://cloudfront-us-east-1.images.arcpublishing.com/gmg/GNIEBDJNFVEZBFZTUQ6ZLBAFSA.jpg");
            model.addAttribute("myModel1", myModel1);
        }

        if(Station1ServiceTank.getStatus().equals("Ok")){
            myModel2.setImagePath("https://thumbs.dreamstime.com/b/water-pump-26951272.jpg");
            model.addAttribute("myModel2", myModel2);
        } else{
            myModel2.setImagePath("https://cloudfront-us-east-1.images.arcpublishing.com/gmg/GNIEBDJNFVEZBFZTUQ6ZLBAFSA.jpg");
            model.addAttribute("myModel2", myModel2);
        }

        if(Station1Pump1.getStatus().equals("Ok")){
            myModel3.setImagePath("https://thumbs.dreamstime.com/b/water-pump-26951272.jpg");
            model.addAttribute("myModel3", myModel3);
        } else{
            myModel3.setImagePath("https://cloudfront-us-east-1.images.arcpublishing.com/gmg/GNIEBDJNFVEZBFZTUQ6ZLBAFSA.jpg");
            model.addAttribute("myModel3", myModel3);
        }

        if(Station1Pump2.getStatus().equals("Ok")){
            myModel4.setImagePath("https://thumbs.dreamstime.com/b/water-pump-26951272.jpg");
            model.addAttribute("myModel4", myModel4);
        } else{
            myModel4.setImagePath("https://cloudfront-us-east-1.images.arcpublishing.com/gmg/GNIEBDJNFVEZBFZTUQ6ZLBAFSA.jpg");
            model.addAttribute("myModel4", myModel4);
        }

        if(Station1Pump3.getStatus().equals("Ok")){
            myModel5.setImagePath("https://thumbs.dreamstime.com/b/water-pump-26951272.jpg");
            model.addAttribute("myModel5", myModel5);
        } else{
            myModel5.setImagePath("https://cloudfront-us-east-1.images.arcpublishing.com/gmg/GNIEBDJNFVEZBFZTUQ6ZLBAFSA.jpg");
            model.addAttribute("myModel5", myModel5);
        }

        
        if(Station1Pump4.getStatus().equals("Ok")){
            myModel5.setImagePath("https://thumbs.dreamstime.com/b/water-pump-26951272.jpg");
            model.addAttribute("myModel6", myModel6);
        } else{
            myModel5.setImagePath("https://cloudfront-us-east-1.images.arcpublishing.com/gmg/GNIEBDJNFVEZBFZTUQ6ZLBAFSA.jpg");
            model.addAttribute("myModel6", myModel6);
        }

        return "index";
    }
    
}
