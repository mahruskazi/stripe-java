package com.stripe.model;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public final class VerificationFieldsDetails extends StripeObject {
  protected List<String> additional;
  protected List<String> minimum;
}
