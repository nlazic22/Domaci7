package vu.che.mvcrest.Coupon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CouponRepository {

	
    private static String[] shops = {"The Shop at Bluebird", "Harrods", "Selfridges", "Goodhood", "Dover Street Market", "Fortnum & Mason", "Liberty", "Harvey Nichols", "Heal's", "Fenwick"};
    private static Float[] oldPrices = {100f, 200f, 300f, 400f, 500f, 600f, 700f, 800f, 900f, 1000f};
    private static Integer[] discounts = {5, 10, 20, 30, 40, 50, 60, 70, 80, 90};
    private static String[] products = {"sweater", "band T-shirt", "shirt", "shoes", "skirt", "eye liner", "hair brush", "necklace", "jeans", "dress"};
    private static Float[] newPrices = {};
    private static List<Coupon> COUPON_LIST;

    static {
        COUPON_LIST = generateCoupons();
    }

    /**
     * Generise 10 korisnika birajuci nasumicno imena i prezimena iz liste
     * @return
     */
    private static List<Coupon> generateCoupons() {
        List<Coupon> coupons = new ArrayList<Coupon>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {

            Coupon coupon = new Coupon();
            Shop shop = new Shop();
            shop.setId(Integer.toString(i));
            shop.setName(shops[i]);
            coupon.setId(i);
            float oldPrice = oldPrices[random.nextInt(oldPrices.length)];
            coupon.setOriginalPrice(oldPrice);
            float discount = discounts[random.nextInt(discounts.length)];
            coupon.setDiscount(discount);
            coupon.setDiscountedPrice(oldPrice - (oldPrice*discount)/100);
            coupon.setProduct(products[i]);
            coupon.setShop(shop);

            coupons.add(coupon);
        }

        return coupons;
    }


    /**
     * Vraca sve User-e u sistemu.
     * Ako je firstName dato onda ce vratiti listu svih korisnika sa tim imenom.
     * @param firstName Opcioni filter za ime
     * @return
     */
    public synchronized static List<Coupon> getCoupons(){

    return COUPON_LIST;
    }
    
    public synchronized static Coupon addCoupon(Coupon coupon){

        coupon.setId(COUPON_LIST.size());
        float discount = ((coupon.getOriginalPrice()-coupon.getDiscountedPrice())*100)/coupon.getOriginalPrice();
        coupon.setDiscount(discount);
        COUPON_LIST.add(coupon);

        return coupon;
    }
    
    public synchronized static void deleteCoupon(int id){

        for(int i = 0; i < COUPON_LIST.size(); i++) {
        	
        	if(COUPON_LIST.get(i).getId() == id) {
        		COUPON_LIST.remove(i);
        	}
        }
      
    }
}
