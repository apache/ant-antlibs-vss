/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.apache.ant.vss;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.types.Commandline;

public class MSVSSSTATUS extends MSVSS {
    
    /**
     * Builds a command line to execute ss.
     * @return     The constructed commandline.
     */
    Commandline buildCmdLine() {
        Commandline commandLine = new Commandline();

        // first off, make sure that we've got a command and a vssdir...
        if (getVsspath() == null) {
            String msg = "vsspath attribute must be set!";
            throw new BuildException(msg, getLocation());
        }
        // build the command line from what we got
        // the format is:
        // ss Status [VSS items] [-H] [-I-] [-N] [-O] [-P[project]] [-R] [-U[username]] [-Y] [-?]
        // as specified in the SS.EXE help
        commandLine.setExecutable(getSSCommand());
        commandLine.createArgument().setValue(COMMAND_STATUS);

        // VSS items (from)
        commandLine.createArgument().setValue(getVsspath());
        // -Y
        commandLine.createArgument().setValue(getLogin());
        // -I-
        commandLine.createArgument().setValue(getAutoresponse());
        // -U
        commandLine.createArgument().setValue(getUser());
        return commandLine;
    }
    
    public void setUser(String u) {
        super.setInternalUser(u);
    }
}
