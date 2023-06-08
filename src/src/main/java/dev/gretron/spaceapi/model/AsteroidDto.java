package dev.gretron.spaceapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("asteroid")
public class AsteroidDto {
    @Id
    @Column("asteroid_id")
    private int id;

    @Column("asteroid_name")
    private String name;

    @Column("asteroid_designation")
    private int designation;

    @Column("sentry_monitored")
    private boolean sentryMonitored;

    @Column("asteroid_dangerous")
    private boolean dangerous;

    @Column("asteroid_magnitude")
    private float magnitude;

    @Column("asteroid_min_diameter")
    private float minDiameter;

    @Column("asteroid_max_diameter")
    private float maxDiameter;

}
