package com.stripe.model;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource;
import com.stripe.net.RequestOptions;

import java.util.List;
import java.util.Map;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Order extends APIResource implements HasId, MetadataStore<Order> {
  String id;
  String object;
  Long amount;
  Long amountReturned;
  String application;
  Long applicationFee;
  @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) ExpandableField<Charge> charge;
  Long created;
  String currency;
  @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) ExpandableField<Customer> customer;
  String email;
  String externalCouponCode;
  List<OrderItem> items;
  Boolean livemode;
  Map<String, String> metadata;
  OrderReturnCollection returns;
  String selectedShippingMethod;
  ShippingDetails shipping;
  List<ShippingMethod> shippingMethods;
  String status;
  StatusTransitions statusTransitions;
  Long updated;
  String upstreamId;

  // <editor-fold desc="charge">
  public String getCharge() {
    return (this.charge != null) ? this.charge.getId() : null;
  }

  public void setCharge(String chargeID) {
    this.charge = setExpandableFieldID(chargeID, this.charge);
  }

  public Charge getChargeObject() {
    return (this.charge != null) ? this.charge.getExpanded() : null;
  }

  public void setChargeObject(Charge charge) {
    this.charge = new ExpandableField<Charge>(charge.getId(), charge);
  }
  // </editor-fold>

  // <editor-fold desc="customer">
  public String getCustomer() {
    return (this.customer != null) ? this.customer.getId() : null;
  }

  public void setCustomer(String customerID) {
    this.customer = setExpandableFieldID(customerID, this.customer);
  }

  public Customer getCustomerObject() {
    return (this.customer != null) ? this.customer.getExpanded() : null;
  }

  public void setCustomerObject(Customer customer) {
    this.customer = new ExpandableField<Customer>(customer.getId(), customer);
  }
  // </editor-fold>

  public static Order create(Map<String, Object> params)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return create(params, null);
  }

  public static Order create(Map<String, Object> params, RequestOptions options)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return request(RequestMethod.POST, classURL(Order.class), params, Order.class, options);
  }

  public static Order retrieve(String id)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return retrieve(id, null);
  }

  public static Order retrieve(String id, RequestOptions options)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return request(RequestMethod.GET, instanceURL(Order.class, id), null, Order.class, options);
  }

  public static Order retrieve(String id, Map<String, Object> params, RequestOptions options)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return request(RequestMethod.GET, instanceURL(Order.class, id), params, Order.class, options);
  }

  public Order update(Map<String, Object> params)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return update(params, null);
  }

  @Deprecated
  public Order update(Map<String, Object> params, RequestOptions options)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return request(RequestMethod.POST, instanceURL(Order.class, this.id), params, Order.class,
        options);
  }

  public static OrderCollection list(Map<String, Object> params)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return list(params, null);
  }

  public static OrderCollection list(Map<String, Object> params,
                     RequestOptions options) throws AuthenticationException,
      InvalidRequestException, APIConnectionException, CardException,
      APIException {
    return requestCollection(classURL(Order.class), params, OrderCollection.class, options);
  }

  @Deprecated
  public static OrderCollection all(Map<String, Object> params)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    return list(params, null);
  }

  @Deprecated
  public static OrderCollection all(Map<String, Object> params,
                    RequestOptions options) throws AuthenticationException,
      InvalidRequestException, APIConnectionException, CardException,
      APIException {
    return list(params, options);
  }

  public Order pay(Map<String, Object> params) throws AuthenticationException,
      InvalidRequestException, APIConnectionException, CardException,
      APIException {
    return this.pay(params, null);
  }

  public Order pay(Map<String, Object> params, RequestOptions options)
      throws AuthenticationException, InvalidRequestException, APIConnectionException,
      CardException, APIException {
    return request(RequestMethod.POST, String.format("%s/pay",
        instanceURL(Order.class, this.getId())), params, Order.class, options);
  }

  public OrderReturn returnOrder(Map<String, Object> params) throws AuthenticationException,
      InvalidRequestException, APIConnectionException, CardException,
      APIException {
    return this.returnOrder(params, null);
  }

  public OrderReturn returnOrder(Map<String, Object> params, RequestOptions options)
      throws AuthenticationException, InvalidRequestException, APIConnectionException,
      CardException, APIException {
    return request(RequestMethod.POST, String.format("%s/returns",
        instanceURL(Order.class, this.getId())), params, OrderReturn.class, options);
  }
}
