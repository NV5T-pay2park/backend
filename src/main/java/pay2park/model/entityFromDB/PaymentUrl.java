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

    @Column(name = "zp_trans_token")
    private String zpTransToken;

    public PaymentUrl() {
    }

    public PaymentUrl(String id, String orderUrl, String zpTransToken) {
        this.id = id;
        this.orderUrl = orderUrl;
        this.zpTransToken = zpTransToken;
    }

    public String getZpTransToken() {
        return zpTransToken;
    }

    public void setZpTransToken(String zpTransToken) {
        this.zpTransToken = zpTransToken;
    }

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