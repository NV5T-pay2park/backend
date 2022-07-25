package pay2park.model.entityFromDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_url")
public class PaymentUrl {
    @Id
    @Column(name = "app_tran_id", nullable = false, length = 50)
    private String id;

    @Column(name = "order_url")
    private String orderUrl;

    public String getOrderUrl() {
        return orderUrl;
    }

    public void setOrderUrl(String orderUrl) {
        this.orderUrl = orderUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}