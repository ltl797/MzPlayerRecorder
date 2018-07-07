package tool;

import java.util.Date;

public class Transfers {
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

    private Integer askingPrice;

    private Integer latestBid;

    private Date dlDate;

    private Date dlTime;

    private Integer dlSeasonDay;

    private Boolean keeper;

    private Boolean guard;

    private Boolean dmf;

    private Boolean midfielder;

    private Boolean forward;

    private Boolean winger;

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

    public Integer getAskingPrice() {
        return askingPrice;
    }

    public void setAskingPrice(Integer askingPrice) {
        this.askingPrice = askingPrice;
    }

    public Integer getLatestBid() {
        return latestBid;
    }

    public void setLatestBid(Integer latestBid) {
        this.latestBid = latestBid;
    }

    public Date getDlDate() {
        return dlDate;
    }

    public void setDlDate(Date dlDate) {
        this.dlDate = dlDate;
    }

    public Date getDlTime() {
        return dlTime;
    }

    public void setDlTime(Date dlTime) {
        this.dlTime = dlTime;
    }

    public Integer getDlSeasonDay() {
        return dlSeasonDay;
    }

    public void setDlSeasonDay(Integer dlSeasonDay) {
        this.dlSeasonDay = dlSeasonDay;
    }

    public Boolean getKeeper() {
        return keeper;
    }

    public void setKeeper(Boolean keeper) {
        this.keeper = keeper;
    }

    public Boolean getGuard() {
        return guard;
    }

    public void setGuard(Boolean guard) {
        this.guard = guard;
    }

    public Boolean getDmf() {
        return dmf;
    }

    public void setDmf(Boolean dmf) {
        this.dmf = dmf;
    }

    public Boolean getMidfielder() {
        return midfielder;
    }

    public void setMidfielder(Boolean midfielder) {
        this.midfielder = midfielder;
    }

    public Boolean getForward() {
        return forward;
    }

    public void setForward(Boolean forward) {
        this.forward = forward;
    }

    public Boolean getWinger() {
        return winger;
    }

    public void setWinger(Boolean winger) {
        this.winger = winger;
    }
}