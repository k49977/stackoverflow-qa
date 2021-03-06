package com.example.en62678427;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Fleet{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FLT_ID")
    private int fltId;

    @Column(name = "FLT_NM")
    private String fleetName;

    @Column(name = "FLT_ASSN")
    private String fleetAssignment;

    @OneToMany(mappedBy = "fleet", cascade = CascadeType.ALL)
    private List<FleetSerialNo> fleetSerialNo;

    public Fleet( ) {

    }

    public Fleet(final String fleetName, final String fleetAssignment) {
        super();
        this.fleetName = fleetName;
        this.fleetAssignment = fleetAssignment;

    }

}