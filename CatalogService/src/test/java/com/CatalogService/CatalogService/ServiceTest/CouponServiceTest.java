package com.CatalogService.CatalogService.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.CatalogService.CatalogService.exception.CatalogRequestException;
import com.CatalogService.CatalogService.model.Coupon;
import com.CatalogService.CatalogService.repository.CouponRepository;
import com.CatalogService.CatalogService.service.CouponService;

@SpringBootTest
public class CouponServiceTest {
			 
	@Autowired
	private CouponService couponService;
	
	@MockBean
	private CouponRepository couponRepository;

	@Test
	public void saveTest() {
		Coupon coupon = new Coupon("2", "food", 12, "12%", "EdnaBakery","https://images.app.goo.gl/XNQ5gnCidxDjRGVb8");
		when(couponRepository.save(coupon)).thenReturn(coupon);
		assertEquals(coupon,couponService.save(coupon));
	}
	
	@Test
	public void findByIdTest() throws CatalogRequestException {
		when (couponRepository.findById("2")).thenReturn(Optional.of(new Coupon("2","food",12, "12%", "EdnaBakery","https://images.app.goo.gl/XNQ5gnCidxDjRGVb8")));
		Optional<Coupon> cou = couponService.findByCouponId("2");
		assertEquals("2", cou.get().getCouponId());
		assertEquals("food",cou.get().getCategory());
		assertEquals(12,cou.get().getCount());
		assertEquals("12%",cou.get().getOffer());
		assertEquals("EdnaBakery",cou.get().getCompanyName());
	}
 
	@Test
	public void findallTest() {
		Coupon c1=new Coupon("1","food",12, "12%", "EdnaBakery","https://images.app.goo.gl/XNQ5gnCidxDjRGVb8");
		Coupon c2=new Coupon("2","food",12, "12%", "EdnaBakery","https://images.app.goo.gl/XNQ5gnCidxDjRGVb8");
		Coupon c3=new Coupon("3","food",12, "12%", "EdnaBakery","https://images.app.goo.gl/XNQ5gnCidxDjRGVb8");
		Coupon c4=new Coupon("4","food",12, "12%", "EdnaBakery","https://images.app.goo.gl/XNQ5gnCidxDjRGVb8");
		List<Coupon> cou= new ArrayList<>();
		cou.add(c1);
		cou.add(c2);
		cou.add(c3);
		cou.add(c4);
		
		when(couponRepository.findAll()).thenReturn(cou);
		assertEquals(couponService.findAll().size(),4);
	}
	
	@Test 
	 public void deleteByIdTest() throws CatalogRequestException {
		when (couponRepository.findById("6")).thenReturn(Optional.of(new Coupon("6","food",12, "12%", "EdnaBakery","https://images.app.goo.gl/XNQ5gnCidxDjRGVb8")));
		doNothing().when(couponRepository).deleteById("6");
		assertEquals(couponService.deleteById("6"), "Id 6 deleted!");
	}	
	
	@Test
	public void findByCategoryTest() {
		Optional<Coupon> c1=Optional.of(new Coupon("1","food",12, "12%", "EdnaBakery","https://images.app.goo.gl/XNQ5gnCidxDjRGVb8"));
		Optional<Coupon> c3=Optional.of(new Coupon("3","food",12, "12%", "EdnaBakery","https://images.app.goo.gl/XNQ5gnCidxDjRGVb8"));
		List<Optional<Coupon>> coupon= new ArrayList<>();
		coupon.add(c1);
		coupon.add(c3);
		when(couponRepository.findByCategory("food")).thenReturn(coupon);
		assertEquals(couponService.findByCategory("food").size(),2);		
	}	
	
	@Test
	public void findByCompanyNameTest() {
		Optional<Coupon> c1=Optional.of(new Coupon("1","food",12, "12%", "EdnaBakery","https://images.app.goo.gl/XNQ5gnCidxDjRGVb8"));
		Optional<Coupon> c2=Optional.of(new Coupon("3","food",12, "12%", "EdnaBakery","https://images.app.goo.gl/XNQ5gnCidxDjRGVb8"));
		List<Optional<Coupon>> coupon= new ArrayList<>();
		coupon.add(c1);
		coupon.add(c2);
		when(couponRepository.findByCompanyName("EdnaBakery")).thenReturn(coupon);
		assertEquals(couponService.findByCompanyName("EdnaBakery").size(),2);		
	}	
		
}
