package ua.kpi.its.lab.data.svc.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.kpi.its.lab.data.entity.Satellite
import ua.kpi.its.lab.data.entity.Processor
import ua.kpi.its.lab.data.repo.SatelliteRepository
import ua.kpi.its.lab.data.repo.ProcessorRepository
import ua.kpi.its.lab.data.svc.SatelliteService

@Service
class SatelliteServiceImpl @Autowired constructor(
    private val repository: SatelliteRepository
): SatelliteService {
    override fun create(satellite: Satellite): Satellite {
        if (satellite.id != -1L && repository.existsById(satellite.id)) {
            throw IllegalArgumentException("Satellite with ID = ${satellite.id} already exists")
        }
        return repository.save(satellite)
    }

    override fun read(): List<Satellite> {
        return repository.findAll()
    }

    override fun readByIndex(index: Int): Satellite {
        return this.read()[index]
    }

    override fun update(satellite: Satellite): Satellite {
        if (!repository.existsById(satellite.id)) {
            throw IllegalArgumentException("Satellite with ID = ${satellite.id} not found")
        }
        return repository.save(satellite)
    }

    override fun delete(satellite: Satellite) {
        if (!repository.existsById(satellite.id)) {
            throw IllegalArgumentException("Satellite with ID = ${satellite.id} not found")
        }
        repository.deleteById(satellite.id)
    }

    override fun deleteByIndex(index: Int): Satellite {
        val target = this.readByIndex(index)
        this.delete(target)
        return target
    }
}
