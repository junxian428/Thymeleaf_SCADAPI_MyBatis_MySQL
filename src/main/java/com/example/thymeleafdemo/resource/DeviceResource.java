package com.example.thymeleafdemo.resource;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import com.example.thymeleafdemo.model.OneRowDevices;
import com.example.thymeleafdemo.service.DeviceService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

@RestController
@RequestMapping("/device")
public class DeviceResource {
    private DeviceMapper deviceMapper;

    @Autowired
    private DeviceService deviceService;


    
    public DeviceResource(DeviceMapper deviceMapper) {
        this.deviceMapper = deviceMapper;
    }

    //@GetMapping("/all")
    //public List<Devices> getAll() {
    //    return deviceMapper.findAll();
    //}

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
        Pump4 = deviceMapper.findPump4(parameter);

        return "[{\"Station\" : \""  + parameter + "\", \"Date Time\" : \"" + SuctionTank.getDatetime()  + "\", \"Device\" : \"" + SuctionTank.getDevice() + "\" , \"Status\" : \""  + SuctionTank.getStatus() 
        + "\" , \"Level\" : " + SuctionTank.getLevel() + " , \"Inlet Pressure\" : " + SuctionTank.getInletpressure() + 
        " , \"Outlet Pressure\" : " + SuctionTank.getOutletpressure() 
        + "}, {\"Station\" : \"" + parameter +  "\", \"Date Time\" : \"" + ServiceTank.getDatetime()  + "\", \"Device\" : \"" + ServiceTank.getDevice()  + "\" , \"Status\" : \""  + ServiceTank.getStatus() 
        + "\" , \"Level\" : " + ServiceTank.getLevel() + " , \"Inlet Pressure\" : " + ServiceTank.getInletpressure() + 
        " , \"Outlet Pressure\" : " + ServiceTank.getOutletpressure() + 
        "}, {\"Station\" : \"" + parameter +  "\", \"Date Time\" : \"" + Pump1.getDatetime()  + "\", \"Device\" : \"" + Pump1.getDevice() + "\" , \"Status\" : \""  + Pump1.getStatus() 
        + "\" , \"Level\" : " + Pump1.getLevel() + " , \"Inlet Pressure\" : " + Pump1.getInletpressure() + 
        " , \"Outlet Pressure\" : " + Pump1.getOutletpressure() 
        +  "}, {\"Station\" : \"" + parameter +  "\", \"Date Time\" : \"" + Pump2.getDatetime()  + "\", \"Device\" : \"" + Pump2.getDevice()  + "\" , \"Status\" : \""  + Pump2.getStatus() 
        + "\" , \"Level\" : " + Pump2.getLevel() + " , \"Inlet Pressure\" : " + Pump2.getInletpressure() + 
        " , \"Outlet Pressure\" : " + Pump2.getOutletpressure()  + 
        "}, {\"Station\" : \"" + parameter +  "\", \"Date Time\" : \"" + Pump3.getDatetime()  + "\", \"Device\" : \"" + Pump3.getDevice()  + "\" , \"Status\" : \""  + Pump3.getStatus() 
        + "\" , \"Level\" : " + Pump3.getLevel() + " , \"Inlet Pressure\" : " + Pump3.getInletpressure() + 
        " , \"Outlet Pressure\" : " + Pump3.getOutletpressure()  +
        "}, {\"Station\" : \"" + parameter +  "\", \"Date Time\" : \"" + Pump4.getDatetime()  + "\", \"Device\" : \"" + Pump4.getDevice()  + "\" , \"Status\" : \""  + Pump4.getStatus() 
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

   // Submit One value to be saved

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
           //deviceMapper.saveDeviceData(station, localDateTime, device2, status, level, inletpressure, outletpressure);
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
   
   // Submit Multiple Values to be saved
   /*
    * 
    [{"Station" : "Station 1", "Date Time" : "2023-04-04 17:02:13.0" , "Status" : "Testing" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, 
    {"Station" : Station 1", "Date Time" : "2023-04-04 17:02:02.0" , "Status" : "Testing" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0},
    {"Station" : Station 1", "Date Time" : "2023-04-04 17:02:27.0" , "Status" : "Testing" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, 
    {"Station" : Station 1", "Date Time" : "2023-04-04 17:02:31.0" , "Status" : "Testing" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, 
    {"Station" : Station 1", "Date Time" : "2023-04-04 17:02:38.0" , "Status" : "Testing" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, 
    {"Station" : Station 1", "Date Time" : "null" , "Status" : "null" , "Level" : 0 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}]


    */

    @PostMapping(value = "/submitMultiForm", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String saveMultiValueForm(@RequestBody MultiValueMap<String, String> formData) {
        MultiValueMap<String, String> data = formData;
        //System.out.println(data);
        //System.out.println("_______________");
        //
        // Convert MultiValueMap into String
        // For the purpose easy to extract the data
        // Documentation 
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : data.entrySet()) {
            String key = entry.getKey();
            List<String> values = entry.getValue();
            for (String value : values) {
                sb.append(key).append("=").append(value).append("&");
            }
        }
        sb.setLength(sb.length() - 1); // remove last "&" character
        String str = sb.toString();
        
        //System.out.println(str);
        str = str.substring(0, str.length() - 1);
        //String substr = str.substring(489, str.length());

        //System.out.println(substr);

        //System.out.println("---------------------");
        //System.out.println(str);
        // 
        /*
         * 
         * 
         * [{"Station" : "Station 1", "Date Time" : "2023-04-04 17:02:13.0" , "Status" : "Testing" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, 
         * {"Station" : Station 1", "Date Time" : "2023-04-04 17:02:02.0" , "Status" : "Testing" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : Station 1", "Date Time" : "2023-04-04 17:02:27.0" , "Status" : "Testing" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, 
         * {"Station" : Station 1", "Date Time" : "2023-04-04 17:02:31.0" , "Status" : "Testing" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : Station 1", "Date Time" : "2023-04-04 17:02:38.0" , "Status" : "Testing" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0},
         *  {"Station" : Station 1", "Date Time" : "null" , "Status" : "null" , "Level" : 0 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}]=
         */
        // The last character have = so we need to remove it 
        // Extract Data Step
        //String jsonArrayString = "[{'name': 'John', 'age': 30}, {'name': 'Mary','age': 25},{ 'name': 'Peter','age': 40}]";
        try{
            JSONArray jsonArray = new JSONArray(str);
            try{
                   //System.out.println(data.getFirst("Station"));
                     // Iterate over the JSON array and extract the values
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String name = jsonObject.getString("Station");
                        String device = jsonObject.getString("Device");
                        String datetime = jsonObject.getString("Date Time");
                        if(datetime.equals("") || datetime == null) {
                            LocalDateTime now = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
                            String newDate = now.format(formatter);
                            datetime = newDate;
                        }
                        String status = jsonObject.getString("Status");
                        int level = jsonObject.getInt("Level");
                        double inletpressure = jsonObject.getDouble("Inlet Pressure");
                        double outletpressure = jsonObject.getDouble("Outlet Pressure");
                        //int age = jsonObject.getInt("age");
                        System.out.println(name +  " " + device+ " " + datetime + " " + status + " " + Integer.toString(level) + " " + inletpressure + " " + outletpressure);
                        // Do something with the extracted values
                        //System.out.println("Name: " + name + ", Age: " + age);
                        try{
                            deviceMapper.saveDeviceData(name, datetime, device, status, level, inletpressure, outletpressure);

                        }catch (Exception e){
                             System.out.println(e);
                            return  e + " . SQL insert problem. Check SQL syntax";
                        }
                    }
                    return "200 Success Insert SQL";

            }catch (Exception e){
                return e + " Error during parse data";

            }
        } catch(Exception e){
            System.out.println(e);
            return e + " . Probably your json file is not accurate. Please check your post data request";
        }

     


        // Process the form data here
       


    }
    /*
     * 
     * {"station1":"Station 1","datetime1":"2023-04-05T01:42:06.000+00:00",
     * "device1":"Suction Tank","status1":"Ok","level1":50,"inletpressure1":10.0,"outletpressure1":100.0,
     * "station2":"Station 1","datetime2":"2023-04-05T01:42:06.000+00:00","device2":"Service Tank","status2":"Ok",
     * "level2":50,"inletpressure2":50.0,"outletpressure2":50.0,"station3":"Station 1","datetime3":"2023-04-05T01:42:06.000+00:00",
     * "device3":"Pump 1","status3":"Bad","level3":100,"inletpressure3":100.0,"outletpressure3":100.0,
     * "station4":"Station 1","datetime4":"2023-04-05T01:42:06.000+00:00","device4":"Pump 2","status4":"Ok",
     * "level4":80,"inletpressure4":120.0,"outletpressure4":78.0,"station5":"Station 1","datetime5":"2023-04-05T01:42:06.000+00:00",
     * "device5":"Pump 3","status5":"Ok","level5":100,"inletpressure5":100.0,"outletpressure5":78.0,"station6":"Station 1",
     * "datetime6":"2023-04-05T01:42:06.000+00:00","device6":"Pump 4","status6":"Ok","level6":90,"inletpressure6":33.33,"outletpressure6":56.0}
     */

     /*Requirement:
      * [{"Station" : "Station 1", "Date Time" : "2023-04-05 09:32:34.0", "Device" : "Suction Tank" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : Station 1", "Date Time" : "2023-04-05 09:32:34.0", "Device" : "Service Tank" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : Station 1", "Date Time" : "2023-04-04 17:02:27.0", "Device" : "Pump 1" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : Station 1", "Date Time" : "2023-04-04 17:02:31.0", "Device" : "Pump 2" , "Status" : "Bad" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : Station 1", "Date Time" : "2023-04-04 17:02:38.0", "Device" : "Pump 4" , "Status" : "Ok" , "Level" : 0 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : Station 1", "Date Time" : "null", "Device" : "null" , "Status" : "null" , "Level" : 0 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}]

      */

    @GetMapping("row/{parameter}")
    public String getDataBasedRow(@PathVariable("parameter") String parameter){
        OneRowDevices rowDevices = new OneRowDevices();
        rowDevices = deviceMapper.findOneRowByStation(parameter);
        String station1 = rowDevices.getStation1();
        Timestamp dateTime1 = rowDevices.getDatetime1();
        String device1 = rowDevices.getDevice1();
        String status1 = rowDevices.getStatus1();
        int level1 = rowDevices.getLevel1();
        double inletpressure1 = rowDevices.getInletpressure1();
        double outletpressure1 = rowDevices.getOutletpressure1(); 

        String station2 = rowDevices.getStation2();
        Timestamp dateTime2 = rowDevices.getDatetime2();
        String device2 = rowDevices.getDevice2();
        String status2 = rowDevices.getStatus2();
        int level2 = rowDevices.getLevel2();
        double inletpressure2 = rowDevices.getInletpressure2();
        double outletpressure2 = rowDevices.getOutletpressure2(); 

        String station3 = rowDevices.getStation3();
        Timestamp dateTime3 = rowDevices.getDatetime3();
        String device3 = rowDevices.getDevice3();
        String status3 = rowDevices.getStatus3();
        int level3 = rowDevices.getLevel3();
        double inletpressure3 = rowDevices.getInletpressure3();
        double outletpressure3 = rowDevices.getOutletpressure3(); 

        String station4 = rowDevices.getStation4();
        Timestamp dateTime4 = rowDevices.getDatetime4();
        String device4 = rowDevices.getDevice4();
        String status4 = rowDevices.getStatus4();
        int level4 = rowDevices.getLevel4();
        double inletpressure4 = rowDevices.getInletpressure4();
        double outletpressure4 = rowDevices.getOutletpressure4(); 

        String station5 = rowDevices.getStation5();
        Timestamp dateTime5 = rowDevices.getDatetime5();
        String device5 = rowDevices.getDevice5();
        String status5 = rowDevices.getStatus5();
        int level5 = rowDevices.getLevel5();
        double inletpressure5 = rowDevices.getInletpressure5();
        double outletpressure5 = rowDevices.getOutletpressure5(); 

        String station6 = rowDevices.getStation6();
        Timestamp dateTime6 = rowDevices.getDatetime6();
        String device6 = rowDevices.getDevice6();
        String status6 = rowDevices.getStatus6();
        int level6 = rowDevices.getLevel6();
        double inletpressure6 = rowDevices.getInletpressure6();
        double outletpressure6 = rowDevices.getOutletpressure6(); 
        /*

String station = (String) jsonMap.get("station");
final String device2 = (String) jsonMap.get("device");
String status = (String) jsonMap.get("status");
int level = (int) jsonMap.get("level");
double inletpressure = (double) jsonMap.get("inletpressure");
double outletpressure = (double) jsonMap.get("outletpressure");

        */       
        //System.out.println(station1);
        
        return "[{\"Station\" : \""  + parameter + "\", \"Date Time\" : \"" + dateTime1  + "\", \"Device\" : \"" + device1 + "\" , \"Status\" : \""  + status1
        + "\" , \"Level\" : " + level1 + " , \"Inlet Pressure\" : " + inletpressure1 + 
        " , \"Outlet Pressure\" : " + outletpressure1 
        + "}, {\"Station\" : \"" + parameter +  "\", \"Date Time\" : \"" + dateTime2  + "\", \"Device\" : \"" + device2  + "\" , \"Status\" : \""  + status2
        + "\" , \"Level\" : " +  level2 + " , \"Inlet Pressure\" : " + inletpressure2 + 
        " , \"Outlet Pressure\" : " + outletpressure2 + 
        "}, {\"Station\" : \"" + parameter +  "\", \"Date Time\" : \"" + dateTime3  + "\", \"Device\" : \"" + device3 + "\" , \"Status\" : \""  + status3
        + "\" , \"Level\" : " + level3 + " , \"Inlet Pressure\" : " + inletpressure3 + 
        " , \"Outlet Pressure\" : " + outletpressure3 
        +  "}, {\"Station\" : \"" + parameter +  "\", \"Date Time\" : \"" + dateTime4  + "\", \"Device\" : \"" + device4  + "\" , \"Status\" : \""  + status4
        + "\" , \"Level\" : " + level4 + " , \"Inlet Pressure\" : " + inletpressure4 + 
        " , \"Outlet Pressure\" : " + outletpressure4 + 
        "}, {\"Station\" : \"" + parameter +  "\", \"Date Time\" : \"" + dateTime5  + "\", \"Device\" : \"" + device5  + "\" , \"Status\" : \""  + status5
        + "\" , \"Level\" : " + level5 + " , \"Inlet Pressure\" : " + inletpressure5 + 
        " , \"Outlet Pressure\" : " + outletpressure5 +
        "}, {\"Station\" : \"" + parameter +  "\", \"Date Time\" : \"" + dateTime6  + "\", \"Device\" : \"" + device6  + "\" , \"Status\" : \""  + status6
        + "\" , \"Level\" : " + level6 + " , \"Inlet Pressure\" : " + inletpressure6 + 
        " , \"Outlet Pressure\" : " + outletpressure6  +
        "}]";
    }
    // In order to make requirement need to parse one by one:
  






}


