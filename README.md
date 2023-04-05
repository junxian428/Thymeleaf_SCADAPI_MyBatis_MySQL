# Thymeleaf_SCADAPI_MyBatis_MySQL-

Display Condition based on MySQL Devices Situtaion 

![image](https://user-images.githubusercontent.com/58724748/229408322-71b9541f-291e-4673-83e4-08748d4279cd.png)

SQL

CREATE TABLE `devices` (

  `id` int(11) NOT NULL,

  `station` varchar(255) NOT NULL,

  `datetime` datetime NOT NULL,

  `device` varchar(255) NOT NULL,

  `status` varchar(255) NOT NULL,

  `level` int(11) NOT NULL,

  `inletpressure` double NOT NULL,

  `outletpressure` int(11) NOT NULL
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

GET Method

http://localhost:8081/device/getDataBased/Station 1

[{"Station" : "Station 1", "Date Time" : "2023-04-05 09:32:34.0", "Device" : "Suction Tank" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : Station 1", "Date Time" : "2023-04-05 09:32:34.0", "Device" : "Service Tank" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : Station 1", "Date Time" : "2023-04-04 17:02:27.0", "Device" : "Pump 1" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : Station 1", "Date Time" : "2023-04-04 17:02:31.0", "Device" : "Pump 2" , "Status" : "Bad" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : Station 1", "Date Time" : "2023-04-04 17:02:38.0", "Device" : "Pump 4" , "Status" : "Ok" , "Level" : 0 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : Station 1", "Date Time" : "null", "Device" : "null" , "Status" : "null" , "Level" : 0 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}]

http://localhost:8081/device/getDataBased/Station 2

[{"Station" : "Station 2", "Date Time" : "2023-04-04 08:47:19.0", "Device" : "Suction Tank" , "Status" : "Ok" , "Level" : 50 , "Inlet Pressure" : 12.0 , "Outlet Pressure" : 59.0}, {"Station" : Station 2", "Date Time" : "2023-04-04 08:56:27.0", "Device" : "Service Tank" , "Status" : "Ok" , "Level" : 50 , "Inlet Pressure" : 100.0 , "Outlet Pressure" : 57.0}, {"Station" : Station 2", "Date Time" : "2023-04-04 08:56:27.0", "Device" : "Pump 1" , "Status" : "Ok" , "Level" : 1 , "Inlet Pressure" : 1.0 , "Outlet Pressure" : 1.0}, {"Station" : Station 2", "Date Time" : "2023-04-04 08:57:24.0", "Device" : "Pump 2" , "Status" : "Ok" , "Level" : 66 , "Inlet Pressure" : 55.0 , "Outlet Pressure" : 44.0}, {"Station" : Station 2", "Date Time" : "2023-04-04 08:58:21.0", "Device" : "Pump 4" , "Status" : "Ok" , "Level" : 1 , "Inlet Pressure" : 23.0 , "Outlet Pressure" : 45.0}, {"Station" : Station 2", "Date Time" : "null", "Device" : "null" , "Status" : "null" , "Level" : 0 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}]

http://localhost:8081/device/getDataBased/Station 3

[{"Station" : "Station 3", "Date Time" : "2023-04-05 09:36:13.0", "Device" : "Suction Tank" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : Station 3", "Date Time" : "2023-04-05 09:36:13.0", "Device" : "Service Tank" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : Station 3", "Date Time" : "2023-04-04 17:02:27.0", "Device" : "Pump 1" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : Station 3", "Date Time" : "2023-04-04 17:02:31.0", "Device" : "Pump 2" , "Status" : "Bad" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : Station 3", "Date Time" : "2023-04-04 17:02:38.0", "Device" : "Pump 4" , "Status" : "Ok" , "Level" : 0 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : Station 3", "Date Time" : "null", "Device" : "null" , "Status" : "null" , "Level" : 0 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}]



POST Method (Can etiher no date or have date)

http://localhost:8081/device/submitMultiForm

Station 1 (Date)

[{"Station" : "Station 1","Device"  :  "Suction Tank", "Date Time" : "" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0},  {"Station" :"Station 1", "Device"  :  "Service Tank", "Date Time" : "" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 1", "Device"  :  "Pump 1", "Date Time" : "2023-04-04 17:02:27.0" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 1",  "Device"  :  "Pump 2", "Date Time" : "2023-04-04 17:02:31.0" , "Status" : "Bad" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 1", "Device"  :  "Pump 3", "Date Time" : "2023-04-04 17:02:38.0" , "Status" : "Bad" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 1", "Device"  :  "Pump 4", "Date Time" : "2023-04-04 17:02:38.0" , "Status" : "Ok" , "Level" : 0 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}]

http://localhost:8081/device/submitMultiForm

Station 1 (No Date)

[{"Station" : "Station 1","Device"  :  "Suction Tank", "Date Time" : "" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0},  {"Station" :"Station 1", "Device"  :  "Service Tank", "Date Time" : "" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 1", "Device"  :  "Pump 1", "Date Time" : "" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 1",  "Device"  :  "Pump 2", "Date Time" : "" , "Status" : "Bad" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 1", "Device"  :  "Pump 3", "Date Time" : "" , "Status" : "Bad" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 1", "Device"  :  "Pump 4", "Date Time" : "" , "Status" : "Ok" , "Level" : 0 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}]

http://localhost:8081/device/submitMultiForm

Station 2 (Date)

[{"Station" : "Station 2","Device"  :  "Suction Tank", "Date Time" : "" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0},  {"Station" :"Station 2", "Device"  :  "Service Tank", "Date Time" : "" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 2", "Device"  :  "Pump 1", "Date Time" : "2023-04-04 17:02:27.0" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 2",  "Device"  :  "Pump 2", "Date Time" : "2023-04-04 17:02:31.0" , "Status" : "Bad" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 2", "Device"  :  "Pump 3", "Date Time" : "2023-04-04 17:02:38.0" , "Status" : "Bad" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 2", "Device"  :  "Pump 4", "Date Time" : "2023-04-04 17:02:38.0" , "Status" : "Ok" , "Level" : 0 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}]

http://localhost:8081/device/submitMultiForm

Station 2 (No Date)

[{"Station" : "Station 2","Device"  :  "Suction Tank", "Date Time" : "" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0},  {"Station" :"Station 2", "Device"  :  "Service Tank", "Date Time" : "" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 2", "Device"  :  "Pump 1", "Date Time" : "" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 2",  "Device"  :  "Pump 2", "Date Time" : "" , "Status" : "Bad" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 2", "Device"  :  "Pump 3", "Date Time" : "" , "Status" : "Bad" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 2", "Device"  :  "Pump 4", "Date Time" : "" , "Status" : "Ok" , "Level" : 0 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}]

http://localhost:8081/device/submitMultiForm

Station 3 (Date)

[{"Station" : "Station 3","Device"  :  "Suction Tank", "Date Time" : "" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0},  {"Station" :"Station 3", "Device"  :  "Service Tank", "Date Time" : "" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 3", "Device"  :  "Pump 1", "Date Time" : "2023-04-04 17:02:27.0" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 3",  "Device"  :  "Pump 2", "Date Time" : "2023-04-04 17:02:31.0" , "Status" : "Bad" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 3", "Device"  :  "Pump 3", "Date Time" : "2023-04-04 17:02:38.0" , "Status" : "Bad" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 3", "Device"  :  "Pump 4", "Date Time" : "2023-04-04 17:02:38.0" , "Status" : "Ok" , "Level" : 0 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}]

http://localhost:8081/device/submitMultiForm

Station 3 (No Date)

[{"Station" : "Station 3","Device"  :  "Suction Tank", "Date Time" : "" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0},  {"Station" :"Station 3", "Device"  :  "Service Tank", "Date Time" : "" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 3", "Device"  :  "Pump 1", "Date Time" : "" , "Status" : "Ok" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 3",  "Device"  :  "Pump 2", "Date Time" : "" , "Status" : "Bad" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 3", "Device"  :  "Pump 3", "Date Time" : "" , "Status" : "Bad" , "Level" : 25 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}, {"Station" : "Station 3", "Device"  :  "Pump 4", "Date Time" : "" , "Status" : "Ok" , "Level" : 0 , "Inlet Pressure" : 0.0 , "Outlet Pressure" : 0.0}]