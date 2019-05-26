/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.apache.ant.vss;

import org.apache.tools.ant.BuildFileTest;

public class MSVSSTest extends BuildFileTest {

    public MSVSSTest() {
        this("MSVSSTest");
    }
    
    public MSVSSTest(String name) {
        super(name);
    }
    
    public void setUp() throws Exception {
        configureProject("src/etc/testcases/msvss.xml");
    }

    public void tearDown() throws Exception {
        executeTarget("cleanup");
    }
    
    public void testMSVSS() throws Exception {
        executeTarget("test-all");
    }
    
    public void testMSVSSMOVE() throws Exception {
        executeTarget("test-move");
    }
    
    public void testMSVSSCLOAK() throws Exception {
        executeTarget("test-cloak");
    }
    
    public void testMSVSSDELETE() throws Exception {
        executeTarget("test-delete");
    }
    
    public void testMSVSSLOCATE() throws Exception {
        executeTarget("test-locate");
    }
    
    public void testMSVSSSTATUS() throws Exception {
        executeTarget("test-status");
    }
}
