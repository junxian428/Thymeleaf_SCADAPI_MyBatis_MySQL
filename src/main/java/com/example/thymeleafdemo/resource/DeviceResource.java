package com.example.thymeleafdemo.resource;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.thymeleafdemo.mapper.DeviceMapper;
import com.example.thymeleafdemo.model.Devices;
import com.example.thymeleafdemo.service.DeviceService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/device")
public class DeviceResource {
    private DeviceMapper deviceMapper;

    @Autowired
    private DeviceService deviceService;


    
    public DeviceResource(DeviceMapper deviceMapper) {
        this.deviceMapper = deviceMapper;
    }

    @GetMapping("/all")
    public List<Devices> getAll() {
        return deviceMapper.findAll();
    }

  //  @PostMapping("/addDeviceData")
   // public void addDeviceData(@RequestBody Devices devices) {
     //   deviceMapper.insertDevice(devices);
   // }

   @GetMapping("/getDataBased/{parameter}")
   public String getDataBasedStation(@PathVariable("parameter") String parameter){
       //System.out.println(parameter);
       try{
        Devices SuctionTank = new Devices();
        //device1 = deviceMapper.findLatestByStation(parameter);
        SuctionTank = deviceMapper.findSuctionTank(parameter);
        Devices ServiceTank = new Devices();
        ServiceTank = deviceMapper.findServiceTank(parameter);
        Devices Pump1 = new Devices();
        Pump1 = deviceMapper.findPump1(parameter);
        Devices Pump2 = new Devices();
        Pump2 = deviceMapper.findPump2(parameter);
        Devices Pump3 = new Devices();
        Pump3 = deviceMapper.findPump3(parameter);
        Devices Pump4 = new Devices();
        Pump3 = deviceMapper.findPump4(parameter);


        return "[{\"Station\" : \""  + parameter + "\", \"Date Time\" : \"" + SuctionTank.getDatetime() + "\" , \"Status\" : \""  + SuctionTank.getStatus() 
        + "\" , \"Level\" : " + SuctionTank.getLevel() + " , \"Inlet Pressure\" : " + SuctionTank.getInletpressure() + 
        " , \"Outlet Pressure\" : " + SuctionTank.getOutletpressure() 
        + "}, {\"Station\" : " + parameter +  "\", \"Date Time\" : \"" + ServiceTank.getDatetime() + "\" , \"Status\" : \""  + ServiceTank.getStatus() 
        + "\" , \"Level\" : " + ServiceTank.getLevel() + " , \"Inlet Pressure\" : " + ServiceTank.getInletpressure() + 
        " , \"Outlet Pressure\" : " + ServiceTank.getOutletpressure() + 
        "}, {\"Station\" : " + parameter +  "\", \"Date Time\" : \"" + Pump1.getDatetime() + "\" , \"Status\" : \""  + Pump1.getStatus() 
        + "\" , \"Level\" : " + Pump1.getLevel() + " , \"Inlet Pressure\" : " + Pump1.getInletpressure() + 
        " , \"Outlet Pressure\" : " + Pump1.getOutletpressure() 
        +  "}, {\"Station\" : " + parameter +  "\", \"Date Time\" : \"" + Pump2.getDatetime() + "\" , \"Status\" : \""  + Pump2.getStatus() 
        + "\" , \"Level\" : " + Pump2.getLevel() + " , \"Inlet Pressure\" : " + Pump2.getInletpressure() + 
        " , \"Outlet Pressure\" : " + Pump2.getOutletpressure()  + 
        "}, {\"Station\" : " + parameter +  "\", \"Date Time\" : \"" + Pump3.getDatetime() + "\" , \"Status\" : \""  + Pump3.getStatus() 
        + "\" , \"Level\" : " + Pump3.getLevel() + " , \"Inlet Pressure\" : " + Pump3.getInletpressure() + 
        " , \"Outlet Pressure\" : " + Pump3.getOutletpressure()  +
        "}, {\"Station\" : " + parameter +  "\", \"Date Time\" : \"" + Pump4.getDatetime() + "\" , \"Status\" : \""  + Pump4.getStatus() 
        + "\" , \"Level\" : " + Pump4.getLevel() + " , \"Inlet Pressure\" : " + Pump4.getInletpressure() + 
        " , \"Outlet Pressure\" : " + Pump4.getOutletpressure()  +
        "}]";
        // System.out.println(device1.getDatetime() + " " + device1.getDevice() + ":" + device1.getOutletpressure());
        //return "{\"station\": \"" + device1.getStation() + "\",\n\"DateTime\": \""+ device1.getDatetime() + "\",\n" + "\"device\" :" + device1.getDevice() + "\", \n \"status\": \""
        // + device1.getStatus() + "\", \"level\": \"" + device1.getLevel() + "\", \"inlet_pressure\":  \"" + device1.getInletpressure() + "\", \"outlet_pressure\" : \"" 
        // + device1.getOutletpressure() + "}";
    }catch (Exception e) {
        //System.out.println(e);
        return "Error Caused by " + e;
       }
       //return "Received Parameter " + parameter;
   }


    @PostMapping(value = "/submitForm", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String submitForm(@RequestBody MultiValueMap<String, String> formData) {
        // Process the form data here
        // ...

        try{
       //     deviceMapper.insertDevice(formData);
            //System.out.println(formData);
            MultiValueMap<String, String> data = formData;
            System.out.println(data);
            String device = formData.getFirst("device");
            System.out.println(device);

            //

            String jsonData = data.toString();
            String subJson = jsonData.substring(1);

            ObjectMapper objectMapper = new ObjectMapper();
String jsonString = "{\"device\":\"Suction tank\",\"status\":\"Hi\",\"level\":25,\"inletpressure\":0.0,\"outletpressure\":0.0}=[]";
Map<String, Object> jsonMap = objectMapper.readValue(subJson, new TypeReference<Map<String, Object>>(){});

String station = (String) jsonMap.get("station");
final String device2 = (String) jsonMap.get("device");
String status = (String) jsonMap.get("status");
int level = (int) jsonMap.get("level");
double inletpressure = (double) jsonMap.get("inletpressure");
double outletpressure = (double) jsonMap.get("outletpressure");
System.out.println(station + " " + device2 + " " + status +  " " + Integer.toString(level)+ " " + Double.toString(inletpressure) + " " + Double.toString(outletpressure) );




            //deviceDataService.saveDeviceData(formData);
            LocalDateTime localDateTime = LocalDateTime.now();
            // void saveDeviceData
           // device.savedDeviceData(localDateTime, device2, status, level, inletpressure, outletpressure);
           try{
            deviceMapper.saveDeviceData(station, localDateTime, device2, status, level, inletpressure, outletpressure);
            System.out.println("saving");
            return "Form submitted successfully! Your data is uploaded... Device: " + device2  ;

           }catch(Exception e){
                System.out.println(e);
                return "Your error code: " +e;
           }

            
        }catch(Exception e){
            System.out.println(e);
            return "Fail to submit";
        }
    }
    
    @PostMapping("/addDeviceData")
public void saveDeviceData(@ModelAttribute Devices form) {
    Devices data = new Devices();
    try{

    
    }catch(Exception e){
        System.out.println(e);
    }

    // Your code to save the data here
    // ...
}



 

@PostMapping("/addDevice")
public ResponseEntity<?> addDeviceData(@RequestBody Devices data) {
    deviceService.saveDeviceData(data);
    return ResponseEntity.ok().build();
}
}


