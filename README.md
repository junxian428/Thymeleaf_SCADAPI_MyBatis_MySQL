# Thymeleaf_SCADAPI_MyBatis_MySQL-

Display Condition based on MySQL Devices Situtaion 

![image](https://user-images.githubusercontent.com/58724748/229408322-71b9541f-291e-4673-83e4-08748d4279cd.png)

SQL

Version 1

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


______________________________________________________________________________________

Version 2


CREATE TABLE `onerowdevices` (
  `id` int(11) NOT NULL,
  `station1` varchar(255) NOT NULL,
  `datetime1` datetime NOT NULL,
  `device1` varchar(255) NOT NULL,
  `status1` varchar(255) NOT NULL,
  `level1` int(11) NOT NULL,
  `inletpressure1` double NOT NULL,
  `outletpressure1` double DEFAULT NULL,
  `station2` varchar(255) NOT NULL,
  `datetime2` datetime NOT NULL,
  `device2` varchar(255) NOT NULL,
  `status2` varchar(255) NOT NULL,
  `level2` int(11) NOT NULL,
  `inletpressure2` double NOT NULL,
  `outletpressure2` double DEFAULT NULL,
  `station3` varchar(255) NOT NULL,
  `datetime3` datetime NOT NULL,
  `device3` varchar(255) NOT NULL,
  `status3` varchar(255) NOT NULL,
  `level3` int(11) NOT NULL,
  `inletpressure3` double NOT NULL,
  `outletpressure3` double DEFAULT NULL,
  `station4` varchar(255) NOT NULL,
  `datetime4` datetime NOT NULL,
  `device4` varchar(255) NOT NULL,
  `status4` varchar(255) NOT NULL,
  `level4` int(11) NOT NULL,
  `inletpressure4` double NOT NULL,
  `outletpressure4` double DEFAULT NULL,
  `station5` varchar(255) NOT NULL,
  `datetime5` datetime NOT NULL,
  `device5` varchar(255) NOT NULL,
  `status5` varchar(255) NOT NULL,
  `level5` int(11) NOT NULL,
  `inletpressure5` double NOT NULL,
  `outletpressure5` double DEFAULT NULL,
  `station6` varchar(255) NOT NULL,
  `datetime6` datetime NOT NULL,
  `device6` varchar(255) NOT NULL,
  `status6` varchar(255) NOT NULL,
  `level6` int(11) NOT NULL,
  `inletpressure6` double NOT NULL,
  `outletpressure6` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `onerowdevices`
--

INSERT INTO `onerowdevices` (`id`, `station1`, `datetime1`, `device1`, `status1`, `level1`, `inletpressure1`, `outletpressure1`, `station2`, `datetime2`, `device2`, `status2`, `level2`, `inletpressure2`, `outletpressure2`, `station3`, `datetime3`, `device3`, `status3`, `level3`, `inletpressure3`, `outletpressure3`, `station4`, `datetime4`, `device4`, `status4`, `level4`, `inletpressure4`, `outletpressure4`, `station5`, `datetime5`, `device5`, `status5`, `level5`, `inletpressure5`, `outletpressure5`, `station6`, `datetime6`, `device6`, `status6`, `level6`, `inletpressure6`, `outletpressure6`) VALUES
(1, 'Station 1', '2023-04-05 09:42:06', 'Suction Tank', 'Ok', 50, 10, 100, 'Station 1', '2023-04-05 09:42:06', 'Service Tank', 'Ok', 50, 50, 50, 'Station 1', '2023-04-05 09:42:06', 'Pump 1', 'Bad', 100, 100, 100, 'Station 1', '2023-04-05 09:42:06', 'Pump 2', 'Ok', 80, 120, 78, 'Station 1', '2023-04-05 09:42:06', 'Pump 3', 'Ok', 100, 100, 78, 'Station 1', '2023-04-05 09:42:06', 'Pump 4', 'Ok', 90, 33.33, 56),
(2, 'Station 2', '2023-04-05 10:07:44', 'Suction Tank', 'Ok', 50, 30, 100, 'Station 2', '2023-04-05 10:07:44', 'Service Tank', 'Ok', 70, 40, 40, 'Station 2', '2023-04-05 10:07:44', 'Pump 1', 'Ok', 70, 50, 40, 'Station 2', '2023-04-05 10:07:44', 'Pump 2', 'Ok', 80, 40, 30, 'Station 2', '2023-04-05 10:07:44', 'Pump 3', 'Bad', 90, 40, 30, 'Station 2', '2023-04-05 10:07:44', 'Pump 4', 'Ok', 90, 55.55, 88.88),
(3, 'Station 3', '2023-04-05 10:07:44', 'Suction Tank', 'Ok', 50, 30, 100, 'Station 3', '2023-04-05 10:07:44', 'Service Tank', 'Ok', 70, 40, 40, 'Station 3', '2023-04-05 10:07:44', 'Pump 1', 'Ok', 70, 50, 40, 'Station 3', '2023-04-05 10:07:44', 'Pump 2', 'Ok', 80, 40, 30, 'Station 3', '2023-04-05 10:07:44', 'Pump 3', 'Bad', 90, 40, 30, 'Station 3', '2023-04-05 10:07:44', 'Pump 4', 'Ok', 90, 55.55, 88.88);
COMMIT;


Version 2

Improvement: Get and Post data into same row instead use for-loop to update one by one

GET METHOD： 

http://localhost:8081/device/row/Station%201

Output:

{"station1":"Station 1","datetime1":"2023-04-05T01:42:06.000+00:00","device1":"Suction Tank","status1":"Ok","level1":50,"inletpressure1":10.0,"outletpressure1":100.0,"station2":"Station 1","datetime2":"2023-04-05T01:42:06.000+00:00","device2":"Service Tank","status2":"Ok","level2":50,"inletpressure2":50.0,"outletpressure2":50.0,"station3":"Station 1","datetime3":"2023-04-05T01:42:06.000+00:00","device3":"Pump 1","status3":"Bad","level3":100,"inletpressure3":100.0,"outletpressure3":100.0,"station4":"Station 1","datetime4":"2023-04-05T01:42:06.000+00:00","device4":"Pump 2","status4":"Ok","level4":80,"inletpressure4":120.0,"outletpressure4":78.0,"station5":"Station 1","datetime5":"2023-04-05T01:42:06.000+00:00","device5":"Pump 3","status5":"Ok","level5":100,"inletpressure5":100.0,"outletpressure5":78.0,"station6":"Station 1","datetime6":"2023-04-05T01:42:06.000+00:00","device6":"Pump 4","status6":"Ok","level6":90,"inletpressure6":33.33,"outletpressure6":56.0}

Make accordingly and follow requirement:



POST METHOD:


_______________________________________________________________________________________________________________

Version 1 API

Problem： Display Problem if order by timestamp 

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