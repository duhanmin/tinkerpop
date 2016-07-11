/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.tinkerpop.gremlin.jsr223;

import javax.script.ScriptEngineFactory;

/**
 * Creates a {@link GremlinScriptEngine} implementation and supplies to it any {@link Customizer} implementations to
 * it that are available on the {@link CustomizerManager}.
 *
 * @author Stephen Mallette (http://stephen.genoprime.com)
 */
public interface GremlinScriptEngineFactory extends ScriptEngineFactory {

    /**
     * Creates a new {@link GremlinScriptEngine} instance. Unlike the JSR-223 implementation, the semantics for this
     * interface expect a "new" instance to be created for each call to this method. Caching or pooling is something
     * to be handled by a {@link GremlinScriptEngineManager}.
     */
    @Override
    GremlinScriptEngine getScriptEngine();

    /**
     * The factory should take the {@link Customizer} implementations made available by the manager and supply them
     * to the {@link GremlinScriptEngine} implementation it creates.
     */
    void setCustomizerManager(final CustomizerManager manager);
}
