package pay2park.model.merchant;

import pay2park.model.entityFromDB.PriceTicket;

public class PriceItem {
    public Integer periodTime;
    public Integer price;
    public Integer unit;

    public PriceItem(PriceTicket priceTicket) {
        this.periodTime = priceTicket.getPeriodTime();
        this.price = priceTicket.getPrice();
        this.unit = priceTicket.getUnit();
    }
}
