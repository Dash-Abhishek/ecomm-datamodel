package com.fake.shop.model;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cart")
public class Cart {


  @Id
  @SequenceGenerator(sequenceName = "cart_item_seq", name = "cart_item_seq_gen", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_item_seq_gen")
  @Column(name = "id")
  private Long cartId;

  @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  @JoinColumn(name = "cart_id")
  private List<Item> items;


  @Column(name = "user_id")
  private String userId;


}
