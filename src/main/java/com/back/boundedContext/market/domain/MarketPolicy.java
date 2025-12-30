package com.back.boundedContext.market.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

// Spring Bean으로 등록되어야 설정값 주입이 가능하다.
@Configuration
public class MarketPolicy {
    public static double PRODUCT_PAYOUT_RATE;

    @Value("${custom.market.product.payoutRate}")
    public void setProductPayoutRate(double rate) {
        PRODUCT_PAYOUT_RATE = rate;
    }

    public static long calculatePayoutFee(long salePrice, double payoutRate) {
        return salePrice - calculateSalePriceWithoutFee(salePrice, payoutRate);
    }

    public static long calculateSalePriceWithoutFee(long salePrice, double payoutRate) {
        return Math.round(salePrice * payoutRate / 100);
    }
}
