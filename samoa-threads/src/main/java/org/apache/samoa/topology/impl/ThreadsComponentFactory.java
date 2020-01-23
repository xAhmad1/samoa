/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.samoa.topology.impl;

import org.apache.samoa.core.EntranceProcessor;
import org.apache.samoa.core.Processor;
import org.apache.samoa.topology.ComponentFactory;
import org.apache.samoa.topology.EntranceProcessingItem;
import org.apache.samoa.topology.IProcessingItem;
import org.apache.samoa.topology.ProcessingItem;
import org.apache.samoa.topology.Stream;
import org.apache.samoa.topology.Topology;

/**
 * ComponentFactory for multithreaded engine
 * 
 * @author Anh Thu Vu
 * 
 */
public class ThreadsComponentFactory implements ComponentFactory {

  @Override
  public ProcessingItem createPi(Processor processor) {
    return this.createPi(processor, 1);
  }

  @Override
  public ProcessingItem createPi(Processor processor, int paralellism) {
    return new ThreadsProcessingItem(processor, paralellism);
  }

  @Override
  public EntranceProcessingItem createEntrancePi(EntranceProcessor entranceProcessor) {
    return new ThreadsEntranceProcessingItem(entranceProcessor);
  }

  @Override
  public Stream createStream(IProcessingItem sourcePi) {
    return new ThreadsStream(sourcePi);
  }

  @Override
  public Topology createTopology(String topoName) {
    return new ThreadsTopology(topoName);
  }

}
