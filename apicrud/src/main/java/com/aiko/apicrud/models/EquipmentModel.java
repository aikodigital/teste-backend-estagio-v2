package com.aiko.apicrud.models;

/**
 *
 * @author Celso França Neto
 */

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_model", schema = "operation")
public class EquipmentModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
