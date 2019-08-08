package sql.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ShareRate extends BaseModel {
    private LocalDateTime operDate;
    private Share share;
    private BigDecimal rate;

    public ShareRate(){
    }

    public ShareRate(long id, LocalDateTime operDate, Share share, BigDecimal rate) {
        super(id);
        this.operDate = operDate;
        this.share = share;
        this.rate = rate;
    }

    public LocalDateTime getOperDate() {
        return operDate;
    }

    public void setOperDate(LocalDateTime operDate) {
        this.operDate = operDate;
    }

    public Share getShare() {
        return share;
    }

    public void setShare(Share share) {
        this.share = share;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
