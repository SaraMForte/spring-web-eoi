package spring_web_eoi.jdbc.application.model;

public class CategorySellsCount {
    private String category;
    private long totalSells;

    public String category() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long totalSells() {
        return totalSells;
    }

    public void setTotalSells(long totalSells) {
        this.totalSells = totalSells;
    }
}
