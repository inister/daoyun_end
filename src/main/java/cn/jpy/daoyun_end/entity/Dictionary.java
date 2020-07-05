package cn.jpy.daoyun_end.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dicId;
    private String dicName;

    public Dictionary() {
    }

    public Integer getDicId() {
        return dicId;
    }

    public void setDicId(Integer dicId) {
        this.dicId = dicId;
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }
}
