package javase.day01.lp3;

public class Car {
    private String brand;
    private String color;
    private int weight;
    private String lic;
    private boolean isNew;

    public void setNew(boolean aNew) {
        this.isNew = aNew;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLic(String lic) {
        this.lic = lic;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getLic() {
        return lic;
    }

    public boolean getIsNew(){
        return isNew;
    }

    @Override
    public String toString() {
        return " 品牌："+brand+" 颜色："+color+" 重量："+weight+" 牌照："+lic+" 是否是新款："+isNew;
    }
}
