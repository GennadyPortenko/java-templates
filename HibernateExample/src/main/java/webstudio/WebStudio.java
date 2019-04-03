package webstudio;

public class WebStudio {
    private int id;
    private String name;
    private double annualProfit;
    private int employeesNum;

    public WebStudio(String name, double annualProfit, int employeesNum) {
        this.name = name;
        this.annualProfit = annualProfit;
        this.employeesNum = employeesNum;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAnnualProfit() {
        return annualProfit;
    }

    public int getEmployeesNum() {
        return employeesNum;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnnualProfit(double annualProfit) {
        this.annualProfit = annualProfit;
    }

    public void setEmployeesNum(int employeesNum) {
        this.employeesNum = employeesNum;
    }
}
