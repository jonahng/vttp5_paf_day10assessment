package vttp.batch5.paf.movies.models;

public class TopDirectors {
    private String name;
    private int movie_count;
    private double revenue;
    private double budget;
    private double profitLoss;

    

    public TopDirectors() {
    }
    

    @Override
    public String toString() {
        return "TopDirectors [name=" + name + ", movie_count=" + movie_count + ", revenue=" + revenue + ", budget="
                + budget + ", profitLoss=" + profitLoss + "]";
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMovie_count() {
        return movie_count;
    }
    public void setMovie_count(int movie_count) {
        this.movie_count = movie_count;
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
