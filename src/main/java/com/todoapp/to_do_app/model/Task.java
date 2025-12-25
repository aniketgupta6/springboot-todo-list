package com.todoapp.to_do_app.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long taskId;
    private String taskName;
    private Boolean status;

}
