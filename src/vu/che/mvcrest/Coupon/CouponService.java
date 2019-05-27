package vu.che.mvcrest.Coupon;

import java.util.List;

public class CouponService {
	
    public List<Coupon> getCoupons(){
        return CouponRepository.getCoupons();
    }
    
    public Coupon addCoupon(Coupon coupon){
        return CouponRepository.addCoupon(coupon);
    }
    
    public void deleteCoupon(int id){
         CouponRepository.deleteCoupon(id);
    }

}
