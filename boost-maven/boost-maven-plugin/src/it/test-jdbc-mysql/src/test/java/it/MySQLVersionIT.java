/*******************************************************************************
 * Copyright (c) 2018 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package it;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.Test;

public class MySQLVersionIT {

    private static final String MYSQL_JAR = "target/liberty/wlp/usr/servers/BoostServer/resources/mysql-connector-java-8.0.15.jar";

    @Test
    public void testMySQLVersion() throws Exception {
        File targetFile = new File(MYSQL_JAR);
        assertTrue(targetFile.getCanonicalFile() + "does not exist.", targetFile.exists());
    }
}
