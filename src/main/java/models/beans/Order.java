package models.beans;

public class Order {
    private int id;
    private String description;
    private int ordererId;
    private String orderStatus;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrdererId() {
        return ordererId;
    }

    public void setOrdererId(int ordererId) {
        this.ordererId = ordererId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
