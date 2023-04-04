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

@Mapper
public interface DeviceMapper {
    @Select("SELECT * FROM devices WHERE id = (SELECT MAX(id) FROM devices);")
    List<Devices> findAll();

    @Insert("INSERT INTO devices (datetime, device, status, level, inletpressure, outletpressure) VALUES (#{datetime}, #{device}, #{status}, #{level}, #{inletpressure}, #{outletpressure})")
    void insertDevice(MultiValueMap<String, String> formData);

    @Select("SELECT * FROM devices WHERE station = #{station} ORDER BY id DESC LIMIT 1")
    Devices findLatestByStation(@Param("station") String station);

    @Select("SELECT * FROM devices WHERE station = #{station} AND device = 'Suction Tank' ORDER BY id DESC LIMIT 1")
    Devices findSuctionTank(@Param("station") String station);

    @Select("SELECT * FROM devices WHERE station = #{station} AND device = 'Service Tank' ORDER BY id DESC LIMIT 1")
    Devices findServiceTank(@Param("station") String station);

    @Select("SELECT * FROM devices WHERE station = #{station} AND device = 'Pump 1' ORDER BY id DESC LIMIT 1")
    Devices findPump1(@Param("station") String station);

    @Select("SELECT * FROM devices WHERE station = #{station} AND device = 'Pump 2' ORDER BY id DESC LIMIT 1")
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
    @Insert("INSERT INTO devices (station, datetime, device, status, level, inletpressure, outletpressure) VALUES (#{station} , #{datetime}, #{device}, #{status}, #{level}, #{inletpressure}, #{outletpressure})")
    void saveDeviceData(@Param("station") String station,@Param("datetime") LocalDateTime localDateTime, @Param("device") String device, @Param("status") String status, @Param("level") int level, @Param("inletpressure") double inletpressure, @Param("outletpressure") double outletpressure);
    //void insertUser(@Param("name") String name, @Param("email") String email);

}
