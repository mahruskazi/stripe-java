package com.stripe.model;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource;
import com.stripe.net.RequestOptions;

import java.util.Map;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Topup extends APIResource implements MetadataStore<Topup>, HasId {
  String id;
  String object;
  Integer amount;
  @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
      ExpandableField<BalanceTransaction> balanceTransaction;
  Long created;
  String currency;
  String description;
  Long expectedAvailabilityDate;
  String failureCode;
  String failureMessage;
  Boolean livemode;
  Map<String, String> metadata;
  Source source;
  String statementDescriptor;
  String status;

  // <editor-fold desc="balanceTransaction">
  public String getBalanceTransaction() {
    return (this.balanceTransaction != null) ? this.balanceTransaction.getId() : null;
  }

  public void setBalanceTransaction(String balanceTransactionID) {
    this.balanceTransaction = setExpandableFieldID(balanceTransactionID, this.balanceTransaction);
  }

  public BalanceTransaction getBalanceTransactionObject() {
    return (this.balanceTransaction != null) ? this.balanceTransaction.getExpanded() : null;
  }

  public void setBalanceTransactionObject(BalanceTransaction c) {
    this.balanceTransaction = new ExpandableField<BalanceTransaction>(c.getId(), c);
  }
  // </editor-fold>

  public static Topup create(Map<String, Object> params)
          throws AuthenticationException, InvalidRequestException,
          APIConnectionException, CardException, APIException {
    return create(params, null);
  }

  public static Topup create(Map<String, Object> params, RequestOptions options)
          throws AuthenticationException, InvalidRequestException,
          APIConnectionException, CardException, APIException {
    return request(RequestMethod.POST, classURL(Topup.class), params, Topup.class, options);
  }

  public static Topup retrieve(String id) throws AuthenticationException,
          InvalidRequestException, APIConnectionException, CardException,
          APIException {
    return retrieve(id, null);
  }

  public static Topup retrieve(String id, RequestOptions options)
          throws AuthenticationException, InvalidRequestException,
          APIConnectionException, CardException, APIException {
    return retrieve(id, null, options);
  }

  public static Topup retrieve(String id, Map<String, Object> params, RequestOptions options)
          throws AuthenticationException, InvalidRequestException,
          APIConnectionException, CardException, APIException {
    return request(RequestMethod.GET, instanceURL(Topup.class, id), params, Topup.class, options);
  }

  public static TopupCollection list(Map<String, Object> params)
          throws AuthenticationException, InvalidRequestException,
          APIConnectionException, CardException, APIException {
    return list(params, null);
  }

  public static TopupCollection list(Map<String, Object> params, RequestOptions options)
          throws AuthenticationException, InvalidRequestException,
          APIConnectionException, CardException, APIException {
    return requestCollection(classURL(Topup.class), params, TopupCollection.class, options);
  }

  @Override
  public Topup update(Map<String, Object> params) throws AuthenticationException,
      InvalidRequestException, APIConnectionException, CardException, APIException {
    return update(params, null);
  }

  @Override
  public Topup update(Map<String, Object> params, RequestOptions options)
      throws AuthenticationException, InvalidRequestException, APIConnectionException,
      CardException, APIException {
    return request(RequestMethod.POST, instanceURL(Topup.class, id), params, Topup.class, options);
  }
}
