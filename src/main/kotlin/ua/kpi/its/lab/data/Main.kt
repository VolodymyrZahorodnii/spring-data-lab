package ua.kpi.its.lab.data

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import ua.kpi.its.lab.data.config.Config
import ua.kpi.its.lab.data.entity.Satellite
import ua.kpi.its.lab.data.entity.Processor
import ua.kpi.its.lab.data.svc.SatelliteService
import java.util.Calendar

fun main() {
    val context = AnnotationConfigApplicationContext(Config::class.java)
    val satelliteService = context.getBean(SatelliteService::class.java)
    val calendar = context.getBean(Calendar::class.java)

    val processor1 = Processor(
        "processor_name_1", "processor_manufacturer_1", 4, 2.0,
        "socket_1", calendar.apply { set(2015, 0, 1, 0, 0, 0) }.time, true
    )

    val processor2 = Processor(
        "processor_name_2", "processor_manufacturer_2", 8, 3.0,
        "socket_2", calendar.apply { set(2016, 0, 1, 0, 0, 0) }.time, false
    )

    val satellite1 = Satellite(
        "satellite_name_1", "country_1", calendar.apply { set(2017, 0, 1, 0, 0, 0) }.time,
        "purpose_1", 1000.0, 500.0, true, processor1
    )

    val satellite2 = Satellite(
        "satellite_name_2", "country_2", calendar.apply { set(2018, 0, 1, 0, 0, 0) }.time,
        "purpose_2", 2000.0, 1000.0, false, processor2
    )

    val satellite3 = Satellite(
        "satellite_name_3", "country_1", calendar.apply { set(2019, 0, 1, 0, 0, 0) }.time,
        "purpose_2", 3000.0, 1500.0, true, processor1
    )

    val satellite4 = Satellite(
        "satellite_name_4", "country_2", calendar.apply { set(2020, 0, 1, 0, 0, 0) }.time,
        "purpose_3", 4000.0, 2000.0, false, processor2
    )

    val satellite5 = Satellite(
        "satellite_name_5", "country_1", calendar.apply { set(2021, 0, 1, 0, 0, 0) }.time,
        "purpose_3", 5000.0, 2500.0, true, processor1
    )

    val satellites = listOf(satellite1, satellite2, satellite3, satellite4, satellite5)
    satellites.forEach { satelliteService.create(it) }

    val satellite2Retrieved = satelliteService.readByIndex(3)
    println("Retrieved satellite: $satellite2Retrieved")

    val deletedSatellite = satelliteService.deleteByIndex(4)
    println("Removed satellite: $deletedSatellite")
}
