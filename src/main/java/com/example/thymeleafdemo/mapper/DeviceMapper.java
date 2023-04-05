package com.example.thymeleafdemo.mapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.util.MultiValueMap;

import com.example.thymeleafdemo.model.Devices;
import com.example.thymeleafdemo.model.OneRowDevices;

@Mapper
public interface DeviceMapper {
    @Select("SELECT * FROM devices WHERE id = (SELECT MAX(id) FROM devices);")
    List<Devices> findAll();

    @Insert("INSERT INTO devices (datetime, device, status, level, inletpressure, outletpressure) VALUES (#{datetime}, #{device}, #{status}, #{level}, #{inletpressure}, #{outletpressure})")
    void insertDevice(MultiValueMap<String, String> formData);

    @Select("SELECT * FROM devices WHERE station = #{station} ORDER BY id DESC LIMIT 1")
    Devices findLatestByStation(@Param("station") String station);

    @Select("SELECT * FROM devices WHERE station = #{station} AND device = 'Suction Tank' ORDER BY datetime DESC LIMIT 1")
    Devices findSuctionTank(@Param("station") String station);

    @Select("SELECT * FROM devices WHERE station = #{station} AND device = 'Service Tank' ORDER BY datetime DESC LIMIT 1")
    Devices findServiceTank(@Param("station") String station);

    @Select("SELECT * FROM devices WHERE station = #{station} AND device = 'Pump 1' ORDER BY datetime DESC LIMIT 1")
    Devices findPump1(@Param("station") String station);

    @Select("SELECT * FROM devices WHERE station = #{station} AND device = 'Pump 2' ORDER BY datetime DESC LIMIT 1")
    Devices findPump2(@Param("station") String station);

    @Select("SELECT * FROM devices WHERE station = #{station} AND device = 'Pump 3' ORDER BY id DESC LIMIT 1")
    Devices findPump3(@Param("station") String station);

    @Select("SELECT * FROM devices WHERE station = #{station} AND device = 'Pump 4' ORDER BY id DESC LIMIT 1")
    Devices findPump4(@Param("station") String station);

    //private Integer id;
    //private Timestamp datetime;
    //private String device;
    //private int status;
    //private int level;
    //private double inletpressure;
    //private double outletpressure;
    @Insert("INSERT INTO devices (datetime, device, status, level, inletpressure, outletpressure) VALUES (#{datetime}, #{device}, #{status}, #{level}, #{inletpressure}, #{outletpressure})")
    void insertDeviceData(Devices devices);

    //void insertDevice(Devices devices);
 
    //void insertUser(@Param("name") String name, @Param("email") String email);
   @Insert("INSERT INTO devices (station, datetime, device, status, level, inletpressure, outletpressure) VALUES (#{station} , #{datetime}, #{device}, #{status}, #{level}, #{inletpressure}, #{outletpressure})")
    void saveDeviceData(@Param("station") String station,@Param("datetime") String datetime, @Param("device") String device, @Param("status") String status, @Param("level") int level, @Param("inletpressure") double inletpressure, @Param("outletpressure") double outletpressure);
   
    @Select("SELECT * FROM onerowdevices WHERE station1 = #{station} ORDER BY id DESC LIMIT 1")
    OneRowDevices findOneRowByStation(@Param("station") String station);


    @Insert("INSERT INTO onerowdevices (station1, datetime1, device1, status1, level1, inletpressure1, outletpressure1, station2, datetime2, device2, status2, level2, inletpressure2, outletpressure2, station3, datetime3, device3, status3, level3, inletpressure3, outletpressure3, station4, datetime4, device4, status4, level4, inletpressure4, outletpressure4, station5, datetime5, device5, status5, level5, inletpressure5, outletpressure5, station6, datetime6, device6, status6, level6, inletpressure6, outletpressure6) VALUES (#{station1} , #{datetime1}, #{device1}, #{status1}, #{level1}, #{inletpressure1}, #{outletpressure1}, #{station2} , #{datetime2}, #{device2}, #{status2}, #{level2}, #{inletpressure2}, #{outletpressure2}, #{station3} , #{datetime3}, #{device3}, #{status3}, #{level3}, #{inletpressure3}, #{outletpressure4} , #{station4} , #{datetime4}, #{device4}, #{status4}, #{level4}, #{inletpressure4}, #{outletpressure4} , #{station5} , #{datetime5}, #{device5}, #{status5}, #{level5}, #{inletpressure5}, #{outletpressure5}, #{station6} , #{datetime6}, #{device6}, #{status6}, #{level6}, #{inletpressure6}, #{outletpressure6})")
    void saveRowData(@Param("station1") String station1,@Param("datetime1") String datetime1, @Param("device1") String device1, @Param("status1") String status1, @Param("level1") int level1, @Param("inletpressure1") double inletpressure1, @Param("outletpressure1") double outletpressure1, @Param("station2") String station2,@Param("datetime2") String datetime2, @Param("device2") String device2, @Param("status2") String status2, @Param("level2") int level2, @Param("inletpressure2") double inletpressure2, @Param("outletpressure2") double outletpressure2, @Param("station3") String station3,@Param("datetime3") String datetime3, @Param("device3") String device3, @Param("status3") String status3, @Param("level3") int level3, @Param("inletpressure3") double inletpressure3, @Param("outletpressure3") double outletpressure3, @Param("station4") String station4,@Param("datetime4") String datetime4, @Param("device4") String device4, @Param("status4") String status4, @Param("level4") int level4, @Param("inletpressure4") double inletpressure4, @Param("outletpressure4") double outletpressure4, @Param("station5") String station5,@Param("datetime5") String datetime5, @Param("device5") String device5, @Param("status5") String status5, @Param("level5") int level5, @Param("inletpressure5") double inletpressure5, @Param("outletpressure5") double outletpressure5, @Param("station6") String station6,@Param("datetime6") String datetime6, @Param("device6") String device6, @Param("status6") String status6, @Param("level6") int level6, @Param("inletpressure6") double inletpressure6, @Param("outletpressure6") double outletpressure6);



}
