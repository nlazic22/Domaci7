package vu.che.mvcrest.Coupon;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import javax.ws.rs.*;

@Path("/coupons")
public class CouponController {
	
    private final CouponService couponService;

    public CouponController() {
        this.couponService = new CouponService();
    }
	
    @GET
    @Path("/coupon")
    @Produces(MediaType.APPLICATION_JSON) 
    public List<Coupon> getCoupons() {
        return couponService.getCoupons();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) // Prilikom POST-a nam je bitno sta je content type onoga sto ova metoda prima zbog deserijalizacije
    @Produces(MediaType.APPLICATION_JSON)
    public Coupon addCoupon(Coupon coupon){
        couponService.addCoupon(coupon);
        return coupon;
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON) // Prilikom POST-a nam je bitno sta je content type onoga sto ova metoda prima zbog deserijalizacije
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCoupon(@PathParam("id") int id) {
    	 couponService.deleteCoupon(id);
    }

}
