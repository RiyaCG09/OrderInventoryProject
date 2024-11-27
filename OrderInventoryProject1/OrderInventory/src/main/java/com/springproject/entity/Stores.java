package com.springproject.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stores")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Stores{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "store_id")
    private int storeId;

    @Column(name = "store_name", nullable = false)
    private String storeName;

    @Column(name = "web_address")
    private String webAddress;

    @Column(name = "physical_address", nullable = false, length = 512)
    private String physicalAddress;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Lob  
    @Column(name = "logo")
    private byte[] logo;

    @Column(name = "logo_mime_type", length = 512)
    private String logoMimeType;

    @Column(name = "logo_filename", length = 512)
    private String logoFilename;

    @Column(name = "logo_charset", length = 512)
    private String logoCharset;

    @Column(name = "logo_last_updated")
    @Temporal(TemporalType.DATE) 
    private Date logoLastUpdated;

    
}
