package com.zouquanguo.pojo;

import java.util.Date;

public class Goupiao {
    private Integer id;
    private String jingdianmingcheng;
    private String jingdiandengji;
    private String suozaichengshi;
    private String diliweizhi;
    private String kaifangshijian;
    private double menpiaojiage;
    private Integer piaoshu;
    private String zongjia;
    private String goupiaoyonghu;
    private String issh;
    private String iszf;
    private Date addtime;

    public Goupiao() {
    }

    public Goupiao(Integer id, String jingdianmingcheng, String jingdiandengji, String suozaichengshi, String diliweizhi, String kaifangshijian, double menpiaojiage, Integer piaoshu, String zongjia, String goupiaoyonghu, String issh, String iszf, Date addtime) {
        this.id = id;
        this.jingdianmingcheng = jingdianmingcheng;
        this.jingdiandengji = jingdiandengji;
        this.suozaichengshi = suozaichengshi;
        this.diliweizhi = diliweizhi;
        this.kaifangshijian = kaifangshijian;
        this.menpiaojiage = menpiaojiage;
        this.piaoshu = piaoshu;
        this.zongjia = zongjia;
        this.goupiaoyonghu = goupiaoyonghu;
        this.issh = issh;
        this.iszf = iszf;
        this.addtime = addtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJingdianmingcheng() {
        return jingdianmingcheng;
    }

    public void setJingdianmingcheng(String jingdianmingcheng) {
        this.jingdianmingcheng = jingdianmingcheng;
    }

    public String getJingdiandengji() {
        return jingdiandengji;
    }

    public void setJingdiandengji(String jingdiandengji) {
        this.jingdiandengji = jingdiandengji;
    }

    public String getSuozaichengshi() {
        return suozaichengshi;
    }

    public void setSuozaichengshi(String suozaichengshi) {
        this.suozaichengshi = suozaichengshi;
    }

    public String getDiliweizhi() {
        return diliweizhi;
    }

    public void setDiliweizhi(String diliweizhi) {
        this.diliweizhi = diliweizhi;
    }

    public String getKaifangshijian() {
        return kaifangshijian;
    }

    public void setKaifangshijian(String kaifangshijian) {
        this.kaifangshijian = kaifangshijian;
    }

    public double getMenpiaojiage() {
        return menpiaojiage;
    }

    public void setMenpiaojiage(double menpiaojiage) {
        this.menpiaojiage = menpiaojiage;
    }

    public Integer getPiaoshu() {
        return piaoshu;
    }

    public void setPiaoshu(Integer piaoshu) {
        this.piaoshu = piaoshu;
    }

    public String getZongjia() {
        return zongjia;
    }

    public void setZongjia(String zongjia) {
        this.zongjia = zongjia;
    }

    public String getGoupiaoyonghu() {
        return goupiaoyonghu;
    }

    public void setGoupiaohonghu(String goupiaoyonghu) {
        this.goupiaoyonghu = goupiaoyonghu;
    }

    public String getIssh() {
        return issh;
    }

    public void setIssh(String issh) {
        this.issh = issh;
    }

    public String getIszf() {
        return iszf;
    }

    public void setIszf(String iszf) {
        this.iszf = iszf;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    @Override
    public String toString() {
        return "Goupiao{" +
                "id=" + id +
                ", jingdianmingcheng='" + jingdianmingcheng + '\'' +
                ", jingdiandengji='" + jingdiandengji + '\'' +
                ", suozaichengshi='" + suozaichengshi + '\'' +
                ", diliweizhi='" + diliweizhi + '\'' +
                ", kaifangshijian='" + kaifangshijian + '\'' +
                ", menpiaojiage=" + menpiaojiage +
                ", piaoshu=" + piaoshu +
                ", zongjia='" + zongjia + '\'' +
                ", goupiaohonghu='" + goupiaoyonghu + '\'' +
                ", issh='" + issh + '\'' +
                ", iszf='" + iszf + '\'' +
                ", addtime=" + addtime +
                '}';
    }
}
