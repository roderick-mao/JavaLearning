package javase.day01.lp6;

public class Grade {
    private float javaGrade;
    private float cshapeGrade;
    private float dbGrade;

    public Grade(){}

    public Grade(float javaGrade,float cshapeGrade,float dbGrade){
        this.javaGrade = javaGrade;
        this.cshapeGrade = cshapeGrade;
        this.dbGrade = dbGrade;
    }

    public float getCshapeGrade() {
        return cshapeGrade;
    }

    public float getDbGrade() {
        return dbGrade;
    }

    public float getJavaGrade() {
        return javaGrade;
    }

    public void setCshapeGrade(float cshapeGrade) {
        this.cshapeGrade = cshapeGrade;
    }

    public void setDbGrade(float dbGrade) {
        this.dbGrade = dbGrade;
    }

    public void setJavaGrade(float javaGrade) {
        this.javaGrade = javaGrade;
    }

    public float average(){
        float average = this.sum() / 3;
        return average;
    }

    public float sum(){
        float sum = this.cshapeGrade+this.dbGrade+this.javaGrade;
        return sum;
    }
}
