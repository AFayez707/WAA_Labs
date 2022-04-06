package edu.miu.restful.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Logger {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long transactionId;
    Date datetime;
    double duration;
    @ManyToOne
    @JoinColumn(name = "principle_id")
    @JsonBackReference
    UserModel principle;
    String operation;
}
