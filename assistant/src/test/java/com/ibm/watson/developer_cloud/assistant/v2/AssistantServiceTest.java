/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.developer_cloud.assistant.v2;

import com.ibm.watson.developer_cloud.WatsonServiceTest;
import org.junit.Assume;
import org.junit.Before;

import java.util.Date;

public class AssistantServiceTest extends WatsonServiceTest {

  private Assistant service;
  private String assistantId;

  public Assistant getService() {
    return this.service;
  }

  public String getAssistantId() {
    return this.assistantId;
  }

  /*
   * (non-Javadoc)
   * @see com.ibm.watson.developer_cloud.WatsonServiceTest#setUp()
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    String username = getProperty("assistant.v2.username");
    String password = getProperty("assistant.v2.password");
    assistantId = getProperty("assistant.v2.assistant_id");

    Assume.assumeFalse("config.properties doesn't have valid credentials.",
        (username == null) || username.equals(PLACEHOLDER));

    service = new Assistant("2018-07-10");
    service.setEndPoint(getProperty("assistant.v2.url"));
    service.setUsernameAndPassword(username, password);
    service.setDefaultHeaders(getDefaultHeaders());
  }

  private long tolerance = 2000; // 2 secs in ms

  /**
   * return `true` if ldate before rdate within tolerance.
   */
  public boolean fuzzyBefore(Date ldate, Date rdate) {
    return (ldate.getTime() - rdate.getTime()) < tolerance;
  }

  /**
   * return `true` if ldate after rdate within tolerance.
   */
  public boolean fuzzyAfter(Date ldate, Date rdate) {
    return (rdate.getTime() - ldate.getTime()) < tolerance;
  }

}
