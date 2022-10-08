package sshukla.java.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author 'Seemant Shukla' on '08/10/2022'
 */

@Entity
@Table(schema = "wikimedia_data")
@Getter
@Setter
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String wikimediaEventData;

}
