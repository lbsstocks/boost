/*******************************************************************************
 * Copyright (c) 2019 IBM Corporation and others.
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

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Db2PasswordAesIT {

    private final String DB_NAME = "myCustomDB";
    private final String DB_USER = "user";
    private final String ENCODED_DB_PASS = "{aes}Lz4sLCgwLTs=";

    @Test
    public void checkPropertiesTest() {
    
        Properties bootstrapProperties = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("target/liberty/wlp/usr/servers/BoostServer/bootstrap.properties");

            bootstrapProperties.load(input);

            assertEquals("Incorrect boost.db.user found in bootstrap.properties.", DB_USER, bootstrapProperties.getProperty("boost.db.user"));
            assertEquals("Incorrect boost.db.password found in bootstrap.properties.", ENCODED_DB_PASS, bootstrapProperties.getProperty("boost.db.password"));
            assertEquals("Incorrect boost.db.databaseName found in bootstrap.properties.", DB_NAME, bootstrapProperties.getProperty("boost.db.databaseName"));
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
} 