package com.brunozarth.testeaiko.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.UUID;

@Entity
@Table(name = "equipment_model")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class EquipmentModel {

    @Id
    @Version
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
