import java.math.BigDecimal;

public abstract class Rider {
    protected BigDecimal rateReduction;

    protected Rider(BigDecimal rateReduction){
        this.setRateReduction(rateReduction);
    }

    protected final void setRateReduction(BigDecimal rateReduction){
        this.rateReduction = rateReduction;
    }

    BigDecimal getRateReduction(){
        return this.rateReduction;
    }
}
