package com.example.ManchesterUnited_api.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "DOB")
    private LocalDate DOB;
    @Column(name = "Age")
    private int age;
    @Column(name = "Nationality")
    private String nationality;
    @Column(name = "Player_number")
    private int number;
    @Column(name = "Foot")
    private String foot;
    @Column(name = "position")
    private String position;
    @JsonIgnore
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;
    @JsonIgnore
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
//    @JsonIgnore
    @Column(name = "player_key")
    private String playerKey;

    public Player(){}
    public Player(@JsonProperty("id") Long id,
                  @JsonProperty("name") String name,
                  @JsonProperty("DOB") LocalDate DOB,
                  @JsonProperty("age") int age,
                  @JsonProperty("nationality") String nationality,
                  @JsonProperty("number") int number,
                  @JsonProperty("foot") String foot,
                  @JsonProperty("created_at") Date createdAt,
                  @JsonProperty("updated_at") Date updatedAt,
                  @JsonProperty("position") String position,
                  @JsonProperty("key") String playerKey) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
        this.age = age;
        this.nationality = nationality;
        this.number = number;
        this.foot = foot;
        this.position = position;
        this.playerKey = playerKey;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDOB() {
        return DOB;
    }
    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getFoot() {
        return foot;
    }
    public void setFoot(String foot) {
        this.foot = foot;
    }
    @JsonIgnore
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    @JsonIgnore
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
//    @JsonIgnore
    public String getPlayerKey() {
        return playerKey;
    }

    public void setPlayerKey(String playerKey) {
        this.playerKey = playerKey;
    }
}