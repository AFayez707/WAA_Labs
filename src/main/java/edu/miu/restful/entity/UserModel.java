package edu.miu.restful.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String name;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    List<Post> posts;

    @OneToMany(mappedBy = "principle", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Logger> log;

    public static UserModel getLoggedInUser(){
        return new UserModel(101,"LoggedIn User!",null,null);
    }
}
