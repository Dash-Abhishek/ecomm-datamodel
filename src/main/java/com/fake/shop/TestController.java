package com.fake.shop;

import com.fake.shop.model.Cart;


import com.fake.shop.model.Orders;
import com.fake.shop.repository.CartRepository;
import com.fake.shop.repository.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


  @Autowired
  private CartRepository cartRepository;

  @Autowired
  private OrderRepository orderRepository;

  @PostMapping("/cart")
  public void createCart(@RequestBody Cart cart){

    cartRepository.save(cart);

  }


  @GetMapping("/cart")
  public ResponseEntity<List<Cart>> getAllCarts(){

    return  new ResponseEntity(cartRepository.findAll(), HttpStatus.OK);

  }


  @GetMapping("/order")
  public ResponseEntity<List<Cart>> getAllOrders(){

    return  new ResponseEntity(orderRepository.findAll(), HttpStatus.OK);

  }

  @PostMapping("/order")
  public void placeOrders(@RequestBody Orders orders){

     orderRepository.save(orders);

  }

}
