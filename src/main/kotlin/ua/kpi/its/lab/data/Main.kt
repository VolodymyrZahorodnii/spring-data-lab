package ua.kpi.its.lab.data

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import ua.kpi.its.lab.data.config.Config
import ua.kpi.its.lab.data.entity.Satellite
import ua.kpi.its.lab.data.entity.Processor
import ua.kpi.its.lab.data.svc.SatelliteService
import java.util.Calendar

fun randomProcessor(calendar: Calendar): Processor {
    val names = arrayOf("processor_name_1", "processor_name_2")
    val manufacturers = arrayOf("processor_manufacturer_1", "processor_manufacturer_2")
    val cores = arrayOf(4, 8, 16)
    val frequency = arrayOf(2.0, 3.0, 4.0)
    val socket = arrayOf("socket_1", "socket_2")
    val productionDate = calendar.apply { set(2020, 0, 1, 0, 0, 0) }.time
    val mmxSupport = arrayOf(true, false)

    return Processor(
        names.random(), manufacturers.random(), cores.random(), frequency.random(),
        socket.random(), productionDate, mmxSupport.random()
    )
}

fun randomSatellite(calendar: Calendar, processor: Processor): Satellite {
    val names = arrayOf("satellite_name_1", "satellite_name_2")
    val countries = arrayOf("country_1", "country_2")
    val launchDate = calendar.apply { set(2010, 0, 1, 0, 0, 0) }.time
    val purpose = arrayOf("purpose_1", "purpose_2")
    val weight = arrayOf(1000.0, 2000.0, 3000.0)
    val height = arrayOf(500.0, 1000.0, 1500.0)
    val geostationary = arrayOf(true, false)

    return Satellite(
        names.random(), countries.random(), launchDate, purpose.random(),
        weight.random(), height.random(), geostationary.random(), processor
    )
}

fun main() {
    val context = AnnotationConfigApplicationContext(Config::class.java)
    val satelliteService = context.getBean(SatelliteService::class.java)
    val calendar = context.getBean(Calendar::class.java)

    // Generate and store satellites
    (1..5).forEach { _ ->
        val processor = randomProcessor(calendar)
        val satellite = randomSatellite(calendar, processor)
        satelliteService.create(satellite)
    }

    // Example of accessing and manipulating data
    val satellite2 = satelliteService.readByIndex(2)
    println("Retrieved satellite: $satellite2")

    val deletedSatellite = satelliteService.deleteByIndex(4)
    println("Removed satellite: $deletedSatellite")
}
