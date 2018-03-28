package com.stripe.model;

import static org.junit.Assert.assertNotNull;

import com.stripe.BaseStripeMockTest;
import com.stripe.model.Balance;
import com.stripe.net.APIResource;

import org.junit.Test;

public class BalanceTest extends BaseStripeMockTest {
  @Test
  public void testDeserialize() throws Exception {
    String data = getFixture("/v1/balance");
    Balance resource = APIResource.GSON.fromJson(data, Balance.class);
    assertNotNull(resource);
  }
}
