package model;

import java.util.Date;

public class Players extends MzPlayerModel{
    private Integer id;

    private Integer pid;

    private String name;

    private Integer birthseason;

    private Integer value;

    private Integer salary;

    private String nationality;

    private Integer speed;

    private Integer stamina;

    private Integer itg;

    private Integer pass;

    private Integer shoot;

    private Integer head;

    private Integer keep;

    private Integer control;

    private Integer tackl;

    private Integer aPass;

    private Integer setPalys;

    private Integer experience;

    private Date jointeam;

    private Date leaveteam;

    private Integer hadCost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getBirthseason() {
        return birthseason;
    }

    public void setBirthseason(Integer birthseason) {
        this.birthseason = birthseason;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getStamina() {
        return stamina;
    }

    public void setStamina(Integer stamina) {
        this.stamina = stamina;
    }

    public Integer getItg() {
        return itg;
    }

    public void setItg(Integer itg) {
        this.itg = itg;
    }

    public Integer getPass() {
        return pass;
    }

    public void setPass(Integer pass) {
        this.pass = pass;
    }

    public Integer getShoot() {
        return shoot;
    }

    public void setShoot(Integer shoot) {
        this.shoot = shoot;
    }

    public Integer getHead() {
        return head;
    }

    public void setHead(Integer head) {
        this.head = head;
    }

    public Integer getKeep() {
        return keep;
    }

    public void setKeep(Integer keep) {
        this.keep = keep;
    }

    public Integer getControl() {
        return control;
    }

    public void setControl(Integer control) {
        this.control = control;
    }

    public Integer getTackl() {
        return tackl;
    }

    public void setTackl(Integer tackl) {
        this.tackl = tackl;
    }

    public Integer getaPass() {
        return aPass;
    }

    public void setaPass(Integer aPass) {
        this.aPass = aPass;
    }

    public Integer getSetPalys() {
        return setPalys;
    }

    public void setSetPalys(Integer setPalys) {
        this.setPalys = setPalys;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Date getJointeam() {
        return jointeam;
    }

    public void setJointeam(Date jointeam) {
        this.jointeam = jointeam;
    }

    public Date getLeaveteam() {
        return leaveteam;
    }

    public void setLeaveteam(Date leaveteam) {
        this.leaveteam = leaveteam;
    }

    public Integer getHadCost() {
        return hadCost;
    }

    public void setHadCost(Integer hadCost) {
        this.hadCost = hadCost;
    }
}