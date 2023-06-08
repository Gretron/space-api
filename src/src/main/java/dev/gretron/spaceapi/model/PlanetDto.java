package dev.gretron.spaceapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("planet")
public class PlanetDto {
    @Id
    @Column("planet_id")
    private int id;

    @Column("star_id")
    private int starId;

    @Column("planet_name")
    private String name;

    private String color;

    private float mass;

    private int diameter;

    @Column("length_of_day")
    private float lengthOfDay;

    @Column("orbital_period")
    private float orbitalPeriod;

    @Column("surface_gravity")
    private float surfaceGravity;

    private int temperature;
}
