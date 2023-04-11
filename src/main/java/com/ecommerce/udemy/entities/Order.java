package com.ecommerce.udemy.entities;
import com.ecommerce.udemy.entities.enums.StatusOrder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
        private Instant moment;
        private StatusOrder status;

        @ManyToOne
        @JoinColumn(name = "client_id")
        private User client;

        @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
        private Payment payment;

        @OneToMany(mappedBy = "id.order")
        private Set<OrderItem> items = new HashSet<>();

        public Order(){
        }

        public Order(Long id, Instant moment, StatusOrder status, User client, Payment payment) {
            this.id = id;
            this.moment = moment;
            this.status = status;
            this.client = client;
            this.payment = payment;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Instant getMoment() {
            return moment;
        }

        public void setMoment(Instant moment) {
            this.moment = moment;
        }

        public StatusOrder getStatus() {
            return status;
        }

        public void setStatus(StatusOrder status) {
            this.status = status;
        }

        public User getClient() {
            return client;
        }

        public void setClient(User client) {
            this.client = client;
        }

        public Payment getPayment() {
            return payment;
        }

        public void setPayment(Payment payment) {
            this.payment = payment;
        }

        public Set<OrderItem> getItems() {
            return items;
        }

        public List<Product> getProducts() {
            return items.stream().map(OrderItem::getProduct).toList();
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Order order)) return false;
            return Objects.equals(id, order.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
