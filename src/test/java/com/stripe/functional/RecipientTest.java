package com.stripe.functional;

import static org.junit.Assert.assertNotNull;

import com.stripe.BaseStripeMockTest;
import com.stripe.exception.StripeException;
import com.stripe.model.Recipient;
import com.stripe.model.RecipientCollection;
import com.stripe.net.APIResource;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Recipients are deprecated. All tests have been removed; the Java APIs will
 * eventually be removed as well.
 */
public class RecipientTest extends BaseStripeMockTest {
  @Test
  public void testList() throws StripeException {
    Map<String, Object> listParams = new HashMap<String, Object>();
    listParams.put("limit", 1);

    RecipientCollection resources = Recipient.list(listParams);

    assertNotNull(resources);
    verifyRequest(
        APIResource.RequestMethod.GET,
        String.format("/v1/recipients")
    );
  }
}
