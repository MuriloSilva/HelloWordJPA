package com.bean;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
 
@Entity
@Table(
   name="users", 
   uniqueConstraints=@UniqueConstraint(
	   columnNames={"name", "password"}, 
	   name="Primarykey"
   )
)
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
     
    @Column
    private String name;
     
    @Column
    private String password;       
     
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User){
            User user = (User) obj;
            return user.getId() == this.getId();
        }         
        return false;
    }
 
    public int getId() {
        return id;
    }
 
//    public void setId(int id) {
//        this.id = id;
//    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString(){
    	return "ID: " + id + " Nome: " + name + " PassWord: " + password;
    }
}
