package ua.kpi.its.lab.data.svc

import ua.kpi.its.lab.data.entity.Satellite
import ua.kpi.its.lab.data.entity.Processor

interface SatelliteService {
    /**
     * Creates a new Satellite record.
     *
     * @param satellite: The Satellite instance to be inserted
     * @return: The recently created Satellite instance
     */
    fun create(satellite: Satellite): Satellite
    /**
     * Reads all created Satellite records.
     *
     * @return: List of created Satellite records
     */
    fun read(): List<Satellite>
    /**
     * Reads a Satellite record by its index.
     * The order is determined by the order of creation.
     *
     * @param index: The index of Satellite record
     * @return: The Satellite instance at index
     */
    fun readByIndex(index: Int): Satellite
    /**
     * Updates a Satellite record data.
     *
     * @param satellite: The Satellite instance to be updated (valid id is required)
     * @return: The updated Satellite record
     */
    fun update(satellite: Satellite): Satellite
    /**
     * Deletes a Satellite record data.
     *
     * @param satellite: The Satellite instance to be deleted (valid `id` is required)
     */
    fun delete(satellite: Satellite)
    /**
     * Deletes a Satellite record by its index.
     * The order is determined by the order of creation.
     *
     * @param index: The index of Satellite record to delete
     * @return: The deleted Satellite instance at index
     */
    fun deleteByIndex(index: Int): Satellite
}

interface ProcessorService {
    /**
     * Creates a new Processor record.
     *
     * @param processor: The Processor instance to be inserted
     * @return: The recently created Processor instance
     */
    fun create(processor: Processor): Processor
    /**
     * Reads all created Processor records.
     *
     * @return: List of created Processor records
     */
    fun read(): List<Processor>
    /**
     * Reads a Processor record by its index.
     * The order is determined by the order of creation.
     *
     * @param index: The index of Processor record
     * @return: The Processor instance at index
     */
    fun readByIndex(index: Int): Processor
    /**
     * Updates a Processor record data.
     *
     * @param processor: The Processor instance to be updated (valid id is required)
     * @return: The updated Processor record
     */
    fun update(processor: Processor): Processor
    /**
     * Deletes a Processor record data.
     *
     * @param processor: The Processor instance to be deleted (valid `id` is required)
     */
    fun delete(processor: Processor)
    /**
     * Deletes a Processor record by its index.
     * The order is determined by the order of creation.
     *
     * @param index: The index of Processor record to delete
     * @return: The deleted Processor instance at index
     */
    fun deleteByIndex(index: Int): Processor
}