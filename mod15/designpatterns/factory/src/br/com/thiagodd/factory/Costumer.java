package br.com.thiagodd.factory;

public class Costumer {
    private String gradeRequest;
    private boolean hasCompanyContract;

    public Costumer(String gradeRequest, boolean hasCompanyContract) {
        this.gradeRequest = gradeRequest;
        this.hasCompanyContract = hasCompanyContract;
    }

    public String getGradeRequest() {
        return gradeRequest;
    }

    public boolean hasCompanyContract() {
        return hasCompanyContract;
    }
}
