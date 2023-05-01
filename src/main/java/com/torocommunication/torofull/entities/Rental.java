package com.torocommunication.torofull.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rental {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Long id;


        @ManyToOne
        private Car car;


        @ManyToOne
        private Employee employee;

        @ManyToOne
        private Customer customer;

        private Date startDate;
        private int durationDays;


      @CreationTimestamp
      @Column(nullable = false)
      private Date dateCreate;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date dateUpdate;


}
