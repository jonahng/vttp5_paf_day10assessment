package vttp.batch5.paf.movies.models;

public class MovieFinance {
    private double revenue;
    private double budget;
    private double profitLoss;


    

    public MovieFinance() {
    }
    
    public double getRevenue() {
        return revenue;
    }
    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
    public double getBudget() {
        return budget;
    }
    public void setBudget(double budget) {
        this.budget = budget;
    }
    public double getProfitLoss() {
        return profitLoss;
    }
    public void setProfitLoss(double profitLoss) {
        this.profitLoss = profitLoss;
    }

    
}
